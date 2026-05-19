import java.lang.reflect.Field;

public class OrderValidator {

    public static boolean validate(Order order) {

        // Получаем все поля класса Order
        Field[] fields = order.getClass().getDeclaredFields();

        // Проходим по каждому полю
        for (Field field : fields) {

            // Если поле отмечено аннотацией @Validate
            if (field.isAnnotationPresent(Validate.class)) {

                // Делаем приватное поле доступным для чтения
                field.setAccessible(true);

                // Получаем параметры аннотации
                Validate validate = field.getAnnotation(Validate.class);

                try {
                    // Читаем текущее значение поля у переданного объекта order
                    Object value = field.get(order);

                    // Если аннотация требует, чтобы поле не было null
                    if (validate.notNull() && value == null) {
                        System.err.println("Ошибка валидации: поле " + field.getName() + " не может быть null");
                        return false;
                    }
                } catch (IllegalAccessException e) {

                    // Если не удалось прочитать поле — ошибка
                    e.printStackTrace();
                    return false;
                }
            }
        }
        // Все проверки пройдены
        return true;
    }
}


