package com.twilio.sdk.resource.instance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.InstanceResource;

/**
 * The AuthorizedConnectApps list resource shows all of the Connect Apps that
 * you have authorized for your account. Each Connect App corresponds to a
 * subaccount within your Twilio account, which acts as that Connect App's
 * sandbox. The instance resource shows you the permissions you have granted for
 * a Connect App as well as information about the Connect App itself.
 * 
 * 
 * 
 * For more information see <a
 * href="http://www.twilio.com/docs/api/rest/authorized-connect-apps"
 * >http://www.twilio.com/docs/api/rest/authorized-connect-apps</a>
 */
public class AuthorizedConnectApp extends InstanceResource {

	/** The Constant SID_PROPERTY. */
	private static final String SID_PROPERTY = "connect_app_sid";

	/** The Constant DATE_UPDATED_PROPERTY. */
	private static final String DATE_UPDATED_PROPERTY = "date_updated";

	/** The Constant DATE_CREATED_PROPERTY. */
	private static final String DATE_CREATED_PROPERTY = "date_created";

	/** The Constant FRIENDLY_NAME_PROPERTY. */
	private static final String FRIENDLY_NAME_PROPERTY = "friendly_name";

	/**
	 * Instantiates a new application.
	 * 
	 * @param client
	 *            the client
	 */
	public AuthorizedConnectApp(TwilioRestClient client) {
		super(client);
	}

	/**
	 * Instantiates a new application.
	 * 
	 * @param client
	 *            the client
	 * @param sid
	 *            the sid
	 */
	public AuthorizedConnectApp(TwilioRestClient client, String sid) {
		super(client);
		if (sid == null) { 
            throw new IllegalStateException("The Sid for an AuthorizedConnectApp can not be null");
        }
		this.setProperty(SID_PROPERTY, sid);
	}

	/**
	 * Instantiates a new application.
	 * 
	 * @param client
	 *            the client
	 * @param properties
	 *            the properties
	 */
	public AuthorizedConnectApp(TwilioRestClient client,
			Map<String, Object> properties) {
		super(client, properties);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.twilio.sdk.resource.Resource#getResourceLocation()
	 */
	@Override
	protected String getResourceLocation() {
		return "/" + TwilioRestClient.DEFAULT_VERSION + "/Accounts/"
				+ this.getRequestAccountSid() + "/AuthorizedConnectApps/" + this.getSid()
				+ ".json";
	}

	/*
	 * Property getters
	 */
	/**
	 * Gets the sid.
	 * 
	 * @return the sid
	 */
	public String getSid() {
		return this.getProperty(SID_PROPERTY);
	}

	/**
	 * Gets the friendly name.
	 * 
	 * @return the friendly name
	 */
	public String getFriendlyName() {
		return this.getProperty(FRIENDLY_NAME_PROPERTY);
	}

	/**
	 * Gets the date created.
	 * 
	 * @return the date created
	 */
	public Date getDateCreated() {
		SimpleDateFormat format = new SimpleDateFormat(
				"EEE, dd MMM yyyy HH:mm:ss Z");
		try {
			return format.parse(this.getProperty(DATE_CREATED_PROPERTY));
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Gets the date updated.
	 * 
	 * @return the date updated
	 */
	public Date getDateUpdated() {
		SimpleDateFormat format = new SimpleDateFormat(
				"EEE, dd MMM yyyy HH:mm:ss Z");
		try {
			return format.parse(this.getProperty(DATE_UPDATED_PROPERTY));
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Gets the account sid.
	 * 
	 * @return the account sid
	 */
	public String getAccountSid() {
		return this.getProperty("account_sid");
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return this.getProperty("connect_app_description");
	}

	/**
	 * Gets the company name.
	 * 
	 * @return the company name
	 */
	public String getCompanyName() {
		return this.getProperty("connect_app_company_name");
	}

	/**
	 * Gets the homepage url.
	 * 
	 * @return the homepage url
	 */
	public String getHomepageUrl() {
		return this.getProperty("connect_app_homepage_url");
	}

	public List<String> getPermissions() {
		Object obj = this.getObject("permissions");
		return (List<String>) obj;
	}
}
