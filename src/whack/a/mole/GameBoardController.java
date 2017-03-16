/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whack.a.mole;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 *
 * @author jibba_000
 */
public class GameBoardController implements Initializable {

    private int score = 0;
    Random ran = new Random();
    private ArrayList<Button> buttonList = new ArrayList<>();

    @FXML
    GridPane gridpane;

    @FXML
    private Label timeLabel, scoreLabel, highScoreLabel;
    
    @FXML
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @FXML
    private AnchorPane anchorPane;
    
    public void buttonArray() {
        buttonList.add(btn1);
        buttonList.add(btn2);
        buttonList.add(btn3);
        buttonList.add(btn4);
        buttonList.add(btn5);
        buttonList.add(btn6);
        buttonList.add(btn7);
        buttonList.add(btn8);
        buttonList.add(btn9);
    }

    public void randomPopUp() {
        int btnVisible = ran.nextInt(buttonList.size());
        int btnVisible1 = ran.nextInt(buttonList.size());
        int btnVisible2 = ran.nextInt(buttonList.size());
        System.out.println(btnVisible);
        System.out.println(btnVisible1);
        System.out.println(btnVisible2);

        buttonList.get(btnVisible).setVisible(true);
        buttonList.get(btnVisible1).setVisible(true);
        buttonList.get(btnVisible2).setVisible(true);

        for (int i = 0; i < buttonList.size(); i++) {
            if (btnVisible != i && btnVisible1 != i && btnVisible2 != i) {
                buttonList.get(i).setVisible(false);
            } else {
                buttonList.get(i).setVisible(true);
            }

        }

    }

    @FXML
    private void startGame(ActionEvent event) {
        System.out.println("Game started");
        
        randomPopUp();
        
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),ae -> randomPopUp()));
        timeline.setCycleCount(50);
        timeline.play();
        timeline.setOnFinished(new EventHandler<ActionEvent>(){
        
    
            public void handle(ActionEvent event) {
                System.out.println("Finished!");
                for (Button button : buttonList) {
                    button.setVisible(false);
                }
        }
        });}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonArray();
    }

}
