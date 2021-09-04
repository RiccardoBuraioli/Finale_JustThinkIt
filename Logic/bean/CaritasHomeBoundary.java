package bean;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.CaritasHomeController;
import exception.MyIOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CaritasHomeBoundary {

	private int idCar;
	
	
	private static Logger logger = LoggerFactory.getLogger(CaritasHomeBoundary.class.getName());


	private CaritasHomeController caritasHomeController;


	@FXML
	private Button deleteAccountButton;

	@FXML
	private Button vBacheca;

	@FXML
	private Font x1;

	@FXML
	private Button eventiC;

	@FXML
	private Button turni;

	
	@FXML
	private Button logoutButton;

	@FXML
	private ImageView arrowRight;

	@FXML
	private ImageView arrowLeft;

	@FXML
	private Text nomeCognome;
	
    @FXML
    private Button openMappa;

	@FXML
	private ImageView profileImage;

	@FXML
	private Button gestisciDona;
	
    @FXML
    private Button offerteProposte;



	public CaritasHomeBoundary() {
		 caritasHomeController = new CaritasHomeController();

	}
	

    @FXML
    void openMappa(ActionEvent event) {
    	TransizionePagine switchPage = new TransizionePagine();
    	switchPage.apriMappa(this.idCar, openMappa.getScene().getWindow());

    }

	@FXML
	void gestisciDonazioni(ActionEvent event) {
      caritasHomeController.apiriGestDonazioni(idCar, offerteProposte.getScene().getWindow());
		
	}

	@FXML
	void gestisciEventi(ActionEvent event) {
		caritasHomeController.apriGestEventi(idCar, offerteProposte.getScene().getWindow());
	}

	@FXML
	void gestisciTurni(ActionEvent event) {
		caritasHomeController.apriGestTurni(idCar, offerteProposte.getScene().getWindow());

	}

	@FXML 
	void visualizzaBacheca(ActionEvent event) {
	caritasHomeController.apriBacheca(idCar, offerteProposte.getScene().getWindow());
	}

	 @FXML
	    void deleteAccountButtonPressed(ActionEvent event) {
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Logout");
	    	alert.setHeaderText("Se cancelli il tuo account verrano cancellati anche le tue attività in corso e potresti ricevere delle sanzioni");
	    	alert.setContentText("Sei sicuro di voler cancellare il tuo account?");
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	    		CaritasHomeController controller = new CaritasHomeController();
	    		controller.deleteAccount(idCar);
	    		TransizionePagine pageSwitch = new TransizionePagine();
	    		pageSwitch.backToLogin(deleteAccountButton.getScene().getWindow());
	    	
	    	} 	
	    }


	    @FXML
	    void offerteProposte(ActionEvent event) {
	    	caritasHomeController.apriOfferte(idCar,offerteProposte.getScene().getWindow());
	    	
	    }


	@FXML
	void logoutButtonPressedCaritas(ActionEvent event) {
	 	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());
    	

	}

	public void initDataC(int id, String nome) {
		this.idCar = id;
		nomeCognome.setText(nome);
		final Circle clip = new Circle();
		clip.setCenterX(25);
		clip.setCenterY(58);
		clip.setRadius(200);
		profileImage.setClip(clip);
		

	}

}
