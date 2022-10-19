/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author phung
 */
public class SocketServerExample {

    public SocketServerExample() {
    }

    public SocketServerExample(int serverPort) throws IOException {
        ServerSocket serverSock = new ServerSocket(serverPort);
        System.out.println("Sever Listening.....");
        while (true) {
            Socket socket = serverSock.accept();
            Thread t = new Thread() {
                @Override
                public void run() {
                    try{
                        DataInputStream input=new DataInputStream(socket.getInputStream());
                        DataOutputStream output=new DataOutputStream(socket.getOutputStream());
                        System.out.println("Client Say: "+input.readUTF());
                        output.writeUTF("I am a socket server!");
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }

            };
            t.start();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServerExample socket=new SocketServerExample(9245);
    }
}
