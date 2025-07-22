package AssignmentFour;

class InvalidBookPriceException extends RuntimeException {
	InvalidBookPriceException() {
		super("Price of the book must be in the range 1 to 5000");
	}
}
