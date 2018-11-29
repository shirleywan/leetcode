package TwoPointer;

/**
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example:
 *      Input: [1,8,6,2,5,4,8,3,7]
 *      Output: 49
 */
class Solution11 {
    /**
     *O(n^2)
     * 512ms, 4.60%
     */
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int max = 0;
        for( int i = 0 ; i < height.length ; i++ ){
            for( int j = i+1 ; j < height.length ; j++){
                int area = (j-i) *Math.min(height[i],height[j]);
                if(area > max) max = area;
            }
        }
        return max;
    }
    /**
     * method 2: O(n)
     * 4ms , 99.55%
     */
    public int maxArea1(int[] height) {
        int max = 0,s = 0;

        for(int i = 0,j = height.length-1; i < j;){
            if(height[i] > height[j]) {
                s = height[j]*(j-i);
                j--;
            }
            else {
                s = height[i]*(j-i);
                i++;
            }
            if(s > max) max = s;
        }

        return max;
    }
}
public class No11ContainerWithMostWater {
    public static void main(String[] args){
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution11().maxArea1(nums));
    }
}
