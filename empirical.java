import java.util.*;
public class empirical{
    
public void selectionSort(int[] list) {
    
    for (int i = 0; i < list.length - 1; i++) {
        
        int currentMin = list[i];
        int currentMinIndex = i;
        for (int j = i + 1; j < list.length; j++) {
            if (currentMin > list[j]) {
                currentMin = list[j];
                currentMinIndex = j;
                
                if (currentMinIndex != i) {
                    list[currentMinIndex] = list[i];
                    list[i] = currentMin;
                }
                
            }
        }
        
    }
}
    public static void main(String[] args){
        empirical e = new empirical();
        int N = Integer.parseInt(args[0]);
        int[] num = new int[N];
        int[] temp = new int[N];
        
        long sum = 0;
        Random r = new Random();
        for(int i =0; i<N;i++){
            num[i] = r.nextInt(Integer.MAX_VALUE);
            
        }
        for(int i =0; i < 10; i++)
        {
            System.arraycopy(num,0,temp,0,N);
            long start = System.nanoTime();
            Arrays.sort(temp);
            //e.selectionSort(temp);
            long stop = System.nanoTime();
            sum+= (stop-start);
        }
        System.out.println(sum/10.0);
    }

}