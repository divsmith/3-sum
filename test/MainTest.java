import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by parker on 3/23/18.
 */
class MainTest {
    @Test
    void insertion_sort() {
        int[] unsorted = {4, 3, 2, 1};
        int[] sorted = {1, 2, 3, 4};

        Assertions.assertTrue(Arrays.equals(sorted, Main.insertion_sort(unsorted)));
    }

    @Test
    void insertion_sort_more()
    {
        int[] unsorted = {17, 8, 9, 11, 44, 19};
        int[] sorted = {8, 9, 11, 17, 19, 44};

        Assertions.assertTrue(Arrays.equals(sorted, Main.insertion_sort(unsorted)));
    }

    @Test
    void binary_search()
    {
        int[] haystack = {1, 2, 3, 4, 5};
        Assertions.assertEquals(1, Main.binary_search(2, haystack));
    }

    @Test
    void binary_search_first()
    {
        int[] haystack = {1, 2, 3, 4, 5};
        Assertions.assertEquals(0, Main.binary_search(1, haystack));
    }

    @Test
    void binary_search_last()
    {
        int[] haystack = {1, 2, 3, 4, 5};
        Assertions.assertEquals(4, Main.binary_search(5, haystack));
    }

    @Test
    void binary_search_not_found()
    {
        int[] haystack = {1, 2, 3, 4, 5};
        Assertions.assertEquals(-1, Main.binary_search(17, haystack));
    }
}