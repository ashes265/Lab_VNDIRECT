package fileio;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectReaderExample {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        File folder = new File("D:\\University\\OJT\\FileIO\\");
        ObjectInputStream input = null;
        input = new ObjectInputStream(new FileInputStream(new File(folder, "myobject")));
        Object obj = input.readObject();

        Method method = obj.getClass().getMethod("run", new Class[0]);
//        try {
//            method.invoke(obj, new Object[0]);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(ObjectReaderExample.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalArgumentException ex) {
//            Logger.getLogger(ObjectReaderExample.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvocationTargetException ex) {
//            Logger.getLogger(ObjectReaderExample.class.getName()).log(Level.SEVERE, null, ex);
//        }
        method.invoke(obj, new Object[0]);
        input.close();
    }
}
