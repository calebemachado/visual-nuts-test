package pt.com.visualnuts.interview.integerchecker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VisualNutsIntegerCheckerTest {

    @Test
    void checkerConstructedWithXItemsShouldReturnListWithXLength() {
        int length = 500;
        var checker = new VisualNutsIntegerChecker(length);
        assertEquals(length, checker.checkValues().size());
    }

    @Test
    void checkerResultWith15ItemsShouldReturnCorrect() {
        var result = Arrays.asList("1", "2", "Visual", "4", "Nuts", "Visual", "7", "8", "Visual", "Nuts",
                "11", "Visual", "13", "14", "Visual Nuts"
        );

        var checker = new VisualNutsIntegerChecker(15);
        assertEquals(result, checker.checkValues());
    }

    @Test
    void checkerConstructedWithNegativeValueShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new VisualNutsIntegerChecker(-15));
    }

    @Test
    void shouldNotCountRepeatedLanguages() {
        assertThrows(IllegalArgumentException.class, () -> new VisualNutsIntegerChecker(-15));
    }
}