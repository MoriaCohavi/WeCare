package Controller;

import Model.Serialization;
import java.io.*;

import Model.Clinic;

public class serHandlerController {
	
	public serHandlerController() {
	}
    public static boolean serialize(Object serObj, String path) {
    	try
    	{
    		Serialization.WriteObjectToFile(serObj, path);
    		return true;
    	}
    	catch (Exception e)
    	{
    		return false;
    	}
    }
    
    public static Object deserialize(String path)
    {
    	Object deserialized;
    	try
    	{
    		deserialized = Serialization.ReadObjectFromFile(path);
    		return deserialized;
    	}
    	catch (Exception e)
    	{
    		return null;
    	}
    }
}
