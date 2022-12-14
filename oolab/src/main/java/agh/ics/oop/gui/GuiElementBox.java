package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GuiElementBox {
    public GuiElementBox(IMapElement mapElement, GridPane gridPane, int column, int  row)  {
//        Image image = new Image(new FileInputStream(mapElement.getElementPath()));
//        ImageView imageView = new ImageView(image);
//        imageView.setFitWidth(20);
//        imageView.setFitHeight(20);
//        Label label = new Label();
//        label.setText(mapElement.toString());
//        VBox verticalBox = new VBox(imageView, label);
//        verticalBox.setAlignment(Pos.CENTER);
        try{
        Image image = new Image(new FileInputStream(mapElement.getElementPath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Label label = new Label();
        label.setText(mapElement.toString());
        VBox verticalBox = new VBox(imageView, label);
        verticalBox.setAlignment(Pos.CENTER);

        GridPane.setColumnIndex(verticalBox, column);
        GridPane.setRowIndex(verticalBox, row);

        GridPane.setHalignment(verticalBox, HPos.CENTER);
        gridPane.getChildren().add(verticalBox);}
        catch (FileNotFoundException e){
            System.out.println("Pliku nie znaleziono!");
        }
    }

    public GuiElementBox(GridPane gridPane, int column, int row){
        ImageView imageView = new ImageView();
        imageView.setFitWidth(35);
        imageView.setFitHeight(35);
        VBox verticalBox = new VBox(imageView);
        verticalBox.setAlignment(Pos.CENTER);

        GridPane.setColumnIndex(verticalBox, column);
        GridPane.setRowIndex(verticalBox, row);

        GridPane.setHalignment(verticalBox, HPos.CENTER);
        gridPane.getChildren().add(verticalBox);
    }



}
