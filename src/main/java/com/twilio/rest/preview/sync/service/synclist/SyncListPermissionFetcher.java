/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.sync.service.synclist;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class SyncListPermissionFetcher extends Fetcher<SyncListPermission> {
    private final String pathServiceSid;
    private final String pathListSid;
    private final String pathIdentity;

    /**
     * Construct a new SyncListPermissionFetcher.
     * 
     * @param pathServiceSid The service_sid
     * @param pathListSid Sync List SID or unique name.
     * @param pathIdentity Identity of the user to whom the Sync List Permission
     *                     applies.
     */
    public SyncListPermissionFetcher(final String pathServiceSid, 
                                     final String pathListSid, 
                                     final String pathIdentity) {
        this.pathServiceSid = pathServiceSid;
        this.pathListSid = pathListSid;
        this.pathIdentity = pathIdentity;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched SyncListPermission
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public SyncListPermission fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.PREVIEW.toString(),
            "/Sync/Services/" + this.pathServiceSid + "/Lists/" + this.pathListSid + "/Permissions/" + this.pathIdentity + "",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncListPermission fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return SyncListPermission.fromJson(response.getStream(), client.getObjectMapper());
    }
}