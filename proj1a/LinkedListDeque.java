public class LinkedListDeque<T> {

    private class ItemNode<T> {
        T item;
        ItemNode next;
        ItemNode pre;
        public ItemNode(T x, ItemNode p, ItemNode n) {
            item = x;
            pre = p;
            next = n;
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

    public void addFirst(T item) {
        ItemNode firstNewItem = new ItemNode(item, sentinel, sentinel.next);
        sentinel.next.pre = firstNewItem;
        sentinel.next = firstNewItem;
        size += 1;
    }

    public void addLast(T item) {
        ItemNode lastNewItem = new ItemNode(item, sentinel.pre, sentinel);
        sentinel.pre.next = lastNewItem;
        sentinel.pre = lastNewItem;
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
        ItemNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        ItemNode p = sentinel.next;
        p.next.pre = sentinel;
        sentinel.next = p.next;
        size -= 1;
        return (T) p.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        ItemNode p = sentinel.pre;
        p.pre.next = sentinel;
        sentinel.pre = p.pre;
        size -= 1;
        return (T) p.item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ItemNode p = sentinel.next;
        while (index != 0) {
            p = p.next;
            index--;
        }
        return (T) p.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ItemNode p = sentinel.next;
        return getHelper(index, p);
    }

    private T getHelper(int index, ItemNode start) {
        if (index == 0) {
            return (T) start.item;
        }
        return (T) getHelper(index - 1, start.next);
    }

}
