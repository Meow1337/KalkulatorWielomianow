package com.company;

public class PobieranieDanychZLiniiPolecen {


    private String[] args;

    public PobieranieDanychZLiniiPolecen(String[] args) {
        this.args = args;
    }

    public int zdefiniujX() {
        return Integer.valueOf(args[args.length-1]);
    }

    public int[] zdefiniujWielomian() {
        int[] wspolczynnikiWielomianiu = new int[args.length-1];

        for (int n = 0; n < args.length-1; n++) {
            wspolczynnikiWielomianiu[n] = Integer.valueOf(args[n]);
        }

        return wspolczynnikiWielomianiu;
    }
}
