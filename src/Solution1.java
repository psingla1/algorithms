import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution1 {
    int Icnt = 0;
    int icnt = 0;
    int ans = 0;
    char IreqO = ' ';
    char ireqO = ' ';
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String inp = in.next();
            System.out.println("Case #" + (i+1) + ": " + new Solution1().solve(inp));
        }
    }
    int solve (String inp) {
        int n = inp.length();
        if (n <= 1) return 0;
        for (int j = 0; j < n; j++) {
            char c = inp.charAt(j);
            if (c == 'I') {
                this.Icnt += 1;
                if (this.Icnt > 2) {
                    return 0;
                }
            }
            else if (c == 'i') {
                this.icnt += 1;
                if (this.icnt > 2) {
                    return 0;
                }
            }
            else {
                if (IreqO == c) {
                    if (tryAssign(false, c)) continue;
                }
                if (ireqO == c) {
                    if (tryAssign(true, c)) continue;
                }
                if (c == 'o') {
                    if (tryAssign(true, c)) continue;
                    if (tryAssign(false, c)) continue;
                    return 0;
                } else if (c == 'O') {
                    if (tryAssign(false, c)) continue;
                    if (tryAssign(true, c)) continue;
                    return 0;
                }
            }
        }
        if (this.Icnt == 0 && this.icnt ==0) {
            return this.ans;
        }
        return 0;
    }

    boolean tryAssign(boolean smallI, char c) {
        if (smallI) {
            if (this.icnt == 2) {
                this.icnt--;
                if (this.ireqO == c) {
                    this.ireqO = ' ';
                } else if (this.ireqO == ' ') {
                    this.ireqO = (c=='o' ? 'O' : 'o');
                }
                return true;
            } else if (this.icnt == 1 && (this.ireqO == c || this.ireqO == ' ')) {
                this.icnt--;
                this.ireqO = ' ';
                return true;
            } else {
                return false;
            }
        } else {
            if (this.Icnt == 2) {
                this.Icnt--;
                if (c == 'O') this.ans++;
                if (this.IreqO == c) {
                    this.IreqO = ' ';
                } else if (this.IreqO == ' ') {
                    this.IreqO = (c == 'o' ? 'O' : 'o');
                }
                return true;
            } else if (this.Icnt == 1 && (this.IreqO == c || this.IreqO == ' ')) {
                this.Icnt--;
                if (c == 'O') this.ans++;
                this.IreqO = ' ';
                return true;
            } else {
                return false;
            }
        }
    }
}