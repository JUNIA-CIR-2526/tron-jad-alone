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

    public String render() {
        final StringBuilder builder = new StringBuilder();
        for (int row = 0; row < this.dimension.height; row++) {
            for (int column = 0; column < this.dimension.width; column++) {
                builder.append(this.sprites[row][column].symbol());
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    public int getHeight() {
        return this.dimension.height;
    }

    public int getWidth() {
        return this.dimension.width;
    }
}
