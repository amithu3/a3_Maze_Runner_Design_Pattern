package ca.mcmaster.se2aa4.mazerunner.utils;

public class PathFormatter {
    // Method to convert the path to its factorized format
    public static String getFactorizedPath(String path) {
        if (path.isEmpty()) return path;

        StringBuilder factorized = new StringBuilder();
        char prev = path.charAt(0);
        int count = 1;

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == prev) {
                count++;
            } else {
                if (count > 1) {
                    factorized.append(count);
                }
                factorized.append(prev);
                prev = path.charAt(i);
                count = 1;
            }
        }

        // Append the last segment
        if (count > 1) {
            factorized.append(count);
        }
        factorized.append(prev);

        return factorized.toString();
    }
}
