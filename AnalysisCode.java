package testSimple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class SimpleCode {

	
	public static void main(String[] args) throws Exception {
		String strFilename = args[0];

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(strFilename))));
		CSVFormat csvFormat = CSVFormat.DEFAULT.withDelimiter(' ');
		CSVParser parser = csvFormat.parse(reader);
		Iterator<CSVRecord> csvIterate = parser.iterator();
		HashMap<String, Integer> hmap = new HashMap<>();
		while (csvIterate.hasNext()) {
			String strIp =csvIterate.next().get(0);
			Integer count = hmap.get(strIp);
			if (null==count) {
				hmap.put(strIp, 1);
			}else{
				hmap.put(strIp, count+1);
			}
		
		}
		int count =0;
		for (String map : hmap.keySet()) {
			if (hmap.get(map)>=50) {
				System.out.println(map+" ===============  "+hmap.get(map));
				
				count++;
			}
			
		}
		System.out.println(count);
	}
}
