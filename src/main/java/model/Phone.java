package model;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.PhoneWindow.PhoneData;


public class Phone {
	
	Map <String,String> networkMap;
	Map <String,String> launchMap;
	Map <String,String> bodyMap;
	Map <String,String> displayMap;
	Map <String,String> platformMap;
	Map <String,String> memoryMap;
	Map <String,String> cameraMap;
	Map <String,String> soundMap;
	Map <String,String> commsMap;
	Map <String,String> featuresMap;
	Map <String,String> batteryMap;
	Map <String,String> miscMap;
	Map <String,String> testsMap;
	
	public Phone() {
		networkMap = new LinkedHashMap<String, String>();
		launchMap = new LinkedHashMap<String, String>();
		bodyMap = new LinkedHashMap<String, String>();
		displayMap = new LinkedHashMap<String, String>();
		platformMap = new LinkedHashMap<String, String>();
		memoryMap = new LinkedHashMap<String, String>();
		cameraMap = new LinkedHashMap<String, String>();
		soundMap = new LinkedHashMap<String, String>();
		commsMap = new LinkedHashMap<String, String>();
		featuresMap = new LinkedHashMap<String, String>();
		batteryMap = new LinkedHashMap<String, String>();
		miscMap = new LinkedHashMap<String, String>();
		testsMap = new LinkedHashMap<String, String>();
	}
			
	public void addSpecification(AppInfo.MapTypes type, String key, String value) {
		switch(type) {
		case NETWORK:
			networkMap.put(key, value);
			break;
		case LAUNCH:
			launchMap.put(key, value);
			break;
		case BODY:
			bodyMap.put(key, value);
			break;
		case DISPLAY:
			displayMap.put(key, value);
			break;
		case PLATFORM:
			platformMap.put(key, value);
			break;
		case MEMORY:
			memoryMap.put(key, value);
			break;
		case CAMERA:
			cameraMap.put(key, value);
			break;
		case SOUND:
			soundMap.put(key, value);
			break;
		case COMMS:
			commsMap.put(key, value);
			break;
		case FEATURES:
			featuresMap.put(key, value);
			break;
		case BETTERY:
			batteryMap.put(key, value);
			break;
		case MISC:
			miscMap.put(key, value);
			break;
		case TESTS:
			testsMap.put(key, value);
			break;
		default:
			System.err.println("map of given name doesnt exist");
			break;
			
		}
	}
		
		public Map<String, String> getSpecifiedMap(AppInfo.MapTypes type) {
			switch(type) {
			case NETWORK:
				return networkMap;
			case LAUNCH:
				return launchMap;
			case BODY:
				return bodyMap;
			case DISPLAY:
				return displayMap;
			case PLATFORM:
				return platformMap;
			case MEMORY:
				return memoryMap;
			case CAMERA:
				return cameraMap;
			case SOUND:
				return soundMap;
			case COMMS:
				return commsMap;
			case FEATURES:
				return featuresMap;
			case BETTERY:
				return batteryMap;
			case MISC:
				return miscMap;
			case TESTS:
				return testsMap;
			default:
				System.err.println("map of given name doesnt exist");
				return null;
				
			}
		
	}
	
	
//todo nalezy zaimplementowac metode do zwracania kazdej mapy w zaleznosci od PARAMETRU	
/*	ObservableList<PhoneData> convertAllMapsToObservable() {
		ObservableList<PhoneData> data = FXCollections.observableArrayList();
		
		for (Map.Entry<String,String> entry : networkMap.entrySet()) {
			  String key = entry.getKey();
			  String value = entry.getValue();
			  data.add(new PhoneData(key, value));
		}
		
		return data;
	}*/
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String temp = new String();
		
		for (Map.Entry<String,String> entry : networkMap.entrySet()) {
			  String key = entry.getKey();
			  String value = entry.getValue();
			  temp += key + " : " + value + " \n";
		}
		
		for (Map.Entry<String,String> entry : miscMap.entrySet()) {
			  String key = entry.getKey();
			  String value = entry.getValue();
			  temp += key + " : " + value + " \n";
		}
		
		for (Map.Entry<String,String> entry : batteryMap.entrySet()) {
			  String key = entry.getKey();
			  String value = entry.getValue();
			  temp += key + " : " + value + " \n";
		}
		
		
		return temp;
	}
	
}