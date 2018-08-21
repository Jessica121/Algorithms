
public class FindCelebrity {
    /*
    people 0 is the candidate, it went thru 1 to n.
    if candidate does not know next, skip since it is not the celebrity.
    if it knows, then that one is the candidate since self cannot know anyone.
    after first pass run a second pass to check others know candidate or not. 
    and also check celebrity knows others or not. this is stupid
    if not return -1.
    else return candidate
    
    corner case: there is a cycle in knowing people. 1 <-> 2, 2 will be candidate, candidate also knows 1.
    i think this should be abstracted as a graph problem: 
    a celebrity is the node that only have incoming edges, not outgoing ones, in a directed graph. 
    so in this sense, using a topological sort, the last one left is the candidate. 
    then run thru if it has any outgoing edges and all other nodes have it as the child.
    but it could that does not have a node to start. 
    
    */
    public int findCelebrity(int n) {
        if(n <= 0) return -1;
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            if(knows(candidate, i)) candidate = i;
        }
        
        for(int i = 0; i < n; i++) {
        	// first i should not equal to candidate. else don't know the definition.
            if(i != candidate) {
            	// second others must all know him / her, and him / her cannot know any others.
                if(!knows(i, candidate) || knows(candidate, i)) return -1;
            }
        }
        return candidate;
    }
}
