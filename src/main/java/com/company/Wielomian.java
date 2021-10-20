package com.company;

public class Wielomian {

    public int[] wspolczynniki_wielomianiu;

    public Wielomian(int[] wspolczynniki_wielomianiu) {
        this.wspolczynniki_wielomianiu = wspolczynniki_wielomianiu;
    }

    public int obliczenia(int x) {
        int wynik = 0;
        for (int n = 0; n < wspolczynniki_wielomianiu.length; n++){
            wynik += wspolczynniki_wielomianiu[n] * Math.pow(x, n);
        }

        return wynik;
    }
}