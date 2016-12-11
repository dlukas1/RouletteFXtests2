package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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
        TextField field = new TextField("Vali number 0 - 36 :");
        stack.getChildren().add(field);
        field.maxWidth(50);
        field.setTranslateY(-150);

        Label YB = new Label("Your bet: ");

//CB1 for betOnNumber
        ChoiceBox cb1 = new ChoiceBox(FXCollections.observableArrayList
                ("Bet 1", "Bet 2", "Bet 5", "Bet 10", "Bet 20"));
        stack.getChildren().add(cb1);
        cb1.setTranslateY(-120);
        cb1.setTooltip(new Tooltip("Choose your bet!"));

        //Radio1 for odd/even
        ToggleGroup g1 = new ToggleGroup();
        RadioButton r1 = new RadioButton("Odd ");
        RadioButton r2 = new RadioButton("Even");
        r1.setToggleGroup(g1);
        r2.setToggleGroup(g1);
        r2.setSelected(true);


        //Toggle for color
        ToggleGroup g2 = new ToggleGroup();
        ToggleButton btnRed = new ToggleButton("Red   ");
        ToggleButton btnBlack = new ToggleButton("Black");
        btnBlack.setStyle("-fx-font: 16 arial; -fx-base:#000000;");
        btnRed.setStyle("-fx-font: 16 arial; -fx-base: #ff0019;");
        btnRed.setToggleGroup(g2);
        btnBlack.setToggleGroup(g2);
        btnBlack.setSelected(true);


        ChoiceBox cb3 = new ChoiceBox(FXCollections.observableArrayList
                ("Bet 1", "Bet 2", "Bet 5", "Bet 10", "Bet 20"));

        stack.getChildren().addAll(btnRed, btnBlack, cb3);
        btnRed.setTranslateX(160);
        btnRed.setTranslateY(10);
        btnBlack.setTranslateX(160);
        btnBlack.setTranslateY(-30);
        cb3.setTranslateX(160);
        cb3.setTranslateY(50);


        ChoiceBox cb2 = new ChoiceBox(FXCollections.observableArrayList
                ("Bet 1", "Bet 2", "Bet 5", "Bet 10", "Bet 20"));
        stack.getChildren().addAll(r1, r2, cb2);
        r1.setTranslateX(-160);
        r2.setTranslateX(-160);
        r2.setTranslateY(-20);
        cb2.setTranslateX(-160);
        cb2.setTranslateY(35);

       /* GridPane grid = new GridPane();
        ToggleGroup g2 = new ToggleGroup();
        ToggleButton e1 = new ToggleButton("1-9");
        ToggleButton e2 = new ToggleButton("10-18");
        ToggleButton e3 = new ToggleButton("19-27");
        ToggleButton e4 = new ToggleButton("28-36");
        e1.setToggleGroup(g2);
        e2.setToggleGroup(g2);
        e3.setToggleGroup(g2);
        e4.setToggleGroup(g2);
        e4.setSelected(true);
        grid.getChildren().add(e1);
        stack.getChildren().add(grid);
        */


        final Text actiontarget = new Text();
        actiontarget.setId("actiontarget");
        actiontarget.setFont(new Font("Arial", 50));
        actiontarget.setFill(Color.WHITE);

        //GAME STARTS HERE!
        spin.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {


                stack.getChildren().remove(circleB);
                stack.getChildren().remove(circleG);
                stack.getChildren().remove(circleR);
                stack.getChildren().remove(actiontarget);


                /*
                Timer timer = new Timer();

                timer.schedule(new TimerTask() {
                    public void run() {
                        stack.getChildren().add(circleB) ;}},500);

              timer.schedule(new TimerTask() {
                    public void run() {
                        stack.getChildren().remove(circleB);
                        stack.getChildren().add(circleR) ;}},1000);

               timer.schedule(new TimerTask() {
                    public void run() {
                        stack.getChildren().remove(circleR);
                        stack.getChildren().add(circleB) ;}},1500);
                timer.schedule(new TimerTask() {
            public void run() {
                stack.getChildren().remove(circleB);
                stack.getChildren().add(circleR) ; }},2000);*/
                int userNumber = Integer.parseInt(field.getText());     //String to integer
                Toggle userColor = g2.getSelectedToggle();
                Toggle userOddEven = g1.getSelectedToggle();
                System.out.println(userNumber);
                System.out.println(userColor);

                System.out.println(userOddEven);


                System.out.println(cb1.getValue());
                System.out.println(cb2.getValue());
                System.out.println(cb3.getValue());


                int luckyNumber = (int) (Math.random() * 36);
                char[] mas = {'G', 'R', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'B', 'R',
                        'B', 'R', 'B', 'R', 'B', 'R', 'R', 'B', 'R', 'B', 'R', 'B', 'R',
                        'B', 'R', 'B', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'R'};
                char luckyColor = mas[luckyNumber];

                System.out.println("Number is " + luckyNumber);
                System.out.println("Color is " + luckyColor);

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




               /* char userOE = 0;
                if(userEven == true){
                    userOE = 'E';
                }
                else if (userOdd == true) {
                    userOE = 'O';
                }
                System.out.println(userOE);*/
                /*String userBetNum = cb1.getValue().toString();
                String userBetCol = cb2.getValue().toString();
                String userBetOE = cb3.getValue().toString();*/

              /* boolean userOdd = r1.isSelected();
                boolean userEven = r2.isSelected();
                boolean userColRed = btnRed.isSelected();
                boolean userColBlack = btnBlack.isSelected();
                char userColor2 = 'z';
                if (userColRed == true) {
                    userColor2 = 'R';
                } else if (userColBlack == true) {
                    userColor2 = 'B';
                }
                System.out.println(userColor2);*/
            }

        });
    }
}