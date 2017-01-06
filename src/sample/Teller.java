package sample;

/**
 * Klass Teller võtab vastu panused (kui palju ja mille peale on pantnud), võrdleb ruletti tulemusega ja arvestab võidu
 */
public class Teller {
    public int userWinN, userWinC, userWinOE;

    //Siin kontrollime kas sisestati numbri
    public boolean kasNumber (String a) {
        try {
            Integer.parseInt(a);
        } catch(Exception e){
            return false;
        }
        return true;
    }

    //Siin kontrollime kas on võidu
    public int checkForWin(int userNumber, int luckyNumber, char luckyColor, int ubn, int ubc, int uboe, char userCharColor, char userCharOE) {
        char luckyOE = 'x'; //default value to initialize luckyOE

        if (userNumber == luckyNumber) {
            userWinN = ubn * 35;
        }

        if (userCharColor == luckyColor) {
            userWinC = ubc * 2;
        }

        if ((luckyNumber % 2) == 0) {
            luckyOE = 'E';
        } else if ((luckyNumber % 1) == 0) {
            luckyOE = 'O';
        }

        if (userCharOE == luckyOE) {
            userWinOE = uboe * 2;
        }

        int userWin = userWinN + userWinC + userWinOE;

        return userWin;
    }
}