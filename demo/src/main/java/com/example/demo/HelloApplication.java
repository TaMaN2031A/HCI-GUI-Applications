package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import java.io.IOException;
import javafx.scene.paint.Color;



public class HelloApplication extends Application {

    public Rectangle manufacturer()
    {
        Rectangle rectangle1 = new Rectangle();

        rectangle1.heightProperty().set(300);
        rectangle1.widthProperty().set(440);
        rectangle1.setX(400);
        rectangle1.setY(100);

        rectangle1.setStroke(Color.RED);
        rectangle1.setFill(Color.GOLD);
        return rectangle1;
    }
    public Rectangle manufacturer2()
    {
        Rectangle rectangle2 = new Rectangle();

        rectangle2.heightProperty().set(50);
        rectangle2.widthProperty().set(50);
        rectangle2.setX(400);
        rectangle2.setY(100);

        rectangle2.setStroke(Color.RED);
        rectangle2.setFill(Color.GOLD);
        return rectangle2;
    }
    public void sendingToConsole(Stage primaryStage, BorderPane pane)
    {

        Scene scene = new Scene(pane, 1000, 700);
        scene.setFill(Color.NAVAJOWHITE);
        primaryStage.setTitle("Peace Be Upon You");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void second(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        Rectangle rectangle = manufacturer();
        Rectangle rectangle1 = manufacturer();
        Rectangle rectangle2 = manufacturer2();

        pane.setCenter(rectangle2);
        pane.setLeft(rectangle);
        pane.setRight(rectangle1);
        pane.setPadding(new Insets(200, 10, 10, 10));
        EventHandler changer = new EventHandler() {
            int x = 30;
            @Override
            public void handle(Event event) {
                rectangle1.widthProperty().set(rectangle1.getX()-x);
                rectangle.widthProperty().set(rectangle.getX()-x);
                x+=30;
            }
        };
        EventHandler changer2 = new EventHandler() {
            int x = 0, y = 0, z = 0, i = 0;
            @Override
            public void handle(Event event) {
                rectangle.setFill(Color.rgb(x,y,z));
                rectangle1.setFill(Color.rgb(x,y,z));
                if(i%3 == 0)
                    x=(x+40)%254;
                else if(i%3 == 1)
                    y=(y+50)%254;
                else
                    z=(z+60)%254;
                i++;
            }
        };
        rectangle2.setOnMouseClicked(changer);
        rectangle1.setOnMouseClicked(changer2);
        rectangle.setOnMouseClicked(changer2);

        sendingToConsole(primaryStage, pane);

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        second(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}
