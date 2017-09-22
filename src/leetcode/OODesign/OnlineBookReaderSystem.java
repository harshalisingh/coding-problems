package leetcode.OODesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class BookCatalog {
	private static Set<Book> books;

	public static void addBook(long ISBN, String author, String title, int number_pages,
			ArrayList<String> content, List<Integer> chapterIndex) {
		books.add(new Book(ISBN, author,title,number_pages, content,chapterIndex));
	}

	public void update() {
	}

	public static void delete(Book b) {
		books.remove(b);
	}

	public static Book find(long id) {
		for (Book b : books)
			if (b.getISBN() == id)
				return b;
		return null;
	}
}

class UserDirectory {
	private static Set<User> users;

	public Book searchLibrary(long id) {
		return BookCatalog.find(id);
	}



	public static User find(long ID) {
		for (User u : users) {
			if (u.getID() == ID)
				return u;
		}
		return null;
	}

	public static void addUser(long ID, String details, 
			int accountType) {
		users.add(new User(ID, details, accountType));
	}
}

class Book {
	private final long ISBN;
	private final String author;
	private final String title;
	private final int number_pages;
	private final List<String> content;
	private final List<Integer> chapterIndex;

	private List<Integer> bookmarks;

	public Book(long ISBN, String author, String title, int number_pages,
			ArrayList<String> content, List<Integer> chapterIndex) {
		super();
		this.ISBN = ISBN;
		this.author = author;
		this.title = title;
		this.number_pages = number_pages;
		this.content = content;
		this.chapterIndex = chapterIndex;
	}

	public void addBookMark(int pageNumber) {
		bookmarks.add(pageNumber);
	}

	public List<Integer> getBookmarks() {
		return bookmarks;
	}

	public String getPage(int pageNumber) {
		return content.get(pageNumber);
	}

	public long getISBN() {
		return ISBN;
	}
}

class User {
	private long ID;
	private String details;
	private int accountType;

	public User(long ID, String details, int accountType){
		this.ID = ID;
		this.details = details;
		this.accountType = accountType;
	}

	public long getID() {
		return ID;
	}

	public void renewMembership() {
	}
}

public class OnlineBookReaderSystem {
	private BookCatalog b;
	private UserDirectory u;

	public OnlineBookReaderSystem(BookCatalog b, UserDirectory u) {
	}

	public void listenRequest() {
	}

	public Book searchBook(long ID) {
		return BookCatalog.find(ID);
	}

	public User searchUser(long ID) {
		return UserDirectory.find(ID);
	}

	public void display() {
	}
}
