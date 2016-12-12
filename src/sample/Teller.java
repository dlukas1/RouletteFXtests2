package sample;

/**
 * Класс Теллер - принимает ставки (сколько и на что поставили), сравнивает ставку и результт рулетки и считает выигрыш
 */
public class Teller {
    public int userWinN, userWinC, userWinOE;

    boolean isEven(int userNumber) {
        return ((userNumber % 2) == 0);
    }
//ubral iz metoda:  char userColor, char cuserOE,
    public int checkForWin(int userNumber, int luckyNumber, char luckyColor, int ubn, int ubc, int uboe) {

        if (userNumber == luckyNumber) {
            userWinN = ubn * 35;

        } /*else if (userColor == luckyColor) {
            userWinC = ubc * 2;

        } else if (isEven(userNumber) == true || cuserOE == 'E') {
            userWinOE = uboe * 2;
        } else if (isEven(userNumber) == false || cuserOE == 'O') {
            userWinOE = uboe * 2;
        } */else {
            System.out.println("You lost!");
        }

        int userWin = userWinN + userWinC + userWinOE;

        return userWin;
    }
}