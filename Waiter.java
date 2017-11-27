package no_threads;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Waiter{
  Restaurant restaurant;
  public String serverIp = "localhost";
  public Waiter(Restaurant restaurant){
    this.restaurant = restaurant;
  }
  public void takeOrder(String order, Customer c) throws UnknownHostException,
            IOException, ClassNotFoundException{
    
    Socket socket = new Socket(serverIp, 5000);
    ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
    
    os.writeObject(order);
    System.out.println("The waiter gave the order: "+order+", to the cook ...");
    
    ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
    String returnMessage = (String) is.readObject();
    System.out.println("Cook prepared the " + returnMessage);
    socket.close();
    c.getServed(returnMessage);
  }
}