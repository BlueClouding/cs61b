public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int head;
    private int tail;
    private int capacity;
    private static int initialCapacity = 8;
    /* expand/contract factor */
    private static int Factor = 2;
    /* minimum capacity for contraction resizing */
    private static int mCapacity = 16;
    /* minimum usage ratio before contraction */
    private static double mRatio = 0.25;


    public ArrayDeque() {
        items = (T[]) new Object[initialCapacity];
        size = 0;
        capacity = 8;
        head = capacity - 1;
        tail = 0;
    }

    private int onePlus(int index) {
        return (index + 1 + capacity) % capacity;
    }

    private int oneMinus(int index) {
        return (index - 1 + capacity) % capacity;
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
        int currentIndex = onePlus(head);
        while (currentIndex != tail) {
            System.out.print(items[currentIndex] + " ");
            currentIndex = onePlus(currentIndex);
        }
        System.out.println();
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        index = (index + head + 1 + capacity) % capacity;
        return items[index];
    }

    /* if head<-- -->tail, means items is consistently,
        else if 0<--->tail ----- head<-->items.length, which break into two part.
     */
    private void resize(int newCapacity) {
        T[] newItems = (T[]) new Object[newCapacity];
        int p = head;
        int len = items.length;
        if (head >= tail) {
            int r = len - p;
            System.arraycopy(items, p, newItems, 0, r);
            System.arraycopy(items, 0, newItems, r, p);
            items = newItems;
            head = 0;
            tail = len;
        } else {
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
            head = 0;
            tail = len;
        }

    }

    private void expand() {
        if (head == tail) {
            int newCapacity = capacity * Factor;
            resize(newCapacity);
        }
    }

    private void contract() {
        double ratio = size / capacity;
        if (capacity >= mCapacity && ratio < mRatio) {
            int newCapacity = capacity / Factor;
            resize(newCapacity);
        }
    }


    public void addFirst(T item) {
        items[head] = item;
        head = (head - 1 + capacity) % capacity;
        size += 1;
        expand();
    }

    public void addLast(T item) {
        items[tail] = item;
        tail = (tail + 1 + capacity) % capacity;
        size += 1;
        contract();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        head = (head + 1 + capacity) % capacity;
        size -= 1;
        contract();
        return items[head + 1];
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        tail = (tail - 1 + capacity) % capacity;
        size -= 1;
        contract();
        return items[tail - 1];
    }


}
