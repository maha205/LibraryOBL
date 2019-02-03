package wep;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * 
 * Region
 *
 */
public class Browser extends Region {
	 
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
    
    /**
     * //apply the styles
     */
    public Browser() {
        
        getStyleClass().add("browser");
        // load the web page
        webEngine.load("http://www.google.com");
        //add the web view to the scene
        getChildren().add(browser);
 
    }
    /**
     * Create Spacer
     * @return
     */
    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
 
    /**
     * layout Children
     */
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }
 
    /**
     * compute Pref Width
     */
    @Override protected double computePrefWidth(double height) {
        return 750;
    }
 
    /**
     * compute Pre fHeight
     */
    @Override protected double computePrefHeight(double width) {
        return 500;
    }
}