/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service.synclist;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class SyncListPermissionUpdater extends Updater<SyncListPermission> {
    private final String pathServiceSid;
    private final String pathListSid;
    private final String pathIdentity;
    private final Boolean read;
    private final Boolean write;
    private final Boolean manage;

    /**
     * Construct a new SyncListPermissionUpdater.
     * 
     * @param pathServiceSid Sync Service Instance SID.
     * @param pathListSid Sync List SID or unique name.
     * @param pathIdentity Identity of the user to whom the Sync List Permission
     *                     applies.
     * @param read Read access.
     * @param write Write access.
     * @param manage Manage access.
     */
    public SyncListPermissionUpdater(final String pathServiceSid, 
                                     final String pathListSid, 
                                     final String pathIdentity, 
                                     final Boolean read, 
                                     final Boolean write, 
                                     final Boolean manage) {
        this.pathServiceSid = pathServiceSid;
        this.pathListSid = pathListSid;
        this.pathIdentity = pathIdentity;
        this.read = read;
        this.write = write;
        this.manage = manage;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated SyncListPermission
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public SyncListPermission update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SYNC.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Lists/" + this.pathListSid + "/Permissions/" + this.pathIdentity + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncListPermission update failed: Unable to connect to server");
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

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (read != null) {
            request.addPostParam("Read", read.toString());
        }

        if (write != null) {
            request.addPostParam("Write", write.toString());
        }

        if (manage != null) {
            request.addPostParam("Manage", manage.toString());
        }
    }
}