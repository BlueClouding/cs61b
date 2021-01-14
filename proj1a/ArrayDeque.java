public class ArrayDeque<T> {
    public T[] items;
    public int size;
    public int nextFirst;
    public int nextLast;
    public int capacity;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        capacity = 8;
        nextFirst = capacity / 2;
        nextLast = nextFirst + 1;
    }

    public void addFirst(T item) {
        reLargerSize();
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + capacity) % capacity;
        size ++;
    }

    public void addLast(T item) {
        reLargerSize();
        items[nextLast] = item;
        nextLast = (nextLast + 1 + capacity) % capacity;
        size ++;
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
        for (int i = nextFirst + 1; items[i] != null; i++ ) {
            int index = i % capacity;
            if (index == nextLast) {
                break;
            }
            System.out.print(items[index] + " ");
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        reShrinkSize();
        nextFirst = (nextFirst + 1 + capacity) % capacity;
        size--;
        return items[nextFirst+1];
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        reShrinkSize();
        nextLast = (nextLast - 1 + capacity) % capacity;
        size--;
        return items[nextLast-1];
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        index = (index + nextFirst + capacity) % capacity;
        return items[index];
    }

    public void reLargerSize() {
        if (nextFirst == nextLast) {
            capacity =  2 * capacity;
            T[] newItems = (T[]) new Object[capacity];
            System.arraycopy(items,0,newItems,capacity / 4, capacity / 2);
            items = newItems;
        }
    }

    public void reShrinkSize() {
        if (size / capacity < 0.25 && size >= 16) {
            capacity =  2 * size;
            T[] newItems = (T[]) new Object[capacity];
            System.arraycopy(items,capacity / 4,newItems,0, capacity / 2);
            items = newItems;
        }
    }
}
