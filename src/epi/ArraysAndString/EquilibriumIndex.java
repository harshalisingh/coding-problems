package epi.ArraysAndString;

public class EquilibriumIndex {
	
	//Codility - Clean and Best
	int equi(int arr[], int n) {
	    if (n==0) return -1; 
	    long sum = 0;
	    int i; 
	    for(i=0;i<n;i++) sum+=(long) arr[i]; 

	    long sum_left = 0;    
	    for(i=0;i<n;i++) {
	        long sum_right = sum - sum_left - (long) arr[i];
	        if (sum_left == sum_right) return i;
	        sum_left += (long) arr[i];
	    } 
	    return -1; 
	} 
	
	int equilibrium(int arr[], int n) 
    {
        int i, j;
        int leftsum, rightsum;
 
        /* Check for indexes one by one until an equilibrium
           index is found */
        for (i = 0; i < n; ++i) 
        {
            leftsum = 0;  // initialize left sum for current index i
            rightsum = 0; // initialize right sum for current index i
 
            /* get left sum */
            for (j = 0; j < i; j++)
                leftsum += arr[j];
 
            /* get right sum */
            for (j = i + 1; j < n; j++)
                rightsum += arr[j];
 
            /* if leftsum and rightsum are same, then we are done */
            if (leftsum == rightsum)
                return i;
        }
 
        /* return -1 if no equilibrium index is found */
        return -1;
    }

}
