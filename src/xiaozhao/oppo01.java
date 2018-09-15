package xiaozhao;

import java.util.*;

/**
 * m次连续子数组最大和 ， 只AC20%，不知道问题出在哪里；
 */

public class oppo01 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int n = Integer.valueOf(line.split(" ")[0]);
        int m = Integer.valueOf(line.split(" ")[1]);
        if( m <= 0 ) {System.out.println(0); return ;}
        if( n <= 0 ) { System.out.println(0); return ;}
        if( n == -1 || m == -1){System.out.println(0); return ;}
        line = in.nextLine();
        String[] string = line.split(" ");
        ArrayList<Integer> list = new ArrayList<Integer>();
        m = Math.min(m , n);
        for(int i= 0 ;i <n ; i++){
            list.add(Integer.valueOf(string[i]));
        }
        int count = 0;
        //int[] nums = {6,-3,-2,7,-15,1,2,2};
        for(int i = 0 ; i< m ; i++){
            count += find(list);
            if(list.size() == 0 ) break;
            System.out.println(count);
            System.out.println(list);
        }
        System.out.println(count);
//        System.out.println(find(nums));
//        System.out.println(Arrays.toString(nums));
    }
    public static int find(ArrayList<Integer> list){
        if(list.size() == 0){return 0;}
        int count = list.get(0);
        int max = list.get(0);
        int n = 0 ;
        int m = 0;
        int p = 0 ;
        while ( p < list.size()){
            if(count < 0) {
                count = list.get(p);
                if(max < list.get(p)){n = p ; m = p;}
                max = Math.max(max , list.get(p));
            }
            else{
                if((count + list.get(p)) > count){
                    count = count + list.get(p);
                    if(max < count ){ m = p;}
                    max = Math.max(max , count);
                }
                else{
                    count = count + list.get(p);
                }
            }
            p++;
        }
        for(int i = n ; i < m + 1 ; i++){
            list.remove(list.get(i));
        }
        return max;
    }
    public static int find(int[] nums){
        if(nums.length == 0) {return 0;}
        int count = nums[0];
        int p = 1 ;
        int max = nums[0];
        int n = 0 ;
        int m = 0;
        while(p < nums.length ){
            if(count < 0 ){
                count = nums[p];
                if(max < nums[p]){ n = p; m = p;}
                max = Math.max(max , nums[p]);
            }
            else{
                if((count + nums[p]) > count){
                    count = count + nums[p];
                    if(max < count){
                        m = p;
                    }
                    max = Math.max(max , count);
                }
                else{
                    count = count + nums[p];
                }
            }
            p ++;

        }
        for(int i = n ; i < m + 1 ; i++){
            nums[i] = Integer.MIN_VALUE;
        }
        return max;
    }
}
