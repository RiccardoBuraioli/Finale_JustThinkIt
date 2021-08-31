package exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import beanweb.BachecaPersonaleBoundary;

public class Trigger {

	public void myTrigger() {
		
	}
	
	 public boolean isNumeric(String str) throws MyException, NumberFormatException { 
		  if (str.isEmpty()) {
			  MyException e = new MyException("Alcuni campi sono vuoti",MyException.CAMPI_VUOTI);
			  throw e;  
		  }else{
			 if(Float.parseFloat(str)== 0) {	
			 MyException e = new MyException("Il numero inserito non è corretto",MyException.CAMPI_VUOTI);
			 throw e;}
		  }
		    return true;     
		}
	 
	 public boolean isNumerico(String str) throws MyException, NumberFormatException { 
		  if (str.isEmpty()) {
			  MyException e = new MyException("Inserisci correttamente l'id", MyException.CAMPI_VUOTI);
			  throw e;  
		  }else{
			 if(Float.parseFloat(str)== 0) {	
			MyException e = new MyException("Il numero inserito non è corretto",MyException.CARITAS_ERROR);
					 throw e;}  
		  }
		    return true;     
		}
}
