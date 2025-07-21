package AssignmentFour;

class Book {
	private int bookNo;
	private String title;
	private Author author;
	private float price;
	private String publisher;
	private String copyright;
	private static int bookCount;
	private static String copyrightContent;
	
	static {
		Book.bookCount = 0;
		Book.copyrightContent = "copyright.txt";
	}
	
	Book(int bookNo, String title, Author author, float price, String publisher, Boolean isCopyright){
		Book.validateTitle(title);
		Book.validatePrice(price);
		
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.copyright = isCopyright ? Book.copyrightContent : "Not available";
		Book.bookCount++;
	}
	
	public static int getBookCount() {
		return Book.bookCount;
	}
	
	public static void validateTitle(String title) throws InvalidBookTitleException {
		if(title.length() < 4) {
			throw new InvalidBookTitleException();
		}
	}
	
	public static void validatePrice(float price) throws InvalidBookPriceException {
		if(price < 1 || price > 5000) {
			throw new InvalidBookPriceException();
		}
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		Book.validateTitle(title);
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		Book.validatePrice(price);
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(Boolean isCopyright) {
		this.copyright = isCopyright ? Book.copyrightContent : "Not available";
	}

	
	@Override 
	public String toString() {
		return String.format("'%s' by %s (%c) at %s", this.title, this.author.getName(), this.author.getGender(), this.author.getEmail());
	}
}
