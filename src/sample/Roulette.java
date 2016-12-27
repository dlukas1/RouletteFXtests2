package sample;

public class Roulette {
    public int fortuneNum() {
        int luckyNumber;
        luckyNumber = (int) (Math.random() * 36);
        return luckyNumber;
    }
    //Тут создаем случ число и ассоциируем с номером

    public char fortuneCol(int luckyNumber) {
        char[] mas = {'G', 'R', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'B', 'R',
                'B', 'R', 'B', 'R', 'B', 'R', 'R', 'B', 'R', 'B', 'R', 'B', 'R',
                'B', 'R', 'B', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'R'};
        char luckyColor = mas[luckyNumber];
        return luckyColor;
    }
}