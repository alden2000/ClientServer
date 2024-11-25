package org.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientA {
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket(1080)){
            Scanner scanner = new Scanner(System.in);
            byte[] message = new byte[256];
            DatagramPacket packet = new DatagramPacket(message, message.length);
            datagramSocket.receive(packet);
            System.out.println("Odgovor: ");
            System.out.println(new String(packet.getData(), 0, packet.getLength()));

            String string = scanner.nextLine();
            //System.out.println(string);
            message = string.getBytes(StandardCharsets.UTF_8);

            packet = new DatagramPacket(message, message.length, packet.getAddress(), packet.getPort());
            datagramSocket.send(packet);
            message = new byte[256];


        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
