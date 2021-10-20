package komunikacjaZUzytkownikiem;

import com.company.enums.WyborUzytkownika;

import java.util.function.Supplier;

public class Wybor {

    public void setIntSupplier(Supplier<WyborUzytkownika> intSupplier) {
        this.intSupplier = intSupplier;
    }

    public Supplier<WyborUzytkownika> intSupplier;

    public WyborUzytkownika choose() {
        System.out.println("Wprowdź sposób wprowadzania danych: ");
        System.out.println("1 - Użytkownik wprowadza dane");
        System.out.println("2 - Dane pobrane z linii poleceń");
        System.out.print("Twój wybór: ");

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
