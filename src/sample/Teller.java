package sample;

/**
 * Класс Теллер - принимает ставки (сколько и на что поставили), сравнивает ставку и результт рулетки и считает выигрыш
 */
public class Teller {
    public int userWinN, userWinC, userWinOE;

    public int checkForWin(int userNumber, int luckyNumber, char luckyColor, int ubn, int ubc, int uboe, char userCharColor, char userCharOE) {
char luckyOE = 'x';
        if (userNumber == luckyNumber) {
            userWinN = ubn * 35;
        }

        if (userCharColor == luckyColor) {
            userWinC = ubc * 2;
            System.out.println("UserColor win!");
        }

        if ((luckyNumber % 2) == 0 ) {
             luckyOE = 'E';
        }
        else if ((luckyNumber % 1) == 0 ) {
             luckyOE = 'O';
        }

if(userCharOE == luckyOE){
    userWinOE = uboe * 2;
    System.out.println("Won OE = " + luckyOE);
}

        int userWin = userWinN + userWinC + userWinOE;

        return userWin;
    }
}