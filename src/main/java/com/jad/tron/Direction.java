package com.jad.tron;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    Direction turnLeft() {
        final int valuesLength = Direction.values().length;
        return Direction.values()[((this.ordinal() - 1 + valuesLength) % valuesLength)];
    }

    Direction turnRight() {
        final int valuesLength = Direction.values().length;
        return Direction.values()[((this.ordinal() + 1) % valuesLength)];
    }
}
