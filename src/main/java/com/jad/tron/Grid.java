package com.jad.tron;

import java.awt.*;

public class Grid {
    private final Dimension dimension;
    private final Sprite[][] sprites;

    public Grid(final Dimension dimension) {
        this.dimension = dimension;
        this.sprites = new Sprite[dimension.height][dimension.width];
        for (int row = 0; row < dimension.height; row++) {
            for (int column = 0; column < dimension.width; column++) {
                this.sprites[row][column] = Sprite.EMPTY;
            }
        }
    }

    public int getHeight() {
        return this.dimension.height;
    }

    public int getWidth() {
        return this.dimension.width;
    }

    public Dimension getDimension() {
        return this.dimension;
    }

    public void setSpriteAt(final Sprite sprite, final Position position) {
        this.sprites[position.getY()][position.getX()] = sprite;
    }

    public Sprite getSpriteAt(final int row, final int column) {
        return this.sprites[row][column];
    }
}
