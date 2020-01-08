### K-th
1. sort
2. Heap use `PriorityQueue` 
    - k max --> use min(default) heap and only save #k items, which means always `poll` small items, and thus the heap will remain k-th largest items
3. RandomSelect / Quickselect


### DFS BFS

#### Binary tree right view  
[199](https://leetcode.com/problems/binary-tree-right-side-view/) 
> BFS  
> store in queue and poll until the last node in this level and store it in result  

> DFS
> 1. Each depth of the tree only select one node.  
> 2. View depth is current size of result list.
```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //BFS

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root ==null) return res;
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                TreeNode node = queue.poll();
                if(i == size-1) res.add(node.val);// last element in current level
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        
        return res;

        //DFS
        List<Integer> res = new ArrayList<>();
        rightView(root,res,0);
        return res;
        
        
    }
    private void rightView(TreeNode root, List<Integer> res, int currDepth) {
        if(root == null) return;
        if(currDepth == res.size()) {
            res.add(root.val);
        }
        //need recursion right first
        rightView(root.right,res, currDepth+1);
        rightView(root.left,res, currDepth+1);

    }
}
```

### Two Pointers

### BinarySearch



### Backtracking
> This structure might apply to many other backtracking questions, but here I am just going to demonstrate **Subsets, Permutations, and Combination Sum**.  
[Template refer](https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning))
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

### Sliding Window
[Template : sliding window for all substring](https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.)

[LC438](https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92015/ShortestConcise-JAVA-O(n)-Sliding-Window-Solution)
```java
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    int[] hash = new int[256]; //character hash
    //record each character in p to hash
    for (char c : p.toCharArray()) {
        hash[c]++;
    }
    //two points, initialize count to p's length
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
        //move right everytime, if the character exists in p's hash, decrease the count
        //current hash value >= 1 means the character is existing in p
        if (hash[s.charAt(right++)]-- >= 1) count--; 
        
        //when the count is down to 0, means we found the right anagram
        //then add window's left to result list
        if (count == 0) list.add(left);
    
        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
        //++ to reset the hash because we kicked out the left
        //only increase the count if the character is in p
        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
    }
    return list;
}
```

### LRU cache
[146](https://leetcode.com/problems/lru-cache/discuss/45911/Java-Hashtable-%2B-Double-linked-list-(with-a-touch-of-pseudo-nodes))
- HashMap + DoubleLinkedList
    - always put the node latest accessed to the head and remove the node form the tail
- extend `LinkedHashMap`
    - implement `removeEldestEntry`
```    
@Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
```

### Tree Traverse

[pre/in/post-order and bfs and dfs](https://blog.csdn.net/My_Jobs/article/details/43451187)

```java
/** pre
*/
public void preOrderTraverse(TreeNode root) {
    if(root!=null) {
        res.add(root);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }
}

/** in
*/
public void inOrderTraverse(TreeNode root) {
    if(root!=null) {
        inOrderTraverse(root.left);
        res.add(root);
        inOrderTraverse(root.right);
    }
}

/** in
*/
public void postOrderTraverse(TreeNode root) {
    if(root!=null) {
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        res.add(root);
    }
}

public void BFS(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
        TreeNode node = queue.poll();
        res.add(node);
        if(node.left!=null) queue.offer(node.left);
        if(node.right!=null) queue.offer(node.right);
    }
}
```
```java
List<TreeNode> list = new ArrayList<>();
public List<TreeNode> traversal(TreeNode root) {
    dfs(root);
    return list;
}

private void dfs(TreeNode root) {
    if (root == null) return;
    list.add(root);
    dfs(root.left);
    dfs(root.right);
}

private void dfsWithStack(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()) {
        TreeNode node = stack.pop();
        list.add(node);
        if(node.left!=null) stack.push(node.left);
        if(node.right!=null) stack.push(node.right);
    }}


```

### Goldman Prep

1. [199. Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)  
2. 
- [x] 20
- [x] 34
- [ ] 155


### System design

#### ELevator
[refer1](https://jiayi797.github.io/2018/07/08/OOD-%E7%94%B5%E6%A2%AF%E7%B3%BB%E7%BB%9F/)
[refer2](https://wdxtub.com/interview/14520604445920.html)
[refer3](https://cloud.tencent.com/developer/article/1102757)
[refer4](https://cloud.tencent.com/developer/article/1102760)

```
public class User {
private name;
    public pressButton(int toFloor) {
        Request req = new Request( toFloor);
        RequestProcessCenter  center = RequestProcessCenter.getInstance();
        center.addRequest(req);
    }
}
public class Request {
    private int toFloor;
    public Request(int _toFloor) {
        toFloor = _toFloor;
    }
    public getToFloor() {
        return toFloor;
    }
}
public class Elevator {
    public static Elevator instance = null;
    private int currentFloor;
    public static Elevator( ) {
        if (instance == null) {  // late loading and eager loading
                    // connection pool
            synchronized (Elevator.class) {
                instance = new Elevator();
    }
    }
    return instance;
    }
    public getInstance() {
        if (instance == null) {
                synchronized (SingletonDemo.class) {
                    instance = new Elevator();
    }
    }
    return instance;
    }
    public getCurrentFloor() {
        return currentFloor;
    }
    public moveToTargetFloor(int toFloor) {
        currentFloor = toFloor;
    }
    public void moveUp();
    public void moveDown();
    }
    public RequestProcessCenter implements runnable {
        public LinkedList<Request> queue;
    public RequestProcessCenter( ) {
            queue = new LinkedList<Request>( );
    }
    public void run() {
            while ( true ) {
                processRequest( )
    }
    }
    public void addRequest(Request request) {
        queue.add(request);
    }
    public void removeRequest(Request request) {
        queue.remove(request);
    }
    public Request getNextRequest( ) {
        Request shortestReq = null;
        int shortest = Integer.MAX_VALUE;
        int curFloor = Elevator.getInstance( ).getCurrentFloor( );
        for (Request item : queue) {
            int distance = Math.abs(curFloor - item.getToFloor( ) );
            if (distance < shortest) {
                shortest = distance;
                shortestReq = item;
    }
    }
    return shortestReq;
    }
    public void processRequest( ) {
        Request req = getNextRequest( );
    if (req != null) {
            int toFloor = req.getToFloor( );
            Elevator.getInstance.moveToTargetFloor( toFloor);
            queue.remove(req);
    }
       
    }
}
```



