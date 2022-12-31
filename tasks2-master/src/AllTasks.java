import java.util.Arrays;

public class AllTasks {

    public static void main(String[] args) {

        // Task 1 ------------------------------------------------------------------------------------------------------

        System.out.println("Task 1 ---------------");

        String answer1 = repeat("test", 5);
        System.out.println(answer1);

        System.out.println();

        // Task 2 ------------------------------------------------------------------------------------------------------

        System.out.println("Task 2 ---------------");

        int[] arr1 = new int[]{3, 0, 0, 10};
        int answer2 = differenceMaxMin(arr1);
        System.out.println(answer2);

        System.out.println();

        // Task 3 ------------------------------------------------------------------------------------------------------

        System.out.println("Task 3 ---------------");

        int[] arr2 = new int[]{4, 4, 2, 2};
        boolean answer3 = isAvgWhole(arr2);
        System.out.println(answer3);

        System.out.println();

        // Task 4 ------------------------------------------------------------------------------------------------------

        System.out.println("Task 4 ---------------");

        int[] arr3 = new int[]{1, 2, 3};
        int[] answer4 = cumulativeSum(arr3);
        for (int i = 0; i < answer4.length; i++) {
            System.out.print(answer4[i]);
            System.out.print(" ");
        }

        System.out.println("\n");

        // Task 5 ------------------------------------------------------------------------------------------------------

        System.out.println("Task 5 ---------------");

        int answer5 = getDecimalPlaces("12.311");
        System.out.println(answer5);

        System.out.println();

        // Task 6 ------------------------------------------------------------------------------------------------------

        System.out.println("Task 6 ---------------");

        int answer6 = Fibonacci(5);
        System.out.println(answer6);

        System.out.println();

        // Task 7 ------------------------------------------------------------------------------------------------------

        System.out.println("Task 7 ---------------");

        boolean answer7 = isValid("12312");
        System.out.println(answer7);

        System.out.println();

        // Task 8 ------------------------------------------------------------------------------------------------------

        System.out.println("Task 8 ---------------");

        boolean answer8 = isStrangePair("341", "123");
        System.out.println(answer8);

        System.out.println();

        // Task 9 ------------------------------------------------------------------------------------------------------

        System.out.println("Task 9 ---------------");

        boolean answer9_1 = isPrefix("automation", "auto-");
        System.out.println(answer9_1);
        boolean answer9_2 = isSuffix("arachnophobia", "-phobia");
        System.out.println(answer9_2);

        System.out.println();

        // Task 10 -----------------------------------------------------------------------------------------------------

        System.out.println("Task 10 --------------");

        int answer10 = boxSeq(3);
        System.out.println(answer10);

    }

    // Task 1 ----------------------------------------------------------------------------------------------------------
    // Repeat all characters in string few times
    // Return this string
    public static String repeat(String str, int number) {
        char[] str_arr = str.toCharArray();
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < number; j++) {
                answer += str_arr[i];
            }
        }
        return answer;
    }

    // Task 2 ----------------------------------------------------------------------------------------------------------
    // Return difference between max and min number in array
    public static int differenceMaxMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return max - min;
    }

    // Task 3 ----------------------------------------------------------------------------------------------------------
    // Return true if avg of numbers of array is integer
    // Else return false
    public static boolean isAvgWhole(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        double sum_d = sum;
        double avg = sum_d / arr.length;

        return Math.round(avg) == avg;
    }

    // Task 4 ----------------------------------------------------------------------------------------------------------
    // Return array where every number is cumulative sum for input array
    public static int[] cumulativeSum(int[] arr) {
        int sum_helper = 0;
        int[] new_arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = arr[i] + sum_helper;
            sum_helper += arr[i];
        }
        return new_arr;
    }

    // Task 5 ----------------------------------------------------------------------------------------------------------
    // Return amount of digits after point
    public static int getDecimalPlaces(String str) {
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                answer = str.length() - (i + 1);
            }
        }

        return answer;
    }

    // Task 6 ----------------------------------------------------------------------------------------------------------
    // Return Fibonacci number with input index
    public static int Fibonacci(int number) {
        int n_1 = 0;
        int n_2 = 1;
        int helper = 0;

        if (number == 1){return 0;}
        if (number == 2){return 1;}

        for (int i = 0; i < number-2; i++) {
            helper = n_2;
            n_2 += n_1;
            n_1 = helper;
        }

        return n_2;
    }

    // Task 7 ----------------------------------------------------------------------------------------------------------
    // Return true if input string is postcode
    // Else return false
    public static boolean isValid(String inp) {
        if (inp.length() > 5) {
            return false;
        }

        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == ' ') {
                return false;
            }
        }

        String digits = "1234567890";

        for (int i = 0; i < inp.length(); i++) {
            boolean is_digit = false;
            for (int j = 0; j < digits.length(); j++){
                if (inp.charAt(i) == digits.charAt(j)) {
                    is_digit = true;
                }
            }
            if (!is_digit) {
                return false;
            }
        }

        return true;
    }

    // Task 8 ----------------------------------------------------------------------------------------------------------
    // Return true if start of first string = end of second string
    // And start of second string = end of first string
    // Else return false
    public static boolean isStrangePair(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        return (arr1[0] == arr2[arr2.length-1]) & (arr2[0] == arr1[arr1.length-1]);
    }

    // Task 9 ----------------------------------------------------------------------------------------------------------
    // Return true if second string is prefix for first string
    public static boolean isPrefix(String str, String prefix) {
        if (prefix.charAt(prefix.length() - 1) != '-') {
            return false;
        }

        char[] prefix_char = prefix.toCharArray();
        char[] str_char = str.toCharArray();

        char[] cutted_prefix = Arrays.copyOf(prefix_char, prefix_char.length - 1);
        char[] cutted_str = Arrays.copyOf(str_char, cutted_prefix.length);

        return Arrays.equals(cutted_prefix, cutted_str);
    }

    // Return true if second string is suffix for first string
    public static boolean isSuffix(String str, String suffix) {
        if (suffix.charAt(0) != '-') {
            return false;
        }

        char[] suffix_char = suffix.toCharArray();
        char[] str_char = str.toCharArray();

        char[] cutted_suffix = Arrays.copyOfRange(suffix_char, 1, suffix_char.length);
        char[] cutted_str = Arrays.copyOfRange(str_char, str_char.length - cutted_suffix.length, str_char.length);

        return Arrays.equals(cutted_str, cutted_suffix);
    }

    // Task 10 ---------------------------------------------------------------------------------------------------------
    // Algorithm:
    // Start with 0
    // 1) Add 3
    // 2) Sub 1
    // Repeat 1) and 2)

    // Return number after n steps
    public static int boxSeq(int inp) {
        int a = inp % 2;
        int b = inp / 2;

        return 0 + 2 * b + 3 * a;
    }

}
