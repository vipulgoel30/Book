package AssignmentFour;

class BookIdNotFoundException extends Exception {
	BookIdNotFoundException(int bookId) {
		super("Book is not found with id " + bookId);
	}
}
 