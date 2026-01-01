import java.util.*;

public class jankenm {
    public static void main(String[] args) {
        System.out.println("0:グー 1:チョキ 2:パー");//そのまま出力する。説明みたいな
        
        Scanner sc = new Scanner(System.in);
        int me = sc.nextInt();
        int cpu = cpuHand();


        System.out.println("わたし" + handName(me));
        System.out.println("あなた" + handName(cpu));

        System.out.println("結果"+ judge(me, cpu));
       
    }

        static int cpuHand(){
            return (int)(Math.random() * 3); 
        }


        static String judge (int me, int cpu) {
            if(me == cpu)
                return "あいこ";
                
            if(me == 0 && cpu == 1) return "かち";
            if(me == 1 && cpu == 2) return "かち";
            if(me == 2 && cpu == 0) return "かち";
            
            return "まけ";
            }
        static String handName(int hand) {
            if(hand == 0) return "グー";
            if(hand == 1) return "チョキ";
            if(hand == 2) return "パー";
            return "不正な値";
        }
}