
public class GasStation {
    /*
    i will just try from each one that gas[i] >= cost[i], stop when gas[i] - cost[i] + gas[i + 1] < 0.
    n^2
    inner loop i = 0 .. len, index wrap around the array. 
    when i reached len and diff >= 0 then break and return the j
    
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for(int j = 0; j < len; j++) {
            if(gas[j] >= cost[j]) {
                int tank = 0;
                int i = 0;
                while(i < len) {
                    tank += gas[(j + i) % len] - cost[(j + i) % len];
                    if(tank < 0) break;
                    i++;
                }
                if(i == len) return j;
            }
        }
        return -1;
    }
    
    /*
    optimized base on the last solution:
    
    tank: 5  (+2) 7 (-8) -1 (at this point break). if start at +2, it will 2   (-8) stop too.
    tank: 5  (-2) 3 (-4) -1 stop. cannot even start from -2.
    start point will make everything in between larger since it must start with positive value.
    so if at some point does not work, jump the length to the next avalible point, rather than j += 1.
    
    */
    public int canCompleteCircuitOptimized(int[] gas, int[] cost) {
        int len = gas.length, i = 0;
        for(int j = 0; j < len; j += i + 1) {
        	// reset the i here, if gas < cost, it will jump to the next index of i.
            i = 0;
            if(gas[j] >= cost[j]) {
                int tank = 0;
                while(i < len) {
                    tank += gas[(j + i) % len] - cost[(j + i) % len];
                    if(tank < 0) break;
                    i++;
                }
                if(i == len) return j;
            }
        }
        return -1;
    }
}
