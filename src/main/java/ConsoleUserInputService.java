import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleUserInputService implements UserInputService {
    private Scanner scanner = new Scanner(System.in); //System.in is a standard input stream

        public List<Integer> getNumbers() {
        System.out.print("Enter a string: ");
        var userInput = scanner.nextLine();

        try {
            return Arrays.stream(userInput.trim().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }

    public List<Vertex> getGivenVertices() throws InvalidInputException {
        List<Vertex> listOfVertices = new ArrayList<>();

        System.out.print("Enter the number of vertices: ");
        int n = validateAndReadNumberOfVertices(scanner);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter a 2 number string: ");
            Vertex vertex = validateAndReadVertex(scanner.nextLine());
            listOfVertices.add(vertex);
        }

        return listOfVertices;
    }

    private int validateAndReadNumberOfVertices(Scanner scanner) throws InvalidInputException {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }

    private Vertex validateAndReadVertex(String userInput) throws InvalidInputException {
        try {
            String[] values = userInput.trim().split("\\s+");
            if (values.length != 2) {
                throw new InvalidInputException();
            }

            return new Vertex(values[0], values[1]);
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }
}

