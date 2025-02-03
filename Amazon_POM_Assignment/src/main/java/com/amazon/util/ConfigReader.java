package com.amazon.util;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigReader {
    private static final Dotenv dotenv = Dotenv.load();

    public static String get(String key) {
        return dotenv.get(key);
    }
}
