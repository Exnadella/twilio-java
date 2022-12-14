/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account.call;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.net.URI;



import java.net.URI;

public class UserDefinedMessageSubscriptionCreator extends Creator<UserDefinedMessageSubscription>{
    private String pathCallSid;
    private URI callback;
    private String pathAccountSid;
    private String idempotencyKey;
    private HttpMethod method;

    public UserDefinedMessageSubscriptionCreator(final String pathCallSid, final URI callback) {
        this.pathCallSid = pathCallSid;
        this.callback = callback;
    }
    public UserDefinedMessageSubscriptionCreator(final String pathAccountSid, final String pathCallSid, final URI callback) {
        this.pathAccountSid = pathAccountSid;
        this.pathCallSid = pathCallSid;
        this.callback = callback;
    }

    public UserDefinedMessageSubscriptionCreator setCallback(final URI callback){
        this.callback = callback;
        return this;
    }

    public UserDefinedMessageSubscriptionCreator setCallback(final String callback){
        return setCallback(Promoter.uriFromString(callback));
    }
    public UserDefinedMessageSubscriptionCreator setIdempotencyKey(final String idempotencyKey){
        this.idempotencyKey = idempotencyKey;
        return this;
    }
    public UserDefinedMessageSubscriptionCreator setMethod(final HttpMethod method){
        this.method = method;
        return this;
    }

    @Override
    public UserDefinedMessageSubscription create(final TwilioRestClient client){
        String path = "/2010-04-01/Accounts/{AccountSid}/Calls/{CallSid}/UserDefinedMessageSubscriptions.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{"+"AccountSid"+"}", this.pathAccountSid.toString());
        path = path.replace("{"+"CallSid"+"}", this.pathCallSid.toString());
        path = path.replace("{"+"Callback"+"}", this.callback.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("UserDefinedMessageSubscription creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return UserDefinedMessageSubscription.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (callback != null) {
            request.addPostParam("Callback", callback.toString());
    
        }
        if (idempotencyKey != null) {
            request.addPostParam("IdempotencyKey", idempotencyKey);
    
        }
        if (method != null) {
            request.addPostParam("Method", method.toString());
    
        }
    }
}
