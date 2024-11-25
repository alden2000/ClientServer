package org.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientB {
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket()){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            InetAddress inetAddress = InetAddress.getByName("localhost");
            byte[] bytes = s.getBytes(StandardCharsets.UTF_8);

            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, inetAddress, 1080);
            datagramSocket.send(datagramPacket);

            bytes = new byte[256];
            datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, 1000);
            datagramSocket.receive(datagramPacket);
            System.out.println("Odgovor ");
            System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));


        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
