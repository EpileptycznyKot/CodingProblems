package arrays_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Map<Character, Long>> wordsToWordsMap = Arrays.stream(strs)
                .collect(Collectors.toMap(
                        str -> str,
                        str -> str.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                ));

        List<List<String>> out = new ArrayList<>();

        Map<Map<Character, Long>, List<String>> charSetsToWords = wordsToWordsMap.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));


        return new ArrayList<>(charSetsToWords.values());
    }

    public List<List<String>> groupAnagramsPureStreams(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        str ->
                                str.chars()
                                        .mapToObj(c -> (char) c)
                                        .collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                        ,
                        Collectors.toList()
                ))
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public static void runTests() {
        GroupAnagram t = new GroupAnagram();


        String[][] inputs = {
                {"act", "pots", "tops", "cat", "stop", "hat"},
                {"x"},
                {""}
        };




        for (int i = 0; i < inputs.length; i++) {
            List<List<String>> result = t.groupAnagramsPureStreams(inputs[i]);
            for (List<String> row : result.stream().toList()) {
                System.out.println(row);
            }
            System.out.println("--------");
        }
    }
}
