public class LinkedListDeque<T> implements Deque<T> {

    private class ItemNode<T> {
        private T item;
        private ItemNode next;
        private ItemNode pre;
        public ItemNode(T item, ItemNode p, ItemNode n) {
            this.item = item;
            this.pre = p;
            this.next = n;
        }
    }

    private ItemNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ItemNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        ItemNode firstNode = new ItemNode(item, sentinel, sentinel.next);
        sentinel.next.pre = firstNode;
        sentinel.next = firstNode;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        ItemNode lastNode = new ItemNode(item, sentinel.pre, sentinel);
        sentinel.pre.next = lastNode;
        sentinel.pre = lastNode;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        ItemNode p = sentinel.next;
        while (p != null) {
            System.out.println(p.item + " ");
        }
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T firstItem = (T) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size -= 1;
        return firstItem;
    }

    @Override
    public T removeLast() {
        if (sentinel.pre == sentinel) {
            return null;
        }
        T lastItem = (T) sentinel.pre.item;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.next = sentinel;
        size -= 1;
        return lastItem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        ItemNode p = sentinel.next;
        while (index != 0) {
            p = p.next;
            index -= 1;
        }
        return (T) p.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ItemNode p = sentinel.next;
        return helper(index, p);
    }

    private T helper(int index, ItemNode p) {
        if (index == 0) {
            return (T) p.item;
        }
        return (T) helper(index - 1, p.next);
    }
}
