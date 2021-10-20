package com.company;

import com.company.enums.WyborUzytkownika;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KowerterWejsciaTest {

    @Test
    void konwerterWejsciaOdUzytkownika() {

        Supplier<WyborUzytkownika> choose = KonwerterWejscia.getWyborUzytkownikaSupplier(1);

        assertEquals(WyborUzytkownika.PODANEPRZEZUZYTKOWNIKA, choose.get(), "Opcja nr 1");
    }

    @Test
    void konwerterWejsciaZLiniiPolecen() {
        Supplier<WyborUzytkownika> choose = KonwerterWejscia.getWyborUzytkownikaSupplier(2);

        assertEquals(WyborUzytkownika.PODANEZLINIIPOLECEN, choose.get(), "Opcja nr 2");
    }

    @Test
    void konwerterWejsciaBladDodatnia() {
        int randomNum = getRandomNumDodatnia();

        Supplier<WyborUzytkownika> choose = KonwerterWejscia.getWyborUzytkownikaSupplier(randomNum);

        assertEquals(WyborUzytkownika.BLAD, choose.get(), "Blad");
    }

    public int getRandomNumDodatnia() {
        Random randomNums = new Random();

        int low = 3;
        int high = 10;
        int random = randomNums.nextInt(high-low) + low;

        return random;

    }



    @Test
    void konwerterWejsciaBladNieDodatnia() {
        int randomNumber = getRandomNumNieDodatnia();

        Supplier<WyborUzytkownika> choose = KonwerterWejscia.getWyborUzytkownikaSupplier(randomNumber);
        System.out.print(randomNumber);
        assertEquals(WyborUzytkownika.BLAD, choose.get(), "Blad");
    }
    public int getRandomNumNieDodatnia() {
        Random random = new Random();

        int low = -10;
        int high = 0;

        return random.nextInt(high-low) + low;
    }


}