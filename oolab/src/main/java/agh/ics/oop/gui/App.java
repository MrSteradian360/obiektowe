package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App extends Application implements IPositionChangeObserver{
    GridPane gridPane = new GridPane();

    @Override
    public void start(Stage primaryStage)  {


        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions;
        GrassField grassField = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 3)};
        IEngine engine;



        try {
            directions = new OptionsParser().parse(args);
            engine = new SimulationEngine(directions, grassField, positions, this);
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

            for (int row = 0; row <= height; row++) {
                for (int column = 0; column - 1 <= width; column++) {
                    //label.setId("label_" + column +'_'+ row);
                    //label.setText("test");
                    if (column == 0 && row == 0) {
                        Label label = new Label();
                        GridPane.setColumnIndex(label, grassField.getMinWidth() + column);
                        GridPane.setRowIndex(label, grassField.getMinHeight() + row);
                        label.setText("y\\x");
                        GridPane.setHalignment(label, HPos.CENTER);
                        gridPane.getChildren().add(label);
                    } else if (row == 0) {
                        Label label = new Label();
                        GridPane.setColumnIndex(label, grassField.getMinWidth() + column);
                        GridPane.setRowIndex(label, grassField.getMinHeight() + row);
                        label.setText(Integer.toString(grassField.getMinWidth() + column - 1));
                        GridPane.setHalignment(label, HPos.CENTER);
                        gridPane.getChildren().add(label);
                    } else if (column == 0) {
                        Label label = new Label();
                        GridPane.setColumnIndex(label, grassField.getMinWidth() + column);
                        GridPane.setRowIndex(label, grassField.getMinHeight() + row);
                        label.setText(Integer.toString(grassField.getHeight() - row));
                        GridPane.setHalignment(label, HPos.CENTER);
                        gridPane.getChildren().add(label);
                    } else {
                        if (grassField.objectAt(new Vector2d(grassField.getMinWidth() + column - 1, grassField.getHeight() - row)) != null) {
                            IMapElement mapElement = (IMapElement) grassField.objectAt(new Vector2d(grassField.getMinWidth() + column - 1, grassField.getHeight() - row));
                            GuiElementBox guiElementBox = new GuiElementBox(mapElement, gridPane, grassField.getMinWidth() + column, grassField.getMinHeight() + row);
                            //label.setText(grassField.objectAt(new Vector2d(grassField.getMinWidth()+column-1,grassField.getHeight()-row)).toString());
                            //System.out.println(grassField.objectAt(new Vector2d(grassField.getMinWidth()+column-1,grassField.getHeight()-row)).toString());
                            //GridPane.setHalignment(guiElementBox, HPos.CENTER);
                            //gridPane.getChildren().add(guiElementBox);
                        } else {
                            GuiElementBox guiElementBox = new GuiElementBox(gridPane, grassField.getMinWidth() + column, grassField.getMinHeight() + row);
                            //label.setText(" ");
                            System.out.println("blank");
                            //GridPane.setHalignment(guiElementBox, HPos.CENTER);
                            //gridPane.getChildren().add(guiElementBox);
                        }
                    }

                    //gridPane.getColumnConstraints().add(new ColumnConstraints(50));

                }


            }
//        gridPane.getRowConstraints().clear();
//        gridPane.getColumnConstraints().clear();
//        for (int i =grassField.getMinHeight(); i <= height; i++) gridPane.getColumnConstraints().add(new ColumnConstraints(20));
//        for (int i =grassField.getMinWidth(); i <= width; i++) gridPane.getRowConstraints().add(new RowConstraints(20));

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


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        gridPane.getChildren().clear();

    }
}
