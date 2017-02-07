package controler;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Parser;
import model.Phone;
import model.PhoneWindow;

public class Controler implements Initializable{
	
	PhoneWindow pw = new PhoneWindow();
	Parser internetParser = new Parser();
	
	@FXML
	private Button button1 ;
	@FXML
	private TextField textField;
	@FXML
	private ListView listView = new ListView<String>();
	@FXML
	private TreeView treeView = new TreeView<String>();
	
	private ObservableList<String> resultList = FXCollections.observableArrayList();
	
	public void initialize(URL location, ResourceBundle resources) {
		listView.setItems(resultList);
		 /*CheckBoxTreeItem<String> root = new CheckBoxTreeItem<String>("Root");
		 
		 CheckBoxTreeItem<String> nodeA = new CheckBoxTreeItem<String>("A");
		 CheckBoxTreeItem<String> nodeB = new CheckBoxTreeItem<String>("B"); */
		
		CheckBoxTreeItem<String> root = new CheckBoxTreeItem<String>("Root");
		 
		CheckBoxTreeItem<String> nodeA = new CheckBoxTreeItem<String>("A");
		CheckBoxTreeItem<String> nodeB = new CheckBoxTreeItem<String>("B");
		 root.getChildren().addAll(nodeA,nodeB);
		 treeView.setRoot(root);
		 treeView.setShowRoot(false);
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
	
	@FXML public void handleMouseClick(MouseEvent arg0) {
	    System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
	}

	

        
}



