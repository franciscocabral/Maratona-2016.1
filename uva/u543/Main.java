package u543;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static int MAX = 1000001;
    static ArrayList<Integer> prime = new ArrayList<Integer>();
    static boolean[] isPrime = new boolean[MAX];
    
    public static void precalc(){
        for(int i = 0; i <= 1000000; i++) isPrime[i] = true;
        isPrime[0] = false;
        isPrime[1] = false;    
        for(int i = 2; i <= 1000000; i++){
            if(isPrime[i]){
                prime.add(i);
                int j = 2;
                while(j*i <= 1000000){
                    isPrime[j*i] = false;
                    j++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        precalc();
        int n = s.nextInt();
        while(n != 0){
            for(int i = 0; i <= Math.sqrt(n)+1; i++){
                int primeI = prime.get(i);
                if(isPrime[n-primeI]){
                    sb.append(n).append(" = ").append(primeI).append(" + ").append(n-primeI).append("\n");
                    break;
                }
            }
            n = s.nextInt();
        }
        System.out.print(sb.toString());
    }
}
