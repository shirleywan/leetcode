package zuochengyun;

import java.util.*;
/**
 * 猫狗队列
 */
class Pet{
    private String type;
    public Pet(String type){
        this.type = type;
    }
    public String getPetType(){
        return this.type ;
    }
}
class Dog extends Pet{
    public Dog(){
        super("dog");
    }
}
class Cat extends Pet{
    public Cat(){
        super("cat");
    }
}

/**
 * 设置一个新的类，是Pet类的一个修正，增加count计数项
 */
class PetEnterQueue{
    private Pet pet;
    private long count;
    public PetEnterQueue(Pet pet , long count){
        this.pet = pet;
        this.count = count;
    }
    public Pet getPet(){
        return this.pet;
    }
    public long getCount(){
        return this.count;
    }
    public String getPetType(){
        return this.pet.getPetType();
    }

}
class Solution4{
    private Queue<PetEnterQueue> dogQ = new LinkedList<PetEnterQueue>();
    private Queue<PetEnterQueue> catQ = new LinkedList<PetEnterQueue>();
    private long count;

    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            dogQ.offer(new PetEnterQueue(pet , this.count++));
        }
        else{
            if(pet.getPetType().equals("cat")){
                catQ.offer(new PetEnterQueue(pet , this.count++));
            }
            else{
                throw new RuntimeException("type is illeagel");
            }
        }
    }
    public Pet pollAll(){
        if(dogQ.isEmpty() && catQ.isEmpty()){throw new RuntimeException("queue is empty");}
        if(dogQ.peek().getCount() < catQ.peek().getCount()){
            return dogQ.poll().getPet();
        }
        else{
            if (!dogQ.isEmpty() && catQ.isEmpty()){
                return dogQ.poll().getPet();
            }
            else{
                if (dogQ.isEmpty() && !catQ.isEmpty()){
                    return catQ.poll().getPet();
                }
                else{
                    return catQ.poll().getPet();
                }
            }
        }


    }
    public Pet pollDog(){
        if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        }
        else{
            throw new RuntimeException("dog queue is empty");
        }
    }
    public Pet pollCat(){
        if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        }
        else{
            throw new RuntimeException("dog queue is empty");
        }
    }
    public boolean isEmpty(){
        return dogQ.isEmpty() && catQ.isEmpty();
    }
    public boolean isDogEmpty(){
        return dogQ.isEmpty();
    }
    public boolean isCatEmpty(){
        return catQ.isEmpty();
    }
}
public class No4 {
    public static void main(String[] args){
        Solution4 solution4 = new Solution4();
        Pet cat1 = new Pet("cat");
        Pet dog1 = new Pet("dog");
        Pet dog2 = new Pet("dog");
        Pet dog3 = new Pet("dog");
        Pet cat2 = new Pet("cat");
        solution4.add(cat1);
        solution4.add(dog1);
        solution4.add(dog2);
        solution4.add(dog3);
        solution4.add(cat2);
        System.out.println(solution4.isEmpty());
        System.out.println(solution4.isDogEmpty());
        System.out.println(solution4.isCatEmpty());

        System.out.println(solution4.pollAll().getPetType());
        System.out.println(solution4.pollDog().getPetType());
        System.out.println(solution4.pollCat().getPetType());
    }
}
