package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	public Serialization() {
		// TODO Auto-generated constructor stub
	}
    public static boolean WriteObjectToFile(Object serObj, String path) {
   	 
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            return true;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static Object ReadObjectFromFile(String path)
    {
    	 try {
	          FileInputStream fileIn = new FileInputStream(path);
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          Object e = (Object) in.readObject();
	          in.close();
	          fileIn.close();
	          return e;
	       } catch (Exception ex) {
	            ex.printStackTrace();
	            return false;
	        }
    }
}
