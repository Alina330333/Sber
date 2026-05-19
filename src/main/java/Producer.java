import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    // Очередь, в которую producer будет складывать заказы
    private final BlockingQueue<Order> queue;

    // Флаг для остановки потока (volatile — чтобы изменения были видны всем потокам)
    private volatile boolean running = true;

    public Producer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int orderCounter = 1;

        try {
            // Пока поток работает и создано не более 20 заказов
            while (running && orderCounter <= 20) {

                // Каждый третий заказ — срочный (остальные обычные)
                boolean isUrgent = orderCounter % 3 == 0;

                // Создаём новый заказ
                Order order = new Order("Order #" + orderCounter, isUrgent);

                // Валидируем заказ перед отправкой в очередь
                if (OrderValidator.validate(order)) {
                    // Кладём заказ в очередь (если очередь заполнена — ждёт)
                    queue.put(order);
                    System.out.println("[PRODUCER] Добавлен: " + order);
                }

                orderCounter++;

                // Небольшая задержка между созданием заказов
                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
            // Если поток прервали — выходим
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        running = false;
    }
}

