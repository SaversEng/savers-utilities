/**
 * ReadFile, used inside of a MuleContext (Java Message Processor) to read the current
 * Account map file into memory
 */
package com.savers.utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

/**
 * @author smcintosh
 *
 */

public class ReadFile implements Callable{
@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		File file = new File("../mappedAccounts.txt");
		String contents = FileUtils.readFileToString(file);
		eventContext.getMessage().setInvocationProperty("fileContents", contents);
		return eventContext.getMessage().getPayload();
	}
}
