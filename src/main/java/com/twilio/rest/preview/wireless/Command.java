/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.wireless;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Command extends Resource {
    private static final long serialVersionUID = 102379842720145L;

    /**
     * Create a CommandFetcher to execute fetch.
     * 
     * @param pathSid The sid
     * @return CommandFetcher capable of executing the fetch
     */
    public static CommandFetcher fetcher(final String pathSid) {
        return new CommandFetcher(pathSid);
    }

    /**
     * Create a CommandReader to execute read.
     * 
     * @return CommandReader capable of executing the read
     */
    public static CommandReader reader() {
        return new CommandReader();
    }

    /**
     * Create a CommandCreator to execute create.
     * 
     * @param command The command
     * @return CommandCreator capable of executing the create
     */
    public static CommandCreator creator(final String command) {
        return new CommandCreator(command);
    }

    /**
     * Converts a JSON String into a Command object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Command object represented by the provided JSON
     */
    public static Command fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Command.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Command object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Command object represented by the provided JSON
     */
    public static Command fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Command.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String deviceSid;
    private final String simSid;
    private final String command;
    private final String commandMode;
    private final String status;
    private final String direction;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private Command(@JsonProperty("sid")
                    final String sid, 
                    @JsonProperty("account_sid")
                    final String accountSid, 
                    @JsonProperty("device_sid")
                    final String deviceSid, 
                    @JsonProperty("sim_sid")
                    final String simSid, 
                    @JsonProperty("command")
                    final String command, 
                    @JsonProperty("command_mode")
                    final String commandMode, 
                    @JsonProperty("status")
                    final String status, 
                    @JsonProperty("direction")
                    final String direction, 
                    @JsonProperty("date_created")
                    final String dateCreated, 
                    @JsonProperty("date_updated")
                    final String dateUpdated, 
                    @JsonProperty("url")
                    final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.deviceSid = deviceSid;
        this.simSid = simSid;
        this.command = command;
        this.commandMode = commandMode;
        this.status = status;
        this.direction = direction;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The device_sid.
     * 
     * @return The device_sid
     */
    public final String getDeviceSid() {
        return this.deviceSid;
    }

    /**
     * Returns The The sim_sid.
     * 
     * @return The sim_sid
     */
    public final String getSimSid() {
        return this.simSid;
    }

    /**
     * Returns The The command.
     * 
     * @return The command
     */
    public final String getCommand() {
        return this.command;
    }

    /**
     * Returns The The command_mode.
     * 
     * @return The command_mode
     */
    public final String getCommandMode() {
        return this.commandMode;
    }

    /**
     * Returns The The status.
     * 
     * @return The status
     */
    public final String getStatus() {
        return this.status;
    }

    /**
     * Returns The The direction.
     * 
     * @return The direction
     */
    public final String getDirection() {
        return this.direction;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
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

        Command other = (Command) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(deviceSid, other.deviceSid) && 
               Objects.equals(simSid, other.simSid) && 
               Objects.equals(command, other.command) && 
               Objects.equals(commandMode, other.commandMode) && 
               Objects.equals(status, other.status) && 
               Objects.equals(direction, other.direction) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            deviceSid,
                            simSid,
                            command,
                            commandMode,
                            status,
                            direction,
                            dateCreated,
                            dateUpdated,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("deviceSid", deviceSid)
                          .add("simSid", simSid)
                          .add("command", command)
                          .add("commandMode", commandMode)
                          .add("status", status)
                          .add("direction", direction)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .toString();
    }
}