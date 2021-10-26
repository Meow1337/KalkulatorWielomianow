package com.company.iostream;

import com.company.enums.WyborUzytkownika;

import java.util.function.Supplier;

public class Wybor {

    public void setIntSupplier(Supplier<WyborUzytkownika> intSupplier) {
        this.intSupplier = intSupplier;
    }

    public Supplier<WyborUzytkownika> intSupplier;

    public WyborUzytkownika choose() {

        WyborUzytkownika numerMetody;
        numerMetody = intSupplier.get();

        boolean metod = false;
        int licznik = 0;

        while (!metod && licznik < 2) {
            if (numerMetody == WyborUzytkownika.PODANEZLINIIPOLECEN || numerMetody == WyborUzytkownika.PODANEPRZEZUZYTKOWNIKA) {
                metod = true;
            }
            else {
                System.out.println("Nie poprawny wybór");
                System.out.print("Proszę wybrać jeszcze raz: ");
                numerMetody = intSupplier.get();
                licznik++;
            }
        }
        if(!metod){
            System.out.print("Błąd");
        }
        return numerMetody;
    }
}
