import java.util.ArrayList;

public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        adq.addFirst(1);
        adq.addFirst(2);
        adq.addLast(3);
        adq.addLast(4);

        adq.printDeque();

        System.out.println();
        adq.removeFirst();
        adq.removeLast();
        adq.printDeque();
        System.out.println(adq.size());
    }


}
