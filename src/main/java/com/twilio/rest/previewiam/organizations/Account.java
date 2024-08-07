/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Organization Public API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.previewiam.organizations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.bearertoken.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Account extends Resource {

    private static final long serialVersionUID = 140632441815443L;

    public static AccountFetcher fetcher(
        final String pathOrganizationSid,
        final String pathAccountSid
    ) {
        return new AccountFetcher(pathOrganizationSid, pathAccountSid);
    }

    public static AccountReader reader(final String pathOrganizationSid) {
        return new AccountReader(pathOrganizationSid);
    }

    /**
     * Converts a JSON String into a Account object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Account object represented by the provided JSON
     */
    public static Account fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Account.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Account object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Account object represented by the provided JSON
     */
    public static Account fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Account.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String friendlyName;
    private final Account.StatusEnum status;
    private final String ownerSid;
    private final ZonedDateTime dateCreated;

    @JsonCreator
    private Account(
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("friendly_name") final String friendlyName,
        @JsonProperty("status") final Account.StatusEnum status,
        @JsonProperty("owner_sid") final String ownerSid,
        @JsonProperty("date_created") final String dateCreated
    ) {
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.status = status;
        this.ownerSid = ownerSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final Account.StatusEnum getStatus() {
        return this.status;
    }

    public final String getOwnerSid() {
        return this.ownerSid;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account other = (Account) o;

        return (
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(friendlyName, other.friendlyName) &&
            Objects.equals(status, other.status) &&
            Objects.equals(ownerSid, other.ownerSid) &&
            Objects.equals(dateCreated, other.dateCreated)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountSid,
            friendlyName,
            status,
            ownerSid,
            dateCreated
        );
    }

    public enum StatusEnum {
        ACTIVE("active"),
        SUSPENDED("suspended"),
        PENDING_CLOSURE("pending_closure"),
        CLOSED("closed");

        private final String value;

        private StatusEnum(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static StatusEnum forValue(final String value) {
            return Promoter.enumFromString(value, StatusEnum.values());
        }
    }
}
