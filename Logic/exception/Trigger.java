package exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import beanweb.BachecaPersonaleBoundary;

public class Trigger {

	public void myTrigger() {
		
	}
	
	 public boolean isNumeric(String str) throws MyException, NumberFormatException { 
		  if (str.isEmpty()) {
				throw new MyException("Devi selezionare una riga della taballa",MyException.CAMPI_VUOTI);

		  }else{
			 if(Float.parseFloat(str)== 0) {	
					throw new MyException("Devi selezionare una riga della taballa",MyException.CAMPI_VUOTI);
}
		  }
		    return true;     
		}
	 
	 public boolean isNumerico(String str) throws MyException, NumberFormatException { 
		  if (str.isEmpty()) {
				throw new MyException("Devi selezionare una riga della taballa",MyException.CAMPI_VUOTI);
 
		  }else{
			 if(Float.parseFloat(str)== 0) {	
					throw new MyException("Devi selezionare una riga della taballa",MyException.CARITAS_ERROR);
}  
		  }
		    return true;     
		}
}
