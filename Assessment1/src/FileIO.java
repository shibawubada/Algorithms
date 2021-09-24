import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner; // Import the Scanner class to read text files

public class FileIO {
	
	public int[] fileRead(String file) {

		String path = "data//"+file;
		
		Path filePath = Paths.get(path);
		Scanner scanner = null;
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		int lines = 0;
		try {
			while (reader.readLine() != null) lines++;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int[] array=new int[lines+1];
		
		try {
			scanner = new Scanner(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i=0;
		while (scanner.hasNext()) {
			i++;
		    if (scanner.hasNextInt()) {
		        array[i]=scanner.nextInt();
		    } else {
		        scanner.next();
		    }
		}
		return array;
	}	
}
