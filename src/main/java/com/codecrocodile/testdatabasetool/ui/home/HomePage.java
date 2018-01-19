package com.codecrocodile.testdatabasetool.ui.home;

import com.codecrocodile.testdatabasetool.ui.Page;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

/**
 * Created by Chris on 19/01/2018.
 */
@Component("HomePage")
public class HomePage extends Page {



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
