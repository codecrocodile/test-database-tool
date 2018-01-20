package com.codecrocodile.testdatabasetool.ui.settings;

import com.codecrocodile.testdatabasetool.ui.Page;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

/**
 * Created by Chris on 20/01/2018.
 */
@Component
public class SettingsPage extends Page {

    /*
     * @see com.codecrocodile.testdatabasetool.ui.Page#createView()
     */
    @Override
    protected Node createView() throws Exception {
        VBox pane = new VBox(10d);

        pane.getChildren().add(createSettingsPane());

        return pane;
    }

    private Node createSettingsPane() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15,12,15,12));
        hBox.setSpacing(10);

        return hBox;
    }

}
