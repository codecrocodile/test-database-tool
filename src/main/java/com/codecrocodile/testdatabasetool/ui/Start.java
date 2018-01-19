package com.codecrocodile.testdatabasetool.ui;

import javafx.animation.FadeTransition;
import javafx.animation.FadeTransitionBuilder;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by Chris on 19/01/2018.
 */
public class Start extends Application {

    private Scene scene;

    private BorderPane root;

    private NavigationManager navigationManager;

    private NavigationBar navigationBar;


    /**
     * Starts the application.
     *
     * @param args
     * 		Program arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /*
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Test Database Tool");
        Image ico = new Image("images/appbar.database.png");
        primaryStage.getIcons().add(ico);
        primaryStage.setWidth(1025);
        primaryStage.setHeight(800);

        root = new BorderPane();

        navigationBar = new NavigationBar();
        navigationManager = new NavigationManager(this);
        navigationManager.addObserver(navigationBar);
        navigationBar.setNavigationManager(navigationManager);

        root.setTop(navigationBar.createView());

        scene = new Scene(root);
        scene.getStylesheets().add("/application-stylesheet.css");
        primaryStage.setScene(scene);

        navigationManager.requestPageChange("HomePage", NavigationManager.HistoryAction.NONE, false);

        primaryStage.show();
    }

    public void setView(Node node, boolean showTransiton) {
        root.setCenter(node);

        if (showTransiton) {
            FadeTransition fadeTransition = FadeTransitionBuilder.create()
                    .duration(Duration.seconds(1))
                    .node(node)
                    .fromValue(0)
                    .toValue(1)
                    .build();
            fadeTransition.play();
        }
    }

}
