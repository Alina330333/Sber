package com.taskmanager.processor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для OrderProcessor (управляющего потоками).
 * Проверяют создание, запуск и остановку процессора.
 */
class OrderProcessorTest {

    /**
     * Тест 1: OrderProcessor должен успешно создаваться
     */
    @Test
    void testOrderProcessorCreation() {
        // Создаём OrderProcessor
        OrderProcessor processor = new OrderProcessor();

        // Проверяем: процессор не должен быть null
        assertNotNull(processor);
    }

    /**
     * Тест 2: OrderProcessor должен запускаться и останавливаться
     */
    @Test
    void testOrderProcessorStartStop() {
        // Создаём и запускаем процессор
        OrderProcessor processor = new OrderProcessor();
        processor.start();

        // Останавливаем процессор
        processor.stop();

        // Если дошли сюда без ошибок — тест пройден
        assertTrue(true);
    }

    /**
     * Тест 3: Повторный запуск OrderProcessor не должен вызывать ошибок
     */
    @Test
    void testOrderProcessorStartTwice() {
        OrderProcessor processor = new OrderProcessor();

        // Первый запуск
        processor.start();

        // Второй запуск (не должен сломать)
        processor.start();

        // Останавливаем
        processor.stop();

        assertTrue(true);
    }

    /**
     * Тест 4: Метод printProcessedOrders не должен выбрасывать исключений
     */
    @Test
    void testPrintProcessedOrders() {
        // Создаём, запускаем и останавливаем процессор
        OrderProcessor processor = new OrderProcessor();
        processor.start();
        processor.stop();

        // Проверяем, что метод не выбрасывает исключение
        assertDoesNotThrow(() -> processor.printProcessedOrders());
    }
}