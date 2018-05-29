package game.networking.clientstuff;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {
    private final InetAddress host;
    private final int port;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public ObjectInputStream getOis() {
        return ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public Client(InetAddress inetAddress, int port) {
        this.host = inetAddress;
        this.port = port;
    }

    public void run() {
        try (Socket socket = new Socket(this.host, this.port)) {
             ois = new ObjectInputStream(socket.getInputStream());
             oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
