public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }


    public static void main(String[] args) {
        IntList L = new IntList(12,null);
        L = new IntList(12,L);
        L = new IntList(13,L);
        System.out.println("wewer");
    }
}
