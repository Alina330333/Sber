import java.lang.annotation.*;

@Target(ElementType.FIELD) // аннотация может применяться только к полям
@Retention(RetentionPolicy.RUNTIME) // аннотация будет доступна во время выполнения
public @interface OrderType {
    String value() default "ORDINARY";
}

