package sample;

public class Roulette {
    public int fortuneNum() {
        int luckyNumber;
        char luckyColor;
        luckyNumber = (int) (Math.random() * 36);
        System.out.println(luckyNumber);
        return luckyNumber;
    }
    //Тут создаем случ число и ассоциируем с номером

    public char fortuneCol(int luckyNumber) {
        char[] mas = {'G', 'R', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'B', 'R',
                'B', 'R', 'B', 'R', 'B', 'R', 'R', 'B', 'R', 'B', 'R', 'B', 'R',
                'B', 'R', 'B', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'R'};
        char luckyColor = mas[luckyNumber];
        System.out.println(luckyColor);
        return luckyColor;
    }
}