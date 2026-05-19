import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест создания OrderProcessor (управляющего потоками).
 * Проверяет, что OrderProcessor успешно создаётся.
 */
class OrderProcessorTest {

    @Test
    void testOrderProcessorCreation() {
        // Создаём OrderProcessor
        OrderProcessor processor = new OrderProcessor();

        // Проверяем: процессор не должен быть null
        assertNotNull(processor);
    }
}
