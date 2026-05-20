package com.taskmanager.consumer;

import com.taskmanager.model.Order;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Consumer implements Runnable {

    // Очередь, откуда consumer забирает заказы
    private final BlockingQueue<Order> queue;

    // Общая потокобезопасная карта для хранения обработанных заказов
    private final ConcurrentHashMap<String, Order> processedOrders;

    // Имя потребителя (для вывода в консоль)
    private final String name;

    public Consumer(BlockingQueue<Order> queue,
                    ConcurrentHashMap<String, Order> processedOrders,
                    String name) {
        this.queue = queue;
        this.processedOrders = processedOrders;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // Бесконечный цикл — consumer работает, пока поток не прервут
            while (true) {

                // Забираем заказ из очереди (если очередь пуста — ждёт)
                Order order = queue.take();

                System.out.println("[" + name + "] Обрабатывает: " + order);

                // Имитация обработки заказа (например, отправка, упаковка)
                Thread.sleep(1000);

                // Сохраняем обработанный заказ в общее хранилище
                processedOrders.put(order.getId(), order);

                System.out.println("[" + name + "] ЗАВЕРШИЛ: " + order.getId());
            }

        } catch (InterruptedException e) {
            // При прерывании потока — завершаем работу
            Thread.currentThread().interrupt();
        }
    }
}

