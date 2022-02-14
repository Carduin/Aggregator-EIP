import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aggregator {

    private Map<Integer, List<Sale>> aggregates;

    public Aggregator() {
        this.aggregates = new HashMap<>();
    }

    public void handleData(Sale sale) {
        Integer clientId = sale.getClientId();
        if(this.aggregates.containsKey(clientId)) {
            this.aggregates.get(clientId).add(sale);
        }
        else {
            List<Sale> sales = new ArrayList<>();
            sales.add(sale);
            this.aggregates.put(clientId, sales);
        }
    }

    public void postProcess() {
          try{
              FileWriter fileWriter = new FileWriter("result.txt");
              PrintWriter printWriter = new PrintWriter(fileWriter);

              for (Map.Entry<Integer, List<Sale>> aggregateElement : aggregates.entrySet()) {
                  Integer clientId = aggregateElement.getKey();
                  Integer totalOrders = aggregateElement.getValue().size();
                  double totalCharged = 0.0;
                  for(Sale sale: aggregateElement.getValue()) {
                      totalCharged = totalCharged + (sale.getPrice() * sale.getQuantity());
                  }

                  printWriter.printf("Client %d ordered %d items for a total of %f \n", clientId, totalOrders, totalCharged);
              }
              printWriter.close();
          } catch (IOException e) {
              System.out.println("Could not write result data to file.");
          }
    }
}
