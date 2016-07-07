package cz.uhk.fim.beacon.data;

import cz.uhk.fim.beacon.data.scan.BleScan;
import cz.uhk.fim.beacon.data.scan.CellScan;
import cz.uhk.fim.beacon.data.scan.WifiScan;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by Kriz on 16. 11. 2015.
 */
public class Measurement {
    List<BleScan> bleScans = new ArrayList<>();
    List<CellScan> cellScans = new ArrayList<>();
    List<WifiScan> wifiScans = new ArrayList<>();
    String id;
    int x;
    int y;
    String level;   // building and floor
    String manufacturer;
    String createdAt; // e.g. "2015-11-13 13:28:24"


    public LocalDateTime getDateTime() {
        // convert to ISO date-time format and parse
        return LocalDateTime.parse(createdAt.replace(' ','T'));
    }

    public String getDeviceManufacturer() {
        return manufacturer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<BleScan> getBleScans() {
        return bleScans;
    }

    public List<WifiScan> getWifiScans() {
        return wifiScans;
    }

    public List<CellScan> getCellScans() {
        return cellScans;
    }

    public void setBleScans(List<BleScan> bleScans) {
        this.bleScans = bleScans;
    }

    public void setWifiScans(List<WifiScan> wifiScans) {
        this.wifiScans = wifiScans;
    }

    public void setCellScans(List<CellScan> cellScans) {
        this.cellScans = cellScans;
    }

    public Position getPosition() {
        return new Position(x, y, level);
    }

    public void addScansFromAnotherMeasurement(Measurement m) {
        this.wifiScans.addAll(m.wifiScans);
        this.bleScans.addAll(m.bleScans);
        this.cellScans.addAll(m.cellScans);
    }

    public void setPosition(Position position) {
        this.x = (int)position.getX();
        this.y = (int)position.getY();
        this.level = position.getFloor();
    }

  
    
    /**
     * Parse Measurement from JSON string
     * @param String json
     * @return Measurement
     *
    public Measurement fromJson(String json) {
    	Measurement measurement = new Measurement();
    	try {	    	
	    	JsonObject jsonObject = (JsonObject) new JsonParser().parse(json);    	
	    	ArrayList<WifiScan> wifiRecords = new ArrayList<>();
	    	ArrayList<BleScan> bluetoothRecords = new ArrayList<>();
	    	
	    	if (jsonObject.get("wifiScans") != null) { // Current data format  		
		    	JsonArray jsonArray =(JsonArray) jsonObject.get("wifiScans");
		    	for (int i = 0; i < jsonArray.size(); i++) {
		    		JsonObject o = (JsonObject) jsonArray.get(i);
		    		WifiScan wifiScan = new WifiScan();
		    		wifiScan.setSsid(o.get("SSID").getAsString());
		    		wifiScan.setMac(o.get("MAC").getAsString());
		    		wifiScan.setSignalStrength(o.get("strength").getAsDouble());
		    		wifiScan.setTime(o.get("time").getAsInt());  		
		    		wifiRecords.add(wifiScan); 		
		    	}	    		    	
		    	jsonArray = (JsonArray) jsonObject.get("bleScans");
		    	for (int i = 0; i < jsonArray.size(); i++) {
		    		JsonObject o = (JsonObject) jsonArray.get(i);
		    		BleScan bleScan = new BleScan();
		    		bleScan.setSignalStrength(o.get("rssi").getAsDouble());
		    		bleScan.setAddress(o.get("address").getAsString());
		    		bleScan.setTime(o.get("time").getAsInt());
		    		bluetoothRecords.add(bleScan);
		    	}
	    	} else { // Own data format
		    	JsonArray jsonArray = (JsonArray) jsonObject.get("wirelessRecords");
		    	for (int i = 0; i < jsonArray.size(); i++) {
		    		JsonObject o = (JsonObject) jsonArray.get(i);
		    		WifiScan wifiScan = new WifiScan();
		    		wifiScan.setSsid(o.get("ssid").getAsString());
		    		wifiScan.setMac(o.get("bssid").getAsString());
		    		wifiScan.setSignalStrength(o.get("rssi").getAsDouble());
		    		wifiScan.setTime(o.get("time").getAsInt());  		
		    		wifiRecords.add(wifiScan); 		
		    	}	    	
		    	jsonArray = (JsonArray) jsonObject.get("bluetoothRecords");
		    	for (int i = 0; i < jsonArray.size(); i++) {
		    		JsonObject o = (JsonObject) jsonArray.get(i);
		    		BleScan bleScan = new BleScan();		    		
		    		bleScan.setAddress(o.get("bssid").getAsString());
		    		bleScan.setSignalStrength(o.get("rssi").getAsDouble());
		    		bleScan.setTime(o.get("time").getAsInt());
		    		bluetoothRecords.add(bleScan);
		    	}
	    	}    		    	
	    	measurement.bleScans = bluetoothRecords;
	    	measurement.wifiScans = wifiRecords;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return measurement; 
    }*/
}
