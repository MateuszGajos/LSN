import java.util.Collections;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        new Task1().run();
    }

    private UserInputService userInputService = new ConsoleUserInputService();

    public void run() {
        System.out.println("Task 1");
        var listOfNumbers = userInputService.getNumbers();
        var sortedDistinctList = listOfNumbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(sortedDistinctList.stream().map(Object::toString).collect(Collectors.joining(" ")));
        System.out.println("count: " + listOfNumbers.size());
        System.out.println("distinct: " + sortedDistinctList.size());
        System.out.println("min: " + Collections.min(sortedDistinctList));
        System.out.println("max: " + Collections.max(sortedDistinctList));
    }
}
