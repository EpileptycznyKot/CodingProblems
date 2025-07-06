package arrays_hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {


    public boolean hasDuplicateLoop(int[] nums) {
        Set<Integer> knownNumbers = new HashSet<>();

        for (Integer i : nums) {
            if (knownNumbers.contains(i)) {
                return true;
            }
            knownNumbers.add(i);
        }
        return false;
    }


    public boolean hasDuplicateStream(int[] nums) {
        return Arrays.stream(nums)
                .distinct()
                .count() < nums.length;
    }
}
