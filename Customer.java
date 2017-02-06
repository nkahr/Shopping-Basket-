import java.util.ArrayList;
import java.util.HashMap;

public class Customer{

  private String name;
  private Basket basket;
  private boolean hasLoyaltyCard;

  public Customer(String name) {
    this.name = name;
    this.hasLoyaltyCard = false;
    this.basket = new Basket();
  }

  public Customer(String name, boolean loyaltyCard) {
    this.name = name;
    this.hasLoyaltyCard = hasLoyaltyCard;
    this.basket = new Basket();
  }

  public String getName() {
    return this.name;
  }

  public Basket getBasket() {
    return this.basket;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean getLoyaltyCard() {
    return this.hasLoyaltyCard;
  }

  public void setLoyaltyCard(boolean hasLoyaltyCard) {
    this.hasLoyaltyCard = hasLoyaltyCard;
  }

  public void addItemToBasket(Item item) {
    basket.addItem(item);
  }


  public double getTotalForBogofItems() {

    ArrayList<Item> bogofArray = new ArrayList<>();
    double total = 0;
    HashMap<Item, Integer> groupedItems = new HashMap<>();

    for (Item item : basket.getItems()) {
      if (item.hasBogof()) {
        bogofArray.add(item);
      }
    }
    for (Item item : bogofArray) {
      if (groupedItems.containsKey(item)) {
        Integer oldKey = groupedItems.get(item);
        groupedItems.put(item, oldKey + 1);
      } else {
        groupedItems.put(item, 1);
      }
    }

    for (Item item : groupedItems.keySet()) {
      double numberOfItems = (double) groupedItems.get(item);
      double priceOfItem = item.getPrice();
      total += priceOfItem * Math.ceil(numberOfItems/2);
    }

    return total;
  }


  public double getTotal() {

    ArrayList<Item> nonBogofArray = new ArrayList<>();
    double total = 0;

    for (Item item : basket.getItems()) {
      if (!item.hasBogof()) {
        nonBogofArray.add(item);
      }
    }

    for (Item item : nonBogofArray) {
      total += item.getPrice();
    }

    total += getTotalForBogofItems();

    if (total > 20) {
      total = total * 0.9;
    }

    if (hasLoyaltyCard) {
      total = total * 0.98;
    }
    return total;
  }

}