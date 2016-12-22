package sample;

/**
 * Created by Dmitry on 11.12.2016.
 */

    //Counts user money, + if win, - if loose.
    //Return value to main window, if money == 0 end game.

public class User {
    int myMoney = 50;
    public int countMoney (int userBet, int userWin) {

System.out.println("UserMoney = "+ myMoney);
    myMoney = myMoney - userBet + userWin;



        return myMoney;
    }

}

/*
int count = 1;
        do {
            System.out.println("Count is: " + count);
            count++;
        } while (count < 11);
 */
