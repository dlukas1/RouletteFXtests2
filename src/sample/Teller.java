package sample;

/**
 * Класс Теллер - принимает ставки (сколько и на что поставили), сравнивает ставку и результт рулетки и считает выигрыш
 */
public class Teller {
    public int userWin;

    public int checkForWin(int userNumber, char userColor, int luckyNumber, char luckyColor, int userBetNum, int userBetCol) {

        if (userNumber == luckyNumber) {
            userWin = userBetNum * 35;
            System.out.println("You win is " + userWin);
        } else if (userColor == luckyColor) {
            userWin = userBetCol * 2;
            System.out.println("Your win is " + userWin);

        } else {
            System.out.println("You lost!");
        }
        return userWin;
    }
}