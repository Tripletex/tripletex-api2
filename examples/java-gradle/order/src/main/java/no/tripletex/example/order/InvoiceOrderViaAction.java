package no.tripletex.example.order;

import no.tripletex.v2.ApiClient;
import no.tripletex.v2.ApiException;
import no.tripletex.v2.api.InvoiceApi;
import no.tripletex.v2.api.OrderApi;
import no.tripletex.v2.model.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * InvoiceOrderViaAction shows how to invoice an order via the /order/{id}/:invoice action.
 * {@link OrderInvoiceExampleBaseline} contains all the shared values between the invoice examples.
 *
 * @author tellef
 * @date 03.10.2018
 */
public class InvoiceOrderViaAction extends OrderInvoiceExampleBaseline {

    private static final Logger LOG = LoggerFactory.getLogger(InvoiceOrderViaAction.class);

    public InvoiceOrderViaAction(ApiClient apiClient) {
        super(apiClient);
    }

    protected void executeExample() throws ApiException {
        final LocalDate today = LocalDate.now();

        final OrderApi orderApi = new OrderApi(apiClient);
        final InvoiceApi invoiceApi = new InvoiceApi(apiClient);

        Invoice invoice = orderApi.invoice(order.getId(), today.toString(), false, null, null).getValue();

        invoice = invoiceApi.payment(invoice.getId(), today.toString(), paymentType.getId(), invoice.getAmount()).getValue();
        LOG.info(invoice.toString());
    }
}
