package com.codecrocodile.testdatabasetool.ui.home;

import com.codecrocodile.testdatabasetool.settings.Settings;
import com.codecrocodile.testdatabasetool.ui.Page;
import com.codecrocodile.testdatabasetool.ui.settings.SettingsController;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Chris on 19/01/2018.
 */
@Component
public class HomePage extends Page {

    @Autowired
    private SettingsController settingsController;

    @Autowired
    private HomeController homeController;

    private ComboBox<Settings> settingsCbo;

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

        settingsCbo = new ComboBox<>();
        settingsCbo.setMinWidth(300);
        settingsCbo.setItems(settingsController.getSettingsList());
        settingsCbo.setOnAction(e -> homeController.setSelectedSettings(settingsCbo.getSelectionModel().getSelectedItem()));

        hBox.getChildren().addAll(settingsCbo);

        return hBox;
    }

}
