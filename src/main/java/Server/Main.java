package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket servSocket = new ServerSocket(20888);
            while (true) {
                Socket socket = servSocket.accept();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    if ("end".equals(line)) {
                        break;
                    }
                    try {
                        long n = Integer.parseInt(line);
                        out.println(n + "-й член ряда Фибоначчи = " + fibonacci(n));
                    } catch (NumberFormatException e) {
                        out.println("Неверное значение, попробуйте ещё раз");
                    }

                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static long fibonacci(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
