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
        if (isNumeric(id))
            return Authentication.signIn(id,password);
    }


}