package top.genitalbean.itj.commons.exception;

public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 2345632345L;
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException() {}
}
