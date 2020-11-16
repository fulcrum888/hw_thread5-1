package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 20888);
            BufferedReader in = new BufferedReader(new InputStreamReader((socket.getInputStream())));
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()), true);
            Scanner scanner = new Scanner(System.in);
            String line;
            while (true) {
                System.out.println("Введите номер члена ряда Фибоначчи или \'end\' для выхода");
                line =scanner.nextLine();
                out.println(line);
                if ("end".equals(line)) break;

                System.out.println(in.readLine());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
