package hu.petrik.matrixoop;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private int sor;
    private int oszlop;
    private int[][] m; //matrix letrehozas syntax
    private static final Random rnd = new Random();


    public Matrix(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;
        this.m = new int[sor][oszlop];
        //matrix inicializalas, feltoltes
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                this.m[i][j] = rnd.nextInt(150) - 50; //matrix elemekkel random elemekkel feltoltes
            }
        }
    }

    public int getElemekOsszege() {
        int osszeg = 0;
        for (int[] sor : this.m) {
            for (int elem : sor) {
                osszeg += elem; //osszes elem osszege
            }
        }
        return osszeg;
    }

    public int getPozitivElemekSzama() {
        int db = 0;
        for (int[] sor : this.m) {
            for (int elem : sor) {
                if (elem > 0) {
                    db++;
                }
            }
        }
        return db;
        //pozitiv elemek osszege
    }


    public int getLegnagyobbElem() {
        int max = this.m[0][0];
        for (int[] sor : this.m) {
            for (int elem : sor) {
                if (elem > max) {
                    max = elem;
                }
            }
        }
        return max;
        //maxkeres matrixban

    }


    public int[] getElsoPozitivElem() {

        int sorIndex = 0;
        int oszlopIndex = 0;

        while (sorIndex < this.m.length && this.m[sorIndex][oszlopIndex] < 1) {

            while (oszlopIndex < this.m[sorIndex].length && this.m[sorIndex][oszlopIndex] < 1) {
                oszlopIndex++;
            }
            if (oszlopIndex == this.m[sorIndex].length) {
                sorIndex++;
                oszlopIndex=0;
            }
        }
        if (sorIndex == this.m.length) {
            return new int[] {-1, -1};

        }
            return new int[]{sorIndex, oszlopIndex};
        //elso pozitiv elem indexeinek visszaadasa (igen, bonyi.)
    }

    public double sorOsszeg (int sor) {
        double osszeg =0;

        for (int elem : m[sor-1])
        {
            osszeg+= elem;
        }
        //adott sor elemeinek osszege
        return osszeg;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] sor : this.m) {
            for (int elem : sor) {
                sb.append(String.format("%3d ", elem)); //tablazatos kiiratas
            }
            sb.append(System.lineSeparator()); //sortores
        }


        return sb.toString().trim(); //utolso folos sortores, szokoz kiszedese
    }

}