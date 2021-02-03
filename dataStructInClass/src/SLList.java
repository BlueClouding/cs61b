public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int x, IntNode n) {
            item = x;
            next = n;
        }
    }

    private int size;
    public IntNode sentinel;
    public IntNode first;

    public SLList(int x) {

        sentinel = new IntNode(63,null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList() {

        sentinel = new IntNode(63,null);
        size = 0;
    }

    public void addFirst(int x) {
        size += 1;
        sentinel.next = new IntNode(x,sentinel.next);
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size += 1;

        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x,null);
    }

    private static int size(IntNode first) {
        if (first.next == null) {
            return 1;
        }
        return 1 + size(first.next);
    }

    public void insert(int item, int position) {
        if (position > size-1) {
            return;
        }
        IntNode p = sentinel;
        while(position != 0) {
            p = p.next;
            position -= 1;
        }
        IntNode newIntNode = new IntNode(item,p.next);
        p.next = newIntNode;
        size += 1;
    }

    public void iterateReverse() {
        IntNode frontOfReversed = null;
        IntNode nextNodeToAdd = sentinel;
        while (nextNodeToAdd != null) {
            IntNode reminderOfOrigin = nextNodeToAdd.next;
            nextNodeToAdd.next = frontOfReversed;
            frontOfReversed = nextNodeToAdd;
            nextNodeToAdd = reminderOfOrigin;
        }
        sentinel.next = frontOfReversed;
    }

    public void recursiveReverse() {
        sentinel.next = helper(sentinel.next);
    }

    private IntNode helper(IntNode front) {
        if (front == null || front.next == null) {
            return front;
        }
        IntNode reversed = helper(front.next);
        front.next.next = front;
        front.next = null;
        return reversed;
    }


    public static void main(String[] args) {
        SLList L = new SLList();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        L.addLast(4);
        L.addLast(5);
        L.addLast(7);
        L.insert(10,5);
        System.out.println(L.size);
        System.out.println(L.getFirst());
        //L.iterateReverse();
        L.recursiveReverse();
        System.out.println(L.getFirst());
    }

}
