import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void everyBranchTest() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 1));
        assertTrue(ex.getMessage().contains("can't be null!"));

        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("", null, 30, 0));
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items1, 1));
        assertTrue(ex.getMessage().contains("No barcode!"));

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("valid", "1lol", 300, 0));
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, 301));
        assertTrue(ex.getMessage().contains("Invalid character"));

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("valid", "023", 100, 0.1f));
        items3.add(new Item("valid", "123", 100, 0));
        assertTrue(SILab2.checkCart(items3, 301));

        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("valid", "023", 100, 0.1f));
        items4.add(new Item("valid", "123", 100, 0));
        assertFalse(SILab2.checkCart(items4, 100));
    }

    @Test
    public void multipleConditionsTest() {
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("valid", "023", 350, 0.1f));
        assertTrue(SILab2.checkCart(items1, 100));  // (T, T, T) should return true

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("valid", "123", 350, 0.1f));
        assertTrue(SILab2.checkCart(items2, 100));  // (T, T, F) should return false

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("valid", "023", 350, 0));
        assertFalse(SILab2.checkCart(items3, 100));  // (T, F, T) should return false

        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("valid", "123", 350, 0));
        assertFalse(SILab2.checkCart(items4, 100));  // (T, F, F) should return false

        List<Item> items5 = new ArrayList<>();
        items5.add(new Item("valid", "023", 250, 0.1f));
        assertTrue(SILab2.checkCart(items5, 100));  // (F, T, T) should return true

        List<Item> items6 = new ArrayList<>();
        items6.add(new Item("valid", "123", 250, 0.1f));
        assertTrue(SILab2.checkCart(items6, 100));  // (F, T, F) should return true

        List<Item> items7 = new ArrayList<>();
        items7.add(new Item("valid", "023", 250, 0));
        assertFalse(SILab2.checkCart(items7, 100));  // (F, F, T) should return true

        List<Item> items8 = new ArrayList<>();
        items8.add(new Item("valid", "123", 250, 0));
        assertFalse(SILab2.checkCart(items8, 100));  // (F, F, F) should return true
    }
}
