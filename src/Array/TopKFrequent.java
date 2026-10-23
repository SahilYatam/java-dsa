package Array;

import java.util.*;

// class Solution4 {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int[] result = new int[k];

//         // Count frequency
//         for(int num : nums){
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         // Store [number, frequency]
//         List<List<Integer>> values = new ArrayList<>();
//         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//             values.add(List.of(entry.getKey(), entry.getValue()));
//         }

//         // Sort by frequency - descending
//         values.sort(
//                 Comparator.comparingInt((List<Integer> a) -> a.get(1)).reversed()
//         );

//         // Get top K numbers
//         for(int i = 0; i < k; i++){
//             result[i] = values.get(i).getFirst();
//         }

//         return result;
//     }
// }

// Optimal approach
class Solution4 {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n, count.getOrDefault(n,0)+1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
            (a,b) -> count.get(a)-count.get(b)
        );

        for(int n : count.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = heap.poll();
        }

        return ans;
    }
}

public class TopKFrequent {
    public static void main(String[] args){

        Solution4 sol = new Solution4();

        int[] nums = {1,2,2,3,3,3};
        int k = 2;
//      Output: [3,2]
        int[] result = sol.topKFrequent(nums,k);
        System.out.print(Arrays.toString(result));

    }
}
