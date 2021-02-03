import javax.swing.plaf.SliderUI;

public class SLList<Item> {

    private static class IntNode<Item> {
        public Item item;
        public IntNode next;

        public IntNode(Item i, IntNode n) {
            item = i;
            next = n;
        }
    }
    private int size;
    public IntNode sentinel;
    public SLList() {
        size = 0;
        sentinel = new IntNode(63,sentinel);
    }

    public SLList(Item x) {
        size = 1;
        sentinel = new IntNode(63, sentinel);
        sentinel.next = new IntNode(x,null);
    }

    public void addFirst(Item x) {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public Item getFirst() {
        return (Item) sentinel.next.item;
    }

    public void addLast(Item x) {
        size += 1;
        IntNode p = sentinel;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public IntNode getLastNode() {
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public Item removeLast() {
        IntNode lastNode = getLastNode();
        if (lastNode == sentinel) {
            return null;
        }
        size = size - 1;
        IntNode p = sentinel;
        while (p.next != lastNode) {
            p = p.next;
        }
        p.next = null;
        return (Item) lastNode.item;
    }

    @Override
    public String toString() {
        if (sentinel.next == null) {
            return null;
        }
        String str = "( ";
        IntNode p = sentinel.next;
        while(p != null) {
            str += p.item.toString();
            str += " --> ";
            p = p.next;
        }
        str += "null )";
        return str;
    }

    public static void main(String[] args) {
        //int[] x = new int[] {1,2,3,4};
        SLList l = new SLList(10);
        l.addFirst(1);
        l.addFirst("ds");
        l.addFirst(3);
        l.addLast(4);
        l.addFirst(0.006);
        System.out.println(l.getFirst());
        System.out.println(l.size);
        System.out.println(l.toString());
    }
}

