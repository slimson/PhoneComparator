package model;

import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PhoneWindow {

	private Label label;
	private TableView<PhoneData> table = new TableView<PhoneData>();
    private ObservableList<PhoneData> tableContent = FXCollections.observableArrayList();
    
    private final String windowTitle = "Phone Data";
    private final int windowWidth = 620;
    private final int windowHeight = 500;
	
    public PhoneWindow(){
		
	}

	public PhoneWindow(Phone phone, String phoneName) {
		label = new Label(phoneName);
		label.setFont(new Font("Arial", 20));
		//test pobierania danych z telefonu
		addMapToObservableList(phone.getSpecifiedMap(AppInfo.MapTypes.NETWORK), AppInfo.MapTypes.NETWORK);
		addMapToObservableList(phone.getSpecifiedMap(AppInfo.MapTypes.LAUNCH), AppInfo.MapTypes.LAUNCH);
		addMapToObservableList(phone.getSpecifiedMap(AppInfo.MapTypes.BODY), AppInfo.MapTypes.BODY);
		addMapToObservableList(phone.getSpecifiedMap(AppInfo.MapTypes.DISPLAY), AppInfo.MapTypes.DISPLAY);
		addMapToObservableList(phone.getSpecifiedMap(AppInfo.MapTypes.MEMORY), AppInfo.MapTypes.MEMORY);
		addMapToObservableList(phone.getSpecifiedMap(AppInfo.MapTypes.MISC), AppInfo.MapTypes.MISC);
		
	}
	
	private void addMapToObservableList(Map <String, String> map, AppInfo.MapTypes type) {
		for (Map.Entry<String,String> entry : map.entrySet()) {
			  String key = entry.getKey();
			  String value = entry.getValue();
			  System.out.println("typem jest " + type.toString());
			  tableContent.add(new PhoneData(type.toString(), key, value));
		}	
	}
	  
    public void start(Phone phone) throws Exception {
       /*
        * to dziala
        *  Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/PhoneWindowView.fxml"));
    	Scene scene =  new Scene(root, 200 ,200);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
         
        Stage secondStage = new Stage();
        secondStage.setTitle("New Stage");
        secondStage.setScene(scene);
         
        secondStage.show();*/
    	
    	Stage stage = prepareStage(windowTitle, windowWidth, windowHeight);
    	Scene scene = new Scene(new Group());
    	
    	TableColumn groupColumn = createColumn("Group", "group", 70);
    	TableColumn prophertiesColumn = createColumn("Propherties", "proph", 100);
    	TableColumn valueColumn = createColumn("Value", "value", 400);
    	table.getColumns().addAll(groupColumn, prophertiesColumn, valueColumn);
    	
        table.setItems(tableContent);
        
        final VBox vbox = prepareVBox();
        
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show(); 

    }
    
    private Stage prepareStage(String title, int width, int height) {
    	Stage stage = new Stage();
    	stage.setTitle(title);
        stage.setWidth(width);
        stage.setHeight(height);
        return stage;
    }
    
    private TableColumn createColumn(String columnName, String variableFromPhoneData, int minWidth) {
    	TableColumn column = new TableColumn(columnName);
    	column.setMinWidth(minWidth);
    	column.setCellValueFactory(
                new PropertyValueFactory<PhoneData, String>(variableFromPhoneData));
        return column;
    }
    
    private VBox prepareVBox() {
    	VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        return vbox;
    }
     
    public class PhoneData {
    	SimpleStringProperty group;
		SimpleStringProperty proph;
		SimpleStringProperty value;
		
		public PhoneData(String group, String a, String b) {
			this.proph=new SimpleStringProperty(a);
			this.value=new SimpleStringProperty(b);
			this.group=new SimpleStringProperty(group);
		}
		  public String getProph() {
	          return proph.get();
	      }

	      public void setProph(String fName) {
	    	  proph.set(fName);
	      }

	      public String getValue() {
	          return value.get();
	      }

	      public void setValue(String fName) {
	    	  value.set(fName);
	      }
	      
	      public String getGroup() {
	          return group.get();
	      }

	      public void setGroup(String fName) {
	    	  group.set(fName);
	      }

	}
}   