package model;

public class AppInfo {
	
	public enum MapTypes {
		NETWORK(0),LAUNCH(1), BODY(2),DISPLAY(3),PLATFORM(4),MEMORY(5),CAMERA(6),SOUND(7),COMMS(8),
		FEATURES(9),BETTERY(10),MISC(11),TESTS(12);
		
		private final int value;
	    private MapTypes(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	
	final static public String QUERRY_URL = "http://www.gsmarena.com/results.php3?sQuickSearch=yes&sName=";
	final static public String PHONES_FOUND = "Phones Found";
	final static public String NO_PHONES_FOUND = "No Phones Found";
	final static public String PHONE_FOUND = "Correct Phone Found";
}
