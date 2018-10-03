package no.tripletex.example.order;

import no.tripletex.v2.ApiClient;
import no.tripletex.v2.ApiException;
import no.tripletex.v2.api.InvoiceApi;
import no.tripletex.v2.model.Invoice;
import no.tripletex.v2.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * InvoiceOrderViaNewInvoice shows how to invoice an order via creating the invoice manually.
 * {@link OrderInvoiceExampleBaseline} contains all the shared values between the invoice examples.
 *
 *
 * @author tellef
 * @date 03.10.2018
 */
public class InvoiceOrderViaNewInvoice extends OrderInvoiceExampleBaseline {

    private static final Logger LOG = LoggerFactory.getLogger(InvoiceOrderViaNewInvoice.class);

    public InvoiceOrderViaNewInvoice(ApiClient apiClient) {
        super(apiClient);
    }

    protected void executeExample() throws ApiException {
        final LocalDate today = LocalDate.now();

        final InvoiceApi invoiceApi = new InvoiceApi(apiClient);

        Invoice invoice = invoiceApi.post(
                new Invoice()
                        .addOrdersItem(new Order().id(order.getId()))
                        .invoiceDate(today.toString())
                        .invoiceDueDate(today.plusDays(30L).toString()),
                false,
                null,
                null
        ).getValue();

        invoice = invoiceApi.payment(invoice.getId(), today.toString(), paymentType.getId(), invoice.getAmount()).getValue();
        LOG.info(invoice.toString());
    }
}
