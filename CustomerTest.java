import org.junit.*;
import static org.junit.Assert.*;

public class CustomerTest{

  Customer customer;
  Item item;
  Item otherItem;
  Item expensiveItem;
  Item bogofItem1;

  @Before
  public void before() {
    customer = new Customer("nina");
    item = new Item("something", 12);
    otherItem = new Item("something else", 4);
    expensiveItem = new Item("expensive thing", 100);
    bogofItem1 = new Item("buy one get one free", 5, true);
  }

  @Test 
  public void canGetCustomerName() {
    assertEquals("nina", customer.getName());
  }

  @Test 
  public void canChangeCustomerName() {
    customer.setName("Nina");
    assertEquals("Nina", customer.getName());
  }

  @Test 
  public void doesCustomerHaveLoyaltyCard() {
    assertEquals(false, customer.getLoyaltyCard());
  }

  @Test 
  public void giveCustomerLoyaltyCard() {
    customer.setLoyaltyCard(true);
    assertEquals(true, customer.getLoyaltyCard());
  }

  @Test 
  public void canGetTotalWithoutDiscounts() {
    customer.addItemToBasket(item);
    customer.addItemToBasket(otherItem);
    assertEquals(16, customer.getTotal(), 0.01);
  }

  @Test 
  public void canGetTotalWithDiscount() {
    customer.addItemToBasket(expensiveItem);
    assertEquals(90, customer.getTotal(), 0.01);
  }

  @Test 
  public void canGetTotalWithLoyaltyCard() {
    customer.setLoyaltyCard(true);
    customer.addItemToBasket(expensiveItem);
    assertEquals(88.2, customer.getTotal(), 0.01);
  }

  @Test 
  public void canAddTwoOfTheSameItem() {
    customer.addItemToBasket(expensiveItem);
    customer.addItemToBasket(expensiveItem);
    assertEquals(2, customer.getBasket().getNumberOfItems());
  }

  @Test
  public void canFindTotalWithBogofItems() {
    customer.addItemToBasket(bogofItem1);
    customer.addItemToBasket(bogofItem1);
    customer.addItemToBasket(bogofItem1);
    assertEquals(10, customer.getTotal(), 0.01);
  }

}