
public class CountPrime {
    /*
    initilize the first prime: 2, then do i = prime, prime * i set to true in an array called isPrime. int[n] for 0, but n is not counted
    i++ until the prime * i > n.
    then go to the next number in j = 2 .. n, if it is false, increase the cnter, do the same thing again.
    then return the cnter.
    corner case: if n <= 1 return 0;
    n is MAX, too many space consumed?
    for 1, it is not a prime and set to true in the first place.
    overflow :]~~~~!!!
    */
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] notPrime = new boolean[n];
        notPrime[0] = notPrime[1] = true;
        int cnt = 0;
        for(int i = 1; i < n; i++) {
            if(!notPrime[i]) {
                cnt++;
                if(i > Math.sqrt(n)) continue;
                for(int j = i; j * i < n; j++) {
                    notPrime[j * i] = true;
                }
            }
        }
        return cnt;
    }
}
