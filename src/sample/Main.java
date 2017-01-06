package sample;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.util.Optional;


public class Main extends Application {
    @Override

    //LOOME MANGUVALJA ELEMENDID
    public void start(Stage primaryStage) throws Exception {

        StackPane stack = new StackPane();
        Scene scene = new Scene(stack, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lucky Roulette");
        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
        scene.getStylesheets().add((getClass().getResource("style.css")).toExternalForm());


        Button spin = new Button("SPIN!");
        stack.getChildren().add(spin);
        spin.setTranslateY(100);

        Circle circleR = new Circle(60);
        circleR.setFill(Color.RED);
        Circle circleG = new Circle(60);
        circleG.setFill(Color.GREEN);
        Circle circleB = new Circle(60);
        circleB.setFill(Color.BLACK);

        //TextField for NUMBER
        TextField field = new TextField("0");
        stack.getChildren().add(field);
        field.setTranslateY(-155);

        Label lb = new Label("Number  0 - 36: ");
        stack.getChildren().add(lb);
        lb.setTranslateY(-180);

        ChoiceBox cb1 = new ChoiceBox(FXCollections.observableArrayList
                (0, 1, 2, 5, 10, 20));
        ChoiceBox cb2 = new ChoiceBox(FXCollections.observableArrayList
                (0, 1, 2, 5, 10, 20));

        ChoiceBox cb3 = new ChoiceBox(FXCollections.observableArrayList
                (0, 1, 2, 5, 10, 20));
        cb1.getSelectionModel().select(0);
        cb2.getSelectionModel().select(0);
        cb3.getSelectionModel().select(0);

        stack.getChildren().add(cb1);
        cb1.setTranslateY(-120);
        cb1.setTooltip(new Tooltip("Choose your bet!"));

        //Radio1 for odd/even
        ToggleGroup g1 = new ToggleGroup();
        RadioButton r1 = new RadioButton("Odd ");
        RadioButton r2 = new RadioButton("Even");
        r1.setUserData('O');
        r2.setUserData('E');
        r1.setToggleGroup(g1);
        r2.setToggleGroup(g1);
        r1.setSelected(true);

        //Toggle for color
        ToggleGroup g2 = new ToggleGroup();
        ToggleButton btnRed = new ToggleButton("Red   ");
        ToggleButton btnBlack = new ToggleButton("Black");
        btnBlack.setStyle("-fx-font: 16 arial; -fx-base:#000000;");
        btnRed.setStyle("-fx-font: 16 arial; -fx-base: #ff0019;");
        btnBlack.setUserData('B');
        btnRed.setUserData('R');
        btnRed.setToggleGroup(g2);
        btnBlack.setToggleGroup(g2);
        btnBlack.setSelected(true);

        //LISAME ELEMENDID LAUALE
        stack.getChildren().addAll(btnRed, btnBlack, cb3);
        btnRed.setTranslateX(160);
        btnRed.setTranslateY(10);
        btnBlack.setTranslateX(160);
        btnBlack.setTranslateY(-30);
        cb3.setTranslateX(160);
        cb3.setTranslateY(50);

        stack.getChildren().addAll(r1, r2, cb2);
        r1.setTranslateX(-160);
        r2.setTranslateX(-160);
        r2.setTranslateY(-20);
        cb2.setTranslateX(-160);
        cb2.setTranslateY(35);

        final Text actiontarget = new Text();
        actiontarget.setId("actiontarget");
        actiontarget.setFont(new Font("Arial", 50));
        actiontarget.setFill(Color.WHITE);

        final Label myMoneyT = new Label("Your money: 100     ");

        stack.getChildren().add(myMoneyT);
        myMoneyT.setTranslateY(-240);
        myMoneyT.setTranslateX(140);

        final Text userMessage = new Text("Welcome to Lucky Casino!");
        userMessage.setTranslateY(150);
        stack.getChildren().add(userMessage);
        userMessage.setFill(Color.RED);
        userMessage.setFont(new Font("Arial", 20));

        Label copyrights = new Label("Dmitri Lukas © 2017");
        stack.getChildren().add(copyrights);
        copyrights.setTranslateY(240);
        copyrights.setTranslateX(130);

        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.ENTER) {
                spin.fire();
            }
        });


        //MANG KAIVITAB SIIN!
        spin.setOnAction(new EventHandler<ActionEvent>() {
            int money = 100;

            @Override

            public void handle(ActionEvent event) {

                //Eemaldame vanad ringid ja kirjad
                stack.getChildren().removeAll(circleB,circleG,circleR,actiontarget);

                userMessage.setText(" ");

                Teller teller = new Teller();
                Roulette rulet = new Roulette();

                //Saame väärtused ToggleButtonist ja konverteerume charidesse
                String userOddEven = g1.getSelectedToggle().getUserData().toString();
                String userColor = g2.getSelectedToggle().getUserData().toString();
                char userCharOE = userOddEven.charAt(0);
                char userCharColor = userColor.charAt(0);

                //Kontrollime kas sisetstatud number
                boolean isNumber = teller.kasNumber(field.getText());
                if (isNumber == false ) {
                    //kui ei ole number
                    userMessage.setText("See ei ole number, sisesta number!");
                } else {
                    //kui on number - kas on vahemikus 0- 36?
                    int userNumber = Integer.parseInt(field.getText());
                    if (userNumber < 0 | userNumber > 36) {
                        userMessage.setText("Number 0 - 36 palun!");
                    }
                    else {
                        //get values from choiceboxes
                        String userBetNum = cb1.getValue().toString();
                        String userBetOE = cb2.getValue().toString();
                        String userBetCol = cb3.getValue().toString();
                        //convert to integers
                        int ubn = Integer.parseInt(userBetNum);
                        int uboe = Integer.parseInt(userBetOE);
                        int ubc = Integer.parseInt(userBetCol);
                        int userBet = ubn + ubc + uboe;
                        System.out.println(userBet);


                        //Kui raha on otsas - algame uut mängu või lõpetame
                        if (money <= 0) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("GAME OVER");
                            alert.setHeaderText("Sorry, you lost all your money!");
                            alert.setContentText("Would you like to play again?");

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK) {
                                money = userBet + 100;
                            } else {
                                System.exit(0);
                            }
                        }

                        int luckyNumber = rulet.fortuneNum();
                        char luckyColor = rulet.fortuneCol(luckyNumber);

                        int userWin = teller.checkForWin(userNumber, luckyNumber, luckyColor, ubn, ubc, uboe, userCharColor, userCharOE);
                        System.out.println("UserWin = " + userWin);

                        if (userWin != 0) {
                            userMessage.setText("Your win: " + userWin);
                            money = money + userWin - userBet;
                            myMoneyT.setText("Your money: " + money);

                        } else if (userBet != 0) {
                            userMessage.setText("Sorry, you lost!");
                            money = money - userBet;
                            myMoneyT.setText("Your money: " + money);
                        }

                        if (luckyColor == 'R') {
                            stack.getChildren().add(circleR);
                        } else if (luckyColor == 'B') {
                            stack.getChildren().add(circleB);
                        } else {
                            stack.getChildren().add(circleG);
                        }
                        stack.getChildren().add(actiontarget);
                        actiontarget.setText("" + luckyNumber);
                    }
                }
            }
        });
    }
}