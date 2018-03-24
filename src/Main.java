import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static int countCubic(int[] a)
    {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = i + 1; j < N; j++)
            {
                for (int k = j + 1; k < N; k++)
                {
                    if (a[i] + a[j] + a[k] == 0)
                    {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static int countQuadratic(int[] a)
    {
        a = insertion_sort(a);

        int N = a.length;
        int count = 0;

        for (int i = 0; i < N; i++)
        {
            for (int j = i + 1; j < N; j++)
            {
                int index = binary_search(-(a[i] + a[j]), a);

                if (index != -1)
                {
                    int number = a[index];

                    if (a[j] < a[index])
                    {
                        count++;

                        /*
                         * The for loops are used to correctly account for duplicate numbers
                         * that would otherwise be missed. Since the condition checks for
                         * a[k] == number, they don't have to loop through the entire
                         * sorted array (unless the rest of the array is that single
                         * number). In most cases this keeps it from degrading to ~n^3.
                         */
                        for (int k = index - 1;  k >= j && a[k] == number; k--)
                        {
                            count++;
                        }

                        for (int k = index + 1; k <= a.length - 1 && a[k] == number; k++)
                        {
                            count++;
                        }
                    }
                    else if (a[j] == a[index])
                    {
                        for (int k = j + 1; k <= a.length - 1 && a[k] == number; k++)
                        {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static int binary_search(int needle, int[] haystack)
    {
        int min = 0;
        int max = haystack.length - 1;

        while (min <= max)
        {
            int mid = (min + max) / 2;
            if (haystack[mid] < needle)
            {
                min = mid + 1;
            }
            else if (haystack[mid] > needle)
            {
                max = mid - 1;
            }
            else
            {
                return mid;
            }
        }

        return -1;
    }

    /**
     * An insertion sort is used because it's simple and
     * doesn't negatively impact the order of growth
     * classification. countQuadratic() grows proportional
     * to ~n^2 due to it's nested for loop, so any sorting
     * algorithm that's equal to or faster than ~n^2 has no
     * impact on the algorithm as a whole.
     */
    public static int[] insertion_sort(int[] input)
    {
        int i = 1;

        while (i < input.length)
        {
            int j = i;
            while (j > 0 && (input[j - 1] > input[j]))
            {
                int temp = input[j];
                input[j] = input[j - 1];
                input [j - 1] = temp;

                j--;
            }

            i++;
        }

        return input;
    }

    public static void main(String[] args) throws FileNotFoundException {
        In in = new In(new File(args[0]));
        int[] a = in.readAllInts();
        System.out.println("Total ints: " + a.length);
        Stopwatch stopwatch = new Stopwatch();
        System.out.println(countCubic(a));
        double time = stopwatch.elapsedTime();
        System.out.println("Cubic Time: " + time);

        stopwatch = new Stopwatch();
        System.out.println(countQuadratic(a));
        time = stopwatch.elapsedTime();
        System.out.println("Quadratic Time: " + time);
    }
}
