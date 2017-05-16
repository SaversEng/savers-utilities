package com.savers.utility;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {
    
    static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
        LOG.info("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));
		System.out.println(getLocalCurrentDate());
	}

	private static String getLocalCurrentDate() {

		LocalDate date = LocalDate.now();
		return date.toString();
	}

}