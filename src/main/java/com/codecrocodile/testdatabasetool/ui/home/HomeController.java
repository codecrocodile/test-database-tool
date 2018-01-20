package com.codecrocodile.testdatabasetool.ui.home;

import com.codecrocodile.testdatabasetool.settings.Settings;
import org.springframework.stereotype.Component;

/**
 * Created by Chris on 20/01/2018.
 */
@Component
public class HomeController {
    private Settings selectedSettings;

    public void setSelectedSettings(Settings selectedSettings) {
        this.selectedSettings = selectedSettings;
    }
}
