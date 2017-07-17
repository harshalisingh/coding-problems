package leetcode.contest;

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. 
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 */
class Relation{
	
}
public class FindCelebrity extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
        	// If candidate knows i, then switch candidate 
            if(knows(candidate, i))
                candidate = i;
        }
        //check whether candidate is real
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }

    //tells you whether A knows B
	private boolean knows(int a, int b) {
		// TODO Auto-generated method stub
		return false;
	}
}
