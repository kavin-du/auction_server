package modules;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import item.Item;

public class ReadFile {
	
	public static void readFile(ArrayList<Item> items) {
		try {
			boolean flag = false;
			Scanner scanner = new Scanner(Paths.get("./src/stocks.csv"));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (flag) { // skipping the first line
					String[] parts = line.split(",");

					String symbol = parts[0];
					String securityName = parts[1];
					int price = Integer.parseInt(parts[parts.length - 1]);

					Item item = new Item(symbol, securityName, price);
					items.add(item);
//					System.out.println(item.toString());

				} else {
					flag = true;
				}

			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}

}
