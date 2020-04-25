package academy.belhard.util;

import java.util.Scanner;

public class CommandReader {
    private static final Scanner scan = new Scanner(System.in);

    public static int readNumber(String message) {
        System.out.println(message);
        return Integer.parseInt(scan.nextLine());
    }

    public static String readString (String message) {
        System.out.println(message);
        return scan.nextLine();
    }


    public static void showMenu() {
        System.out.println("1.Показать таблицу 'Pharmacy'");
        System.out.println("2.Добавить новую аптеку в таблицу 'Pharmacy'");
        System.out.println("3.Обновить значение в таблице 'Pharmacy'");
        System.out.println("4.Удалить строку в таблице 'Pharmacy'");
        System.out.println("5.Вывести строку из таблицы 'Pharmacy' под нужным id");
        System.out.println("6.Показать таблицу 'Medicine'");
        System.out.println("7.Добавить новый медикамент в таблицу 'Medicine'");
        System.out.println("8.Обновить значение в таблице 'Medicine'");
        System.out.println("9.Удалить строку в таблице 'Medicine'");
        System.out.println("10.Вывести строку из таблицы 'Medicine' под нужным id");
        System.out.println("11.Показать таблицу 'Replacement'");
        System.out.println("12.Добавить значение в таблицу 'Replacement'");
        System.out.println("13.Обновить значение в таблице 'Replacement'");
        System.out.println("14.Удалить строку в таблице 'Replacement'");
        System.out.println("15.Вывести строку из таблицы 'Replacement' под нужным id");
        System.out.println("16. Показать содержимое трех таблиц");
        System.out.println("17.Выход");


    }
}