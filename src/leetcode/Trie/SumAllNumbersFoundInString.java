package leetcode.Trie;

import java.util.Map;

public class SumAllNumbersFoundInString {
	public static void sumAllNumbers(String inputStr){
		
        int i=0, sum=0;
        String currString = "";
        
        inputStr =inputStr.replace("one", "1");
        inputStr =inputStr.replace("two", "2");
        inputStr =inputStr.replace("three", "3");
        inputStr =inputStr.replace("four", "4");
        inputStr =inputStr.replace("five", "5");
        inputStr =inputStr.replace("six", "6");
        inputStr =inputStr.replace("seven", "7");
        inputStr =inputStr.replace("eight", "8");
        inputStr =inputStr.replace("nine", "9");
        inputStr =inputStr.replace("zero", "0");
        inputStr =inputStr.replace("minus", "-");
        
        while(i<inputStr.length())
        {
            if(inputStr.charAt(i) >= '0' && inputStr.charAt(i) <= '9' || inputStr.charAt(i) == '-' )
            {
                currString = currString + inputStr.charAt(i);
                i++;
            }
            else
            {
                if(currString != "")
                {
                    sum = sum + Integer.parseInt(currString);
                    currString = "";
                }
                i++;
            }
       }
        
        if(currString != "")
            sum = sum + Integer.parseInt(currString);
        
         System.out.println(sum);
	}
	
	/*
	public int findSum(String s, TrieNode node, Map<String, String> dict)
	{
		StringBuilder sb = new StringBuilder();
		//int sum = 0;
		boolean negative = false;
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < s.length();i++)
		{
			char c = s.charAt(i);
			TrieNode child = node.getChild(c);
			if(child==null)
			{
				i = i - sb.length();
				sb = new StringBuilder();
				node = trie.root;
				res.append(" ");
				continue;
			}
			else 
			{
				sb.append(child.getVal());
				node = child;
				if(child.isWord())
				{
					if("minus".equals(sb.toString()))
						negative = true;
					else
					{
						String n = dict.get(sb.toString());
						if(negative)
							n = "-"+n;
						res.append(n);
						negative = false;
						node = trie.root;
						sb = new StringBuilder();
					}
				}
			}
		}
		
		String[] nums = res.toString().split("\\s+");

		int sum = 0;
		for(String n : nums)
		{
			if(!n.isEmpty())
				sum += Integer.parseInt(n);
		}
		return sum;
	}
	*/

	
	public static void main(String[] args){
		String inputStr = "xyzonexyztwothreeeabrminussevenskdjjtwozerodfs";
		sumAllNumbers(inputStr);
	}
}
