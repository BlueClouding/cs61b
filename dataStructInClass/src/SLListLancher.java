public class SLListLancher {
    public static void main(String[] args) {
        SLList s = new SLList();
        for (int i = 0 ; i < 100000; i ++) {
            s.addLast(i);
        }
    }
}
