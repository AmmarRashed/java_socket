package no_threads;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Cook{
  Restaurant restaurant;
  public static final int port = 5000;
  private ServerSocket ss = null;
  
  public Cook(Restaurant restaurant){
    this.restaurant = restaurant;
  }
  
  public void runServer() throws IOException, ClassNotFoundException {
    ss = new ServerSocket(port);
    System.out.println("cook is ready to take orders");
    Socket socket = ss.accept();
    ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
    
    String order = (String) is.readObject();
    System.out.println("The cook has received the order: "+order);
    os.writeObject(order);
    socket.close();
    
  }
  public void cook(String meal){
    System.out.println("The Cook is cooking "+meal+" .");
  }
}