import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
    private final int x;
    private final int y;

    public Vertex(String xStr, String yStr) {
        try {
            this.x = Integer.parseInt(xStr);
            this.y = Integer.parseInt(yStr);

            if (this.x <= 0 || this.y <= 0) {
                throw new InvalidInputException("Values of x and y must be positive integers");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("NaN");
        }
    }

    public List<Integer> getValuesAsList(){
        return new ArrayList<>(Arrays.asList(x, y));
    }
}
