import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    private UserInputService userInputService = new ConsoleUserInputService();
    private final Integer sum = 13;

    public static void main(String[] args) {
        new Task2().run();
    }

    public void run() {
        System.out.println("Task 2");
        var listOfNumbers = userInputService.getNumbers();
        var pairs = getPairsOfNumbersWithSum13(listOfNumbers);
        printPairs(pairs);
    }

    List<Pair> getPairsOfNumbersWithSum13(List<Integer> listOfNumbers) {
        var sortedList = listOfNumbers.stream().sorted().collect(Collectors.toList());
        var pairs = new ArrayList<Pair>();
        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = sortedList.size() - 1; j > i; j--) {
                if (sortedList.get(j) + sortedList.get(i) < sum) {
                    break;
                }
                if (sortedList.get(i) + sortedList.get(j) == sum) {
                    pairs.add(new Pair(sortedList.get(i), sortedList.get(j)));
                }
            }
        }
        return pairs;
    }

    private void printPairs(List<Pair> pairs) {
        for (Pair pair : pairs) {
            System.out.println(pair.x() + " " + pair.y());
        }
    }
}
