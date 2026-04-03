import java.util.*;

public class BinaryTree<T extends Comparable<T>> {

    // Корень дерева
    private Node root;

    // Количество элементов
    private int size;

    private class Node {
        T value;     // Значение в узле
        Node left;   // Левый ребенок (меньшие значения)
        Node right;  // Правый ребенок (большие значения)

        Node(T value) {
            this.value = value;
        }
    }

    // Добавление элемента
    public void add(T value) {
        // Не добавляем null
        if (value == null) {
            return;
        }
        // Рекурсивно добавляем начиная с корня
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node node, T value) {
        // Если дошли до пустого места - создаем новый узел
        if (node == null) {
            size++;
            return new Node(value);
        }

        // Сравниваем значения
        int cmp = value.compareTo(node.value);

        // Меньше - идем влево
        if (cmp < 0) {
            node.left = addRecursive(node.left, value);
        }
        // Больше - идем вправо
        else if (cmp > 0) {
            node.right = addRecursive(node.right, value);
        }
        // Равны - ничего не делаем

        return node;
    }

    // Удаление элемента
    public void remove(T value) {
        // Проверяем, существует ли элемент
        if (value == null || !contains(value)) {
            return;
        }
        // Рекурсивно удаляем
        root = removeRecursive(root, value);
        size--;
    }

    private Node removeRecursive(Node node, T value) {
        if (node == null) {
            return null;
        }

        int cmp = value.compareTo(node.value);

        // Ищем в левом поддереве
        if (cmp < 0) {
            node.left = removeRecursive(node.left, value);
        }
        // Ищем в правом поддереве
        else if (cmp > 0) {
            node.right = removeRecursive(node.right, value);
        }
        // Нашли узел для удаления
        else {
            // Если нет правого ребенка - возвращаем левого
            if (node.right == null) {
                return node.left;
            }
            // Если нет левого ребенка - возвращаем правого
            if (node.left == null) {
                return node.right;
            }

            // Если есть оба ребенка
            // Находим минимальное значение в правом поддереве
            T minValue = findMin(node.right);
            // Заменяем значение текущего узла
            node.value = minValue;
            // Удаляем тот узел из правого поддерева
            node.right = removeRecursive(node.right, minValue);
        }

        return node;
    }

    // Поиск минимального значения в поддереве
    private T findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    // Проверка существования элемента
    private boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node node, T value) {
        if (node == null) {
            return false;
        }

        int cmp = value.compareTo(node.value);

        if (cmp < 0) {
            return containsRecursive(node.left, value);
        } else if (cmp > 0) {
            return containsRecursive(node.right, value);
        } else {
            return true;
        }
    }

    // Итератор для обхода элементов
    public Iterator<T> iterator() {
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator<T> {
        // Стек для хранения узлов
        private Stack<Node> stack = new Stack<>();

        // Конструктор - сразу кладем в стек все левые узлы
        TreeIterator() {
            pushLeft(root);
        }

        // Помещает в стек все левые узлы начиная с node
        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        // Есть ли следующий элемент
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // Возвращает следующий элемент
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            // Достаем узел из стека
            Node node = stack.pop();
            T result = node.value;

            // Если есть правый ребенок - обрабатываем его левое поддерево
            if (node.right != null) {
                pushLeft(node.right);
            }

            return result;
        }
    }
}