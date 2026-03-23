import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartServiceTest {

    @Test
    void shouldCalculateTotalCost() {
        ShoppingCartService service = new ShoppingCartService();
        double result = service.addItem(10.0, 3);
        assertEquals(30.0, result);
    }

    @Test
    void shouldUpdateTotalCostAfterAddingItem() {
        ShoppingCartService service = new ShoppingCartService();
        service.addItem(10.0, 2);
        assertEquals(20.0, service.getTotalCost());
    }

    @Test
    void shouldAddMultipleItems() {
        ShoppingCartService service = new ShoppingCartService();
        service.addItem(10.0, 3);
        service.addItem(10.0, 2);
        service.addItem(10.0, 3);
        assertEquals(80.0, service.getTotalCost());
    }
}
