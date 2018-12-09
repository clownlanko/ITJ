package top.genitalbean.itj.commons.exception;

public class DataAreadyExistsException extends ServiceException {
	private static final long serialVersionUID = -3648831624149585482L;

	public DataAreadyExistsException(String message){
        super(message);
    }
}
