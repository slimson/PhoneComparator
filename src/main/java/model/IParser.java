package model;

import java.util.Map;

public interface IParser {
	public Phone donwloadPhoneData(String url);
	public String downloadPhoneList(String modelStr);
	public Map <String, String> getListWithResults();
}
