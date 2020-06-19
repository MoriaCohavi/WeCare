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
		
		StatisitcalData stat = new StatisitcalData("000000000");
		double num = 5;
		stat.addtotalDailyPatients(num);
	    Assert.assertTrue(stat.getTotalDailyPatients() == 5);
	}
	
	@Test
	public void CheckDailylabs()
	{
		
		StatisitcalData stat = new StatisitcalData("000000000");
		double num = 5;
		stat.addtotalDailylabs(num);
		Assert.assertTrue(stat.getTotalDailylabs() == 5);
	}
	
	@Test
	public void CheckDailySubs()
	{
		
		StatisitcalData stat = new StatisitcalData("000000000");
		double num = 5;
		stat.addtotalDailylabs(num);
		Assert.assertTrue(stat.getTotalDailySubs() == 5);
	}	
	
}
