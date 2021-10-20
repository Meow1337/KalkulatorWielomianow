package komunikacjaZUzytkownikiem;

import com.company.enums.WyborUzytkownika;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class WyborTest {

    @Test
    void akceptujWprowadzaniePrzezUzytkownika() {
        Wybor wybor = new Wybor();
        Supplier<WyborUzytkownika> zawsze1 = () -> WyborUzytkownika.PODANEPRZEZUZYTKOWNIKA;

        wybor.setIntSupplier(zawsze1);

        WyborUzytkownika choose = wybor.choose();

        assertEquals(WyborUzytkownika.PODANEPRZEZUZYTKOWNIKA, choose, "Niedopuszczalny wybór użytkownika");
    }

    @Test
    void akceptujWprowadzanieZKonsoli() {
        Wybor wybor = new Wybor();
        Supplier<WyborUzytkownika> zawsze2 = () -> WyborUzytkownika.PODANEZLINIIPOLECEN;

        wybor.setIntSupplier(zawsze2);

        WyborUzytkownika choose = wybor.choose();

        assertEquals(WyborUzytkownika.PODANEZLINIIPOLECEN, choose, "Niedopuszczalny wybór użytkownika");
    }

    @Test
    void pytajDopokiUzytkownikWprowadziAkceptowanaWartosc() {
        Wybor wybor = new Wybor();

        Supplier mock = Mockito.mock(Supplier.class);

        wybor.setIntSupplier(mock);
        Mockito.when(mock.get()).thenReturn(WyborUzytkownika.BLAD, WyborUzytkownika.BLAD, WyborUzytkownika.PODANEPRZEZUZYTKOWNIKA);

        WyborUzytkownika choose = wybor.choose();

        assertEquals(WyborUzytkownika.PODANEPRZEZUZYTKOWNIKA, choose, "Niedopuszczalny wybór użytkownika");
    }

    @Test
    void pytajDopokiUzytkownikWprowadziAkceptowanaWartoscBlad() {
        Wybor wybor = new Wybor();

        Supplier mock = Mockito.mock(Supplier.class);

        wybor.setIntSupplier(mock);
        Mockito.when(mock.get()).thenReturn(WyborUzytkownika.BLAD, WyborUzytkownika.BLAD, WyborUzytkownika.BLAD);

        WyborUzytkownika choose = wybor.choose();

        assertEquals(WyborUzytkownika.BLAD , choose, "Zbyt wiele prób");
    }

}