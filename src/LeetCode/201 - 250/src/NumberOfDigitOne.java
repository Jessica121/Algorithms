
public class NumberOfDigitOne {
    /*
    best smart question ever :]
    really count for each digit, when it is 1, how much could it be.
    but it could get tricky in regards to how to calculate it.
    okay so take an example for 1310.
    so starts with the 
    LSD: 131[0], 0 < 1, how many when it is 1 ? only 0001 - 1301, if 1311 will out of bounds. so that is 131
    LSD: 13[1]0, 1 = 1, when it is 1, it has prev * zeros after. so (0 ~ 12) * 10 + after + 1. for every prev + 1, it has zeros after many ways, basic math. as regard to prev is 13, it has how many after it + 1. so it is 13 * 10 = 130 + 1
    basically it means: 00 -> 10, 01 -> 10, ... 12 -> 10 till 1219 (130) and 131*, it only can go no greater than 1310. so 1.
    LSD: 1[3]10: 3 > 1, it actually covers 1. so when it is 1, prev + 1 (0 ~ 1) * number of zeros after = 2 * 100 = 200
    LSD: [1]310: 1 == 1, same as before, before(0) * 1000 + 1*** (0 ~ 310) = 311
    so it has 773
    
    later can be calculated as we go: later += cur * 10 ^ i. after calculation is done.
    prev: n / 10.
    after the calculation, n /= 10;
    */
    public int countDigitOne(int n) {
        int cur = 0, res = 0, later = 0, prev = 0, i = 0;
        while(n > 0) {
            cur = n % 10;
            prev = n / 10;
            if(cur == 1) res += prev * Math.pow(10, i) + later + 1;
            else if(cur < 1) res += prev * Math.pow(10, i);
            else res += (prev + 1) * Math.pow(10, i);
            later += cur * Math.pow(10, i);
            i++;
            n /= 10;
        }
        return res;
    }
}
