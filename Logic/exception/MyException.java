package exception;



public class MyException extends Exception {
	public static final  int EMAIL_ERROR = 400;
	public static final  int CARITAS_ERROR = 200;
	public static  final  int NEGOZIO_ERROR = 300;
	public static final  int VOLONTARIO_ERROR = 100;
	public static final  int CAMPI_VUOTI = 103; 
	public static final  int ORARIO = 105;
	public static final  int UTENTE_NON_REGISTRATO = 106;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorCode;

	public MyException() {
		errorCode=0;
	}
	
	
	public MyException (String message) {
		super(message);
	}
	
	public MyException (Throwable cause) {
		super(cause);
	}

	public MyException (String message, Throwable cause) {
		super(" +++ " + message + " +++ ", cause);
	}

	public void setErrorNumber(int i) {
		errorCode = i;
		
	}

	public int getErrorNumber() {
		return errorCode;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + " Code = " + errorCode;
	}
	
}
