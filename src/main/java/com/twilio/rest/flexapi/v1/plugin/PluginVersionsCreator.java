/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Flex
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.flexapi.v1.plugin;

import com.twilio.base.Creator;
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
import java.net.URI;
import java.net.URI;

public class PluginVersionsCreator extends Creator<PluginVersions> {

    private String pathPluginSid;
    private String version;
    private URI pluginUrl;
    private String flexMetadata;
    private String changelog;
    private Boolean _private;
    private String cliVersion;
    private String validateStatus;

    public PluginVersionsCreator(
        final String pathPluginSid,
        final String version,
        final URI pluginUrl
    ) {
        this.pathPluginSid = pathPluginSid;
        this.version = version;
        this.pluginUrl = pluginUrl;
    }

    public PluginVersionsCreator setVersion(final String version) {
        this.version = version;
        return this;
    }

    public PluginVersionsCreator setPluginUrl(final URI pluginUrl) {
        this.pluginUrl = pluginUrl;
        return this;
    }

    public PluginVersionsCreator setPluginUrl(final String pluginUrl) {
        return setPluginUrl(Promoter.uriFromString(pluginUrl));
    }

    public PluginVersionsCreator setFlexMetadata(final String flexMetadata) {
        this.flexMetadata = flexMetadata;
        return this;
    }

    public PluginVersionsCreator setChangelog(final String changelog) {
        this.changelog = changelog;
        return this;
    }

    public PluginVersionsCreator set_private(final Boolean _private) {
        this._private = _private;
        return this;
    }

    public PluginVersionsCreator setCliVersion(final String cliVersion) {
        this.cliVersion = cliVersion;
        return this;
    }

    public PluginVersionsCreator setValidateStatus(
        final String validateStatus
    ) {
        this.validateStatus = validateStatus;
        return this;
    }

    @Override
    public PluginVersions create(final TwilioRestClient client) {
        String path = "/v1/PluginService/Plugins/{PluginSid}/Versions";

        path =
            path.replace(
                "{" + "PluginSid" + "}",
                this.pathPluginSid.toString()
            );
        path = path.replace("{" + "Version" + "}", this.version.toString());
        path = path.replace("{" + "PluginUrl" + "}", this.pluginUrl.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.FLEXAPI.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "PluginVersions creation failed: Unable to connect to server"
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

        return PluginVersions.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (version != null) {
            request.addPostParam("Version", version);
        }
        if (pluginUrl != null) {
            request.addPostParam("PluginUrl", pluginUrl.toString());
        }
        if (changelog != null) {
            request.addPostParam("Changelog", changelog);
        }
        if (_private != null) {
            request.addPostParam("Private", _private.toString());
        }
        if (cliVersion != null) {
            request.addPostParam("CliVersion", cliVersion);
        }
        if (validateStatus != null) {
            request.addPostParam("ValidateStatus", validateStatus);
        }
    }

    private void addHeaderParams(final Request request) {
        if (flexMetadata != null) {
            request.addHeaderParam("Flex-Metadata", flexMetadata);
        }
    }
}
