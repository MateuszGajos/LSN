import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {

    UserInputService userInputService = new ConsoleUserInputService();

    public static void main(String[] args) {
        new Task3().run();
    }

    public void run() {
        System.out.println("Task3, enter number of vertices:");
        var listOfVertices = userInputService.getGivenVertices();

        System.out.println(getNumberOfGraphs(listOfVertices).size());
    }

    protected List<List<Integer>>  getNumberOfGraphs(List<Vertex> listOfVertices) {
        if(listOfVertices.size() == 0) {
            throw new InvalidInputException("No vertices given");
        }
        List<List<Integer>> graphs = listOfVertices.stream().map(Vertex::getValuesAsList).collect(Collectors.toList());
        for (int i = 0; i < graphs.size() - 1; i++) {
            for (int j = i + 1; j < graphs.size(); j++) {
                if (graphs.get(i).contains(graphs.get(j).get(0))) {
                    graphs.get(i).add(graphs.get(j).get(1));
                    graphs.remove(j);
                    i--;
                    break;
                } else if (graphs.get(i).contains(graphs.get(j).get(1))) {
                    graphs.get(i).add(graphs.get(j).get(0));
                    graphs.remove(j);
                    i--;
                    break;
                }
            }
        }
        return graphs;
    }
}