
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        Calculator calculator;
        calculator = new Calculator();
        // Выясняем сколько платить
        double PoSkolkoPlatit=calculator.start();
        // выясняем какое окончание у "рубль"
        String pravilno= calculator.roubleEnd(PoSkolkoPlatit);
        //идем на извращения, дабы поменять точку на запятую.
        // функция replace не работает и т.п. тоже не работают
        if (PoSkolkoPlatit>0) {


            DecimalFormat myFloatFormatter = new DecimalFormat("#.##");
            String dolgStr = myFloatFormatter.format(PoSkolkoPlatit);
            if (PoSkolkoPlatit-(int)PoSkolkoPlatit==0)
                {dolgStr=dolgStr+",00";}
            int zap = dolgStr.indexOf(",");
            String part1 = dolgStr.substring(0, zap);
            String part2 = dolgStr.substring(zap + 1, dolgStr.length());

            // Выводим итог
            System.out.println("Каждый должен заплатить по: " + part1 + "." + part2 + " " + pravilno);

        }
    }
}
