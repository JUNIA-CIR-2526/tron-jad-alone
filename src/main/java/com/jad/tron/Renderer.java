package com.jad.tron;

enum Renderer {
    ;

    static String render(final Grid grid) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < grid.getHeight(); row++) {
            for (int column = 0; column < grid.getWidth(); column++) {
                stringBuilder.append(grid.getSpriteAt(row, column).symbol());
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
