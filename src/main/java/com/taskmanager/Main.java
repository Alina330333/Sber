package com.taskmanager;

import com.taskmanager.processor.OrderProcessor;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Создаём контроллер системы
        OrderProcessor processor = new OrderProcessor();

        // Запускаем producer и consumers
        processor.start();

        // Даём системе поработать 15 секунд
        Thread.sleep(15_000);

        // Останавливаем систему
        processor.stop();

        // Выводим результаты
        processor.printProcessedOrders();

        System.out.println("Система завершила работу.");
    }
}

