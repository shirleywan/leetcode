package xiaozhao;

class Planet{
    public static void A(){
        System.out.println("Planet");
    }
    public static void B(){
        System.out.println("Planet");
    }
}
public class Earth {
    public static void A(){
        System.out.println("Earth");
    }
    public static void B(){
        System.out.println("Earth");
    }
    public static void main(String[] args){
        Earth earth = new Earth();
//        Planet planet = (Planet)earth; 注意不能用这种方法强转
//        planet.A();
//        planet.B();
    }
}
