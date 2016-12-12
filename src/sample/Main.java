package sample;
import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        primaryStage.show();
        // scene.getStylesheets().add((getClass().getResource("style.css")).toExternalForm());
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

        Label YB = new Label("Your bet: ");
        Label lb = new Label("Number  0 - 36: ");
        stack.getChildren().add(lb);
        lb.setTranslateY(-170);

        ChoiceBox cb1 = new ChoiceBox(FXCollections.observableArrayList
                (0,1,2,5,10,20));
        ChoiceBox cb2 = new ChoiceBox(FXCollections.observableArrayList
                (0,1,2,5,10,20));

        ChoiceBox cb3 = new ChoiceBox(FXCollections.observableArrayList
                (0,1,2,5,10,20));
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

        //GAME STARTS HERE!
        spin.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {

                stack.getChildren().remove(circleB);
                stack.getChildren().remove(circleG);
                stack.getChildren().remove(circleR);
                stack.getChildren().remove(actiontarget);
                User user = new User();
                Teller teller = new Teller();
                Roulette rulet = new Roulette();


                int userNumber = Integer.parseInt(field.getText());     //String to integer

                //get values from choiceboxes
                String userBetNum = cb1.getValue().toString();
                String userBetOE = cb2.getValue().toString();
                String userBetCol = cb3.getValue().toString();
                //convert to integers
                int ubn = Integer.parseInt(userBetNum);
                int uboe = Integer.parseInt(userBetOE);
                int ubc = Integer.parseInt(userBetCol);
                int userBet = ubn+ubc+uboe;
                System.out.println(userBet);


              /*  g2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    public void changed(ObservableValue<? extends Toggle> ov,
                                        Toggle old_toggle, Toggle new_toggle) {
                        if (g2.getSelectedToggle() != null) {
                            System.out.println(g2.getSelectedToggle().getUserData().toString());
                        }
                    }
                });
                g1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    public void changed(ObservableValue<? extends Toggle> ov,
                                        Toggle old_toggle, Toggle new_toggle) {
                        if (g1.getSelectedToggle() != null) {
                            System.out.println(g1.getSelectedToggle().getUserData().toString());
                        }
                    }
                });

                //get values from toggle buttons
                String userOddEven = g1.getSelectedToggle().getUserData().toString();
                String userColor = g2.getSelectedToggle().getUserData().toString();*/
                //convert strings to chars
               /* char cuserOE = userOddEven.charAt(0);
                char cuserColor = userColor.charAt(0);
                */
                int luckyNumber = rulet.fortuneNum();
                char luckyColor = rulet.fortuneCol(luckyNumber);

                int userWin = teller.checkForWin(userNumber,luckyNumber,luckyColor, ubn,  ubc, uboe);

                int userMoney = user.countMoney(userBet, userWin);
                myMoneyT.setText("Your money: " + userMoney);

                /*
                int userWin = teller.checkForWin(userNumber, cuserColor,cuserOE,luckyNumber,luckyColor, ubn,  ubc, uboe);

                int userMoney = user.countMoney(userBet, userWin);
                myMoneyT.setText("Your money: " + userMoney);*/
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

        });
    }
}