package com.jad.tron;

import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class TronGame {
    private static final int GRID_WIDTH = 200;
    private static final int GRID_HEIGHT = 50;
    private final Grid grid;
    private final List<LightCycle> lightCycles;

    public TronGame() {
        Dimension dimension = new Dimension(TronGame.GRID_WIDTH, TronGame.GRID_HEIGHT);
        this.grid = new Grid(dimension);
        this.lightCycles = List.of(
                new LightCycle(5, 5, Direction.EAST, new Sprite('░'), this.grid),
                new LightCycle(10, 10, Direction.WEST, new Sprite('▒'), this.grid)
                                  );
    }

    public void play() {
        TextWindow textWindow = this.getTextWindow();
        boolean isRunning = true;

        while (isRunning) {
            if (textWindow.isOn("exit")) isRunning = false;
            if (textWindow.isOn("player1_left")) this.lightCycles.get(0).turnLeft();
            if (textWindow.isOn("player1_right")) this.lightCycles.get(0).turnRight();
            if (textWindow.isOn("player2_left")) this.lightCycles.get(1).turnLeft();
            if (textWindow.isOn("player2_right")) this.lightCycles.get(1).turnRight();
            for (LightCycle lightCycle : this.lightCycles) {
                lightCycle.move();
                if (lightCycle.isCrashed()) isRunning = false;
            }
            textWindow.display(Renderer.render(this.grid));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        textWindow.close();
    }

    private TextWindow getTextWindow() {
        TextWindowSettings settings = new TextWindowSettings();
        settings.addKeyboardListener(KeyEvent.VK_ESCAPE, "exit");
        settings.addKeyboardListener(KeyEvent.VK_Q, "player1_left");
        settings.addKeyboardListener(KeyEvent.VK_D, "player1_right");
        settings.addKeyboardListener(KeyEvent.VK_LEFT, "player2_left");
        settings.addKeyboardListener(KeyEvent.VK_RIGHT, "player2_right");
        settings.setScreenHeight(this.grid.getHeight());
        settings.setScreenWidth(this.grid.getWidth());
        TextWindow textWindow = new TextWindow(settings);
        textWindow.setVisible(true);
        return textWindow;
    }
}

