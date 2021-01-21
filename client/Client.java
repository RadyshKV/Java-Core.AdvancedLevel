package HomeWork6.client;


import HomeWork6.models.Network;

public class Client {

    private static Network network;



    public static void main(String[] args) {

        network = new Network();
        network.connect();
        network.waitMessage();
        network.sendMessage();
    }


}
