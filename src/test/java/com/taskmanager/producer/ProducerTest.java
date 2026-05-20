package com.taskmanager.producer;

import com.taskmanager.model.Order;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для Producer (производителя заказов).
 */
class ProducerTest {

    /**
     * Тест 1: Producer должен успешно создаваться
     */
    @Test
    void testProducerCreation() {
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(queue);
        assertNotNull(producer);
    }

    /**
     * Тест 2: Producer должен добавлять заказы в очередь
     */
    @Test
    void testProducerAddsOrdersToQueue() throws InterruptedException {
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>(10);
        Producer producer = new Producer(queue);

        Thread thread = new Thread(producer);
        thread.start();

        Thread.sleep(500);
        producer.stop();
        thread.interrupt();

        assertTrue(queue.size() > 0);
    }

    /**
     * Тест 3: Проверка, что stop() не выбрасывает исключение
     */
    @Test
    void testProducerCanBeStopped() {
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(queue);

        // Просто вызываем stop() — не должно быть исключения
        assertDoesNotThrow(() -> producer.stop());
    }
}