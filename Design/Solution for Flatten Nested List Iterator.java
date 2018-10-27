/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    private Stack<ListIterator<NestedInteger>> S;

    public NestedIterator(List<NestedInteger> nestedList) {
        S = new Stack<>();
        S.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        return S.peek().next().getInteger();
        
    }

    @Override
    public boolean hasNext() {
        while (!S.isEmpty()) {
            if (!S.peek().hasNext()) S.pop();
            else {
                NestedInteger x = S.peek().next();
                if (x.isInteger()) return S.peek().previous() == x;
                S.push(x.getList().listIterator());
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */