import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Тест создания Producer (производителя заказов).
 * Проверяет, что Producer успешно создаётся.
 */
class ProducerTest {

    @Test
    void testProducerCreation() {
        // Создаём очередь для заказов
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>();

        // Создаём Producer
        Producer producer = new Producer(queue);

        // Проверяем: Producer не должен быть null
        assertNotNull(producer);
    }
}

