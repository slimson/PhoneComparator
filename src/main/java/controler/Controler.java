package controler;


import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AppInfo;
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
	private TreeView treeView = new TreeView();
	
	//@FXML
	//private TableView<DataElo> table = new TableView<DataElo>();
	
	private Phone phone;
	
	private ObservableList<String> resultList = FXCollections.observableArrayList();
	//private ObservableList<DataElo> dane = FXCollections.observableArrayList();
	
	List<AppInfo.MapTypes> listOfParameters = new ArrayList<AppInfo.MapTypes>();
	
    CheckBoxTreeItem<String> item1;
    CheckBoxTreeItem<String> item2;
    CheckBoxTreeItem<String> item3;
    CheckBoxTreeItem<String> item4;
    CheckBoxTreeItem<String> item5;
    CheckBoxTreeItem<String> item6;
    CheckBoxTreeItem<String> item7;
    CheckBoxTreeItem<String> item8;
    CheckBoxTreeItem<String> item9;
    CheckBoxTreeItem<String> item10;
    CheckBoxTreeItem<String> item11;
    CheckBoxTreeItem<String> item12;
    CheckBoxTreeItem<String> item13;
    CheckBoxTreeItem<String> rootItem;

    
	public void initialize(URL location, ResourceBundle resources) {
		listView.setItems(resultList);
		
		rootItem = new CheckBoxTreeItem<String>("Parameters to display:");
	    rootItem.setExpanded(true);
	    treeView.setEditable(true);
	    
	    treeView.setCellFactory(CheckBoxTreeCell.<String>forTreeView());
	    
	    item1 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.NETWORK.toString());
	    item2 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.LAUNCH.toString());
	    item3 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.BODY.toString());
	    item4 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.DISPLAY.toString());
	    item5 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.PLATFORM.toString());
	    item6 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.MEMORY.toString());
	    item7 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.CAMERA.toString());
	    item8 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.SOUND.toString());
	    item9 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.COMMS.toString());
	    item10 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.FEATURES.toString());
	    item11 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.BETTERY.toString());
	    item12 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.MISC.toString());
	    item13 = new CheckBoxTreeItem<String>(AppInfo.MapTypes.TESTS.toString());

	    
        rootItem.getChildren().addAll(item1, item2, item3, item4, item5,
        		item6, item7, item8, item9, item10, item11, item12, item13);            

        rootItem.setSelected(true);
        treeView.setRoot(rootItem);
        treeView.setShowRoot(true);
	        
	}

/*	CheckBoxTreeItem<String> createChildrensFromParameters(AppInfo.MapTypes type) {
		CheckBoxTreeItem<String> rootItem = new CheckBoxTreeItem<String>("Parameters to display:");
		for(App)
		
	}*/
	List<AppInfo.MapTypes> createListFromChosenParameters() {
		List<AppInfo.MapTypes> lista = new ArrayList<AppInfo.MapTypes>();
		for(TreeItem item : rootItem.getChildren()) {
			if(((CheckBoxTreeItem)item).isSelected()){
	            System.out.println(item.getValue().toString() + " is selected");
	            lista.add(itemToMapType(item));
	        }
		}
		return lista;
	}
	
	AppInfo.MapTypes itemToMapType(TreeItem item ) {
		if(item.getValue().toString().equals(AppInfo.MapTypes.NETWORK.toString())) {
			return AppInfo.MapTypes.NETWORK;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.LAUNCH.toString())) {
			return AppInfo.MapTypes.LAUNCH;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.BODY.toString())) {
			return AppInfo.MapTypes.BODY;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.DISPLAY.toString())) {
			return AppInfo.MapTypes.DISPLAY;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.PLATFORM.toString())) {
			return AppInfo.MapTypes.PLATFORM;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.MEMORY.toString())) {
			return AppInfo.MapTypes.MEMORY;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.CAMERA.toString())) {
			return AppInfo.MapTypes.CAMERA;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.SOUND.toString())) {
			return AppInfo.MapTypes.SOUND;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.COMMS.toString())) {
			return AppInfo.MapTypes.COMMS;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.FEATURES.toString())) {
			return AppInfo.MapTypes.FEATURES;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.BETTERY.toString())) {
			return AppInfo.MapTypes.BETTERY;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.MISC.toString())) {
			return AppInfo.MapTypes.MISC;
		}
		if(item.getValue().toString().equals(AppInfo.MapTypes.TESTS.toString())) {
			return AppInfo.MapTypes.TESTS;
		} else {
			return null;
		}
		
	}
	
	@FXML
    private void openNewWindow(ActionEvent event) throws Exception {
		resultList.clear();
        System.out.println("nowe okno");
        Stage stage = new Stage();
        Phone phone = new Phone();
        //pw.start(phone);
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
		try {
			listOfParameters = createListFromChosenParameters();
			String s = listView.getSelectionModel().getSelectedItem().toString();
			String res = internetParser.getListWithResults().get(s);
			System.out.println("clicked on " + s + " : " + res );
			phone = internetParser.donwloadPhoneData(res);
			System.out.println(phone);
			pw = new PhoneWindow(phone, s, listOfParameters);
			pw.start(phone);
		} catch (Exception e) {
			System.out.println("click on row");
		}
	}
	
        
}





