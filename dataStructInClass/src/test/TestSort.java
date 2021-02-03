package test;

import org.junit.Test;
import static org.junit.Assert.*;
public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"good", "man", "is", "always", "bad"};
        String[] expected = {"always","bad","good","is","man"};
        Sort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"good", "man", "is", "always", "bad"};
        String expected = "always";
        String smallestItem = input[Sort.findSamllest(input, 0)];
        assertEquals(expected, smallestItem);
    }

    @Test
    public void testSwap() {
        String[] input = {"good", "man", "is", "always", "bad"};
        String[] expected = {"is", "man", "good", "always", "bad"};
        Sort.swap(input,0,2);
        assertArrayEquals(expected, input);
    }


}
