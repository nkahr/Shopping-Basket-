public class Item {

  private String name;
  private double price;
  private boolean bogof;

  public Item(String name, double price){
    this.name = name;
    this.price = price;
    this.bogof = false;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean hasBogof() {
    return this.bogof;
  }

}