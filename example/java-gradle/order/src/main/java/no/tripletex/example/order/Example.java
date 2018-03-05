package no.tripletex.example.order;

import no.tripletex.api.v2.TripletexApiClient;
import no.tripletex.v2.ApiException;
import no.tripletex.v2.api.*;
import no.tripletex.v2.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Supplier;

public class Example {

    private static final Logger LOG = LoggerFactory.getLogger(Example.class);

    interface ApiLambda<T> extends Supplier<T> {

        @Override
        default T get() {
            try {
                return getException();
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
        }

        T getException() throws ApiException;
    }

    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("First argument is the consumer token, the second is the employee token.");
            return;
        }

        Example example = new Example();

        try {
            example.run(args[0], args[1]);
        } catch (ApiException e) {
            LOG.error("Example run failed", e);
        }
    }

    public void run(String consumerToken, String employeeToken) throws ApiException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1L);

        // API client, handles authentication
        TripletexApiClient tripletexApiClient = new TripletexApiClient();

        // First we need to create a session token. We could have reused an existing token if it has yet to expire.
        TokensessionApi sessionApi = new TokensessionApi(tripletexApiClient);
        ResponseWrapperSessionToken sessionTokenResponse = sessionApi.create(consumerToken, employeeToken, tomorrow.toString());
        String sessionToken = sessionTokenResponse.getValue().getToken();

        // "0" here means that we are authenticating as ourselves.
        // For accountant login, the username is the id of the company you are using proxy login into.
        tripletexApiClient.setUsername("0");
        tripletexApiClient.setPassword(sessionToken);

        // API access wrappers.
        LedgervatTypeApi ledgervatTypeApi = new LedgervatTypeApi(tripletexApiClient);
        ProductApi productApi = new ProductApi(tripletexApiClient);
        CustomerApi customerApi = new CustomerApi(tripletexApiClient);
        OrderApi orderApi = new OrderApi(tripletexApiClient);
        OrderorderlineApi orderorderlineApi = new OrderorderlineApi(tripletexApiClient);
        InvoiceApi invoiceApi = new InvoiceApi(tripletexApiClient);
        InvoicepaymentTypeApi invoicepaymentTypeApi = new InvoicepaymentTypeApi(tripletexApiClient);

        // This requires that the Tripletex account this is used on is VAT registered on.
        VatType vatHigh = ledgervatTypeApi
                .search(null, "3", null, null, null, "*")
                .getValues()
                .stream()
                .findFirst()
                .orElseThrow(IllegalStateException::new);

        VatType vatLow = ledgervatTypeApi
                .search(null, "33", null, null, null, "*")
                .getValues()
                .stream()
                .findFirst()
                .orElseThrow(IllegalStateException::new);

        Product product = productApi.search(null, Collections.singletonList("T00" + today.getDayOfYear()), "Order-Test-" + today.toString(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "*")
                .getValues()
                .stream()
                .findFirst()
                .orElseGet((ApiLambda<Product>) () ->
                        productApi.post(new Product()
                                .name("Order-Test-" + today.toString())
                                .number("T00" + today.getDayOfYear())
                                .costExcludingVatCurrency(BigDecimal.ZERO)
                                .priceExcludingVatCurrency(BigDecimal.valueOf(1000L))
                                .priceIncludingVatCurrency(BigDecimal.valueOf(1250L))
                                .vatType(vatHigh)
                        ).getValue()
                );

        Customer customer = customerApi.search(null, null, "test@test.test", "test@test.test", null, null, null, null, null, "id")
                .getValues()
                .stream()
                .findFirst()
                .orElseGet((ApiLambda<Customer>) () ->
                        // The additional object creating is to make a model with only its id set, to lessen data sent in other requests.
                        new Customer().id(customerApi.post(new Customer()
                                .name("Test Testersen")
                                .email("test@test.test")
                                .invoiceEmail("test@test.test")
                                .isPrivateIndividual(true)
                                .postalAddress(new Address()
                                        .addressLine1("Test gata 1")
                                        .postalCode("0001")
                                        .city("Test")
                                )
                        ).getValue().getId())
                );

        // The additional object creating is to make a model with only its id set, to lessen data sent in other requests.
        Order order = new Order().id(orderApi.post(new Order()
                .customer(customer)
                .deliveryDate(today.plusDays(7).toString())
                .orderDate(today.toString())
                .isPrioritizeAmountsIncludingVat(true)
        ).getValue().getId());

        orderorderlineApi.postList(Arrays.asList(
                new OrderLine()
                        .order(order)
                        .product(product)
                        .count(2D)
                        .unitCostCurrency(product.getCostExcludingVatCurrency())
                        .unitPriceIncludingVatCurrency(product.getPriceIncludingVatCurrency())
                        .unitPriceExcludingVatCurrency(product.getPriceExcludingVatCurrency())
                        .vatType(vatHigh)
                ,
                new OrderLine()
                        .order(order)
                        .description("Foo")
                        .unitCostCurrency(BigDecimal.ZERO)
                        .unitPriceExcludingVatCurrency(BigDecimal.valueOf(100L))
                        .unitPriceIncludingVatCurrency(BigDecimal.valueOf(112L))
                        .count(1D)
                        .vatType(vatLow)
        ));

        Invoice invoice = orderApi.invoice(order.getId(), today.toString(), false).getValue();

        PaymentType paymentType = invoicepaymentTypeApi.search(null, "Betalt til bank", null, null, null, "id").getValues().stream().findFirst().orElseThrow(IllegalStateException::new);
        invoice = invoiceApi.payment(invoice.getId(), today.toString(), paymentType.getId(), BigDecimal.valueOf(2612L)).getValue();
        System.out.println(invoice);
    }
}
