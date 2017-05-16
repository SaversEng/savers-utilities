/**
 * 
 */
package com.savers.utility;

import org.junit.Before;
import org.junit.Test;
import com.savers.utility.TranslateAXAccount;

import junit.framework.TestCase;

/**
 * @author smcintosh
 *
 */
public class TestAccountTranslation extends TestCase {
	
	private TranslateAXAccount _itemUnderTest;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		_itemUnderTest = new TranslateAXAccount();
	}

	@Test
	public void testOriginalValuePreserved() {
		
		// ARRANGE
		String expectedResults = "1-2-3-4-5-6";
		
		// ACT
		String actualResults = _itemUnderTest.translateDisplayValue(expectedResults, null, null, null, null, null);
		
		// ASSERT
		assertEquals(expectedResults, actualResults);
	}
	
	@Test
	public void testOriginalValueModifiedByBusinessUnit() {
		
		// ARRANGE
		String startingAccount = "1-2-3-4-5-6";
		String expectedResults = "1-bu-3-4-5-6";
		
		// ACT
		String actualResults = _itemUnderTest.translateDisplayValue(startingAccount, "bu", null, null, null, null);
		
		// ASSERT
		assertEquals(expectedResults, actualResults);
	}
	
	@Test
	public void testOriginalValueModifiedByDept() {
		
		// ARRANGE
		String startingAccount = "1-2-3-4-5-6";
		String expectedResults = "1-2-dept-4-5-6";
		
		// ACT
		String actualResults = _itemUnderTest.translateDisplayValue(startingAccount, null, "dept", null, null, null);
		
		// ASSERT
		assertEquals(expectedResults, actualResults);
	}

	@Test
	public void testOriginalValueModifiedByCostCenter() {
		
		// ARRANGE
		String startingAccount = "1-2-3-4-5-6";
		String expectedResults = "1-2-3-costcenter-5-6";
		
		// ACT
		String actualResults = _itemUnderTest.translateDisplayValue(startingAccount, null, null, "costcenter", null, null);
		
		// ASSERT
		assertEquals(expectedResults, actualResults);
	}

	@Test
	public void testOriginalValueModifiedByLocation() {
		
		// ARRANGE
		String startingAccount = "1-2-3-4-5-6";
		String expectedResults = "1-2-3-4-location-6";
		
		// ACT
		String actualResults = _itemUnderTest.translateDisplayValue(startingAccount, null, null, null, "location", null);
		
		// ASSERT
		assertEquals(expectedResults, actualResults);
	}

	@Test
	public void testOriginalValueModifiedByProject() {
		
		// ARRANGE
		String startingAccount = "1-2-3-4-5-6";
		String expectedResults = "1-2-3-4-5-project";
		
		// ACT
		String actualResults = _itemUnderTest.translateDisplayValue(startingAccount, null, null, null, null, "project");
		
		// ASSERT
		assertEquals(expectedResults, actualResults);
	}
	
	@Test
	public void testOriginalValueModifiedByAll() {
		
		// ARRANGE
		String startingAccount = "1-2-3-4-5-6";
		String expectedResults = "1-bu-dept-costcenter-location-project";
		
		// ACT
		String actualResults = _itemUnderTest.translateDisplayValue(startingAccount, "bu", "dept", "costcenter", "location", "project");
		
		// ASSERT
		assertEquals(expectedResults, actualResults);
	}
	
}
