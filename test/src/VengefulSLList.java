public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems;

    public String printLostItems() {
        return deletedItems.toString();
    }

    public VengefulSLList() {
        deletedItems = new SLList<>();
    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vengefulSLList = new VengefulSLList<>();
        vengefulSLList.addLast(1);
        vengefulSLList.addLast(2);
        vengefulSLList.addLast(3);
        vengefulSLList.addLast(4);

        vengefulSLList.removeLast();
        vengefulSLList.removeLast();

        System.out.println(vengefulSLList.printLostItems());
    }
}
