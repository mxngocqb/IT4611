package com.hust.soict.your_name.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // TODO Auto-generated method stub
        Socket socket = new Socket("localhost", 9898);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // System.out.println(in.readLine());
        String input = in.readLine();
        System.out.println(input);
        Scanner scanner = new Scanner(System.in);
        String message;

        while (true) {
            message = scanner.nextLine();
            out.write(message + " ");
            // out.newLine();
            out.flush();
            if (message.equals("")) {
                // out.write("");
                // out.newLine();
                // out.flush();
                break;
            }
        }

        // while (true) {
        //     input = in.readLine();
        //     System.out.println(input);
        //     if (input.isEmpty()) {
        //         break;
        //     }
        // }

        socket.close();
        scanner.close();
    }
}