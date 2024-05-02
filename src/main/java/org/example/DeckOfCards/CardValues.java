package org.example.DeckOfCards;


public enum CardValues {
    ACE("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K");

    private final String value;

    CardValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CardValues fromValue(String value) {
        for (CardValues cardValue : CardValues.values()){
            if (cardValue.getValue().equals(value)){
                return cardValue;
            }
        }
        throw new IllegalArgumentException("Error");
    }
}
