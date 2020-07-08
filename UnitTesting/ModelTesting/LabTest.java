package ModelTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Model.*;

public class LabTest {
	@Test
	public void CheckUpdateResults() {		
		Lab lab1 = new Lab("Blood Test", null, false, "000000000");
		Lab lab2 = new Lab("Urin Test", null, false, "000000000");
		
		lab1.updateResults("Normal", false);
		lab2.updateResults("Abnormal", true);
		
		Assert.assertTrue(lab1.getAttentionRequired() == false && lab1.getResult().equals("Normal"));
		Assert.assertTrue(lab2.getAttentionRequired() == true && lab2.getResult().equals("Abnormal"));
	}
}
