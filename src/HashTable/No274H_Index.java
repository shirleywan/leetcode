package HashTable;

import java.util.*;

/**
 * 274. H-Index
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 *
 * Example:
 *      Input: citations = [3,0,6,1,5]
 *      Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 *              received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
class Solution274 {
    public int hIndex1(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int count = Math.min(citations[0] , citations.length);
        for( int i = 0; i < citations.length ; i++){
            if(citations[i] <= citations.length -i) count =  Math.max(citations[0] , i+1);
            else{
                break;
            }
        }
        return count;
    }
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(citations);
        for (int i = len - 1; i >= 0; i--) {
            int numEls = len - i;
            int maxH = citations[i], minH = i == 0 ? 0 : citations[i - 1];
            if (numEls >= minH && numEls <= maxH) {
                return Math.max(minH, numEls);
            }
        }
        return 0;
    }
}
public class No274H_Index {
    public static void main(String[] args){
        int[] nums = {3,3,5,5,7};
        System.out.println(new Solution274().hIndex(nums));
    }
}
