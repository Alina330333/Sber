import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест проверки валидации заказа.
 * Проверяет, что корректный заказ проходит валидацию.
 */
class OrderValidatorTest {

    @Test
    void testValidOrder() {
        // Создаём обычный заказ
        Order order = new Order("Тестовый заказ", false);

        // Проверяем: валидатор должен вернуть true
        assertTrue(OrderValidator.validate(order));
    }
}

