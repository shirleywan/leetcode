package Stack;

import utils.NestedInteger;
import java.util.Iterator;
import java.util.*;

/**
 * 341. Flatten Nested List Iterator
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *      Input: [[1,1],2,[1,1]]
 *      Output: [1,1,2,1,1]
 *      Explanation: By calling next repeatedly until hasNext returns false,
 *                      the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 *      Input: [1,[4,[6]]]
 *      Output: [1,4,6]
 *      Explanation: By calling next repeatedly until hasNext returns false,
 *                      the order of elements returned by next should be: [1,4,6].
 */
class NestedIterator implements Iterator<Integer> {

    public NestedIterator(List<NestedInteger> nestedList) {
        lists = new Stack<ListIterator<NestedInteger>>();
        lists.push(nestedList.listIterator());
    }

    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger())
                    return lists.peek().previous() == x;
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }

    private Stack<ListIterator<NestedInteger>> lists;
}
public class No341FlattenNestedListIterator {
    public static void main(String[] args){
        //main函数不会写，参考吧
    }
}
