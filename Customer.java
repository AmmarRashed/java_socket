package no_threads;
import java.net.UnknownHostException;
public class Customer{
  String name;
  Restaurant restaurant;
  public Customer(Restaurant restaurant, String name){
    this.restaurant = restaurant;
    this.name = name;
  }
  public void order(int i){
    String order = this.restaurant.meals[i];
    System.out.println("Customer "+this+" has ordered "+order+" .");
    try{this.restaurant.waiter.takeOrder(order, this);
    }catch (Exception e){
    System.out.println("Unknown host");}
  }
  public void getServed(String order){
    System.out.println("Customer "+this+" has been served "+order+" .");
  }
  
  @Override
  public String toString(){
    return this.name;
  }
}