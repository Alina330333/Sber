import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Тест создания Consumer (потребителя заказов).
 * Проверяет, что Consumer успешно создаётся.
 */
class ConsumerTest {

    @Test
    void testConsumerCreation() {
        // Создаём очередь для заказов
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>();

        // Создаём хранилище обработанных заказов
        ConcurrentHashMap<String, Order> storage = new ConcurrentHashMap<>();

        // Создаём Consumer с именем "Test"
        Consumer consumer = new Consumer(queue, storage, "Test");

        // Проверяем: Consumer не должен быть null
        assertNotNull(consumer);
    }
}

