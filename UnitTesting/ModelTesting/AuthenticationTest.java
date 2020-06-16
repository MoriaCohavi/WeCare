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
		User user = new User("123456780", 0541234567, "test", "test.gmail.com", "password", "Doctor");		
	    Assert.assertTrue(Authentication.signUp(user.getId(), user) == 1);
	    Assert.assertTrue(Authentication.signUp(user.getId(), user) == -1);
	}
	
	@Test
	public void CheckSignIn()
	{
		User user = new User("123456789", 0541234567, "test", "test.gmail.com", "password", "Doctor");
		Authentication.signUp("123456789", user);
	    Assert.assertTrue(Authentication.signIn("123456700", "testFalse") == -1);
	    Assert.assertTrue(Authentication.signIn("123456789", "password") != -1);
	}
	
	@Test
	public void CheckSignOut()
	{
		User user = new User("123456789", 0541234567, "test", "test.gmail.com", "password", "Doctor");
		Authentication.signUp(user.getId(), user);
		long token = Authentication.signIn("123456789", "password");
		Assert.assertTrue(Authentication.signOut(token));
		Assert.assertFalse(Authentication.signOut(token));
	}
	
	@Test
	public void CheckValidateuser()
	{
		User user1 = new User("123456789", 0541234567, "test", "test.gmail.com", "password", "Doctor");
		Authentication.signUp(user1.getId(), user1);
		User user2 = new User("987654321", 0541234567, "test", "test.gmail.com", "password", "Manager");
		Authentication.signUp(user2.getId(), user2);
		long token1 = Authentication.signIn("123456789", "password");
		long token2 = Authentication.signIn("987654321", "password");
		Assert.assertTrue(Authentication.validateUser(token1, "Doctor"));
		Assert.assertFalse(Authentication.validateUser(token1, "Manager"));
		Assert.assertTrue(Authentication.validateUser(token2, "Manager"));
		Assert.assertFalse(Authentication.validateUser(token2, "Docotor"));
	}
	
	@Test
	public void CheckGenerateToken()
	{
		User user1 = new User("123456789", 0541234567, "test", "test.gmail.com", "password", "Doctor");
		Authentication.signUp(user1.getId(), user1);
		Assert.assertTrue(Authentication.generateToken(user1.getId()) != Authentication.generateToken(user1.getId()));
	}
	/*@Test
	public void CheckResetPassword()
	{
		User user1 = new User("123456789", 0541234567, "test", "test.gmail.com", "password", "Doctor");
		Authentication.signUp(user1.getId(), user1);
		User user2 = new User("987654321", 0541234567, "test", "test.gmail.com", "password", "Manager");
		Authentication.signUp(user2.getId(), user2);
		long token1 = Authentication.signIn("123456789", "password");
		long token2 = Authentication.signIn("987654321", "password");
		String newPassword = "Password1";
		Assert.assertTrue(Authentication.resetPassword(token1, "password", newPassword));
		Assert.assertFalse(Authentication.resetPassword(token1, "testFalse", newPassword));
		Assert.assertTrue(Authentication.resetPassword(token2, "password", newPassword));
		Assert.assertFalse(Authentication.resetPassword(token2, user1.getPassword(), newPassword));
	} */
}
