public class SpeedTestAList {
    public static void main(String[] args) {
        AList a = new AList();
        for (int i = 0; i < 1000000; i++) {
            a.addLast(i);
        }
    }
}
