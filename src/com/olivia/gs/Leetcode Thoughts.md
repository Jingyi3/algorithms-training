### K-th
1. sort
2. Heap use `PriorityQueue` 
    - k max --> use min(default) heap and only save #k items, which means always `poll` small items, and thus the heap will remain k-th largest items
3. RandomSelect / Quickselect


### DFS BFS

### Two Pointers

### BinarySearch

### Backtracking
> This structure might apply to many other backtracking questions, but here I am just going to demonstrate **Subsets, Permutations, and Combination Sum**.  
[refer](https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning))
1. Subset 
[LC78]( https://leetcode.com/problems/subsets/)

```Java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}
```

```
Another approach
1. record valid result - reach the length
2. (1) choose cur num
        call helper()
   (2) not choose cur num
        call helper()
```
2. Subsets II (contains duplicates) : [LC90](https://leetcode.com/problems/subsets-ii/)
> 当两个数字一样,前一个数字没有被取，但后一个数字被取了，就会出现重复的 subset / permutation  
```java
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
} 
```