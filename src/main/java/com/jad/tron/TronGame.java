package com.jad.tron;

import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class TronGame {
    private final Grid grid;
    private final List<LightCycle> lightCycles;
    private boolean isRunning;

    public TronGame() {
        Dimension dimension = new Dimension(200, 50);
        this.grid = new Grid(dimension);
        this.lightCycles = List.of(
                new LightCycle(new Position(5, 5, dimension), Direction.EAST, new Sprite('░')),
                new LightCycle(new Position(10, 10, dimension), Direction.WEST, new Sprite('▒'))
                                  );
    }

    public void play() {
        TextWindowSettings settings = new TextWindowSettings();
        settings.addKeyboardListener(KeyEvent.VK_ESCAPE, "exit");
        settings.addKeyboardListener(KeyEvent.VK_Q, "player1_left");
        settings.setScreenHeight(this.grid.getHeight());
        settings.setScreenWidth(this.grid.getWidth());
        TextWindow textWindow = new TextWindow(settings);
        textWindow.setVisible(true);
        this.isRunning = true;

        while (this.isRunning) {
            if (textWindow.isOn("exit")) this.isRunning = false;
        }
        textWindow.close();
    }
}

