package controler;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Parser;
import model.Phone;
import model.PhoneWindow;

public class Controler implements Initializable{
	
	PhoneWindow pw;
	Parser internetParser = new Parser();
	
	@FXML
	private Button button1 ;
	@FXML
	private TextField textField;
	@FXML
	private ListView<String> listView = new ListView<String>();
	@FXML
	private TreeView treeView = new TreeView<String>();
	
	//@FXML
	//private TableView<DataElo> table = new TableView<DataElo>();
	
	private Phone phone;
	
	private ObservableList<String> resultList = FXCollections.observableArrayList();
	//private ObservableList<DataElo> dane = FXCollections.observableArrayList();
	
	
	public void initialize(URL location, ResourceBundle resources) {
		listView.setItems(resultList);
		/*dane.add(new DataElo("dupa", "kupa"));
	    TableColumn firstNameCol = new TableColumn("First Name");
	    TableColumn lastNameCol = new TableColumn("Last Name");
	    
	    firstNameCol.setCellValueFactory(
	    	    new PropertyValueFactory<DataElo,String>("a")
	    	);
	    lastNameCol.setCellValueFactory(
	    	    new PropertyValueFactory<DataElo,String>("b")
	    	);
	    	
	    table.setItems(dane);
	    table.getColumns().addAll(firstNameCol, lastNameCol);*/
	}

	@FXML
    private void openNewWindow(ActionEvent event) throws Exception {
		resultList.clear();
       /* System.out.println("nowe okno");
        Stage stage = new Stage();
        Phone phone = new Phone();
        pw.start(phone);*/
		String content = textField.getText();
		button1.setText("elo");
		//listView.getItems().add(content);
		System.out.println(internetParser.downloadPhoneList(content));
		saveResultToObservable(internetParser.getListWithResults());
    }
	
	
	private void saveResultToObservable(HashMap<String, String> results){
		for (Map.Entry<String, String> entry : results.entrySet())
		{
			resultList.add(entry.getKey());
		}
	}
	
	@FXML public void handleMouseClick(MouseEvent arg0) throws Exception {
		
		String s = listView.getSelectionModel().getSelectedItem().toString();
		String res = internetParser.getListWithResults().get(s);
	    System.out.println("clicked on " + s + " : " + res );
	    phone = internetParser.donwloadPhoneData(res);
	    System.out.println(phone);
	    pw = new PhoneWindow(phone, s);
        pw.start(phone);
	}
	
        
}





