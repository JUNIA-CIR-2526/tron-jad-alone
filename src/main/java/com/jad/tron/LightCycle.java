package com.jad.tron;

public class LightCycle {
    private final Position position;
    private final Sprite sprite;
    private Direction direction;

    public LightCycle(final Position position, final Direction direction, final Sprite sprite) {
        this.position = position;
        this.direction = direction;
        this.sprite = sprite;
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
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }
}
