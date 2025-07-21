package AssignmentFour;
import java.util.Scanner;

class BookDetails {
	public static Book initBook(Scanner scanner) {		
		System.out.print("Enter the book number : ");
		int number = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter the book title : ");
		String title = scanner.nextLine();
		Book.validateTitle(title);
		
		System.out.print("Enter the book author name : ");
		String authorName = scanner.nextLine();
		
		System.out.print("Enter the book author email : ");
		String authorEmail = scanner.nextLine();
		
		System.out.print("Enter the book author gender : ");
		char authorGender = scanner.next().charAt(0);
		scanner.nextLine();
		
		System.out.print("Enter the book price : ");
		float price = scanner.nextFloat();
		scanner.nextLine();
		Book.validatePrice(price);
		
		System.out.print("Enter the book publisher : ");
		String publisher = scanner.nextLine();
		
		System.out.print("Enter whether the book is copyright or not(true/false) : ");
		Boolean isCopyright = scanner.nextBoolean();
		scanner.nextLine();
		
		return new Book(number, title, new Author(authorName, authorEmail, authorGender), price, publisher, isCopyright);
	}
	
	static public int searchBookByNo(Book[] books, int searchNo) throws BookIdNotFoundException {
		for(int i = 0; i < books.length; i++) {
			if(books[i].getBookNo() == searchNo) {
				return i;
			}
		}
		
		throw new BookIdNotFoundException(searchNo);
	}
	
	static public void printBookDetails(Book book) {
		System.out.println("Number : " + book.getBookNo() + " Title : " + book.getTitle() + " Author Name : " + book.getAuthor().getName() + " Author Email : " + book.getAuthor().getEmail() + " Author Gender : " + book.getAuthor().getGender() + " Price : " + book.getPrice() + " Publisher :  " + book.getPublisher() + " Copyright : " + book.getCopyright());
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Initializing books array
		int bookCount = 1;
		Book[] books = new Book[bookCount];
		for(int i = 0; i < bookCount; i++) {
			System.out.println("Enter the details of book " + (i + 1) + " : ");
			books[i] = BookDetails.initBook(scanner);
		}
		
		
		// Printing all books
		System.out.println("All books : ");
		for(Book book : books) {
			System.out.println(book);
		}
		
		
		// Searching for book
		System.out.print("Enter the book number to search : ");
		int searchBookNo = scanner.nextInt();
		scanner.nextLine();
		
		try {
			int indexFound = BookDetails.searchBookByNo(books,searchBookNo);
			System.out.println("Book with number " + searchBookNo + " is found.");
			BookDetails.printBookDetails(books[indexFound]);
		}catch(BookIdNotFoundException exception) {
			System.err.println("Book with number " + searchBookNo + " is not found.");
		}
		
		
		
		// Testing engineering book class
		EngineeringBook engBook = new EngineeringBook(1, "ABCDE", new Author("Vipul Goel", "vipul@gmail.com" ,'M'), 100, "XYZ", true, "data");
		System.out.println("------------------------");
		System.out.println("Testing EngineeringBook class.");
		System.out.println("Book number : " + engBook.getBookNo());
		System.out.println("Book title : " + engBook.getTitle());
		System.out.println("Book author name : " + engBook.getAuthor().getName());
		System.out.println("Book author email : " + engBook.getAuthor().getEmail());
		System.out.println("Book author gender : " + engBook.getAuthor().getGender());
		System.out.println("Book price : " + engBook.getPrice());
		System.out.println("Book publisher : " + engBook.getPublisher());
		System.out.println("Book copyright : " + engBook.getCopyright());
		System.out.println("Book category : " + engBook.getCategory());
		
		scanner.close();

	}

}
