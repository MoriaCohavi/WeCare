package Controller;

import java.util.HashMap;

import Model.*;

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
        if (isNumeric(id) && id.length() == 9)
            return Authentication.signUp(id,user);
        else
            return -2; //ID can contain 9 digits only
    }

    /*public String isAuthorized(String token, String typeNeed) // we need to figure where the typeNeed comes from / maybe this function can be deleted.
    {
        if(Authentication.validateUser(token,typeNeed))
            return "true";
        
        return false;
    } */

 /*   public static String changePassword(long token,String cPassword,String nPassword )
    {
      if(Authentication.resetPassword(token,cPassword,nPassword))
        return "Password changed successfuly";
      
      else
        return "Wrong current password, password did not changed";
    } */

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
	
}