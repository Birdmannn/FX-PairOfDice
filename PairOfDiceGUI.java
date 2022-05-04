package com.example.pairofdicegui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PairOfDiceGUI extends Application {

    private GraphicsContext g;

    public void start(Stage stage) {
        Canvas canvas = new Canvas(100, 100);
        g = canvas.getGraphicsContext2D();
        draw(g);
        PairOfDice dice = new PairOfDice(6,6);
        drawDie(g, dice.getFirstDieValue(), 10, 10);
        drawDie(g, dice.getSecondDieValue(), 55, 55);
        canvas.setOnMouseClicked(e -> {
            dice.roll();
            drawDie(g, dice.getFirstDieValue(), 10, 10);
            drawDie(g, dice.getSecondDieValue(), 55, 55);

        });

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }
    public void draw(GraphicsContext g) {
        g.setFill(Color.rgb(222,105,241, 0.7));
        g.fillRect(0,0,100,100);
        g.setStroke(Color.rgb(126,7, 164));
        g.setLineWidth(3);
        g.strokeRect(0,0,100,100);

    }

    public void drawDie(GraphicsContext g, int val, int x, int y) {
        g.setFill(Color.WHITE);
        g.fillRect(x,y,35,35);
        g.setFill(Color.BLACK);
        g.setLineWidth(2);
        g.strokeRect(x,y,35,35);
        int count = 0;

        switch (val) {
            case 1:
                g.setFill(Color.RED);
                g.fillOval(x+9,y+9,17,17);
                break;
            case 2:
                g.fillOval(x+5, y+5,8,8);
                g.fillOval(x+(8*2)+5, y+(8*2)+5, 8, 8);
                break;
            case 3:
                for(int i = 1; i <= 3; i++) {
                    g.fillOval(x+(4*i)+count, y+(4*i)+count,6,6);
                    count += 6;
                }
                break;
            case 4:
                g.fillOval(x+5,y+5,8,8);
                g.fillOval(x+5,y+(8*2)+5,8,8);
                g.fillOval(x+(8*2)+5, y+5,8,8);
                g.fillOval(x+(8*2)+5,y+(8*2)+5,8,8);
                break;
            case 5:
                for(int i = 1; i <= 3; i++) {
                    g.fillOval(x+(4*i)+count,y+(4*i)+count,6,6);
                    count += 6;
                }
                g.fillOval(x+4,y+(4*3)+12,6,6);
                g.fillOval(x+(4*3)+12,y+4,6,6);
                break;
            case 6:
                for(int i = 1; i <= 3; i++) {
                    g.fillOval(x+4,y+(4*i)+count,6,6);
                    count += 6;
                }
                count = 0;
                for(int i = 1; i <= 3; i++) {
                    g.fillOval(x+(4*3)+12,y+(4*i)+count,6,6);
                    count += 6;
                }
                break;

        }
    }


    public static void main(String[] args) {
        launch();
    }




}