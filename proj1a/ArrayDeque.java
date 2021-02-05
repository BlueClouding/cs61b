public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private static int initCapacity = 8;
    private static int factor = 2;
    private static double ratio = 0.25;
    private static int minCapacity = 16;
    private int capacity;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[initCapacity];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
        capacity = initCapacity;
    }

    public int minusOne(int i) {
        if (i == 0) {
            return capacity - 1;
        }
        return i - 1;
    }

    public int plusOne(int i) {
        if (i == capacity - 1) {
            return 0;
        }
        return i + 1;
    }

    private void resize(int newCapacity) {
        T[] newItems = (T[]) new Object[newCapacity];
        int oldIndex = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            newItems[i] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        capacity = newCapacity;
        nextFirst = capacity - 1;
        nextLast = size;
        items = newItems;
    }


    public void addFirst(T item) {
        if (size == capacity) {
            resize(factor * capacity);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    public void addLast(T item) {
        if (size == capacity) {
            resize(factor * capacity);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int index = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[index] + " ");
            index = (index + 1) % capacity;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        return remove(nextFirst);
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = minusOne(nextLast);
        return remove(nextLast);
    }

    public T remove(int index) {
        T removeItem = items[index];
        items[index] = null;
        size -= 1;
        if (size >= minCapacity && size / capacity < ratio) {
            resize(capacity / factor);
        }
        return removeItem;
    }

    public T get(int index) {
        if (index < 0 || index >= capacity) {
            return null;
        }
        int start = plusOne(nextFirst);
        return items[(start + index) % size];
    }
}
