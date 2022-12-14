/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Bulkexports
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.bulkexports.v1.export;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import java.util.Objects;



@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Day extends Resource {
    private static final long serialVersionUID = 277630118297206L;

    public static DayFetcher fetcher(final String pathResourceType, final String pathDay){
        return new DayFetcher(pathResourceType, pathDay);
    }

    public static DayReader reader(final String pathResourceType){
        return new DayReader(pathResourceType);
    }

    /**
    * Converts a JSON String into a Day object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Day object represented by the provided JSON
    */
    public static Day fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Day.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Day object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Day object represented by the provided JSON
    */
    public static Day fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Day.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final URI redirectTo;
    private final String day;
    private final Integer size;
    private final String createDate;
    private final String friendlyName;
    private final String resourceType;

    @JsonCreator
    private Day(
        @JsonProperty("redirect_to")
        final URI redirectTo,

        @JsonProperty("day")
        final String day,

        @JsonProperty("size")
        final Integer size,

        @JsonProperty("create_date")
        final String createDate,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("resource_type")
        final String resourceType
    ) {
        this.redirectTo = redirectTo;
        this.day = day;
        this.size = size;
        this.createDate = createDate;
        this.friendlyName = friendlyName;
        this.resourceType = resourceType;
    }

        public final URI getRedirectTo() {
            return this.redirectTo;
        }
        public final String getDay() {
            return this.day;
        }
        public final Integer getSize() {
            return this.size;
        }
        public final String getCreateDate() {
            return this.createDate;
        }
        public final String getFriendlyName() {
            return this.friendlyName;
        }
        public final String getResourceType() {
            return this.resourceType;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Day other = (Day) o;

        return Objects.equals(redirectTo, other.redirectTo) &&  Objects.equals(day, other.day) &&  Objects.equals(size, other.size) &&  Objects.equals(createDate, other.createDate) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(resourceType, other.resourceType)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(redirectTo, day, size, createDate, friendlyName, resourceType);
    }

}

