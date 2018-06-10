package test;

import java.util.HashSet;

public class HashSet2
{
    public static void main(String[] args)
    {
        HashSet hashSet = new HashSet();
        People p1 = new People("zhangsan");
        People p2 = new People("lisi");
        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet);
    }
}
class People
{
     String name;
     People(String name)
    {
        this.name=name;
    }
     public int hashCode()
     {
         return this.name.hashCode();
     }
     public boolean equals(Object obj)
     {    
         if(this==obj)
         {
             return true;
         }
         if(obj!=null&&obj instanceof People)
         {
             People p = (People)obj;
             if(name.equals(p.name))
             {
                 return true;
             }
         }
         return false;
     }
     
}