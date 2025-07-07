package arrays_hash;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EncodeDecode {
    public String encode(List<String> strs) {
        return strs.stream()
                .map(str -> str.length() + "#" + str)
                .collect(Collectors.joining());
    }

    public List<String> decode(String str) {
        int hashPos = -1;
        List<String> output = new ArrayList<>();
        int i =0;
        while (i < str.length()){
            String currentSubString = str.substring(i);
            hashPos = currentSubString.indexOf('#');
            int wordLength = Integer.parseInt(currentSubString.substring(0, hashPos));
            output.add(currentSubString.substring(hashPos + 1, hashPos + wordLength + 1));
            i +=  wordLength + str.substring(0, hashPos).length() + 1;
        }
        return output;
    }


    public static void runTests() {
        EncodeDecode t = new EncodeDecode();

// []
        String[][] inputs = {
                {},
                {""},
                {"test","as"},
                {"we","say",":","yes","!@#$%^&*()"},
                {"The quick brown fox","jumps over the","lazy dog","1234567890","abcdefghijklmnopqrstuvwxyz"}

        };


        for (int i = 0; i < inputs.length; i++) {
            String encode = t.encode(List.of(inputs[i]));
            System.out.println("Encoded-------");
            System.out.println(encode);
            List<String> decode = t.decode(encode);
            System.out.println("Input---------");
            System.out.println(List.of(inputs[i]));
            System.out.println("Decoded-------");
            System.out.println(decode);
            System.out.println("--------");
        }
    }
}
