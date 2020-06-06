package Controller;

import Model.Authentication;

public class authenticationController{


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

    /*public String isAuthorized(String token, String typeNeed) // we need to figure where the typeNeed comes from / maybe this function can be deleted.
    {
        if(Authentication.validateUser(token,typeNeed))
            return "true";
        
        return false;
    } */

    public String changePassword(long token,String cPassword,String nPassword )
    {
      if(Authentication.resetPassword(token,cPassword,nPassword))
        return "Password changed successfuly";
      
      else
        return "Wrong current password, password did not changed";
    }

    public String logOut(long token)
    {
        if (Authentication.signOut(token))
            return "Singed out";
        else
            return "user not found";
    }

}