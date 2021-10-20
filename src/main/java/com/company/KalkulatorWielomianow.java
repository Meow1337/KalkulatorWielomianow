package com.company;

import com.company.enums.WyborUzytkownika;
import komunikacjaZUzytkownikiem.PobieranieDanychOdUzytkownika;
import komunikacjaZUzytkownikiem.Wybor;

import java.util.Scanner;
import java.util.function.Supplier;

public class KalkulatorWielomianow {

    public static void main(String[] args) {
        Wybor wybory = new Wybor();

        Scanner scanner = new Scanner(System.in);
        WyborUzytkownika wybor1 = wybory.choose();

        int i = scanner.nextInt();
        Supplier<WyborUzytkownika> intSupplier = KonwerterWejscia.getWyborUzytkownikaSupplier(i);

        wybory.setIntSupplier(intSupplier);

        switch (wybor1) {
            case PODANEPRZEZUZYTKOWNIKA:
                PobieranieDanychOdUzytkownika daneUzytkownika = new PobieranieDanychOdUzytkownika();
                Wielomian w1 = new Wielomian(daneUzytkownika.zdefiniujWielomian());
                int wynik1 = w1.obliczenia(daneUzytkownika.zdefiniujX());
                System.out.println("Wartość wielomianu wynosi: " + wynik1);
                break;
            case PODANEZLINIIPOLECEN:
                PobieranieDanychZLiniiPolecen daneZLinii = new PobieranieDanychZLiniiPolecen(args);
                Wielomian w2 = new Wielomian(daneZLinii.zdefiniujWielomian());
                int wynik2 = w2.obliczenia(daneZLinii.zdefiniujX());
                System.out.println("Wartość wielomianu wynosi: " + wynik2);
                break;
        }

    }
}