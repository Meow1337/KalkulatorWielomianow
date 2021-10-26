package com.company;

import com.company.enums.WyborUzytkownika;
import com.company.iostream.PobieranieDanychOdUzytkownika;
import com.company.iostream.Wybor;

import java.util.Scanner;
import java.util.function.Supplier;

public class KalkulatorWielomianow {

    public static void main(String[] args) {
        System.out.println("Wprowdź sposób wprowadzania danych: ");
        System.out.println("1 - Użytkownik wprowadza dane");
        System.out.println("2 - Dane pobrane z linii poleceń");
        System.out.print("Twój wybór: ");

        Wybor wybory = new Wybor();
        Supplier<WyborUzytkownika> intSupplier = KonwerterWejscia.getWyborUzytkownikaSupplier( () -> new Scanner(System.in).nextInt());
        wybory.setIntSupplier(intSupplier);

        WyborUzytkownika wybor1 = wybory.choose();

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