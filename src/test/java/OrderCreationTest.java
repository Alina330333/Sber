import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты создания заказа.
 * Проверяют, что у заказа есть ID, описание и работает toString.
 */
class OrderCreationTest {

    @Test
    void testOrderHasId() {
        // Создаём срочный заказ
        Order order = new Order("Заказ", true);

        // Проверяем: ID не должен быть null
        assertNotNull(order.getId());
    }

    @Test
    void testDescriptionNotNull() {
        // Создаём заказ с описанием
        Order order = new Order("Описание заказа", false);

        // Проверяем: описание не должно быть null
        assertNotNull(order.getDescription());
    }

    @Test
    void testToStringWorks() {
        // Создаём тестовый заказ
        Order order = new Order("Тест", false);

        // Проверяем: toString() возвращает строку с информацией о заказе
        assertNotNull(order.toString());
        assertTrue(order.toString().contains("Order{"));
    }
}

