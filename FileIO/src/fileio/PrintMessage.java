package fileio;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintMessage implements Runnable,Serializable{

    String x;

    public PrintMessage() {
    }
    
    public PrintMessage(String x) {
        this.x=x;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }
    

    @Override
    public void run() {
        System.out.println("Message: "+x);
    }
//    public static void main(String[] args) throws FileNotFoundException, IOException {
//        File folder=new File("D:\\University\\OJT\\FileIO\\");
//        ObjectOutputStream output=null;
//        FileOutputStream fos=new FileOutputStream(new File(folder,"my_object"));
//        output=new ObjectOutputStream(fos);
//        output.writeObject(new PrintMessage("Can Noi Noi"));
//        output.close();
////        Desktop.getDesktop().open(folder);
//    }

    @Override
    public String toString() {
        return x;
    }
    
}
class ObjectWriteExample {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        File file=new File("D:\\University\\OJT\\FileIO\\");
        ObjectOutputStream output=null;
        FileOutputStream fileOutput=new FileOutputStream(new File(file, "myobject"));
        output=new ObjectOutputStream(fileOutput);
//        PrintMessage print=new PrintMessage();
        output.writeObject(new PrintMessage("Phung Duc Hai"));
//        output.close();
        
        ObjectInputStream input = null;
        input = new ObjectInputStream(new FileInputStream(new File(file, "myobject")));
        Object obj = input.readObject();
        Method method = obj.getClass().getMethod("run", new Class[0]);
        method.invoke(obj, new Object[0]);
        input.close();
    }
}
