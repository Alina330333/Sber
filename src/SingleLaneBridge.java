public class SingleLaneBridge {

    public static void main(String[] args) {
        // Создаём мост
        Bridge bridge = new Bridge();

        // Создаём несколько машин с севера
        for (int i = 1; i <= 5; i++) {
            new Car(bridge, Direction.NORTH, "NorthCar-" + i).start();
        }

        // Создаём несколько машин с юга
        for (int i = 1; i <= 5; i++) {
            new Car(bridge, Direction.SOUTH, "SouthCar-" + i).start();
        }
    }
}

// Направление движения по мосту
enum Direction {
    NORTH,  // едем с севера на юг
    SOUTH,  // едем с юга на север
    NONE    // мост пуст / нет направления
}

// Мост
class Bridge {
    private int carsOnBridge = 0;          // сколько машин сейчас на мосту
    private Direction currentDirection = Direction.NONE; // текущее направление движения

    // Въезд на мост
    public synchronized void enter(Direction direction, String carName) {
        // Пока направление не совпадает или на мосту уже есть машины
        // но другое направление — ждём
        while (currentDirection != Direction.NONE && currentDirection != direction) {
            try {
                System.out.println(carName + " ждёт, мост занят в другую сторону");
                wait(); // освобождаем монитор и ждём
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Устанавливаем направление (если мост был пуст)
        if (currentDirection == Direction.NONE) {
            currentDirection = direction;
        }

        // Заезжаем на мост
        carsOnBridge++;
        System.out.println(carName + " ЗАЕХАЛ(а) на мост. На мосту: " + carsOnBridge +
                " машин, направление: " + currentDirection);
    }

    // Выезд с моста
    public synchronized void exit(String carName) {
        // Покидаем мост
        carsOnBridge--;
        System.out.println(carName + " ПОКИНУЛ(а) мост. Осталось на мосту: " + carsOnBridge);

        // Если машин на мосту больше нет
        if (carsOnBridge == 0) {
            currentDirection = Direction.NONE; // мост свободен
            System.out.println("--- МОСТ ПУСТ ---");
            // Будим все ждущие машины (с обеих сторон)
            notifyAll();
        }
    }
}

// Машина (поток)
class Car extends Thread {
    private final Bridge bridge;
    private final Direction direction;
    private final String carName;

    public Car(Bridge bridge, Direction direction, String carName) {
        this.bridge = bridge;
        this.direction = direction;
        this.carName = carName;
    }

    @Override
    public void run() {
        try {
            // Имитация подъезда к мосту (разные времена)
            Thread.sleep((long) (Math.random() * 1000));

            // Въезд на мост
            bridge.enter(direction, carName);

            // Имитация движения по мосту
            Thread.sleep((long) (Math.random() * 500));

            // Выезд с моста
            bridge.exit(carName);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}