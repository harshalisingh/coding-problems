package leetcode.contest;

/**
 * https://leetcode.com/problems/lonely-pixel-i/#/description
 */
public class LonelyPixel {
	//O(nm) Time, O(n+m) Space 
	public int findLonelyPixel1(char[][] picture) {
		int n = picture.length, m = picture[0].length;

		int[] rowCount = new int[n], colCount = new int[m];
		for (int i=0;i<n;i++) 
			for (int j=0;j<m;j++) 
				if (picture[i][j] == 'B') { rowCount[i]++; colCount[j]++; }

		int count = 0;
		for (int i=0;i<n;i++) 
			for (int j=0;j<m;j++) 
				if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) count++;

		return count;
	}

	//O(nm) Time, O(m) Space 
	public int findLonelyPixel2(char[][] picture) {
		if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;

		int[] colCount = new int[picture[0].length];
		for (int i = 0; i < picture.length; i++) {
			for (int j = 0; j < picture[0].length; j++) {
				if (picture[i][j] == 'B') colCount[j]++;
			}
		}

		int count = 0;
		for (int i = 0; i < picture.length; i++) {
			int rowCount = 0, pos = 0;
			for (int j = 0; j < picture[0].length; j++) {
				if (picture[i][j] == 'B') {
					rowCount++;
					pos = j;
				}
			}
			if (rowCount == 1 && colCount[pos] == 1) count++;
		}
		return count;
	}

	//O(nm) Time, O(1) Space 
	public int findLonelyPixel3(char[][] picture) {
		int n = picture.length, m = picture[0].length;

		int firstRowCount = 0;
		for (int i=0;i<n;i++) 
			for (int j=0;j<m;j++) 
				if (picture[i][j] == 'B') {   
					if (picture[0][j] < 'Y' && picture[0][j] != 'V') picture[0][j]++;
					if (i == 0) firstRowCount++;
					else if (picture[i][0] < 'Y' && picture[i][0] != 'V') picture[i][0]++;
				}

		int count = 0;
		for (int i=0;i<n;i++) 
			for (int j=0;j<m;j++) 
				if (picture[i][j] < 'W' && (picture[0][j] == 'C' || picture[0][j] == 'X')) { 
					if (i == 0) count += firstRowCount == 1 ? 1 : 0;
					else if (picture[i][0] == 'C' || picture[i][0] == 'X') count++;
				}

		return count;
	}
}
