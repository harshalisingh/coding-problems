package leetcode.Strings;

public class LongestCommonPrefix {

	public static void main(String[] args){
		String arr[] = {"geeksforgeeks", "geeks",
				"geek", "geezer"};
		int n = arr.length;
		//String ans = commonPrefixCharByChar (arr, n);
		//String ans = commonPrefixDivideAndConquer(arr, 0, n-1);
		String ans = commonPrefixBinarySearch(arr);
		System.out.println(ans);
	}

	// A Function that returns the longest common prefix
	// from the array of strings
	public static String commonPrefixCharByChar(String arr[], int n)
	{
		int minlen = findMinLength(arr, n);

		StringBuilder result = new StringBuilder(); // Our resultant string
		char current;  // The current character

		for (int i=0; i<minlen; i++)
		{
			// Current character (must be same
			// in all strings to be a part of
			// result)
			current = arr[0].charAt(i);

			for (int j=1 ; j<n; j++)
				if (arr[j].charAt(i) != current)
					return result.toString();

			// Append to result
			result.append(current);
		}

		return result.toString();
	}

	// A Function to find the string having the minimum
	// length and returns that length
	static int findMinLength(String arr[], int n)
	{
		int min = Integer.MAX_VALUE;

		for (int i=0; i<=n-1; i++)
			if (arr[i].length() < min)
				min = arr[i].length();
		return(min);
	}

	//=====================================================================

	// A Divide and Conquer based function to find the
	// longest common prefix. This is similar to the
	// merge sort technique
	static String commonPrefixDivideAndConquer(String arr[], int low, int high)
	{
		if (low == high)
			return (arr[low]);

		String result = "";
		if (high > low)
		{
			// Same as (low + high)/2, but avoids overflow for
			// large low and high
			int mid = low + (high - low) / 2;

			String str1 = commonPrefixDivideAndConquer(arr, low, mid);
			String str2 = commonPrefixDivideAndConquer(arr, mid+1, high);

			result = (commonPrefixUtil(str1, str2));
		}
		return result;
	}

	// A Utility Function to find the common prefix between
	// strings- str1 and str2
	static String commonPrefixUtil(String str1, String str2)
	{
		String result = "";
		int n1 = str1.length(), n2 = str2.length();

		for (int i=0, j=0; i<=n1-1&&j<=n2-1; i++,j++)
		{
			if (str1.charAt(i) != str2.charAt(j))
				break;
			result += str1.charAt(i);
		}
		return result;
	}

	//=================================================================

	// A Function that returns the longest common prefix
	// from the array of strings
	static String commonPrefixBinarySearch(String arr[])
	{
		int n = arr.length;
		int index = findMinLength(arr, n);
		StringBuilder prefix = new StringBuilder(); // Our resultant string
	
		// We will do an in-place binary search on the
		// first string of the array in the range 0 to
		// index
		int low = 0, high = index;

		while (low <= high)
		{
			// Same as (low + high)/2, but avoids overflow
			// for large low and high
			int mid = low + (high - low) / 2;

			if (allContainsPrefix (arr, n, arr[0], low, mid))
			{
				// If all the strings in the input array contains
				// this prefix then append this substring to
				// our answer
				prefix.append(arr[0].substring(low, mid-low+1));

				// And then go for the right part
				low = mid + 1;
			}

			else // Go for the left part
				high = mid - 1;
		}

		return (prefix).toString();
	}

	static boolean allContainsPrefix(String arr[], int n, String str,
			int start, int end)
	{
		for (int i=0; i<n; i++)
			for (int j=start; j<=end; j++)
				if (arr[i].charAt(j) != str.charAt(j))
					return false;
		return true;
	}
}
