package com.taskmanager.validator;

import com.taskmanager.model.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для проверки валидатора заказов.
 * Проверяют как корректные, так и некорректные заказы.
 */
class OrderValidatorTest {

    /**
     * Тест 1: Валидный заказ должен пройти проверку
     */
    @Test
    void testValidOrder() {
        // Создаём обычный заказ
        Order order = new Order("Тестовый заказ", false);

        // Проверяем: валидатор должен вернуть true
        assertTrue(OrderValidator.validate(order));
    }

    /**
     * Тест 2: Заказ с null описанием НЕ должен пройти валидацию
     */
    @Test
    void testInvalidOrderWithNullDescription() throws Exception {
        // Создаём временный заказ
        Order order = new Order("temp", false);

        // Через рефлексию устанавливаем description = null
        java.lang.reflect.Field field = order.getClass().getDeclaredField("description");
        field.setAccessible(true);
        field.set(order, null);

        // Проверяем: валидатор должен вернуть false
        assertFalse(OrderValidator.validate(order));
    }
}