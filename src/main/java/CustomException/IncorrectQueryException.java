package CustomException;

public class IncorrectQueryException extends RuntimeException{
	private static final long serialVersionUID = 72441728679216163L;

	public IncorrectQueryException(String mess) {
		super(mess);
	}
}
