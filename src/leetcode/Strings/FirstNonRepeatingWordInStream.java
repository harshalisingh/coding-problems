package leetcode.Strings;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

interface Stream {
    char getNext();
    boolean hasNext();
}
public class FirstNonRepeatingWordInStream {
	public static String firstWord(final Stream input) {
        char c; //current char of input stream
        StringBuilder sb = new StringBuilder();
        String word;
        Set<String> duplicate = new HashSet<String>(); //handle the case triple duplicate "the the the"
        Set<String> nonDuplicate = new LinkedHashSet<String>();
        

        while (input.hasNext()) {
            c = input.getNext();
            switch (c) {
                //The chars to specify the end of word are ' ' and '.'
                case ' ':
                case '.':
                    //NOTE: need to convert to lower case, else the
                    //      sample stream will return "The" instead of "dog"
                    word = sb.toString().toLowerCase();
                    if (nonDuplicate.contains(word)) {
                    	nonDuplicate.remove(word);
                        duplicate.add(word);
                    } else if (!duplicate.contains(word)) {
                    	nonDuplicate.add(word);
                    }

                    //Reset StringBuilder to accept the next word.
                    sb.setLength(0);
                    break;
                default:
                    sb.append(c);
            }
        }

        if (nonDuplicate.isEmpty()) {
            return "";
        } else {
            return nonDuplicate.iterator().next();
        }
    }
}
