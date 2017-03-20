/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whack.a.mole;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author jibba_000
 */
public class WhackAMole extends Application {
    
    @Override
    public void start(Stage primarystage) throws Exception {
        Parent anchor = FXMLLoader.load(getClass().getResource("GameBoard.fxml"));
        
        anchor.setVisible(true);
        
        Scene scene = new Scene(anchor);
//        Image image = new Image("hammer.png");  
//        ImageCursor cursor = new ImageCursor(image);
//        scene.setCursor(cursor);
        scene.getStylesheets().add(WhackAMole.class.getResource("GameBoard.css").toExternalForm());
        
        primarystage.setScene(scene);
        primarystage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
