package leetcode.DP;

public class EditDistance {
    /**
     * Uses bottom up DP to find the edit distance
     * min of(top,left,diagonal), top refers to inserting a[i], left refers to deleting a[i] and diagonal refers to replacing a[i]. 
     * Time Complexity: O(mn)
     * Auxiliary Space: O(mn)
     */
    public int dynamicEditDistance(char[] str1, char[] str2){
        int temp[][] = new int[str1.length+1][str2.length+1];
        
        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i;
        }
        
        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
        }
        
        for(int i=1;i <=str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    temp[i][j] = temp[i-1][j-1];
                }else{
                    temp[i][j] = 1 + min(temp[i-1][j-1], //replace
                    					 temp[i-1][j], 	//insert
                    					 temp[i][j-1]); //delete
                }
            }
        }
        return temp[str1.length][str2.length];    
    }
    
    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    
    public static void main(String args[]){
        String str1 = "sunday";
        String str2 = "saturday";
        EditDistance editDistance = new EditDistance();
        int result = editDistance.dynamicEditDistance(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
    }


}
