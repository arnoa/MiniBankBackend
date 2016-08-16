package eu.arr.minipoco.exception;

public class InsufficientFundsOnAccountException extends ClientException{
	private static final long serialVersionUID = 7950538327133757154L;

	public InsufficientFundsOnAccountException(String message) {
		super(message);
	}
}
