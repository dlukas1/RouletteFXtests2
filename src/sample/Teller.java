package sample;

/**
 * Класс Теллер - принимает ставки (сколько и на что поставили), сравнивает ставку и результт рулетки и считает выигрыш
 */
public class Teller {
    public int userWinN, userWinC, userWinOE;

    public int checkForWin(int userNumber, int luckyNumber, char luckyColor, int ubn, int ubc, int uboe, char userCharColor, char userCharOE) {

        if (userNumber == luckyNumber) {
            userWinN = ubn * 35;
        }

        if (userCharColor == luckyColor) {
            userWinC = ubc * 2;
            System.out.println("UserColor win!");
        }

        if ((luckyNumber % 2) == 0 && userCharOE == 'E') {
            System.out.println("Число " + luckyNumber + " четное ");
            userWinOE = uboe * 2;
            System.out.println(userWinOE);
        } else if ((luckyNumber % 1) == 0 && userCharOE == 'O') {
            System.out.println("Число " + luckyNumber + " нечетное ");
            userWinOE = uboe * 2;
            System.out.println(userWinOE);
        }


        int userWin = userWinN + userWinC + userWinOE;

        return userWin;
    }
}