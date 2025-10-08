package com.jad.tron;

public class LightCycle {
    private final Position position;
    private final Sprite sprite;
    private final Grid grid;
    private Direction direction;
    private boolean crashed = false;

    public LightCycle(final int x, final int y, final Direction direction, final Sprite sprite, final Grid grid) {
        this.position = new Position(x, y, grid.getDimension());
        this.direction = direction;
        this.sprite = sprite;
        this.grid = grid;
    }

    public boolean isCrashed() {
        return this.crashed;
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Position getPosition() {
        return this.position;
    }

    public void move() {
        this.position.move(this.direction);
        if (this.grid.getSpriteAt(this.position.getY(), this.position.getX()) != Sprite.EMPTY) {
            this.crashed = true;
        } else {
            this.grid.setSpriteAt(this.sprite, this.position);
        }
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }
}
