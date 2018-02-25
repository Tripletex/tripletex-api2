package no.tripletex.example.order;

import no.tripletex.api.v2.TripletexApiClient;
import no.tripletex.v2.ApiException;
import no.tripletex.v2.api.TokensessionApi;
import no.tripletex.v2.model.ResponseWrapperSessionToken;

import java.time.LocalDateTime;

public class Example {

    public static void main(String[] args) throws ApiException {

        if(args.length != 2) {
            // stuff
        }

        // Could also be called applicationToken or integrationToken
        String consumerToken = args[0];
        String employeeToken = args[1];

        TripletexApiClient tripletexApiClient = new TripletexApiClient();

        TokensessionApi sessionApi = new TokensessionApi(tripletexApiClient);

        ResponseWrapperSessionToken sessionTokenResponse = sessionApi.create(consumerToken, employeeToken, LocalDateTime.now().plusHours(1).toString());
        String sessionToken = sessionTokenResponse.getValue().getToken();

        // "0" here means that we are authenticating as ourselves.
        // For accountant login, the username is the id of the company you are using proxy login into.
        tripletexApiClient.setUsername("0");
        tripletexApiClient.setPassword(sessionToken);
    }
}
