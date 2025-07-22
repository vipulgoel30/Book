package AssignmentFour;

class InvalidBookTitleException extends RuntimeException {
	 InvalidBookTitleException() {
		 super("Title of the book must have atleast 4 characters");
	}
}
