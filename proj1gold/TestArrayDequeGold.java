import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold  {

    private static final int calls = 1000;
    private static String message = "";

    private void randomAdd(double random, Integer i, StudentArrayDeque<Integer> sad, ArrayDequeSolution<Integer> ads) {
        if (random < 0.5) {
            sad.addFirst(i);
            ads.addFirst(i);
            message += String.format("\naddFirst(%d)", i);
        } else {
            sad.addLast(i);
            ads.addLast(i);
            message += String.format("\naddLast(%d)", i);
        }
    }

    private void randomRemove(double random, Integer i, StudentArrayDeque<Integer> sad, ArrayDequeSolution<Integer> ads) {
        Integer expected, actual;
        if (random < 0.5) {
            expected = sad.removeFirst();
            actual = ads.removeFirst();
            message += "\nremoveFirst()";
        } else {
            expected = sad.removeLast();
            actual = ads.removeLast();
            message += "\nremoveLast()";
        }
        assertEquals(message, expected, actual);
    }


    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        for (int i = 0; i < calls; i += 1) {

            if (sad.isEmpty() || ads.isEmpty()) {
                double random = StdRandom.uniform();
                randomAdd(random, i, sad, ads);
            } else {
                double r1 = StdRandom.uniform();
                double r2 = StdRandom.uniform();

                if (r1 < 0.5) {
                    randomAdd(r2, i, sad, ads);
                } else {
                    randomRemove(r2, i, sad, ads);
                }
            }

        }
    }
}
