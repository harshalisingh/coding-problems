package leetcode.contest;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Note:
 * The read function may be called multiple times.
 */
public class ReadNCharactersGivenRead4II {
	private int offSet = 0;
	private int remaining = 0;
	private boolean isEndOfFile = false;
	private char[] buffer = new char[4];

	/**
	 * @param buf Destination buffer
	 * @param n   Maximum number of characters to read
	 * @return    The number of characters read
	 * The key is to store memorized variable in the class level and remember offset position and remaining number of elements.
	 */
	public int read(char[] buf, int n) {
		int readBytes = 0;
		while (readBytes < n && (remaining != 0 || !isEndOfFile)) {
			int readSize = 0;
			if (remaining != 0) {
				readSize = remaining;
			} else {
				offSet = 0;
				readSize = read4(buffer);
				if (readSize != 4) {
					isEndOfFile = true;
				}
			}
			int length = Math.min(n - readBytes, readSize);
			for (int i= offSet; i<offSet + length; i++) {
				buf[readBytes++] = buffer[i];
			}
			remaining = readSize - length;
			if (remaining != 0) {
				offSet += length;
			}
		}
		return readBytes;
	}

	private int read4(char[] buffer2) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Solution {
	/* I used buffer pointer (buffPtr) and buffer Counter (buffCnt) to store the data received in previous calls. 
	 * In the while loop, if buffPtr reaches current buffCnt, it will be set as zero to be ready to read new data.
	 */
	private int buffPtr = 0;
	private int buffCnt = 0;
	private char[] buff = new char[4];
	public int read(char[] buf, int n) {
		int ptr = 0;
		while (ptr < n) {
			if (buffPtr == 0) {
				buffCnt = read4(buff);
			}
			while (ptr < n && buffPtr < buffCnt) {
				buf[ptr++] = buff[buffPtr++];
			}
			// all chars in buff used up, set pointer to 0
			if (buffPtr == buffCnt) buffPtr = 0;
			// read4 returns less than 4, end of file
			if (buffCnt < 4) break;
		}
		return ptr;
	}
	private int read4(char[] buff2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
