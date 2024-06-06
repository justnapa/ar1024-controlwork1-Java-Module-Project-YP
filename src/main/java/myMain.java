import java.util.Arrays;
import java.util.Scanner;
public class myMain {

    public static void main(String[] args) {
        Calculator calculator;
        calculator = new Calculator();
        DebtsData data = new DebtsData(); // данные с долгами
        Scanner scanner = new Scanner(System.in);


        System.out.println("Привет, мир отдыхающих! ");
        System.out.println("Это альтернативный калькулятор ");
        data.people = calculator.skolkoNaroduPlatit(); //число плательщиков
        //1. Сумма на всех
        double naVseh = 0;
        System.out.println("введите сумму, которую надо поделить на всех(0-завершить)?: ");

        while (true) {
            try {
                String vvodStr = scanner.nextLine();
                naVseh = Double.parseDouble(vvodStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("неверный ввод, повторите ");
            }
        }
        if (naVseh == 0) return; // выход
        double fullSumma=naVseh;
        data.fullDebt= data.fullDebt+naVseh;
        // double[] itogi = new double[people]; //массив с долгом каждого плательщика
        double forEach = naVseh / data.people;
        Arrays.fill(data.debt, forEach); // делим поровну сумму на всех
        data.printDolgi();
        System.out.println("Теперь у каждого плательщика - номер  от 1 до " + data.people);
        int i = 1;
        boolean fullEnd = false;// маркер окончания ввода
        double summa = 0;
        while (!fullEnd) {

            while (true) {
                System.out.println("Сумма №" + i + ", которую надо поделить на некоторых (0-завершить): ");
                String vvodStr = scanner.nextLine();
                summa = 0;
                if (vvodStr.equals("0")) {
                    fullEnd = true;
                    System.out.println("  введено 0. ");break;
                }
                else {
                try {
                    summa = Double.parseDouble(vvodStr);
                    System.out.print(summa);
                    System.out.println("  введено");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("неверный ввод, повторите ");

                    }
                }
            }

        boolean endVvod = false; // маркер окончания ввода товаров для отдельных плательщиков
        int s;
       // System.out.println(fullEnd);
        while ((!endVvod)&&(!fullEnd)) { //  теперь считаем отдельные долги
            s = 0;
            if (fullEnd) break; // завершаем подсчет ибо введен 0
            System.out.println("на кого делить сумму №" + i + " ("+summa +"), номера плательщиков через запятую (например 1,2,5 или 1-2-5)?: ");
            int[] wHoPay4 = new int[10]; //массив с номерами плательщиков
            String spisok = scanner.nextLine();
            spisok.trim();
            boolean notWrong = false;
            for (int t = 0; t < spisok.length(); t = t + 2) { //поиск плательщиков в строке


                char numStr = spisok.charAt(t);
                int num = numStr - '0';
                try {

                    if ((num > 0) && (num < 10)) {
                        s = s + 1;
                        wHoPay4[s] = num;
                        System.out.println("pos" + t + " num " + num);
                        notWrong=true;
                    } else {
                        System.out.println("неверное число " + num);
                        notWrong = false;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("неправильный ввод, повторите ");
                    notWrong = false;
                }

            }


            if (notWrong) {
                System.out.println("Позиция № " + i + " введена успешно");
                data.fullDebt= data.fullDebt+summa;
                double newDolg = summa / s;
                System.out.println(String.format("долг по товару %s с плательщиков  по %.2f ",i, newDolg));
                System.out.println(String.format("общий долг: %.2f ", data.fullDebt));
                for (int d = 1; d <= s; d++) {
                    data.debt[wHoPay4[d]] = data.debt[wHoPay4[d]] + newDolg;
                    //System.out.println(String.format("долг по товару с плательщиков по %.2f ", newDolg));
                    endVvod = true;
                }
                data.printDolgi();
                i++;
            }

        }
        }
        System.out.println(String.format("Итого платить %.2f ", data.fullDebt));
        data.printDolgi();


    }


}

class DebtsData{
    double fullDebt; // общий долг
    int people; //число плательщиков
    double[] debt = new double[10]; // долги
    public  void printDolgi (){
        for(int i=1;i<=this.people;i++){
            System.out.println(String.format("Плательщик № %S платит %.2f " ,i,this.debt[i]));
        }
    }
}