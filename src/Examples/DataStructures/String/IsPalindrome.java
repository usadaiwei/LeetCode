package Examples.DataStructures.String;

public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        if (x < 0 || x % 10 == 0)
            return false;

        String xStr = String.valueOf(x);
        int p1 = 0, p2 = xStr.length() - 1;

        while(p1 < p2) {
            if(xStr.charAt(p1++) != xStr.charAt(p2--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }
}
