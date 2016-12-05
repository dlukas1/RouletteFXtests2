package sample;

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
//CB1 for betOnNumber
        ChoiceBox cb1 = new ChoiceBox(FXCollections.observableArrayList
                ("" + "Bet 1", "Bet 2", "Bet 5", "Bet 10", "Bet 20"));
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
        ToggleButton btn1 = new ToggleButton("Red   ");
        ToggleButton btn2 = new ToggleButton("Black");
        btn1.setToggleGroup(g2);
        btn2.setToggleGroup(g2);
        btn2.setSelected(true);
        ChoiceBox cb3 = new ChoiceBox(FXCollections.observableArrayList
                ("Bet 1", "Bet 2", "Bet 5", "Bet 10", "Bet 20"));
        stack.getChildren().addAll(btn1, btn2, cb3);
        btn1.setTranslateX(160);
        btn1.setTranslateY(18);
        btn2.setTranslateX(160);
        btn2.setTranslateY(-10);
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
              /* Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        stack.getChildren().add(circleZ) ;}},500);
                timer.schedule(new TimerTask() {
                    public void run() {
                        stack.getChildren().remove(circleR);
                        stack.getChildren().add(circleB) ;}},500);
                timer.schedule(new TimerTask() {
                    public void run() {
                        stack.getChildren().remove(circleB);
                        stack.getChildren().add(circleR) ;}},500);
                timer.schedule(new TimerTask() {
                    public void run() {
                        stack.getChildren().remove(circleR);
                        stack.getChildren().add(circleB) ;}},500);*/
                // stack.getChildren().remove(circleZ);
                stack.getChildren().remove(circleB);
                stack.getChildren().remove(circleG);
                stack.getChildren().remove(circleR);
                stack.getChildren().remove(actiontarget);
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

               /* Scanner sc1 = new Scanner(System.in);
                int userNumber = sc1.nextInt();*/

               /* boolean userOdd = r1.isSelected();
                boolean userEven = r2.isSelected();

                boolean userColRed = btn1.isSelected();
                boolean userColBlack = btn2.isSelected();
                char userColor = 'z';
                if (userColRed == true) {
                    userColor = 'R';
                } else if (userColBlack == true) {
                    userColor = 'B';
                }
                System.out.println(userColor);*/

                int luckyNumber = (int) (Math.random() * 36);
                char[] mas = {'G', 'R', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'B', 'R',
                        'B', 'R', 'B', 'R', 'B', 'R', 'R', 'B', 'R', 'B', 'R', 'B', 'R',
                        'B', 'R', 'B', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'R'};
                char luckyColor = mas[luckyNumber];

                System.out.println("Number is " + luckyNumber);
                System.out.println("Color is " + luckyColor);
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
        primaryStage.show();
    }
}