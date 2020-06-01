package Controller;

import Model.Authentication
import java.util.*
public class AuthenticationController{


    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String login(String id, String password)
    {
        if (isNumeric(id) && id.length() == 9)
            return Authentication.signIn(id,password);
        else
            return "ID can contain 9 digits only";
    }

    /*public String isAuthorized(String token, String typeNeed) // we need to figure where the typeNeed comes from / maybe this function can be deleted.
    {
        if(Authentication.validateUser(token,typeNeed))
            return "true";
        
        return false;
    } */

    public String changePassword(String token,String cPassword,String nPassword )
    {
      if(Authentication.resetPassword(token,cPassword,nPassword))
        return "Password changed successfuly";
      
      else
        return "Wrong current password, password did not changed";
    }

}