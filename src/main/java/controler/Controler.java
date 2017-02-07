package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Phone;
import model.PhoneWindow;

public class Controler {
	
	PhoneWindow pw = new PhoneWindow();
	
	@FXML
	private Button button ;
	
	@FXML
    private void openNewWindow(ActionEvent event) throws Exception {
        System.out.println("nowe okno");
        Stage stage = new Stage();
        Phone phone = new Phone();
        pw.start(phone);
    }

        
}



