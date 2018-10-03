package no.tripletex.example.order;

import no.tripletex.util.RuntimeExceptionConverter;
import no.tripletex.v2.ApiClient;
import no.tripletex.v2.ApiException;
import no.tripletex.v2.api.*;
import no.tripletex.v2.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

/**
 * OrderInvoiceExampleBaseline contains all the shared values between the invoice examples.
 *
 * @author tellef
 * @date 03.10.2018
 */
public abstract class OrderInvoiceExampleBaseline {

    protected final ApiClient apiClient;

    protected VatType vatHigh;
    protected VatType vatLow;
    protected Product product;
    protected Customer customer;
    protected Order order;
    protected PaymentType paymentType;

    protected OrderInvoiceExampleBaseline(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public void work() throws ApiException {
        LocalDate today = LocalDate.now();

        // API access wrappers.
        final LedgervatTypeApi ledgervatTypeApi = new LedgervatTypeApi(apiClient);
        final ProductApi productApi = new ProductApi(apiClient);
        final CustomerApi customerApi = new CustomerApi(apiClient);
        final OrderApi orderApi = new OrderApi(apiClient);
        final OrderorderlineApi orderorderlineApi = new OrderorderlineApi(apiClient);
        final InvoicepaymentTypeApi invoicepaymentTypeApi = new InvoicepaymentTypeApi(apiClient);

        // This requires that the Tripletex account this is used on is VAT registered on.
        vatHigh = new VatType().id(
            ledgervatTypeApi.search(null, "3", null, null, null, "*")
                .getValues()
                .stream()
                .findFirst()
                .orElseThrow(IllegalStateException::new)
                .getId()
        );

        vatLow = new VatType().id(
            ledgervatTypeApi.search(null, "33", null, null, null, "*")
                .getValues()
                .stream()
                .findFirst()
                .orElseThrow(IllegalStateException::new)
                .getId()
        );

        paymentType = new PaymentType().id(
            invoicepaymentTypeApi.search(null, "Betalt til bank", null, null, null, "id")
                .getValues()
                .stream()
                .findFirst()
                .orElseThrow(IllegalStateException::new)
                .getId()
        );

        // Find a previously created product, create a new product if not found.
        product = productApi.search(null, Collections.singletonList("T00" + today.getDayOfYear()), "Order-Test-" + today.toString(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "*")
                .getValues()
                .stream()
                .findFirst()
                .orElseGet((RuntimeExceptionConverter<Product>) () ->
                        productApi.post(new Product()
                                .name("Order-Test-" + today.toString())
                                .number("T00" + today.getDayOfYear())
                                .costExcludingVatCurrency(BigDecimal.ZERO)
                                .priceExcludingVatCurrency(BigDecimal.valueOf(1000L))
                                .priceIncludingVatCurrency(BigDecimal.valueOf(1250L))
                                .vatType(vatHigh)
                        ).getValue()
                );

        // Find a previously created customer, create a new customer if not found.
        // The additional object creating is to make a model with only its id set, to lessen data sent in other requests.
        customer = customerApi.search(null, null, null, "test@test.test", "test@test.test", null, null, null, null, null, "id")
                .getValues()
                .stream()
                .findFirst()
                .orElseGet((RuntimeExceptionConverter<Customer>) () ->
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

        final Integer orderId = orderApi.post(new Order()
                .customer(customer)
                .deliveryDate(today.plusDays(7).toString())
                .orderDate(today.toString())
                .isPrioritizeAmountsIncludingVat(true)
        ).getValue().getId();

        // The additional object creating is to make a model with only its id set, to lessen data sent in other requests. Also not all fields can be updated in post operations.
        order = new Order().id(orderId);

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

        executeExample();
    }

    protected abstract void executeExample() throws ApiException;
}
