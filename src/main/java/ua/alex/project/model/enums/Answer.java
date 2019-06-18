package ua.alex.project.model.enums;

import java.util.Random;

/**
 * Enum for Question`s answer variants;
 */
public enum Answer {
    A, B, C;

    public static Answer getRandomAnswer() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
