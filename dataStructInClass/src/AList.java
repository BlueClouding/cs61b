import java.util.Arrays;

public class AList<Item> implements List61B<Item>{
    private int size;
    private Item[] items;

    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }

    @Override
    public void addFirst(Item x) {
        insert(x,0);
    }

    @Override
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[size] = x;
        size += 1;
    }

    @Override
    public Item getFirst() {
        return items[0];
    }

    @Override
    public Item getLast() {
        return items[size - 1];
    }

    @Override
    public Item get(int i) {
        return items[i];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(Item x, int position) {
        Item[] newItems = (Item[]) new Object[items.length + 1];
        System.arraycopy(items,0,newItems,0,position);
        newItems[position] = x;
        System.arraycopy(items,position,newItems,position + 1,items.length - position);
        items = newItems;
    }

    @Override
    public Item removeLast() {
        Item x = getLast();
        items[size - 1] = null;
        size -= 1;
        return x;
    }
}
