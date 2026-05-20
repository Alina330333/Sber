package com.taskmanager.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для проверки создания заказов.
 * Проверяют, что у заказа есть ID, описание и работает toString.
 */
class OrderCreationTest {

    /**
     * Тест 1: У заказа должен быть не null ID
     */
    @Test
    void testOrderHasId() {
        // Создаём срочный заказ
        Order order = new Order("Заказ", true);

        // Проверяем: ID не должен быть null
        assertNotNull(order.getId());
    }

    /**
     * Тест 2: Описание заказа не должно быть null
     */
    @Test
    void testDescriptionNotNull() {
        // Создаём заказ с описанием
        Order order = new Order("Описание заказа", false);

        // Проверяем: описание не должно быть null
        assertNotNull(order.getDescription());
    }

    /**
     * Тест 3: Метод toString должен возвращать строку с информацией о заказе
     */
    @Test
    void testToStringWorks() {
        // Создаём тестовый заказ
        Order order = new Order("Тест", false);

        // Проверяем: toString() не null и содержит "Order{"
        assertNotNull(order.toString());
        assertTrue(order.toString().contains("Order{"));
    }
}