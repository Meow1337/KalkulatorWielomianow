package com.company;

import com.company.enums.WyborUzytkownika;

import java.util.function.Supplier;


public class KonwerterWejscia {

    public static Supplier<WyborUzytkownika>  getWyborUzytkownikaSupplier(Supplier<Integer>  i) {
        Supplier<WyborUzytkownika> intSupplier = () -> {
            switch (i.get()) {
                case 1: return WyborUzytkownika.PODANEPRZEZUZYTKOWNIKA;
                case 2: return WyborUzytkownika.PODANEZLINIIPOLECEN;
                default: return WyborUzytkownika.BLAD;
            }
        };
        return intSupplier;
    }
}
