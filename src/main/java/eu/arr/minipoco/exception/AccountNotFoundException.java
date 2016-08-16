package eu.arr.minipoco.exception;

public class AccountNotFoundException extends ClientException{
	private static final long serialVersionUID = -3398211280349392503L;
	
	public AccountNotFoundException(String string) {
		super(string);
	}
}
