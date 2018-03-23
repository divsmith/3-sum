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

}