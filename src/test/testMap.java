package test;

import java.util.Collection;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  
import java.util.Map.Entry;  
import java.util.Set;  
  
public class testMap {  
    private Map map;  
      
    testMap(){  
//      Map<Integer,String> map =new HashMap<Integer,String>();  
        this.map =new HashMap();  
        map.put(1, "str1");  
        map.put(2, "str2");  
        map.put(3, "str1");  
    }  
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
    	testMap guo =new testMap();  
        guo.fun1();  
        guo.fun2();  
    }  
      
    public<E> void fun1(){  //遍历Map  
        System.out.println(map.size()); //map映射个数  
        System.out.println(map.entrySet().getClass());  //HashMap的内部类EntrySet  
          
        //map的三种视图  
        Set<Entry<Integer, String>> set =map.entrySet();  
//      Set<Integer> set_Key =map.keySet();  
        Set<E> set_Key =(Set<E>) map.keySet();  
        Collection<String> col_Value = map.values();  //不能返回Set，values值可能有重复  
          
          
        Iterator<Map.Entry<Integer, String>> itera_Entry =set.iterator();  
        Iterator itera_Key =set_Key.iterator();  
        Iterator<String> itera_Value =col_Value.iterator();  
          
        //迭代器  
        while(itera_Entry.hasNext()){  
            Map.Entry<Integer, String> mapEntry =itera_Entry.next();  
            System.out.println("键："+mapEntry.getKey()+" 值："+mapEntry.getValue());  
        }  
        //增强for循环  
        /*for(Integer key:set_Key){ 
            System.out.println("键："+key); 
        }*/  
        for(E key:set_Key){  
            System.out.println("键："+key);  
        }  
          
        for(String value:col_Value){  
            System.out.println("值："+value);  
        }  
    }  
      
    public Boolean fun2(){  
        Boolean b;  
        b =map.containsKey(5);  
        System.out.println(b);  
        return b;  
    }  
  
}  
