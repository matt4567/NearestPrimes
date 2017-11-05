import sun.font.CompositeGlyphMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by matthewmoore on 21/08/2017.
 */
public class NearestPrimes {

    public static void main(String[] args) {
        String answer = new NearestPrimes().nearestPrime(53532);
        System.out.println(answer);

    }

    private List<Integer> Seive(long number){
        int rootNumber = (int) Math.ceil(Math.sqrt(number));
        boolean[] primes  = new boolean[rootNumber];

        for (int i = 0; i<rootNumber; i ++){
            if (i > 0 && !primes[i]){
                int val = i + 1;
                val += val;
                while(val < rootNumber){
                    primes[val] = true;
                    val += (i + 1);
                }

            }
        }


        List<Integer> primeList = new ArrayList<>();
        for (int i = 0; i<rootNumber; i ++){
            if (!primes[i] && i != 0){
                primeList.add(i);
            }
        }

        return primeList;


    }

    private boolean prime(long n){
        if (n <= 1){
            return false;
        }
        int i = 2;
        while (i * i <= n){
            if (Seive(n).contains(i)){
                if (n%i == 0){
                    return false;
                }
            }
            i ++;
        }
        return true;
    }

    private long largerPrime(long n){
        while(!prime(n)){
            n++;
        }
        return n;
    }
    private long smallerPrime(long n){
        while(!prime(n)){
            n--;
        }
        return n;
    }

    private String nearestPrime(long n){
        if(prime(n)){
            return Long.toString(n) + " is a prime.";
        }
        long largerPrime = largerPrime(n);
        long smallerPrime = smallerPrime(n);

        String output = Long.toString(smallerPrime) + " < " + Long.toString(n) + " < " + Long.toString(largerPrime);

        return output;

    };

}
