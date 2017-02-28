/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.pricing.v1.voice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.type.InboundCallPrice;
import com.twilio.type.OutboundCallPrice;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Currency;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Number extends Resource {
    private static final long serialVersionUID = 198694876395979L;

    /**
     * Create a NumberFetcher to execute fetch.
     * 
     * @param pathNumber The number
     * @return NumberFetcher capable of executing the fetch
     */
    public static NumberFetcher fetcher(final com.twilio.type.PhoneNumber pathNumber) {
        return new NumberFetcher(pathNumber);
    }

    /**
     * Converts a JSON String into a Number object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Number object represented by the provided JSON
     */
    public static Number fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Number.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Number object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Number object represented by the provided JSON
     */
    public static Number fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Number.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final com.twilio.type.PhoneNumber number;
    private final String country;
    private final String isoCountry;
    private final OutboundCallPrice outboundCallPrice;
    private final InboundCallPrice inboundCallPrice;
    private final Currency priceUnit;
    private final URI url;

    @JsonCreator
    private Number(@JsonProperty("number")
                   final com.twilio.type.PhoneNumber number, 
                   @JsonProperty("country")
                   final String country, 
                   @JsonProperty("iso_country")
                   final String isoCountry, 
                   @JsonProperty("outbound_call_price")
                   final OutboundCallPrice outboundCallPrice, 
                   @JsonProperty("inbound_call_price")
                   final InboundCallPrice inboundCallPrice, 
                   @JsonProperty("price_unit")
                   @JsonDeserialize(using = com.twilio.converter.CurrencyDeserializer.class)
                   final Currency priceUnit, 
                   @JsonProperty("url")
                   final URI url) {
        this.number = number;
        this.country = country;
        this.isoCountry = isoCountry;
        this.outboundCallPrice = outboundCallPrice;
        this.inboundCallPrice = inboundCallPrice;
        this.priceUnit = priceUnit;
        this.url = url;
    }

    /**
     * Returns The The number.
     * 
     * @return The number
     */
    public final String getSid() {
        return this.getNumber().toString();
    }

    /**
     * Returns The The number.
     * 
     * @return The number
     */
    public final com.twilio.type.PhoneNumber getNumber() {
        return this.number;
    }

    /**
     * Returns The The country.
     * 
     * @return The country
     */
    public final String getCountry() {
        return this.country;
    }

    /**
     * Returns The The iso_country.
     * 
     * @return The iso_country
     */
    public final String getIsoCountry() {
        return this.isoCountry;
    }

    /**
     * Returns The The outbound_call_price.
     * 
     * @return The outbound_call_price
     */
    public final OutboundCallPrice getOutboundCallPrice() {
        return this.outboundCallPrice;
    }

    /**
     * Returns The The inbound_call_price.
     * 
     * @return The inbound_call_price
     */
    public final InboundCallPrice getInboundCallPrice() {
        return this.inboundCallPrice;
    }

    /**
     * Returns The The price_unit.
     * 
     * @return The price_unit
     */
    public final Currency getPriceUnit() {
        return this.priceUnit;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Number other = (Number) o;

        return Objects.equals(number, other.number) && 
               Objects.equals(country, other.country) && 
               Objects.equals(isoCountry, other.isoCountry) && 
               Objects.equals(outboundCallPrice, other.outboundCallPrice) && 
               Objects.equals(inboundCallPrice, other.inboundCallPrice) && 
               Objects.equals(priceUnit, other.priceUnit) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number,
                            country,
                            isoCountry,
                            outboundCallPrice,
                            inboundCallPrice,
                            priceUnit,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("number", number)
                          .add("country", country)
                          .add("isoCountry", isoCountry)
                          .add("outboundCallPrice", outboundCallPrice)
                          .add("inboundCallPrice", inboundCallPrice)
                          .add("priceUnit", priceUnit)
                          .add("url", url)
                          .toString();
    }
}