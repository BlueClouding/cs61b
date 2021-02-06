import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertEquals(palindrome.isPalindrome("isasi"), true);
        assertEquals(palindrome.isPalindrome("is"), false);
        assertEquals(palindrome.isPalindrome(""), true);
    }

    @Test
    public void testIsPalindrome2() {
        assertEquals(palindrome.isPalindrome("acdb", cc), true);
    }
}
