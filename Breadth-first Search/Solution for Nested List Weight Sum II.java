/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // Stack<ListIterator<NestedInteger>> S = new Stack<>();
        // S.push(nestedList.listIterator());
        // int sum = 0, max_depth = 0;
        // Map<Integer, Integer> map = new HashMap<>();
        // while (!S.isEmpty()) {
        //     if (!S.peek().hasNext()) {
        //         S.pop();
        //     } else {
        //         NestedInteger x = S.peek().next();
        //         if (x.isInteger()) {
        //             if (!map.containsKey(S.size())) {
        //                 map.put(S.size(), 0);
        //             } 
        //             max_depth = Math.max(max_depth, S.size());
        //             map.put(S.size(), map.get(S.size()) + x.getInteger());
        //         } else {
        //             S.push(x.getList().listIterator());
        //         }
        //     }
        // }
        // for (int key : map.keySet()) {
        //     sum += (max_depth - key + 1) * map.get(key);
        // }
        // return sum;
        
        int weighted_sum = 0, unweighted_sum = 0;
        while (nestedList.size() != 0) {
            List<NestedInteger> nestedLevel = new ArrayList<>();
            for (NestedInteger nest : nestedList) {
                if (nest.isInteger()) unweighted_sum += nest.getInteger();
                else {
                    nestedLevel.addAll(nest.getList());
                }
            }
            nestedList = nestedLevel;
            weighted_sum += unweighted_sum;
        }
        return weighted_sum;
    }
}