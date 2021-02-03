
public class RotatingSLList<Item> extends SLList<Item> {
    public void rotateRight() {
        Item x = removeLast();
        addFirst(x);
    }



//    LinkedList<Item> linkedList = new LinkedList<>();
    public static void main(String[] args) {
        RotatingSLList<Integer> rsl = new RotatingSLList<>();
        rsl.addFirst(1);
        rsl.addFirst(2);
        rsl.addLast(3);
        rsl.addLast(5);

        System.out.println(rsl.toString());
        rsl.rotateRight();
        System.out.println(rsl.toString());
    }
}
