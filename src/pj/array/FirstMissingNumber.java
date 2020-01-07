// Find first missing positive number

package pj.array;

import java.util.Arrays;
import pj.V;

public class FirstMissingNumber {
    public static int solve(int[] arr) {
        Arrays.sort(arr);

        int i = 0;
        while (i < arr.length && arr[i] <= 0) i++;

        if (i == arr.length || arr[i] != 1) return 1;
        i++;

        while (i < arr.length && arr[i] - arr[i-1] <= 1) {
            i++;
        }
        return arr[i-1] + 1;
    }

    public static void main(String args[]) {
        V.verify(solve(new int[]{1, 1, 1}), 2);
        V.verify(solve(new int[]{-1, -1, -2}), 2);
        V.verify(solve(new int[]{-1, -1, -2}), 2);
        V.verify(solve(new int[]{-1, -1, -2}), 2);
        V.verify(solve(new int[]{-1, -1, -2}), 2);
        V.verify(solve(new int[]{-1, -1, -2}), 2);
        V.end();
    }
}