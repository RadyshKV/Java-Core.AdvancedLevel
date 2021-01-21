package HomeWork6.models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Network {

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 8888;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private final String host;
    private final int port;
    private boolean connectionON;
    private boolean isExit;

    public Network(String host, int port) {
        this.host = host;
        this.port = port;
        connectionON = false;
        isExit = false;
    }

    public Network() {
        this.host = DEFAULT_HOST;
        this.port = DEFAULT_PORT;
        connectionON = false;
        isExit = false;
    }


    public void connect() {

        try {
            socket = new Socket(host, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            connectionON = true;

        } catch (IOException e) {
            System.out.println("Соединение не установлено");
            e.printStackTrace();
        }
    }
    public void serverConnect() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Ожидание подключения...");
                Socket socket = serverSocket.accept();
                System.out.println("Соединение установлено");
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                connectionON = true;
                waitMessage();
                sendMessage();
                socket.close();
                if (isExit) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitMessage() {
        Thread waitMessageThread = new Thread(()->{
            try {
                while (true) {
                    String message = in.readUTF();
                    if (message.equals("\\end") || message.equals("\\exit") ) {
                        connectionON = false;
                        break;
                    }
                    System.out.println(message);
                }
                System.out.println("Отключение");
            } catch (IOException e) {
                System.out.println("Ошибка подключения");
            }
        });
        waitMessageThread.setDaemon(true);
        waitMessageThread.start();
    }

    public void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                String message = scanner.nextLine();
                if (!connectionON) {
                    System.out.println("Соединение разорвано");
                    break;
                }
                out.writeUTF(message);
                if (message.equals("\\end")) {
                    connectionON = false;
                    break;
                }
                if (message.equals("\\exit")) {
                    connectionON = false;
                    isExit = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка отправки сообщения");
        }
    }
}
