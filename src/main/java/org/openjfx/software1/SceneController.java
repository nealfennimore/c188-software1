/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.software1;

import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 *
 * @author neal
 */
public class SceneController {
    private static HashMap<String, Pane> sceneMap = new HashMap<>();
    private static Scene main;

    /**
     * @param main the main to set
     */
    public static void setMain(Scene main) {
        SceneController.main = main;
    }

    protected static void addScene(String name, Pane pane){
        sceneMap.put(name, pane);
    }

    protected static void removeScene(String name){
        sceneMap.remove(name);
    }

    protected static void activate(String name){
        main.setRoot( sceneMap.get(name) );
    }
}
//
//screenController.add("calculator", FXMLLoader.load(getClass().getResource( "calculator.fxml" )));
//screenController.add("testSwitch", FXMLLoader.load(getClass().getResource( "TestSwitch.fxml" )));
//screenController.activate("calculator");