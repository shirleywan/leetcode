package Arrays;
/**
 * No.88 merge 不会做！
 * @author admin
 *
 */
class Solution88{
	public void merge(int[] A,int m,int[] B,int n) {
		int i=m-1, j=n-1, k=m+n-1;
	    while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
	    while (j>-1)         A[k--]=B[j--];
	}
}
//这个程序是错的，要注意改！！
//class Solution88 {
//    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] count=new int[m+n];
//        int num=0;
//        for(int i=0,j=0;i<nums1.length && j<nums2.length && num<m+n;) {
//        	if(nums1[i]>nums2[j]) {
//        		count[num]=nums2[j];j++;num++;}
//        	if(nums1[i]==nums2[j]) {count[num]=nums1[i];count[num+1]=nums2[j];num=num+1;i++;j++;}
//        	else {count[num]=nums1[i];i++;num++;}
//        }
//        return count;
//    }
//}
public class merge {
	public static String integerArrayToString(int[] nums, int length) {
        String result = "";
        if (length == 0) {
            return result;
        }
    
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return result.substring(0, result.length() - 2);
    }
	
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
	public static void main(String[] args) {
		int[] nums1= {1,2,4,7};
		int[] nums2= {0,5,8,10,11};
		new Solution88().merge(nums1,4,nums2,5);
        String out = integerArrayToString(nums1);
        
        System.out.print(out);
		
	}
}
