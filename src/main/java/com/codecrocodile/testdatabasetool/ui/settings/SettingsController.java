package com.codecrocodile.testdatabasetool.ui.settings;

import com.codecrocodile.testdatabasetool.settings.Settings;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Component;

/**
 * Created by Chris on 20/01/2018.
 */
@Component
public class SettingsController {
    private ObservableList<Settings> settingsList;

    public ObservableList<Settings> getSettingsList() {
        return settingsList;
    }
}
