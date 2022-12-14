/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Supersim
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.supersim.v1;

import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.base.Page;



public class IpCommandReader extends Reader<IpCommand> {
    private String sim;
    private String simIccid;
    private IpCommand.Status status;
    private IpCommand.Direction direction;
    private Integer pageSize;

    public IpCommandReader(){
    }

    public IpCommandReader setSim(final String sim){
        this.sim = sim;
        return this;
    }
    public IpCommandReader setSimIccid(final String simIccid){
        this.simIccid = simIccid;
        return this;
    }
    public IpCommandReader setStatus(final IpCommand.Status status){
        this.status = status;
        return this;
    }
    public IpCommandReader setDirection(final IpCommand.Direction direction){
        this.direction = direction;
        return this;
    }
    public IpCommandReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<IpCommand> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<IpCommand> firstPage(final TwilioRestClient client) {
        String path = "/v1/IpCommands";

        Request request = new Request(
            HttpMethod.GET,
            Domains.SUPERSIM.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<IpCommand> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("IpCommand read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "ip_commands",
            response.getContent(),
            IpCommand.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<IpCommand> previousPage(final Page<IpCommand> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.SUPERSIM.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<IpCommand> nextPage(final Page<IpCommand> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.SUPERSIM.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<IpCommand> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addQueryParams(final Request request) {
        if (sim != null) {
    
            request.addQueryParam("Sim", sim);
        }
        if (simIccid != null) {
    
            request.addQueryParam("SimIccid", simIccid);
        }
        if (status != null) {
    
            request.addQueryParam("Status", status.toString());
        }
        if (direction != null) {
    
            request.addQueryParam("Direction", direction.toString());
        }
        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if(getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
