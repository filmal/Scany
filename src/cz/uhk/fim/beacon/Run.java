package cz.uhk.fim.beacon;

import cz.uhk.fim.beacon.dao.DataProvider;
import cz.uhk.fim.beacon.dao.FileDataProvider;
import cz.uhk.fim.beacon.data.Measurement;
import cz.uhk.fim.beacon.data.scan.WifiScan;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;






public class Run {


    public static void main(String[] args) {
        DataProvider dp = new FileDataProvider("f:/couchdump.json");
        List<Measurement> measurements = dp.getMeasurements();

        
        List<Measurement> measurementsFiltered = measurements.stream()
                .filter(m -> m.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE).equals("2016-03-07") // J3NP  100ms Tx 0dbm
                ).collect(Collectors.toList());
        
        
        //for (Measurement m : measurementsFiltered) {
        for (int i = 0; i < 5; i++) {    
            Measurement m = measurements.get(i);
            
            for (WifiScan w: m.getWifiScans()) {
                System.out.println("WIFI: id=" + w.getId() + ", freq=" + w.getFrequency() + ", sigstr" + w.getSignalStrength() +  ", ch=" + w.getChannel() + ", time=" + w.getTime() + ", ssid=" + w.getSsid());
            }
            
        }
        

    }
}
