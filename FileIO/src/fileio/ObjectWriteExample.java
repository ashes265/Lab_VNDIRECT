///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fileio;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
///**
// *
// * @author phung
// */
//public class ObjectWriteExample {
//    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//        File file=new File("D:\\University\\OJT\\FileIO\\");
//        ObjectOutputStream output=null;
//        FileOutputStream fileOutput=new FileOutputStream(new File(file, "myobject"));
//        output=new ObjectOutputStream(fileOutput);
////        PrintMessage print=new PrintMessage();
//        output.writeObject(new PrintMessage("Phung Duc Hai"));
////        output.close();
//        
//        ObjectInputStream input = null;
//        input = new ObjectInputStream(new FileInputStream(new File(file, "myobject")));
//        Object obj = input.readObject();
//        Method method = obj.getClass().getMethod("run", new Class[0]);
//        method.invoke(obj, new Object[0]);
//        input.close();
//    }
//}
