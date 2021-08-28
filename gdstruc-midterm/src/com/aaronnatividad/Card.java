package com.aaronnatividad;

import java.util.Objects;
import java.util.Random;

public class Card {
    private Random generatedId;
    private String name;

    // auto generated 3-digit card name 000 - 999
    public Card(){
        generatedId = new Random();
        name = "Card #%03d".formatted(generatedId.nextInt(1000));
    }

    // custom card name
    public Card(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Card{" +
                "generatedId=" + generatedId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(generatedId, card.generatedId) && Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generatedId, name);
    }
}
