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

  public double getTotal() {
    double total = 0;
    for (Item item : basket.getItems()) {
      total += item.getPrice();
    }
    if (total > 20) {
      total = total * 0.9;
    }
    if (hasLoyaltyCard) {
      total = total * 0.98;
    }
    return total;
  }



}