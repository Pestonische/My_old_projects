package additionalSystems;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderText {
    public String[] readFromFile() {
        String delimiters = "[^A-Za-z]";
        int counter = 0;
        ArrayList<String> list = new ArrayList<>();
        try {
            FileReader file = new FileReader("textForColor.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                counter++;
                String str = scanner.next();
                String[] words = str.split(delimiters);
                for (String word : words) {
                    if (word.equals("")) {
                        continue;
                    }
                    list.add(word.toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("------------------" + counter + "------------------");
        return list.toArray(new String[0]);
    }
}
