public class Maximizer {

    public static Comparable max(Comparable[] items) {
        int maxIndex = 0;
        for (int i = 0; i < items.length; i++) {
            int cmp = items[i].compareTo(items[maxIndex]);
            if (cmp > 0) {
                maxIndex = i;
            }
        }
        return items[maxIndex];
    }
    public static void main(String[] args) {
        Dog[] dogs = {new Dog("a", 3), new Dog("b", 5),
        new Dog("c", 7)};

        Dog maxDog = (Dog) max(dogs);
        maxDog.bark();
        System.out.println(maxDog);

    }
}
