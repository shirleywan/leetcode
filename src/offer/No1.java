package offer;

/**
 * 二维数组中的查找
 */
class Solution1{
    public boolean Find(int target, int [][] array) {
        if(array.length == 0 || array[0].length == 0){return false;}
        int n = array.length ;
        int m = array[0].length;
        for(int i =0 , j = m-1; i< n && j >=0 ;){
            if(array[i][j] == target){return true;}
            if(array[i][j] > target){j--;}
            else{
                if(array[i][j] < target){i++;}
            }
        }
        return false;
    }
}
public class No1 {
    public static void main(String[] args){
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 5;
        System.out.println(new Solution1().Find(target , nums));
    }
}
