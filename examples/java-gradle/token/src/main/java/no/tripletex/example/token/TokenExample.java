package no.tripletex.example.token;

import no.tripletex.api.v2.TripletexApiClient;
import no.tripletex.v2.ApiClient;
import no.tripletex.v2.ApiException;
import no.tripletex.v2.api.*;
import no.tripletex.v2.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class TokenExample {

    private static final Logger LOG = LoggerFactory.getLogger(TokenExample.class);

    public static void main(String[] args) {
        if(args.length != 2) {
            LOG.error("First argument is the consumer token, the second is the employee token.");
            return;
        }

        final String consumerToken = args[0];
        final String employeeToken = args[1];

        try {
            final TokenExample tokenExample = new TokenExample();
            tokenExample.simple(consumerToken, employeeToken);
            tokenExample.withCustomClient(consumerToken, employeeToken);
        } catch (ApiException e) {
            LOG.error("TokenExample run failed", e);
        }
    }

    private void simple(String consumerToken, String employeeToken) throws ApiException {
        final LocalDate tomorrow = LocalDate.now().plusDays(1L);

        // API client, handles authentication
        final ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(TripletexApiClient.TEST_BASE_PATH);

        // First we need to create a session token. We could have reused an existing token if it has yet to expire.
        final TokensessionApi sessionApi = new TokensessionApi(apiClient);
        final ResponseWrapperSessionToken sessionTokenResponse = sessionApi.create(consumerToken, employeeToken, tomorrow.toString());
        final String sessionToken = sessionTokenResponse.getValue().getToken();

        /**
         * "0" here means that we are authenticating for access to our own data.
         * For accountant / proxy login, the username is the id of the client company that you are
         * authenticating for and will be the context for all calls using the returned session token.
         */
        apiClient.setUsername("0");
        apiClient.setPassword(sessionToken);

        final LoggedInUserInfoDTO loggedInUserInfo = sessionApi.whoAmI("*,company(*),employee(*)").getValue();
        LOG.info(loggedInUserInfo.toString());
    }

    private void withCustomClient(String consumerToken, String employeeToken) throws ApiException {
        TripletexApiClient tripletexApiClient = new TripletexApiClient(TripletexApiClient.TEST_BASE_PATH, consumerToken, employeeToken);

        final TokensessionApi sessionApi = new TokensessionApi(tripletexApiClient);

        final LoggedInUserInfoDTO loggedInUserInfo = sessionApi.whoAmI("*,company(*),employee(*)").getValue();
        LOG.info(loggedInUserInfo.toString());
    }
}
