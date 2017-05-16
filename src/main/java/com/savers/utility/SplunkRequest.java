/**
 * SplunkRequest class encapsulates the data that is required to 
 * create a Splunk request. 
 */
package com.savers.utility;

import java.io.IOException;
import java.util.HashMap;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.apache.commons.lang.StringEscapeUtils;

public class SplunkRequest {
	
	private String event;
	private String sourcetype = "manual";
	private HashMap<String, String> fieldList = new HashMap<String, String>();
	
	/**
	 * Default Constructor
	 */
	public SplunkRequest() {
	}
	
	/**
	 * @param event
	 */
	public SplunkRequest(String event) {
		this.event = event;
		this.sourcetype = "manual";
	}

	/**
	 * @param event
	 * @param sourcetype
	 */
	public SplunkRequest(String event, String sourcetype) {
		this.event = event;
		this.sourcetype = sourcetype;
	}

	public String getEvent() {
		return event;
	}
	
	public void setEvent(String value) {
		event = value;
	}
	
	/**
	 * Used to ensure that the HashMap gets converted to JSON 
	 * 
	 * @return
	 */
	public String getFields() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
		String jsonValue = "";
		try {
			jsonValue = mapper.writeValueAsString(fieldList);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return StringEscapeUtils.unescapeJava(jsonValue);
	}
	
	/*
	 * Adds the specified key/value pair to the fields hash map
	 */
	public void addFieldMapValue(String key, String value) {
		if(fieldList.containsKey(key)) {
			throw new IllegalArgumentException(String.format("The key %s already exists in the map", key));
		}
		fieldList.put(key, value);
	}

	public String getSourcetype() {
		return sourcetype;
	}
	
	@Override
	public String toString() {
		String jsonValue = null;
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		try {
			jsonValue = StringEscapeUtils.unescapeJava(ow.writeValueAsString(this))
						.replace("\"{\"", "{\"")
						.replace("\"}\"", "\"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonValue;
	}
	
}
