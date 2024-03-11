import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    private static List<Integer> numbersWithSumOf13;
    private static List<Integer> numbersWithoutSumOf13;

    @BeforeAll
    static void setup() {
        numbersWithSumOf13 = Arrays.asList(1, 5, 6, 9, 10, 2, 11, 3, 22, 8, 15, 5);
        numbersWithoutSumOf13 = Arrays.asList(1, 5, 10, 20, 11, 4);

    }
    @Test
    void shouldReturnPairsOfNumbersWithSum13(){
        var actual = new Task2().getPairsOfNumbersWithSum13(numbersWithSumOf13).size();
        assertEquals(4, actual);
    }

    @Test
    void shouldNotReturnPairsOfNumbersWithSum13(){
        var actual = new Task2().getPairsOfNumbersWithSum13(numbersWithoutSumOf13).size();
        assertNotEquals(3, actual);
    }

}