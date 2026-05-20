package com.taskmanager.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для проверки типов заказов.
 * Убеждаются, что срочный заказ имеет тип URGENT, а обычный — ORDINARY.
 */
class OrderTypeTest {

    /**
     * Тест 1: Срочный заказ должен иметь тип "URGENT"
     */
    @Test
    void testUrgentOrderType() {
        // Создаём срочный заказ (isUrgent = true)
        Order order = new Order("Срочный", true);

        // Проверяем: тип должен быть "URGENT"
        assertEquals("URGENT", order.getType());
    }

    /**
     * Тест 2: Обычный заказ должен иметь тип "ORDINARY"
     */
    @Test
    void testOrdinaryOrderType() {
        // Создаём обычный заказ (isUrgent = false)
        Order order = new Order("Обычный", false);

        // Проверяем: тип должен быть "ORDINARY"
        assertEquals("ORDINARY", order.getType());
    }
}