package com.company;
// задача Шилдт стр 115 на цикл for
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	int i;
        System.out.println("Для остановки нажмите S");
        for (i=1; (char) System.in.read()!='S'; i++){
            System.out.println("Проход :" + i);
        }
    }
}
