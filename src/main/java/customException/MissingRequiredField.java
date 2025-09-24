package customException;

public class MissingRequiredField extends RuntimeException{
	private static final long serialVersionUID = -4649323861711525153L;

	public MissingRequiredField(String mess) {
		super(mess);
	}
}
