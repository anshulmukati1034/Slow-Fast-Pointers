public class Q4_HappyNumber {
     public static boolean isHappy(int n) {
        int slow = square(n);
        int fast = square(square(n));

        while(slow!=fast){
            slow = square(slow);
            fast = square(square(fast));

            if(slow == 1 || fast == 1){
                return true;
            }
        }
        return slow == 1;
    }

    public static int square(int num) {
        
        int ans = 0;
        
        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int n = 19;
        if (isHappy(n)) {
            System.out.println(n + " is a happy number.");
        } else {
            System.out.println(n + " is not a happy number.");
        }
    }
}
