import java.util.*;
/* 
public class InterfaceB {
    public static void main (String[]args) {
    Scanner sc = new Scanner(System.in);
    String GR = sc.next();
    Greeting greeting;
    if(GR.equals("morning")){
        greeting = new MorningGreeting();
    } else {
        greeting = new EveningGreeting();
    }
    greeting.sayHello();
    }
}
 
interface  Greeting {  
    void sayHello();
}

class MorningGreeting implements Greeting{
    public void sayHello(){
    System.out.println("おはようございます");
    }
}
class EveningGreeting implements Greeting{
    public void sayHello(){
    System.out.println("こんばんは");
    }
}
    */

public class InterfaceB{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String gr = sc.next();

        Greeting g = GreetingFactory.create(gr);
        g.sayHello();
    }
}
class GreetingFactory{
    public static Greeting create(String type){

    if(type.equals("morning")){
        return new MorningGreeting();
    } else {
        return new EveningGreeting();
    }
    //String result = sayHello(type);
    //System.out.println(result);
    } 
}

interface Greeting{
    void sayHello();
}

class MorningGreeting implements Greeting{
    public void sayHello(){
    System.out.println("おはようございます");
    }
}
class EveningGreeting implements Greeting{
    public void sayHello(){
    System.out.println("こんばんは");
}
}