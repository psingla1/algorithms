import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int cnt = in.nextInt();
            int nums[] = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                nums[cnt-j-1] = in.nextInt();
            }
            int ass[] = new int[cnt];
            solve(cnt, nums, ass, 0, 0, 0);
            String s = "";
            for (int j = 0; j < cnt; j++) {
                s += (ass[j] == 1) ? 'R' : 'L';
            }
            System.out.println("Case #" + (i+1) + ": " + s);
        }
    }
    static boolean solve(int cnt, int[] nums, int[] ass, int sum1, int sum2, int pos) {
        if (pos == cnt) return true;
        if (solveL(cnt, nums, ass, sum1, sum2, pos)) {
            return true;
        }
        if (solveR(cnt, nums, ass, sum1, sum2, pos)) {
            return true;
        }
        ass[pos] = 0;
        return false;
    }

    static boolean solveL(int cnt, int[] nums, int[] ass, int sum1, int sum2, int pos) {
        // assign -1
        ass[pos] = -1;
        int sum1t = sum1-1;
        if (sum1t < -1 || sum1t > 1) return false;
        int sum2t = getSum(nums, ass);
        if (sum2t < -1 || sum2t > 1) return false;
        return solve(cnt, nums, ass, sum1t, 0, pos+1);
    }
    static boolean solveR(int cnt, int[] nums, int[] ass, int sum1, int sum2, int pos) {
        ass[pos] = 1;
        int sum1t = sum1+1;
        if (sum1t < -1 || sum1t > 1) return false;
        int sum2t = getSum(nums, ass);
        if (sum2t < -1 || sum2t > 1) return false;
        return solve(cnt, nums, ass, sum1t, 0, pos+1);
    }

    static int getSum(int[] nums, int[] ass) {
        int sum = 0;
        for (int i = 0; i<nums.length;i++) {
            if (ass[nums[i]-1] == 0) return sum;
            sum += ass[nums[i] - 1];
            if (sum < -1 || sum > 1) return sum;
        }
        return sum;
    }
}