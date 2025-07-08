package two_pointers;

import java.util.stream.Collectors;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String cleanedString = s.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .filter(c -> Character.isAlphabetic(c) || Character.isDigit(c))
                .map(String::valueOf)
                .collect(Collectors.joining());

        int l = 0;
        int p = cleanedString.length() - 1;

        while (l < p) {
            if (cleanedString.charAt(l) != cleanedString.charAt(p)) {
                return false;
            }
            l++;
            p--;
        }
        return true;
    }

    public static void runTests() {
        ValidPalindrome t = new ValidPalindrome();


        String[][] inputs = {
                {"Was it a car or a cat I saw?"},
                {"tab a cat"},
                {"0P"}
        };


        for (int i = 0; i < inputs.length; i++) {
            System.out.println(t.isPalindrome(inputs[i][0]));
        }
    }
}
