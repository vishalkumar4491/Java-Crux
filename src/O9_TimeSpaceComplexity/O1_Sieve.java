package O9_TimeSpaceComplexity;

public class O1_Sieve {
    public static void main(String[] args) {
        int [] seive = new int[10001];
        seive[0] = 1;
        seive[1] = 1;
        for(int i = 2; i <= Math.sqrt(10000); i++){
            if(seive[i] == 0){
                for(int j = i * i; j <= 10000; j += i){
                    seive[j] = 1;
                }
            }
        }
        for(int i = 10; i <= 10000; i++){
            if(seive[i] == 0){
            System.out.print(i + " ");
        }}
    }
}
