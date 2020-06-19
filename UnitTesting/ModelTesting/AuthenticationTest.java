package ModelTesting;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Controller.authenticationController;
import Model.*;

public class AuthenticationTest {
	
	@Test
	public void CheckSHA1()
	{
		String first = Authentication.SHA1("admin");
		String second = Authentication.SHA1("admin");
		
	    Assert.assertTrue(first.equals(second) && second.equals(first));
	    Assert.assertTrue(first.hashCode() == second.hashCode());
	}
	
	@Test
	public void CheckSignUp()
	{
		User user = new User("000000008", 0541234567, "test", "test.gmail.com", "password", "Doctor");		
	    Assert.assertTrue(Authentication.signUp(user.getId(), user) == 1);
	    Assert.assertTrue(Authentication.signUp(user.getId(), user) == -1);
	    
	    Authentication.signOut(user.getToken());
	    
	}
	
	@Test
	public void CheckSignIn()
	{
		User user = new User("000000000", 0541234567, "test", "test.gmail.com", "password", "Doctor");
		Authentication.signUp("000000000", user);
	    Assert.assertTrue(Authentication.signIn("000000000", "testFalse") == -1);
	    Assert.assertTrue(Authentication.signIn("000000000", "password") != 1);
	    
	    Authentication.signOut(user.getToken());
	    

	    
	}
	
	@Test
	public void CheckSignOut()
	{
		User user = new User("000000000", 0541234567, "test", "test.gmail.com", "password", "Doctor");
		Authentication.signUp(user.getId(), user);
		long token = Authentication.signIn("000000000", "password");
		Assert.assertTrue(Authentication.signOut(token));
		Assert.assertFalse(Authentication.signOut(token));
	}
	
	@Test
	public void CheckValidateuser()
	{
		User user1 = new User("000000000", 0541234567, "test", "test.gmail.com", "password", "Doctor");
		Authentication.signUp(user1.getId(), user1);
		User user2 = new User("000000001", 0541234567, "test", "test.gmail.com", "password", "Manager");
		Authentication.signUp(user2.getId(), user2);
		long token1 = Authentication.signIn("000000000", "password");
		long token2 = Authentication.signIn("000000001", "password");
		Assert.assertTrue(Authentication.validateUser(token1, "Doctor"));
		Assert.assertFalse(Authentication.validateUser(token1, "Manager"));
		Assert.assertTrue(Authentication.validateUser(token2, "Manager"));
		Assert.assertFalse(Authentication.validateUser(token2, "Docotor"));
		
		Authentication.signOut(user1.getToken());
		Authentication.signOut(user2.getToken());
	}
	
	@Test
	public void CheckGenerateToken()
	{
		User user1 = new User("000000000", 0541234567, "test", "test.gmail.com", "password", "Doctor");
		Authentication.signUp(user1.getId(), user1);
		Assert.assertTrue(Authentication.generateToken(user1.getId()) != Authentication.generateToken(user1.getId()));
		
		Authentication.signOut(user1.getToken());
	}
	
	@Test
	public void CheckUpdateDoctorInfo()
	{
		Doctor doctor = new Doctor("000000000", "000000003", 5200000, "Name", "Email", "Spetialty","password", "Doctor");
		Authentication.signUp("000000000", doctor);
		Assert.assertTrue(Authentication.updateDoctorInfo(doctor.getId(), "Email test", 0541234567));
		Assert.assertFalse(Authentication.updateDoctorInfo("000000009", "Email test", 0541234567));
		
		Authentication.signOut(doctor.getToken());
	}
}
