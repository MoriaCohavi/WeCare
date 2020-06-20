package ModelTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Model.*;

public class StatisticalDataTest {
	
	
	@Test
	public void CheckAddDailyPatients()
	{
		
		StatisitcalData stat1 = new StatisitcalData("000000001");
		double num = 5;
		stat1.addtotalDailyPatients(num);
	    Assert.assertTrue(stat1.getTotalDailyPatients() == 5);
	}
	
	@Test
	public void CheckDailylabs()
	{
		
		StatisitcalData stat2 = new StatisitcalData("000000002");
		double num = 5;
		stat2.addtotalDailylabs(num);
		Assert.assertTrue(stat2.getTotalDailylabs() == 5);
	}
	
	@Test
	public void CheckDailySubs()
	{
		
		StatisitcalData stat3 = new StatisitcalData("000000003");
		double num = 5;
		stat3.addtotalDailySubs(num);
		Assert.assertTrue(stat3.getTotalDailySubs() == 5);
	}	
	
}
