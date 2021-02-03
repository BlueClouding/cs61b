public interface List61B<Item> {
    public void addFirst(Item x);

    public void addLast(Item y);

    public Item getFirst();

    public Item getLast();

    public Item get(int i);

    public int size();

    public void insert(Item x, int position);

    public Item removeLast();

    default public void print() {
        for (int i = 0; i < size(); i++ ) {
            System.out.println(get(i));
        }
    }
}
