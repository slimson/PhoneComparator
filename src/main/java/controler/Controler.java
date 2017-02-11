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
		
	@FXML
	private Button button1 ;
	@FXML
	private TextField textField;
	@FXML
	private ListView<String> listView = new ListView<String>();
	@FXML
	private TreeView treeView = new TreeView();
	
	private Parser internetParser = new Parser();
	private PhoneWindow pw;
	private Phone phone;
	
	private CheckBoxTreeItem<String> item1;
    private CheckBoxTreeItem<String> item2;
    private CheckBoxTreeItem<String> item3;
    private CheckBoxTreeItem<String> item4;
    private CheckBoxTreeItem<String> item5;
    private CheckBoxTreeItem<String> item6;
    private CheckBoxTreeItem<String> item7;
    private CheckBoxTreeItem<String> item8;
    private CheckBoxTreeItem<String> item9;
    private CheckBoxTreeItem<String> item10;
    private CheckBoxTreeItem<String> item11;
    private CheckBoxTreeItem<String> item12;
    private CheckBoxTreeItem<String> item13;
    private CheckBoxTreeItem<String> rootItem;
    
    private ObservableList<String> resultList = FXCollections.observableArrayList();
	private List<AppInfo.MapTypes> listOfParameters = new ArrayList<AppInfo.MapTypes>();
	

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

	@FXML
    public void search(ActionEvent event) throws Exception {
		resultList.clear();
        Stage stage = new Stage();
        Phone phone = new Phone();
		String content = textField.getText();
		String result = internetParser.downloadPhoneList(content);
		if(result.equals(AppInfo.PHONE_FOUND) || result.equals(AppInfo.PHONES_FOUND) ) {
			saveResultToObservable(internetParser.getListWithResults());
		} else {
			showMessageForNoResult();
		}				
    }
	
	
	private void saveResultToObservable(HashMap<String, String> results){
		for (Map.Entry<String, String> entry : results.entrySet())
		{
			resultList.add(entry.getKey());
		}
	}
	
	private void showMessageForNoResult() {
		resultList.add("NO PHONES FOUND");
	}
	
	@FXML 
	public void handleMouseClick(MouseEvent arg0) {
		try {
			listOfParameters = createListFromChosenParameters();
			String selectedRow = listView.getSelectionModel().getSelectedItem().toString();
			String res = internetParser.getListWithResults().get(selectedRow);
			if(!selectedRow.equals("NO PHONES FOUND")) {
				phone = internetParser.donwloadPhoneData(res);
				pw = new PhoneWindow(phone, selectedRow, listOfParameters);
				pw.start(phone);
			}
		} catch (Exception e) {
			System.out.println("click on row");
		}
	}
	
	private List<AppInfo.MapTypes> createListFromChosenParameters() {
		List<AppInfo.MapTypes> lista = new ArrayList<AppInfo.MapTypes>();
		for(TreeItem item : rootItem.getChildren()) {
			if(((CheckBoxTreeItem)item).isSelected()){
	            lista.add(itemToMapType(item));
	        }
		}
		return lista;
	}
	
	private AppInfo.MapTypes itemToMapType(TreeItem item ) {
		if(isItemSpecificType(item, AppInfo.MapTypes.NETWORK)) {
			return AppInfo.MapTypes.NETWORK;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.LAUNCH)) {
			return AppInfo.MapTypes.LAUNCH;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.BODY)) {
			return AppInfo.MapTypes.BODY;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.DISPLAY)) {
			return AppInfo.MapTypes.DISPLAY;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.PLATFORM)) {
			return AppInfo.MapTypes.PLATFORM;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.MEMORY)) {
			return AppInfo.MapTypes.MEMORY;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.CAMERA)) {
			return AppInfo.MapTypes.CAMERA;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.SOUND)) {
			return AppInfo.MapTypes.SOUND;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.COMMS)) {
			return AppInfo.MapTypes.COMMS;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.FEATURES)) {
			return AppInfo.MapTypes.FEATURES;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.BETTERY)) {
			return AppInfo.MapTypes.BETTERY;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.MISC)) {
			return AppInfo.MapTypes.MISC;
		}
		if(isItemSpecificType(item, AppInfo.MapTypes.TESTS)) {
			return AppInfo.MapTypes.TESTS;
		} else {
			return null;
		}	
	}
	
	private Boolean isItemSpecificType(TreeItem item, AppInfo.MapTypes type) {
		if(item.getValue().toString().equals(type.toString())) {
			return true;
		}
		return false;
	}        
}
