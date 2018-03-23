import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static int count(int[] a)
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

    public static int[] insertion_sort(int[] input)
    {
        int[] output = new int[input.length];

        return output;
    }

    public static void main(String[] args) throws FileNotFoundException {
        In in = new In(new File(args[0]));
        int[] a = in.readAllInts();
        System.out.println("Total ints: " + a.length);
        Stopwatch stopwatch = new Stopwatch();
        System.out.println(count(a));
        double time = stopwatch.elapsedTime();
        System.out.println("Time: " + time);
    }
}
