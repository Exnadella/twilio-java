/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.incomingphonenumber;

import com.twilio.base.Deleter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class AssignedAddOnDeleter extends Deleter<AssignedAddOn> {
    private String pathAccountSid;
    private final String pathResourceSid;
    private final String pathSid;

    /**
     * Construct a new AssignedAddOnDeleter.
     * 
     * @param pathResourceSid The resource_sid
     * @param pathSid The Installed Add-on Sid to remove
     */
    public AssignedAddOnDeleter(final String pathResourceSid, 
                                final String pathSid) {
        this.pathResourceSid = pathResourceSid;
        this.pathSid = pathSid;
    }

    /**
     * Construct a new AssignedAddOnDeleter.
     * 
     * @param pathAccountSid The account_sid
     * @param pathResourceSid The resource_sid
     * @param pathSid The Installed Add-on Sid to remove
     */
    public AssignedAddOnDeleter(final String pathAccountSid, 
                                final String pathResourceSid, 
                                final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathResourceSid = pathResourceSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the delete.
     * 
     * @param client TwilioRestClient with which to make the request
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public boolean delete(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.DELETE,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/IncomingPhoneNumbers/" + this.pathResourceSid + "/AssignedAddOns/" + this.pathSid + ".json",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("AssignedAddOn delete failed: Unable to connect to server");
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

        return response.getStatusCode() == 204;
    }
}