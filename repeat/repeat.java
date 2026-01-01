public class repeat{
    public static void main(String[] args) {
        int sum = 0;
        int max = 0;
        int list[] = {1,2,5,4,4,3};
        
        for(int i = 0; i < list.length; i++){
            sum += list[i];
            
            if(max < list[i]){
                max = list[i];
            }
        }
        System.out.println(max);
        System.out.println(sum);
    }
}