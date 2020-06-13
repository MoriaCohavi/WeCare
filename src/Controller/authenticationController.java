package Controller;

import Model.*;
import View.*;

public class authenticationController{
	public static String serPath = "src\\Model\\files\\authentication.ser";
	private Authentication authentication;
	private LoginView login_view;
	
	public authenticationController() {
		
		// init users hashmap
		// add manager specificly
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
    
	public void serialize(serHandlerController handler)
	{
		handler.serialize(authentication, serPath);
	}
	
	public void deserialize(serHandlerController handler)
	{
		authentication = (Authentication)handler.deserialize(serPath);
	}
	
	public void openLoginForm()
	{
		login_view = new LoginView();
	}
	
	public void nextPage(long token)
	{
		String type = this.fetchUserType(token);
		if (type.equals("Manager"))
		{
//			ManagerPanelView managerPanel = new ManagerPanelView(token);
			ManagerPanelView managerPanel = new ManagerPanelView(token);
		}
		else if (type.equals("Doctor"))
		{
			DoctorView doctorPanel = new DoctorView();
		}
	}
	
}