import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    private static List<Vertex> listOfVertices;

    @BeforeAll
    static void setup() {
        listOfVertices = new ArrayList<>();
        listOfVertices.add(new Vertex("1", "2"));
        listOfVertices.add(new Vertex("2", "3"));
        listOfVertices.add(new Vertex("6", "2"));
        listOfVertices.add(new Vertex("5", "1"));
        listOfVertices.add(new Vertex("7", "8"));
        listOfVertices.add(new Vertex("12", "11"));
        listOfVertices.add(new Vertex("11", "10"));

    }
    @Test
    void shouldReturnThreeGraphs(){
        var expected = new Task3().getNumberOfGraphs(listOfVertices).size();
        assertEquals(3, expected);
    }

    @Test void shouldThrowInvalidInputExceptionForEmptyList(){
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            new Task3().getNumberOfGraphs(List.of());
        });

        assertEquals("No vertices given", exception.getMessage());
    }
}