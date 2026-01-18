package ru.alexis.util;

public class CliUtils {

    private CliUtils() {
    }

    public static boolean isOption(String arg) {
        if (arg == null || arg.isEmpty()) {
            return false;
        }
        return arg.toLowerCase().startsWith("-");
    }

}
