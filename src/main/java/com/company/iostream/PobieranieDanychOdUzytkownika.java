package com.company.iostream;

import java.util.Scanner;

public class PobieranieDanychOdUzytkownika {

    public PobieranieDanychOdUzytkownika(){}
    public int[] zdefiniujWielomian() {

        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj stopień wielomianu n: ");
        int stopienWielomianu = scan.nextInt();

        int[] wspolczynnikiWielomianiu = new int[stopienWielomianu];

        for(int i = 0; i < stopienWielomianu; i++) {
            System.out.print("Podaj wartość " + (i + 1)  + " wielomianu: ");

            wspolczynnikiWielomianiu[i] = scan.nextInt();
        }

        return wspolczynnikiWielomianiu;
    }

    public int zdefiniujX() {
        System.out.print("Podaj warrtość 'x': ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
