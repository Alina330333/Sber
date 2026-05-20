package com.taskmanager.consumer;

import com.taskmanager.model.Order;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для Consumer (потребителя заказов).
 */
class ConsumerTest {

    /**
     * Тест 1: Consumer должен успешно создаваться
     */
    @Test
    void testConsumerCreation() {
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>();
        ConcurrentHashMap<String, Order> storage = new ConcurrentHashMap<>();
        Consumer consumer = new Consumer(queue, storage, "Test");
        assertNotNull(consumer);
    }

    /**
     * Тест 2: Consumer должен обрабатывать заказы
     * Исправленная версия с увеличенным временем ожидания
     */
    @Test
    void testConsumerProcessesOrder() throws InterruptedException {
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>();
        ConcurrentHashMap<String, Order> storage = new ConcurrentHashMap<>();

        // Добавляем тестовый заказ в очередь
        Order testOrder = new Order("Тестовый заказ", false);
        queue.put(testOrder);

        // Создаём и запускаем Consumer
        Consumer consumer = new Consumer(queue, storage, "TestConsumer");
        Thread thread = new Thread(consumer);
        thread.start();

        // Увеличиваем время на обработку до 1 секунды
        Thread.sleep(1000);

        // Останавливаем Consumer
        thread.interrupt();

        // Ждём завершения потока
        thread.join(500);

        // Проверяем: заказ должен быть в хранилище
        boolean contains = storage.containsKey(testOrder.getId());

        // Если не содержит, выводим содержимое для отладки
        if (!contains) {
            System.out.println("Хранилище содержит: " + storage.keySet());
            System.out.println("Ожидался ID: " + testOrder.getId());
        }

        assertTrue(contains, "Заказ не был обработан Consumer'ом");
    }

    /**
     * Тест 3: Consumer должен корректно создаваться с пустой очередью
     */
    @Test
    void testConsumerHandlesEmptyQueue() {
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>();
        ConcurrentHashMap<String, Order> storage = new ConcurrentHashMap<>();
        Consumer consumer = new Consumer(queue, storage, "Test");

        assertNotNull(consumer);
    }
}