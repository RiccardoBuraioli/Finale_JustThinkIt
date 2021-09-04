package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.BachecaPersonaleBoundary;
import bean.CreaNecessitaBoundary;
import dao.BachecaDao;
import entity.Necessita;
import exception.MyIOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CreaNecessitaController {
	private BachecaDao creaBachecaDao;
	private Logger logger = LoggerFactory.getLogger(CreaNecessitaController.class.getName());

	private static CreaNecessitaController instance = null;
	private int idCaritas;
	
	public static CreaNecessitaController getInstace() {
		if(instance == null) {
			instance = new CreaNecessitaController ();
		}
		return instance;
		}
	
		
	public CreaNecessitaController() {
		creaBachecaDao = new BachecaDao();
		
	}
	
	public void apriBachecaPersonale(int idCar, Window stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Bacheca_Personale.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) stage;
			home.setScene(new Scene(root, 775, 500));
			home.show();

			BachecaPersonaleBoundary bacheca = loader.getController();
			bacheca.loadFormBoundary(idCaritas);

		} catch (Exception e) {
			logger.error(e.getMessage());
			MyIOException.openPageFault("Bacheca Personale");
		}
	}
	
	
	public boolean creaNecessita(String tipo, String urg, String desc) {
		
		Necessita necessita = new Necessita(tipo, desc, urg);
		return creaBachecaDao.creaNecessita(necessita, idCaritas);
		
	}
	
	
	
	public void inizializza(int codCar) {
		this.idCaritas = codCar;
	}
	
}
