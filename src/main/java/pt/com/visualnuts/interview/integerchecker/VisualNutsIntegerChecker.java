package pt.com.visualnuts.interview.integerchecker;

import java.util.LinkedList;
import java.util.List;

public class VisualNutsIntegerChecker {

    private final int length;
    private final List<String> result = new LinkedList<>();

    public VisualNutsIntegerChecker(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Please insert a positive integer length. Only values after 0 will be printed.");
        }
        this.length = length;
    }

    private boolean nutsCheck(int i) {
        if (i % 5 == 0) {
            result.add("Nuts");
            return true;
        }
        return false;
    }

    private boolean visualCheck(int i) {
        if (i % 3 == 0) {
            result.add("Visual");
            return true;
        }
        return false;
    }

    private boolean visualNutsCheck(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            result.add("Visual Nuts");
            return true;
        }
        return false;
    }

    public List<String> checkValues() {
        for (int i = 1; i <= length; i++) {
            if (visualNutsCheck(i)) continue;

            if (visualCheck(i)) continue;

            if (nutsCheck(i)) continue;

            result.add(String.valueOf(i));
        }

        return result;
    }
}
