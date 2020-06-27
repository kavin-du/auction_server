package modules;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import item.Item;

/* 
* This class reads the given csv file and strore them as "Item"
*/

public class ReadFile {
	
	public static void readFile(ArrayList<Item> items) {
		try {
			boolean flag = false;
			Scanner scanner = new Scanner(Paths.get("./src/stocks.csv"));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (flag) { // skipping the first line of csv since it has details about the colomns, not real values
					String[] parts = line.split(",");

					String symbol = parts[0];
					String securityName = parts[1].split("-")[0];
					int availableLots = Integer.parseInt(parts[parts.length - 1]);

					Item item = new Item(symbol, securityName, availableLots); // creating new object 
					items.add(item); // add object to the list

				} else {
					flag = true; // invert flag, then read from 2nd line
				}

			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}

}
