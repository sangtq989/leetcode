import java.util.HashMap;
import java.util.Map;

public class LC03005 {
    public static void main(String[] args) {
        Solution3005 s = new Solution3005();
        System.out.println(s.maxFrequencyElements(new int[]{10,12,11,9,6,19,11})) ;
    }
}
class Solution3005 {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> stat = new HashMap<>();
        for (int key : nums) {
            if (stat.containsKey(key)) {
                stat.put(key, stat.get(key) + 1);
            } else {
                stat.put(key, 1);
            }
        }
        int best = 0;
        int bestCount = 0;

        for (Map.Entry<Integer, Integer> entry : stat.entrySet()) {
            best = Math.max(entry.getValue(), best);
        }
        for (Map.Entry<Integer, Integer> entry : stat.entrySet()) {
            if(entry.getValue() == best) bestCount++;
        }
        return bestCount * best;
    }
}

