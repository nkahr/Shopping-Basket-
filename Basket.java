import java.util.ArrayList;

public class Basket{

  private ArrayList<Item> items = new ArrayList<>();

  public int getNumberOfItems() {
    return items.size();
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public ArrayList<Item> getItems() {
    return this.items;
  }
  
}