import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты проверки типов заказов.
 * Убеждаются, что срочный заказ имеет тип URGENT, а обычный — ORDINARY.
 */
class OrderTypeTest {

    @Test
    void testUrgentOrderType() {
        // Создаём срочный заказ (isUrgent = true)
        Order order = new Order("Срочный", true);

        // Проверяем: тип должен быть "URGENT"
        assertEquals("URGENT", order.getType());
    }

    @Test
    void testOrdinaryOrderType() {
        // Создаём обычный заказ (isUrgent = false)
        Order order = new Order("Обычный", false);

        // Проверяем: тип должен быть "ORDINARY"
        assertEquals("ORDINARY", order.getType());
    }
}

