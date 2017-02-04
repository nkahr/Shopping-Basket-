import org.junit.*;
import static org.junit.Assert.*;

public class ItemTest{

  Item item;

  @Before
  public void before() {
    item = new Item("toothbrush", 2.5);
  }

  @Test
  public void canGetItemsName() {
    assertEquals("toothbrush", item.getName());
  }

  @Test
  public void canGetItemsPrice() {
    assertEquals(2.5, item.getPrice(), 0.01);
  }

  @Test 
  public void canSetName() {
    item.setName("hat");
    assertEquals("hat", item.getName());
  }

  @Test
  public void canSetPrice() {
    item.setPrice(15);
    assertEquals(15, item.getPrice(), 0.01);
  }

  @Test 
  public void hasBuyOneGetOneFree() {
    assertEquals(false, item.hasBogof());
  }
}