package leetcode.Design;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SharedParagraph{
	int start,end;
}
class Book {
	List<SharedParagraph> list;
	int size(){
		return list.size();
	}
}

/*Assume that there is an e-book application. For every book the sharable part of the book content cannot exceed 10% of the whole book. 
 * Design a module to decide whether the current part of content is sharable. 
 * 
 * if there are two paragraphs of the book content with the exact same texts, as long as they are not in the same place, 
 * they would be considered different content. 
 * I then realized it’s a question about merging segments - have a helper to find each pair of start and end point of the input content 
 * (given multiple separated paragraphs). Then merge the intervals and see if they combined exceed 10% of the entire book. 
 */
public class ShrareableBookPart {
	public boolean validForSharing(List<SharedParagraph> sharedParagraphs, Book book) {

	    if(sharedParagraphs.isEmpty()) return true;

	    //sort sharedParagraphs
	    Collections.sort(sharedParagraphs, new Comparator<SharedParagraph>(){
	        public int compare(SharedParagraph i1, SharedParagraph i2){
	            if(i1.start!=i2.start)
	                return i1.start-i2.start;
	            else
	                return i1.end-i2.end;
	        }
	    });
	 
	    int totalShared = 0, start = 0, end = 0;

	    for(int i=0; i < sharedParagraphs.size(); i++){

	       SharedParagraph curr = sharedParagraphs.get(i);

	       if(curr.start >= end) {

	            totalShared += end - start;
	            start = curr.start;
	            end = curr.end;
	       } else {

	            end = Math.max(curr.end, end);
	       }
	    }
	    totalShared += end - start;
	 
	    return totalShared <= book.size() / 10;
	}
}
