package extensions;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVUtils {	
	
	public static String GetDataFromCSV(String fileName, int line, int column) throws IOException, CsvException {
		try {
			CSVReader csvReader = new CSVReader(new FileReader(fileName));
			List<String[]> allData = csvReader.readAll();
			csvReader.close();
			String[] lineDatas = allData.get(line)[0].split(";");
			return lineDatas[column];
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
