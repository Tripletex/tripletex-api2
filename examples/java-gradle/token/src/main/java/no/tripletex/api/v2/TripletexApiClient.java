package no.tripletex.api.v2;

import com.squareup.okhttp.Call;
import no.tripletex.v2.*;
import no.tripletex.v2.api.TokensessionApi;
import no.tripletex.v2.model.SessionToken;

import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Map;

/**
 * This {@link ApiClient} generated session tokens when needed.
 *
 * @author tellef
 * @date 03.10.2018
 */
public class TripletexApiClient extends ApiClient {

    public static final String PRODUCTION_BASE_PATH = "https://tripletex.no/v2";
    public static final String TEST_BASE_PATH = "https://api.tripletex.io/v2";

    private static final TemporalAmount TIME_TO_LIVE_API_TOKEN = Period.ofDays(1);
    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    private static ZonedDateTime getZonedNow() {
        return ZonedDateTime.now(DEFAULT_ZONE_ID);
    }

    private final TokensessionApi sessionApi;

    private final String consumerToken;
    private final String employeeToken;

    private ZonedDateTime tokenValidUntil = getZonedNow().minusDays(1);
    private SessionToken currentSessionToken = null;

    public TripletexApiClient(String consumerToken, String employeeToken) {
        this(TEST_BASE_PATH, consumerToken, employeeToken, "0");
    }

    public TripletexApiClient(String basePath, String consumerToken, String employeeToken) {
        this(basePath, consumerToken, employeeToken, "0");
    }
    public TripletexApiClient(String basePath, String consumerToken, String employeeToken, String username) {
        super();
        super.setBasePath(basePath);
        this.consumerToken = consumerToken;
        this.employeeToken = employeeToken;
        this.setUsername(username);
        this.sessionApi = new TokensessionApi(this);
    }

    @Override
    public Call buildCall(String path, String method, List<Pair> queryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String[] authNames, ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        refreshApiToken();
        return super.buildCall(path, method, queryParams, body, headerParams, formParams, authNames, progressRequestListener);
    }

    @Override
    public void setPassword(String password) {
        // No op
    }

    /**
     * Refreshes the api token, ensuring that it is valid before use.
     *
     * @throws ApiException Thrown when the request fails.
     *
     * @author tellef
     * @date 03.10.2018
     */
    private void refreshApiToken() throws ApiException {
        if(getZonedNow().isBefore(tokenValidUntil)) {
            return;
        }

        doRefreshApiToken();
    }

    /**
     * Does the api token refresh.
     *
     * @throws ApiException Thrown when the request fails.
     *
     * @author tellef
     * @date 03.10.2018
     */
    private synchronized void doRefreshApiToken() throws ApiException {
        if(getZonedNow().isBefore(tokenValidUntil)) {
            return;
        }

        deleteOldToken();
        this.tokenValidUntil = getZonedNow().plus(TIME_TO_LIVE_API_TOKEN);
        this.currentSessionToken = sessionApi.create(this.consumerToken, this.employeeToken, this.tokenValidUntil.format(DateTimeFormatter.ISO_DATE)).getValue();
        super.setPassword(this.currentSessionToken.getToken());
    }

    private void deleteOldToken () {
        try {
            sessionApi.delete(this.currentSessionToken.getToken());
        } catch (Exception ignore) {}
    }
}
