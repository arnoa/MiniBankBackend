package eu.arr.minipoco.exception;

public class ClientException extends Exception{
	private static final long serialVersionUID = -1122860546724212879L;
	
	public ClientException(String message) {
		super(message);
	}
}
