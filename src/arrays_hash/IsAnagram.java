package arrays_hash;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> lettersToCount = new HashMap<>();

        for (Character c : s.toCharArray()) {
            if (!lettersToCount.containsKey(c)) {
                lettersToCount.put(c, 1);
            }else {
                lettersToCount.put(c, lettersToCount.get(c) + 1);
            }
        }

        for (Character c : t.toCharArray()) {
            if (!lettersToCount.containsKey(c)) {
                return false;
            }else {
                lettersToCount.put(c, lettersToCount.get(c) -1 );
            }
        }

        if (lettersToCount.values().stream().anyMatch(a -> a != 0)) {
            return false;
        }
        return true;
    }

    public boolean isAnagramStreams(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Long> lettersToCountS = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> lettersToCountT = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return lettersToCountS.equals(lettersToCountT);
    }
}

