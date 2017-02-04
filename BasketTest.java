import org.junit.*;
import static org.junit.Assert.*;

public class BasketTest{

  Basket basket;
  Item item;
  Item otherItem;
  Item expensiveItem;

  @Before 
  public void before() {
    basket = new Basket();
    item = new Item("something", 12);
    otherItem = new Item("something else", 4);
    expensiveItem = new Item("expensiveItem", 100);
  }

  @Test 
  public void canGetNumberOfItems() {
    assertEquals(0, basket.getNumberOfItems());
  }

  @Test
  public void canAddItemToBasket() {
    basket.addItem(item);
    assertEquals(1, basket.getNumberOfItems());
  }

  @Test 
  public void canGetItemsInBasket() {
    basket.addItem(item);
    basket.addItem(otherItem);
    assertEquals(2, basket.getNumberOfItems());
    assertEquals(item, basket.getItems().get(0));
    assertEquals(otherItem, basket.getItems().get(1));
  }



}