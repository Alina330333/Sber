package com.taskmanager.processor;

import com.taskmanager.consumer.Consumer;
import com.taskmanager.model.Order;
import com.taskmanager.producer.Producer;

import java.util.concurrent.*;

public class OrderProcessor {

    // Очередь заказов с ограничением в 10 элементов (LinkedBlockingQueue)
    private final BlockingQueue<Order> queue;

    // Потокобезопасная карта для хранения обработанных заказов
    private final ConcurrentHashMap<String, Order> processedOrders;

    // Пул потоков для управления producer и consumers
    private final ExecutorService executor;

    // Ссылка на producer (чтобы можно было его остановить)
    private Producer producer;

    public OrderProcessor() {
        // Очередь вместимостью 10 заказов
        this.queue = new LinkedBlockingQueue<>(10);

        // Хранилище обработанных заказов
        this.processedOrders = new ConcurrentHashMap<>();

        // Пул из 3 потоков: 1 producer + 2 consumers
        this.executor = Executors.newFixedThreadPool(3);
    }

    public void start() {
        producer = new Producer(queue);

        Consumer consumer1 = new Consumer(queue, processedOrders, "com.taskmanager.consumer.Consumer-1");
        Consumer consumer2 = new Consumer(queue, processedOrders, "com.taskmanager.consumer.Consumer-2");

        // Отправляем задачи в пул потоков
        executor.submit(producer);
        executor.submit(consumer1);
        executor.submit(consumer2);
    }

    public void stop() {
        if (producer != null) {
            producer.stop();
        }
        // Немедленно останавливает все потоки (shutdownNow прерывает их)
        executor.shutdownNow();
    }

    public void printProcessedOrders() {
        System.out.println("\n=== Обработанные заказы ===");
        processedOrders.values().forEach(System.out::println);
    }
}

