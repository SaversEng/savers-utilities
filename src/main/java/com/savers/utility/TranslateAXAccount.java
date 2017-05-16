package com.savers.utility;

import org.apache.commons.lang3.StringUtils;

public class TranslateAXAccount {
	
	private static final String AccountFormat = "%s-%s-%s-%s-%s-%s";
	private static final String AccountDelimiter = "-";
	
	// Private method that can build any DisplayValue for AX based on the inputs
	//
	public String translateDisplayValue(String originalValue, String businessUnit, String dept, String costCenter, String location, String project) throws IllegalArgumentException {
	
		String[] accountParts = originalValue.split(AccountDelimiter, -1);
		/* If the account is not in the form 1340050----- */
		
		/* Validate the length of the account number */
		int lengthOfAccountNumber = accountParts == null ? 0 : accountParts.length;
		if(lengthOfAccountNumber != 6) {
			throw new IllegalArgumentException(String.format("A length of %d for the account number to translate is not valid for account number %s", lengthOfAccountNumber, originalValue));
		}

		/* We always get the 0th element of the account number */
		String baseAccount = accountParts[0];
		businessUnit = !StringUtils.isBlank(businessUnit) ? businessUnit : accountParts[1];
		dept = !StringUtils.isBlank(dept) ? dept : accountParts[2];
		costCenter = !StringUtils.isBlank(costCenter) ? costCenter : accountParts[3];
		location = !StringUtils.isBlank(location) ? location : accountParts[4];
		project = !StringUtils.isBlank(project) ? project : accountParts[5];

		/* Form the new account number */
		return String.format(AccountFormat,	baseAccount, 
											StringUtils.isBlank(businessUnit) ? "" : businessUnit, 
											StringUtils.isBlank(dept) ? "" : dept, 
											StringUtils.isBlank(costCenter) ? "" : costCenter, 
											StringUtils.isBlank(location) ? "" : location, 
											StringUtils.isBlank(project) ? "" : project);

	}

}
