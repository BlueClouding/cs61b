import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog d1 = new Dog("alog", 3);
        Dog d2 = new Dog("bala", 5);
        Dog d3 = new Dog("cava", 7);
        Dog[] dogs= new Dog[]{d1, d2, d3};

        if (d1.compareTo(d2) > 0) {
            System.out.println("d1");
        } else {
            System.out.println("d2");
        }

        Comparator<Dog> nc = Dog.getNameComparator();
        if (nc.compare(d1, d2) > 0) {
            d1.bark();
        } else {
            d2.bark();
        }

    }
}
