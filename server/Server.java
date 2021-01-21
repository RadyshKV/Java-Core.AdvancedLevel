package HomeWork6.server;

import HomeWork6.models.Network;

public class Server {

    private static Network network;

    public static void main(String[] args) {

        network = new Network();
        network.serverConnect();

    }
}
