package sample;

/**
 * Created by Dmitry on 11.12.2016.
 */

    //Counts user money, + if win, - if loose.
    //Return value to main window, if money == 0 end game.

public class User {

    public int countMoney (int userBet, int userWin) {
        int startMoney = 100;
        int myMoney = startMoney - userBet + userWin;
        return myMoney;
    }

}
