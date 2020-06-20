package Controller;

import java.util.HashMap;

import Model.*;
//import sun.tools.tree.ThisExpression;

public class authenticationController{
	public static String userSerPath = "src\\Model\\files\\users.ser";
	private static Authentication authentication;
	
	public authenticationController() {
		authentication = new Authentication();
	}
	
    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
            if(strNum.matches("[0-9]+"))
                return true;
            
            return false;
    }
    
    public User getLoggedinUser(long token)
    {
    	return authentication.getLoggedinusers().get(token);
    }

    public long login(String id, String password)
    {
        if (isNumeric(id) && id.length() == 9)
            return Authentication.signIn(id,password);
        else
            return -2; //ID can contain 9 digits only
    }
    
    public static int register(String id, User user)
    {
        if (isNumeric(id) && id.length() == 9 && validateTestID(id))
            return Authentication.signUp(id,user);
        else
            return -2; //ID can contain 9 digits only
    }

    public static String logOut(long token)
    {
        if (Authentication.signOut(token))
            return "Singed out";
        else
            return "user not found";
    }

    public String fetchUserType(long token)
    {
    	return Authentication.getType(token);
    }
    
	public void serialize()
	{
		HashMap<String,User> tempUsers = authentication.getUsers();
		serHandlerController.serialize(tempUsers, userSerPath);
		
	}
	
	public static boolean deleteUser(long managerToken, String userId)
	{
		if(Authentication.validateUser(managerToken, Authentication.getType(managerToken)))
		{
			if(authentication.remove(userId))
				return true;
		}
		return false;
	}
	
	public boolean deserialize()
	{
		HashMap<String,User> usersTemp = (HashMap<String,User>)serHandlerController.deserialize(userSerPath);
		if (usersTemp == null)
			return false;
		this.authentication.setUsers(usersTemp);
		return true;
	}
	
	private static boolean validateTestID(String userID)
	{
		try
		{
			/** Test IDs are 000000000-000000030*/
			int id = Integer.parseInt(userID);
			if (id < 30)
				return false;
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
}