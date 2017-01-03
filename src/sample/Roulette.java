package sample;
/*
Klass Rulette - genereerime juhuslik number ja assotsieerume värviga
*/
public class Roulette {

    //Siin genireerima juhuslikku numbri
    public int fortuneNum() {
        int luckyNumber;
        luckyNumber = (int) (Math.random() * 36);
        return luckyNumber;
    }

    //Siin assotsieerime numbri ja värvi
    public char fortuneCol(int luckyNumber) {
        char[] mas = {'G', 'R', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'B', 'R',
                'B', 'R', 'B', 'R', 'B', 'R', 'R', 'B', 'R', 'B', 'R', 'B', 'R',
                'B', 'R', 'B', 'B', 'R', 'B', 'R', 'B', 'R', 'B', 'R'};
        char luckyColor = mas[luckyNumber];
        return luckyColor;
    }
}