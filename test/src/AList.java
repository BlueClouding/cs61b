public class AList<Item> {
    private Item[] items;
    private int size;

    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    public void addLast(Item x) {
        if (size == items.length) {
            resize();
        }
        items[size] = x;
        size += 1;
    }

    public Item getLast() {
        return items[size - 1];
    }

    public Item get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public void resize() {
        Item[] a = (Item[]) new Object[2 * size];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public Item deleteBack() {
        Item returnItem = getLast();
        items[size - 1] = null;
        size -= 1;
        return returnItem;
    }

}
