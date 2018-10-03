package no.tripletex.example.order;

import no.tripletex.api.v2.TripletexApiClient;
import no.tripletex.v2.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderExample {

    private static final Logger LOG = LoggerFactory.getLogger(OrderExample.class);

    public static void main(String[] args) {
        if(args.length != 2) {
            LOG.error("First argument is the consumer token, the second is the employee token.");
            return;
        }

        final String consumerToken = args[0];
        final String employeeToken = args[1];

        try {
            /**
             * See {@link no.tripletex.example.token.TokenExample} for how to use the token / auth API.
             */
            TripletexApiClient tripletexApiClient = new TripletexApiClient(TripletexApiClient.TEST_BASE_PATH, consumerToken, employeeToken);

            new InvoiceOrderViaAction(tripletexApiClient).work();
            new InvoiceOrderViaNewInvoice(tripletexApiClient).work();

        } catch (ApiException e) {
            LOG.error("TokenExample run failed", e);
        }
    }
}
