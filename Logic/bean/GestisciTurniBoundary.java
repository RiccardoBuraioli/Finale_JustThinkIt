package bean;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.GestioneTurniCaritas;
import entity.TurnoTab;
import exception.MyException;
import exception.MyIOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GestisciTurniBoundary {

	Logger logger = LoggerFactory.getLogger(GestisciTurniBoundary.class.getName());
	
	
	@FXML
	private TextArea newNote;

	@FXML
	private TableView<TurnoTab> tab;

	@FXML
	private Button cancTurn;

	@FXML
	private Button modTurn;

	@FXML
	private Button creaTurn;

	@FXML
	private TableColumn<TurnoTab, String> giorno;

	@FXML
	private TableColumn<TurnoTab, String> orario;

	@FXML
	private TableColumn<TurnoTab, String> numParte;

	@FXML
	private TableColumn<TurnoTab, String> note;

	@FXML
	private Button richieste;

	@FXML
	private Button back;

	private TurnoTab turn;

	private int caritas;

	private GestioneTurniCaritas gestTurn;




	public GestisciTurniBoundary() {
		this.gestTurn = new GestioneTurniCaritas();
	}

	@FXML
	void cancellaTurno(ActionEvent event) {
		try {
			if(check()) {
				gestTurn.cancellaTurno(turn.getId());
			}
		} catch (MyException e) {
			logger.error(e.getMessage());
		}
	}

	@FXML
	void creaTurno(ActionEvent event) {
	 gestTurn.apriCreaTurno(caritas, creaTurn.getScene().getWindow());
		}
	

	@FXML
	public void modificaTurno(ActionEvent event) {
		try {
			if(check()) {
				gestTurn.modificaTurno(turn.getId(), newNote.getText(), turn.getIdCar());
			}
		} catch (MyException e) {
			logger.error(e.getMessage());
		}

	}

	@FXML
	void backPressed(ActionEvent event) {
		TransizionePagine pageSwitch = new TransizionePagine();
		pageSwitch.backToMenuCaritas(caritas, back.getScene().getWindow());
		
	}

	@FXML
	void turnSelected(MouseEvent event) {
		this.turn = tab.getSelectionModel().getSelectedItem();

	}

	public boolean check() throws MyException{
		if(this.turn == null) {
			throw new MyException("Devi selezionare una riga della taballa",MyException.CARITAS_ERROR);
	
		}
		if(newNote.getText() == null) {
			throw new MyException("Devi selezionare una riga della taballa",MyException.CAMPI_VUOTI);
	
		}
		return true;
	}

	public void loadFormBoundary(int id) {
		this.caritas = id;
		List<TurnoTab> listT = gestTurn.caricaTurni(id);

		ObservableList<TurnoTab> data = FXCollections.observableArrayList(listT);
		this.giorno.setCellValueFactory(new PropertyValueFactory<>("giorno"));
		this.orario.setCellValueFactory(new PropertyValueFactory<>("orario"));
		this.note.setCellValueFactory(new PropertyValueFactory<>("note"));
		this.numParte.setCellValueFactory(new PropertyValueFactory<>("partecipanti"));

		tab.setItems(data);

	}

}
