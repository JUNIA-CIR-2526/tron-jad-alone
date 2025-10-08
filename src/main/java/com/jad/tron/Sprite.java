package com.jad.tron;

public record Sprite(char symbol) {
    public final static Sprite EMPTY = new Sprite('.');
}
