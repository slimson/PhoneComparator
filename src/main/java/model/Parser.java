package model;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser implements IParser{
	
	
	Document doc;
	Phone phone;
	Elements table;
	HashMap <String, String> searchingResults;
	
	public Parser() {
		phone = new Phone();
		searchingResults= new HashMap<String, String>();

	}
	
	public HashMap <String, String> getListWithResults() {
		return searchingResults;
	}
		
	public Phone donwloadPhoneData(String url) {
		
		setParserPage(url);
		for (AppInfo.MapTypes type : AppInfo.MapTypes.values()) {
			parseGivenSpecification(type);
		}
		return phone;
	}
	
	void setParserPage(String url) {
		try {
			doc = Jsoup.connect(url).get();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void parseGivenSpecification(AppInfo.MapTypes type) {
		
		try {
			table = getMainTableContent();
			Element tableContentOfChosenType = table.get(type.getValue());
			//System.out.println(type);
			Boolean rowIsFirst = true;
			for (Element row : tableContentOfChosenType.select("tr")) {
				if (rowIsFirst) {
					ParseDataToPhone(type, row.child(1), row.child(2));
					rowIsFirst = false;
				} else {
					ParseDataToPhone(type, row.child(0), row.child(1));
				}
			} 
		} catch (Exception e) {
			//brak specyfikacji na stronie
		}    
	}
	
	Elements getMainTableContent() {
		Elements ele = doc.select("div#specs-list");
        Elements table = ele.select("table");
        return table;
	}
	
	void ParseDataToPhone(AppInfo.MapTypes type, Element specification, Element value) {
		if(specification == null) {
			phone.addSpecification(type, "-", value.text());
		} else {
			phone.addSpecification(type, specification.text(), value.text());
		}
		
	}
	
	
	
	public String downloadPhoneList(String modelStr) {
		searchingResults.clear();
		String querryUrl = createQuerryUrl(modelStr);
				
		setParserPage(querryUrl);
		
		String resultInfo = getInformatonAbiutResult();
		
		if(resultInfo.contains("Your search returned")) {
			Elements ele = doc.getElementsByClass("section-body");
			for( Element row : ele.select("li").select("a") ) {
	        	String model = row.select("strong").select("span").text();
	        	String shortUrl = row.attr("href");
	        	String modelUrl = "http://www.gsmarena.com/" + shortUrl;
	        	
	        	searchingResults.put(model, modelUrl);
	        }
			return AppInfo.PHONES_FOUND;
		} else if(resultInfo.equals("No phones found!")) {
			return AppInfo.NO_PHONES_FOUND;
		} else {
			String model = modelStr;
			searchingResults.put(model,querryUrl);
			return AppInfo.PHONE_FOUND;	
        }
        
	}
	
	String createQuerryUrl(String modelStr) {
		String querryUrl = AppInfo.QUERRY_URL;
		
		String str = modelStr.replace(' ', '+');
		querryUrl += str;
		return querryUrl;
	}
	
	String getInformatonAbiutResult() {
		Elements e = doc.getElementsByClass("st-text");
		if ( e.isEmpty() ){
			return "";
		} else {
			return e.select("p").get(0).text();
		}	
	}
}
