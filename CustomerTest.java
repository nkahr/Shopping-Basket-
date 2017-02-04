import org.junit.*;
import static org.junit.Assert.*;

public class CustomerTest{

  Customer customer;
  Item item;
  Item otherItem;
  Item expensiveItem;

  @Before
  public void before() {
    customer = new Customer("nina");
    item = new Item("something", 12);
    otherItem = new Item("something else", 4);
    expensiveItem = new Item("expensiveItem", 100);
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

}