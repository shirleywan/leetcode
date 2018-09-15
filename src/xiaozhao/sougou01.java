package xiaozhao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 搜狗笔试题：第一次取最大值，后来每次取最前或最后的最大值，分给两个人，比较二者差值；
 */
public class sougou01 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int  i = 0 ; i< n ; i++){
            nums[i] = in.nextInt();
        }
        int max = nums[0];
        int p = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > max) {max = nums[i]; p = i;}
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = p+1 ; i < n ; i++){
            list.add(nums[i]);
        }
        for(int i = 0 ; i < p ; i++){
            list.add(nums[i]);
        }
        System.out.println(list);
        int count1 = 0;
        int count2 = 0;
        count1 += max;
        int i = 0;
        while(list.size() >0){
            int maxnum= Math.max(list.get(0) , list.get(list.size()-1));
            if( i % 2 == 0){count2 += maxnum;list.remove(list.get(0) > list.get(list.size()-1) ? 0 : list.size()-1);}
            else{count1 += maxnum;list.remove(list.get(0) > list.get(list.size()-1) ? 0 : list.size()-1);}
            i++;
        }
        System.out.println(Math.abs(count1 - count2));
    }
}
