public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private static int initCapacity = 8;
    private static int factor = 2;
    private static double ratio = 4;
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
        int oldIndex = minusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            newItems[i] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        capacity = newCapacity;
        nextFirst = capacity - 1;
        nextLast = size;
        items = newItems;
    }


    @Override
    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
        if (size == capacity) {
            resize(factor * capacity);
        }
    }

    @Override
    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
        if (size == capacity) {
            resize(factor * capacity);
        }
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int index = plusOne(nextFirst);

        for (int i = 1; i < size; i++) {
            System.out.print(items[index] + " ");
            index = plusOne(index);
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        return remove(nextFirst);
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = minusOne(nextLast);
        return remove(nextLast);
    }

    private T remove(int index) {
        T removeItem = items[index];
        items[index] = null;
        if (size >= minCapacity && size * ratio < capacity) {
            resize(capacity / factor);
        }
        return removeItem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= capacity) {
            return null;
        }
        int start = plusOne(nextFirst);
        return items[(start + index) % size];
    }
}
