package cz.uhk.fim.beacon.data.scan;

import cz.uhk.fim.beacon.data.general.TransmitterSignal;

/**
 * Created by Kriz on 16. 11. 2015.
 * Edited by filmal on 6. 6. 2016.
 */
public class WifiScan implements TransmitterSignal {
    String mac;
    double rssi;
    String ssid;
    int time; // ms;
    int frequency;
    int channel;
 

    public void setMac(String mac) {
		this.mac = mac;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getId() {
        return "WIFI:"+mac.toLowerCase();
    }

    public double getSignalStrength() {
        return rssi;
    }

    @Override
    public void setSignalStrength(double signalStrength) {
        this.rssi = signalStrength;
    }

    public int getTime() {
        return time;
    }

    public String getSsid() {
        return ssid;
    }

    @Override
    public void setTime(int time) {
        this.time = time;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getChannel() {
        return channel;
    }
    
    
}
