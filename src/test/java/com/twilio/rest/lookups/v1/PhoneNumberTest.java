/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.lookups.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class PhoneNumberTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.LOOKUPS.toString(),
                                          "/v1/PhoneNumbers/+15017122661");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            PhoneNumber.fetcher(new com.twilio.type.PhoneNumber("+15017122661")).fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"caller_name\": {\"caller_name\": \"Delicious Cheese Cake\",\"caller_type\": \"CONSUMER\",\"error_code\": null},\"carrier\": {\"error_code\": null,\"mobile_country_code\": \"310\",\"mobile_network_code\": \"456\",\"name\": \"verizon\",\"type\": \"mobile\"},\"country_code\": \"US\",\"national_format\": \"(510) 867-5309\",\"phone_number\": \"+15108675309\",\"add_ons\": {\"status\": \"successful\",\"message\": null,\"code\": null,\"results\": {}},\"url\": \"https://lookups.twilio.com/v1/PhoneNumbers/phone_number\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(PhoneNumber.fetcher(new com.twilio.type.PhoneNumber("+15017122661")).fetch());
    }
}