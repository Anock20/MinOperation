public class Main {
    static int[] test;

    static void testRecur(int n) {
        test = new int[n + 1];
        System.out.println(recur(n));
    }
    public static int recur(int n) {
        if (n == 1)
            return 0;
        if (test[n] != 0)
            return test[n]; // 이미 계산한 값이라면 저장된 결과 반환
        int count1 = recur(n - 1) + 1; // 1을 뺀 경우
        if (n % 3 == 0) {
            int count3 = recur(n / 3) + 1; // 3으로 나누는 경우
            count1 = Math.min(count1, count3);
        }
        if (n % 2 == 0) {
            int count2 = recur(n / 2) + 1; // 2로 나누는 경우
            count1 = Math.min(count1, count2);
        }
        test[n] = count1; // 결과 저장
        return count1;
    }
    public static void main(String[] args) {
        testRecur(2);
        testRecur(10);
        testRecur(5);
        testRecur(20);
    }
}