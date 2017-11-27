package no_threads;
import java.io.IOException;
public class Main{
  public static void main(String[] args) throws ClassNotFoundException, IOException{
    Restaurant restaurant = new Restaurant();
    Waiter waiter = new Waiter(restaurant);
    waiter.serverIp = "192.168.1.21";
//    Cook cook = new Cook(restaurant);
    restaurant.waiter = waiter;
//    restaurant.cook = cook;
    Customer c1 = new Customer(restaurant, "Ahmet");
//    Customer c2 = new Customer(restaurant, "Ammar");
//    Customer c3 = new Customer(restaurant, "Ali");
    c1.order(0);
//    c2.order(1);
//    c3.order(2);
//    cook.runServer();  //Abduljaleel side
  }
}