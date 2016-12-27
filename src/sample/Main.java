package sample;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stack = new StackPane();
        Scene scene = new Scene(stack, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lucky Roulette");
        primaryStage.getIcons().add(new Image("icon.png"));
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
        field.maxWidth(50);
        field.setTranslateY(-150);

        Label lb = new Label("Number  0 - 36: ");
        stack.getChildren().add(lb);
        lb.setTranslateY(-170);

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
        RadioButton r3 = new RadioButton("Def");
        r1.setUserData('O');
        r2.setUserData('E');

        r1.setToggleGroup(g1);
        r2.setToggleGroup(g1);
        r1.setSelected(true);
        /* r3.setUserData('D');     Сделать чтоб по умолчанию не было выбора и ошибка не выбивалась
        stack.getChildren().add(r3);
        r3.setVisible(false);*/


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

        final Text myMoneyT = new Text();
        stack.getChildren().add(myMoneyT);
        stack.setAlignment(myMoneyT, Pos.TOP_RIGHT);

        final Text userMessage = new Text("Welcome to Lucky Casino!");
        userMessage.setTranslateY(200);
        stack.getChildren().add(userMessage);
        userMessage.setFill(Color.RED);
        userMessage.setFont(new Font("Arial", 20));

        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.ENTER) {
                spin.fire();
            }
        });


        //GAME STARTS HERE!
        spin.setOnAction(new EventHandler<ActionEvent>() {
            int money = 100;

            @Override

            public void handle(ActionEvent event) {

                stack.getChildren().remove(circleB);
                stack.getChildren().remove(circleG);
                stack.getChildren().remove(circleR);
                stack.getChildren().remove(actiontarget);
                userMessage.setText(" ");
                Teller teller = new Teller();
                Roulette rulet = new Roulette();

                //quit game if loose all money
                if (money <= 0) {
                    System.exit(0);
                }

                //get values from toggles and convert to chars
                String userOddEven = g1.getSelectedToggle().getUserData().toString();
                String userColor = g2.getSelectedToggle().getUserData().toString();
                char userCharOE = userOddEven.charAt(0);
                char userCharColor = userColor.charAt(0);
                System.out.println("UserColor = " + userCharColor);

                boolean isNumber = teller.kasNumber(field.getText());
                if (isNumber == false) {
                    userMessage.setText("See ei ole number, sisesta number!"); //if not a number
                } else {
                    int userNumber = Integer.parseInt(field.getText());    //String to integer
                    if (userNumber < 0 | userNumber > 36) {
                        userMessage.setText("Number 0 - 36 please!");
                    } else {
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


                        stack.getChildren().remove(circleB);
                        stack.getChildren().remove(circleG);
                        stack.getChildren().remove(circleR);
                        stack.getChildren().remove(actiontarget);

                        if (luckyColor == 'R') {
                            stack.getChildren().add(circleR);
                        } else if (luckyColor == 'G') {
                            stack.getChildren().add(circleG);
                        } else {
                            stack.getChildren().add(circleB);
                        }
                        stack.getChildren().add(actiontarget);
                        actiontarget.setText("" + luckyNumber);
                    }

                }
            }

        });
    }
}