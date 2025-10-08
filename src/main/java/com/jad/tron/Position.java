package com.jad.tron;

import java.awt.*;

public class Position {
    private final Dimension dimension;
    private int x;
    private int y;

    public Position(final int x, final int y, final Dimension dimension) {
        this.dimension = dimension;
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return this.x;
    }

    private void setX(final int x) {
        this.x = x % this.dimension.width;
    }

    public int getY() {
        return this.y;
    }

    private void setY(final int y) {
        this.y = y % this.dimension.height;
    }

    public void move(Direction direction) {
        switch (direction) {
            case NORTH -> this.setY(this.y - 1);
            case SOUTH -> this.setY(this.y + 1);
            case EAST -> this.setX(this.x + 1);
            case WEST -> this.setX(this.x - 1);
        }
    }
}
