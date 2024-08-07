/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Content
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.content.v2;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.constant.EnumConstants;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.time.ZonedDateTime;
import java.util.List;

public class ContentAndApprovalsReader extends Reader<ContentAndApprovals> {

    private Integer pageSize;
    private String sortByDate;
    private String sortByContentName;
    private ZonedDateTime dateCreatedAfter;
    private ZonedDateTime dateCreatedBefore;
    private String contentName;
    private String content;
    private List<String> language;
    private List<String> contentType;
    private List<String> channelEligibility;

    public ContentAndApprovalsReader() {}

    public ContentAndApprovalsReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public ContentAndApprovalsReader setSortByDate(final String sortByDate) {
        this.sortByDate = sortByDate;
        return this;
    }

    public ContentAndApprovalsReader setSortByContentName(
        final String sortByContentName
    ) {
        this.sortByContentName = sortByContentName;
        return this;
    }

    public ContentAndApprovalsReader setDateCreatedAfter(
        final ZonedDateTime dateCreatedAfter
    ) {
        this.dateCreatedAfter = dateCreatedAfter;
        return this;
    }

    public ContentAndApprovalsReader setDateCreatedBefore(
        final ZonedDateTime dateCreatedBefore
    ) {
        this.dateCreatedBefore = dateCreatedBefore;
        return this;
    }

    public ContentAndApprovalsReader setContentName(final String contentName) {
        this.contentName = contentName;
        return this;
    }

    public ContentAndApprovalsReader setContent(final String content) {
        this.content = content;
        return this;
    }

    public ContentAndApprovalsReader setLanguage(final List<String> language) {
        this.language = language;
        return this;
    }

    public ContentAndApprovalsReader setLanguage(final String language) {
        return setLanguage(Promoter.listOfOne(language));
    }

    public ContentAndApprovalsReader setContentType(
        final List<String> contentType
    ) {
        this.contentType = contentType;
        return this;
    }

    public ContentAndApprovalsReader setContentType(final String contentType) {
        return setContentType(Promoter.listOfOne(contentType));
    }

    public ContentAndApprovalsReader setChannelEligibility(
        final List<String> channelEligibility
    ) {
        this.channelEligibility = channelEligibility;
        return this;
    }

    public ContentAndApprovalsReader setChannelEligibility(
        final String channelEligibility
    ) {
        return setChannelEligibility(Promoter.listOfOne(channelEligibility));
    }

    @Override
    public ResourceSet<ContentAndApprovals> read(
        final TwilioRestClient client
    ) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<ContentAndApprovals> firstPage(final TwilioRestClient client) {
        String path = "/v2/ContentAndApprovals";

        Request request = new Request(
            HttpMethod.GET,
            Domains.CONTENT.toString(),
            path
        );

        addQueryParams(request);
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        return pageForRequest(client, request);
    }

    private Page<ContentAndApprovals> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "ContentAndApprovals read failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException(
                    "Server Error, no content",
                    response.getStatusCode()
                );
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "contents",
            response.getContent(),
            ContentAndApprovals.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<ContentAndApprovals> previousPage(
        final Page<ContentAndApprovals> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.CONTENT.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<ContentAndApprovals> nextPage(
        final Page<ContentAndApprovals> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.CONTENT.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<ContentAndApprovals> getPage(
        final String targetUrl,
        final TwilioRestClient client
    ) {
        Request request = new Request(HttpMethod.GET, targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (pageSize != null) {
            request.addQueryParam("PageSize", pageSize.toString());
        }
        if (sortByDate != null) {
            request.addQueryParam("SortByDate", sortByDate);
        }
        if (sortByContentName != null) {
            request.addQueryParam("SortByContentName", sortByContentName);
        }
        if (dateCreatedAfter != null) {
            request.addQueryParam(
                "DateCreatedAfter",
                dateCreatedAfter.toInstant().toString()
            );
        }

        if (dateCreatedBefore != null) {
            request.addQueryParam(
                "DateCreatedBefore",
                dateCreatedBefore.toInstant().toString()
            );
        }

        if (contentName != null) {
            request.addQueryParam("ContentName", contentName);
        }
        if (content != null) {
            request.addQueryParam("Content", content);
        }
        if (language != null) {
            for (String prop : language) {
                request.addQueryParam("Language", prop);
            }
        }
        if (contentType != null) {
            for (String prop : contentType) {
                request.addQueryParam("ContentType", prop);
            }
        }
        if (channelEligibility != null) {
            for (String prop : channelEligibility) {
                request.addQueryParam("ChannelEligibility", prop);
            }
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
