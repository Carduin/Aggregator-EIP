import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Aggregator aggregator = new Aggregator();

        try {
            File salesFile = new File("sales.txt");
            Scanner reader = new Scanner(salesFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                Sale sale = new Sale(data);
                aggregator.handleData(sale);
            }
            aggregator.postProcess();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist.");
        }
    }
}
