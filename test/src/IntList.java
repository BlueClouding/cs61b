public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size(){
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while(p != null) {
            totalSize ++;
            p = p.rest;
        }
        return totalSize;
    }
    public int get(int number) {
        if (number == 0) {
            return this.first;
        }
        return rest.get(number - 1);
    }

    public int iterativeGet(int number){
        IntList p = this;
        while(number != 0) {
            number --;
            p = p.rest;
        }
        return p.first;
    }

    public static void main(String[] args) {
        IntList L = new IntList(1,null);
        L = new IntList(2,L);
        L = new IntList(3,L);
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(2));
    }
}
