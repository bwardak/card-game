package org.example.DeckOfCards;

public enum CardValuesInt {
    ACE("A", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10);

    private final String rank;
    private final int value;

    CardValuesInt(String rank, int value ) {
        this.rank = rank;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getRank() {
        return rank;
    }

    public static int matchValue(String value) {
        String cardRank = value.substring(0, value.length() - 1);
        for (CardValuesInt cardValueInt : CardValuesInt.values()){
            if (cardValueInt.getRank().equalsIgnoreCase(cardRank)){
                return cardValueInt.value;
            }
        }
        throw new IllegalArgumentException("Error");
    }
}
