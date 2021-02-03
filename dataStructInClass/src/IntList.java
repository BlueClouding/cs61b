public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p.rest;
            for (int i = 0; i <= n; i++ ) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }
            p = next;
            n += 1;
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(5,null);
        L = new IntList(21,L);
        L = new IntList(22,L);
        L = new IntList(24,L);
        L = new IntList(25,L);
        L = new IntList(27,L);

        System.out.println(L);
    }
}
