import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {


    public double start() {
        ArrayList<Bludo> feedList = new ArrayList<>();
        System.out.println("Привет!");
        double dolg = 0; // итог калькулятора
        // ВВод числа плательщиков
        int menCount = skolkoNaroduPlatit();
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        boolean vvod = true;
        double fullPrice = 0;
        while (vvod) {
            Bludo bludo = new Bludo();
            i++;
            System.out.println("Введите название товара № " + i + " или введите 'Завершить': ");
            String vvodStr = scanner.nextLine().trim();
            double price = 0;
            if (!vvodStr.equalsIgnoreCase("завершить")) {
                bludo.name = vvodStr;

                price=0;
                while (true) {
                    try {
                        System.out.println("Введите цену [руб].[коп]:");
                        vvodStr = scanner.nextLine();
                        price = Double.parseDouble(vvodStr);
                        if (price > 0) {
                            bludo.price = price;
                            fullPrice = fullPrice + price;
                            System.out.println("Товар '"+bludo.name+"' успешно добавлен на сумму: " + fullPrice + " руб.");
                            ;break;
                        }
                        else System.out.println("введите цену больше 0 ");

                    } catch (NumberFormatException e) {
                       System.out.println("неверный ввод, повторите ");
                    }

// добавление товара в список
                }
                feedList.add(bludo);

            } else vvod = false;
       }
        // Итоговый подсчет
        int tovarov = feedList.size();
        if (fullPrice > 0) {

            System.out.println(String.format("Итого: %.2f", fullPrice));
            for (int t = 0; t < tovarov; t++) {
                System.out.println("Добавленные товары: " + feedList.get(t).name);

            }

            dolg = fullPrice /(double)menCount;

        }
        return dolg;
    }

    public static int skolkoNaroduPlatit() {
        boolean notOk = true;
        int men = 0;
        while (notOk) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Сколько человек расплачиваются(2-9)?");
            String strMen = scanner.nextLine();

            try {
                men = Integer.parseInt(strMen.trim());
                if ((men > 1) && (men < 10)) {

                    notOk = false;
                } else System.out.println("неверное число " + men);
            } catch (NumberFormatException nfe) {
                System.out.println("неправильный ввод, повторите ");
            }
        }
        return men;
    }

    public static String roubleEnd(double itog) {
        int roubles = 0;

        roubles = (int) itog;
        int rouble = roubles - ((int) roubles / 10) * 10;

        String pravilno = "";
        if (rouble == 1) {
            pravilno = "рубль";
        }
        ;
        if ((rouble == 0) || (rouble > 4)) {
            pravilno = "рублей";
        }
        ;
        if ((rouble > 1) && (rouble < 5)) {
            pravilno = "рубля";

        }


        ;
        return pravilno;
    }


    static class Bludo {
        double price;
        String name;
    }

}