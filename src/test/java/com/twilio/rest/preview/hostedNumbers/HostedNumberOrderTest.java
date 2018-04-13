/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.hostedNumbers;

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

public class HostedNumberOrderTest {
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
                                          Domains.PREVIEW.toString(),
                                          "/HostedNumbers/HostedNumberOrders/HRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            HostedNumberOrder.fetcher("HRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"address_sid\": \"AD11111111111111111111111111111111\",\"call_delay\": 15,\"capabilities\": {\"sms\": true,\"voice\": false},\"cc_emails\": [\"aaa@twilio.com\",\"bbb@twilio.com\"],\"date_created\": \"2017-03-28T20:06:39Z\",\"date_updated\": \"2017-03-28T20:06:39Z\",\"email\": \"test@twilio.com\",\"extension\": \"5105\",\"failure_reason\": \"\",\"friendly_name\": \"friendly_name\",\"incoming_phone_number_sid\": \"PN11111111111111111111111111111111\",\"phone_number\": \"+14153608311\",\"sid\": \"HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"signing_document_sid\": \"PX11111111111111111111111111111111\",\"status\": \"received\",\"unique_name\": \"foobar\",\"url\": \"https://preview.twilio.com/HostedNumbers/HostedNumberOrders/HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"verification_attempts\": 0,\"verification_call_sids\": [\"CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab\"],\"verification_code\": \"8794\",\"verification_document_sid\": null,\"verification_type\": \"phone-call\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(HostedNumberOrder.fetcher("HRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testDeleteRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.DELETE,
                                          Domains.PREVIEW.toString(),
                                          "/HostedNumbers/HostedNumberOrders/HRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            HostedNumberOrder.deleter("HRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testDeleteResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("null", TwilioRestClient.HTTP_STATUS_CODE_NO_CONTENT);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        HostedNumberOrder.deleter("HRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.PREVIEW.toString(),
                                          "/HostedNumbers/HostedNumberOrders/HRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            HostedNumberOrder.updater("HRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"address_sid\": \"AD11111111111111111111111111111111\",\"call_delay\": 15,\"capabilities\": {\"sms\": true,\"voice\": false},\"cc_emails\": [\"test1@twilio.com\",\"test2@twilio.com\"],\"date_created\": \"2017-03-28T20:06:39Z\",\"date_updated\": \"2017-03-28T20:06:39Z\",\"email\": \"test+hosted@twilio.com\",\"extension\": \"1234\",\"failure_reason\": \"\",\"friendly_name\": \"new friendly name\",\"incoming_phone_number_sid\": \"PN11111111111111111111111111111111\",\"phone_number\": \"+14153608311\",\"sid\": \"HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"signing_document_sid\": \"PX11111111111111111111111111111111\",\"status\": \"pending-loa\",\"unique_name\": \"new unique name\",\"url\": \"https://preview.twilio.com/HostedNumbers/HostedNumberOrders/HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"verification_attempts\": 1,\"verification_call_sids\": [\"CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab\"],\"verification_code\": \"8794\",\"verification_document_sid\": null,\"verification_type\": \"phone-call\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        HostedNumberOrder.updater("HRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.PREVIEW.toString(),
                                          "/HostedNumbers/HostedNumberOrders");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            HostedNumberOrder.reader().read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"meta\": {\"first_page_url\": \"https://preview.twilio.com/HostedNumbers/HostedNumberOrders?PageSize=50&Page=0\",\"key\": \"items\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://preview.twilio.com/HostedNumbers/HostedNumberOrders?PageSize=50&Page=0\"},\"items\": []}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(HostedNumberOrder.reader().read());
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"meta\": {\"first_page_url\": \"https://preview.twilio.com/HostedNumbers/HostedNumberOrders?PageSize=50&Page=0\",\"key\": \"items\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://preview.twilio.com/HostedNumbers/HostedNumberOrders?PageSize=50&Page=0\"},\"items\": [{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"address_sid\": \"AD11111111111111111111111111111111\",\"call_delay\": 15,\"capabilities\": {\"sms\": true,\"voice\": false},\"cc_emails\": [\"aaa@twilio.com\",\"bbb@twilio.com\"],\"date_created\": \"2017-03-28T20:06:39Z\",\"date_updated\": \"2017-03-28T20:06:39Z\",\"email\": \"test@twilio.com\",\"extension\": \"1234\",\"failure_reason\": \"\",\"friendly_name\": \"friendly_name\",\"incoming_phone_number_sid\": \"PN11111111111111111111111111111111\",\"phone_number\": \"+14153608311\",\"sid\": \"HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"signing_document_sid\": \"PX11111111111111111111111111111111\",\"status\": \"received\",\"unique_name\": \"foobar\",\"url\": \"https://preview.twilio.com/HostedNumbers/HostedNumberOrders/HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"verification_attempts\": 0,\"verification_call_sids\": [\"CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"CAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab\"],\"verification_code\": \"8794\",\"verification_document_sid\": null,\"verification_type\": \"phone-call\"}]}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(HostedNumberOrder.reader().read());
    }

    @Test
    public void testCreateRequest() {
                    new NonStrictExpectations() {{
                        Request request = new Request(HttpMethod.POST,
                                                      Domains.PREVIEW.toString(),
                                                      "/HostedNumbers/HostedNumberOrders");
                        request.addPostParam("PhoneNumber", serialize(new com.twilio.type.PhoneNumber("+15017122661")));
        request.addPostParam("SmsCapability", serialize(true));
                        twilioRestClient.request(request);
                        times = 1;
                        result = new Response("", 500);
                        twilioRestClient.getAccountSid();
                        result = "AC123";
                    }};

        try {
            HostedNumberOrder.creator(new com.twilio.type.PhoneNumber("+15017122661"), true).create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"address_sid\": \"AD11111111111111111111111111111111\",\"call_delay\": 0,\"capabilities\": {\"sms\": true,\"voice\": false},\"cc_emails\": [],\"date_created\": \"2017-03-28T20:06:39Z\",\"date_updated\": \"2017-03-28T20:06:39Z\",\"email\": \"test@twilio.com\",\"extension\": null,\"failure_reason\": \"\",\"friendly_name\": null,\"incoming_phone_number_sid\": \"PN11111111111111111111111111111111\",\"phone_number\": \"+14153608311\",\"sid\": \"HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"signing_document_sid\": null,\"status\": \"received\",\"unique_name\": null,\"url\": \"https://preview.twilio.com/HostedNumbers/HostedNumberOrders/HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"verification_attempts\": 0,\"verification_call_sids\": null,\"verification_code\": null,\"verification_document_sid\": null,\"verification_type\": \"phone-call\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        HostedNumberOrder.creator(new com.twilio.type.PhoneNumber("+15017122661"), true).create();
    }

    @Test
    public void testCreateWithoutOptionalLoaFieldsResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"address_sid\": null,\"call_delay\": 0,\"capabilities\": {\"sms\": true,\"voice\": false},\"cc_emails\": [],\"date_created\": \"2017-03-28T20:06:39Z\",\"date_updated\": \"2017-03-28T20:06:39Z\",\"email\": null,\"extension\": null,\"failure_reason\": \"\",\"friendly_name\": null,\"incoming_phone_number_sid\": \"PN11111111111111111111111111111111\",\"phone_number\": \"+14153608311\",\"sid\": \"HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"signing_document_sid\": null,\"status\": \"received\",\"unique_name\": null,\"url\": \"https://preview.twilio.com/HostedNumbers/HostedNumberOrders/HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"verification_attempts\": 0,\"verification_call_sids\": null,\"verification_code\": null,\"verification_document_sid\": null,\"verification_type\": \"phone-call\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        HostedNumberOrder.creator(new com.twilio.type.PhoneNumber("+15017122661"), true).create();
    }

    @Test
    public void testCreateWithPhoneBillVerificationResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"address_sid\": null,\"call_delay\": 0,\"capabilities\": {\"sms\": true,\"voice\": false},\"cc_emails\": [],\"date_created\": \"2017-03-28T20:06:39Z\",\"date_updated\": \"2017-03-28T20:06:39Z\",\"email\": null,\"extension\": null,\"failure_reason\": \"\",\"friendly_name\": null,\"incoming_phone_number_sid\": \"PN11111111111111111111111111111111\",\"phone_number\": \"+14153608311\",\"sid\": \"HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"signing_document_sid\": null,\"status\": \"received\",\"unique_name\": null,\"url\": \"https://preview.twilio.com/HostedNumbers/HostedNumberOrders/HRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"verification_attempts\": 0,\"verification_call_sids\": null,\"verification_code\": null,\"verification_document_sid\": \"RIaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"verification_type\": \"phone-bill\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        HostedNumberOrder.creator(new com.twilio.type.PhoneNumber("+15017122661"), true).create();
    }
}