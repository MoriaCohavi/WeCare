package ModelTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Model.Authentication;
import Model.User;
import Model.StatisitcalData;

public class StatisticalDataTest {
	
	@Test
	public void ChekcVisitTime()
	{
		
		StatisitcalData stat = new StatisitcalData();
		double num = 5;
		double newNum = stat.getTotalVisitTime() + num;
		stat.addtotalVisitTime(num);
	    Assert.assertEquals(0,(newNum), stat.getTotalVisitTime());
	}
	
	@Test
	public void ChekcDailyPatients()
	{
		
		StatisitcalData stat = new StatisitcalData();
		double num = 5;
		double newNum = stat.getTotalDailyPatients() + num;
		stat.setTotalDailyPatients(num);
	    Assert.assertEquals(0,(newNum), stat.getTotalDailyPatients());
	}
	
	@Test
	public void ChekcDailylabs()
	{
		
		StatisitcalData stat = new StatisitcalData();
		double num = 5;
		double newNum = stat.getTotalDailylabs() + num;
		stat.addtotalDailylabs(num);
	    Assert.assertEquals(0,(newNum), stat.getTotalDailylabs());
	}
	
	@Test
	public void ChekcDailySubs()
	{
		
		StatisitcalData stat = new StatisitcalData();
		double num = 5;
		double newNum = stat.getTotalDailySubs() + num;
		stat.addtotalDailySubs(num);
	    Assert.assertEquals(0,(newNum), stat.getTotalDailySubs());
	}	
	
}
