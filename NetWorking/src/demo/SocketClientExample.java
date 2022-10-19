/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author phung
 */
public class SocketClientExample {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9245);
        System.out.println("Client start sending");
        try {
            DataInputStream intput = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF("Hello Servers");
            System.out.println("Sever Say: " + intput.readUTF());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            socket.close();
        }
    }
}
