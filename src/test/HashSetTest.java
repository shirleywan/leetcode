package test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest
{
    public static void main(String[] args)
    {
        HashSet hashSet = new HashSet();
        hashSet.add(new Persion(111));
        hashSet.add(new Persion(111));
        System.out.println(hashSet);
        System.out.println("以上为第一部分----------------");
        Persion p1=new Persion(123);
        hashSet.add(p1);
        hashSet.add(p1);
        System.out.println(hashSet);
        System.out.println("下面来的为第三部分------------");
        String s1 = new String("aa");
        String s2 = new String("aa");
        hashSet.add(s1);
        hashSet.add(s2);
        System.out.println(hashSet);
        
    }
}
class Persion
{
    int name;
    Persion(int name)
    {
        this.name=name;
    }
}

