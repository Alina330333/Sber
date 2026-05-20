package com.taskmanager.validator;

import com.taskmanager.model.Order;
import com.taskmanager.annotations.NotNull;
import com.taskmanager.annotations.OrderType;
import java.lang.reflect.Field;

public class OrderValidator {

    public static boolean validate(Order order) {
        Field[] fields = order.getClass().getDeclaredFields();

        for (Field field : fields) {
            // Проверка @NotNull
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(order) == null) {
                        System.err.println("Поле " + field.getName() + " не может быть null");
                        return false;
                    }
                } catch (IllegalAccessException e) {
                    return false;
                }
            }

            // Проверка @OrderType
            if (field.isAnnotationPresent(OrderType.class) && field.getName().equals("type")) {
                OrderType annotation = field.getAnnotation(OrderType.class);
                String expectedType = annotation.value();
                field.setAccessible(true);
                try {
                    String actualType = (String) field.get(order);
                    if (!expectedType.equals(actualType)) {
                        System.err.println("Неверный тип заказа. Ожидается: " + expectedType);
                        return false;
                    }
                } catch (IllegalAccessException e) {
                    return false;
                }
            }
        }
        return true;
    }
}