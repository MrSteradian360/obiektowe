package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App extends Application {

    GridPane gridPane = new GridPane();

    @Override
    public void start(Stage primaryStage) {

        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions;
        GrassField grassField = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 3)};
        IEngine engine;
        try {
            directions = new OptionsParser().parse(args);
            engine = new SimulationEngine(directions, grassField, positions);
            engine.run();
            System.out.println(grassField);
        }
        catch(IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

        //Label label = new Label("Zwierzak");
        //gridPane.setGridLinesVisible(true);
        //gridPane.add(label, 0, 0);
        System.out.println(grassField.getHeight());
        System.out.println(grassField.getMinHeight());
        int height = grassField.getHeight() - grassField.getMinHeight();
        int width = grassField.getWidth() - grassField.getMinWidth();

        for(int row = 0; row <= height; row++) {
            for (int column = 0; column-1 <= width; column++) {
                Label label = new Label();
                GridPane.setColumnIndex(label, grassField.getMinWidth()+column);
                GridPane.setRowIndex(label, grassField.getMinHeight()+row);
                //label.setId("label_" + column +'_'+ row);
                //label.setText("test");
                if(column==0 && row==0){
                    label.setText("y\\x");
                }
                else if(row==0){
                    label.setText(Integer.toString(grassField.getMinWidth()+column-1));
                }
                else if(column==0){
                    label.setText(Integer.toString(grassField.getHeight()-row));
                }
                else {
                    if(grassField.objectAt(new Vector2d(grassField.getMinWidth()+column-1,grassField.getHeight()-row)) != null){
                        label.setText(grassField.objectAt(new Vector2d(grassField.getMinWidth()+column-1,grassField.getHeight()-row)).toString());
                    }
                }

                //gridPane.getColumnConstraints().add(new ColumnConstraints(50));
                GridPane.setHalignment(label, HPos.CENTER);
                gridPane.getChildren().add(label);
            }


        }
        gridPane.getRowConstraints().clear();
        gridPane.getColumnConstraints().clear();
        for (int i =grassField.getMinHeight(); i <= height; i++) gridPane.getColumnConstraints().add(new ColumnConstraints(20));
        for (int i =grassField.getMinWidth(); i <= width; i++) gridPane.getRowConstraints().add(new RowConstraints(20));

        //gridPane.getRowConstraints().addAll(new RowConstraints(50));



        gridPane.setGridLinesVisible(true);
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void addLabel(String labelname, int columnIndex, int rowIndex) {
        Label label = new Label();
        GridPane.setColumnIndex(label, columnIndex);
        GridPane.setRowIndex(label, rowIndex);
        label.setId(labelname + columnIndex);
        label.setText("test");
        gridPane.getChildren().add(label);
    }
}
