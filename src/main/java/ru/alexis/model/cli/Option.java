package ru.alexis.model.cli;

public enum Option {

    OUTPUT_PATH("-o"),

    PREFIX("-p"),

    APPEND_MODE("-a"),

    SHORT_STATS("-s"),

    FULL_STATS("-f");

    private final String name;

    Option(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Option fromString(String str) {
        for (Option option : Option.values()) {
            if (option.getName().equals(str)) {
                return option;
            }
        }
        return null;
    }

}
