package com.taskmanager.model;

import com.taskmanager.annotations.NotNull;
import com.taskmanager.annotations.OrderType;

import java.util.UUID;

public class Order {

    // Поле id
    @NotNull(notNull = true)
    private String id;

    // Описание заказа
    @NotNull(notNull = true)
    private String description;

    // Тип заказа: срочный или обычный
    @OrderType("ORDINARY") // можно будет заменить на "URGENT"
    private String type;

    public Order(String description, boolean isUrgent) {

        // Генерируем уникальный идентификатор заказа
        this.id = UUID.randomUUID().toString();
        this.description = description;

        // Устанавливаем тип в зависимости от флага isUrgent
        this.type = isUrgent ? "URGENT" : "ORDINARY";
    }

    // Геттеры для доступа к полям
    public String getId() { return id; }
    public String getDescription() { return description; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return "com.taskmanager.model.Order{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}


