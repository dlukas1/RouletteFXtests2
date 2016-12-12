package sample;

/**
 * Created by Dmitry on 11.12.2016.
 */

    //Counts user money, + if win, - if loose.
    //Return value to main window, if money == 0 end game.

public class User {
    int startMoney = 100;
    public int countMoney (int userBet, int userWin) {

        int myMoney = startMoney - userBet + userWin;
        return myMoney;
    }

}
