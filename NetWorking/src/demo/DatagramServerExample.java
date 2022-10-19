/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatagramServerExample implements Runnable {

    DatagramSocket socket;

    public DatagramServerExample() throws SocketException {
        socket = new DatagramSocket(4445);
        System.out.println("Data Server listening.....");
    }

    @Override
    public void run() {
        try {
            byte[] bytes = new byte[1000];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);
            System.out.println("From Client: " + new String(packet.getData(), 0, packet.getLength()));
            bytes = "Sever say hello".getBytes();
            socket.send(new DatagramPacket(bytes, bytes.length, packet.getAddress(), packet.getPort()));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) throws SocketException {
        new Thread(new DatagramServerExample()).start();
    }
}
