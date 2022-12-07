module oolab.main {
    requires javafx.graphics;
    requires javafx.controls;
    requires jdk.xml.dom;

    exports agh.ics.oop.gui;
    opens agh.ics.oop.gui to javafx.graphics;
}