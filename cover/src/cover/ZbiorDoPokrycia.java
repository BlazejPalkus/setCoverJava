package cover;

import java.util.HashSet;
import java.util.Set;

public class ZbiorDoPokrycia {

    //Zbior do pokrycia sklada sie z elementow 1,2,...,n
    //n jest wielkoscia zbioru i dostajemy ja na wejsciu
    //Potrzebujmy zatem trzymac tylko wielkosc zbioru
    private int wielkoscZbioruDoPokrycia;

    public ZbiorDoPokrycia(int wielkoscZbioruDoPokrycia) {
        this.wielkoscZbioruDoPokrycia = wielkoscZbioruDoPokrycia;
    }

    public int wielkoscZbioruDoPokrycia() {
        return wielkoscZbioruDoPokrycia;
    }

    public Set<Integer> stworzZbiorDoPokrycia() {
        Set<Integer> zbiorDoPokrycia = new HashSet<>();
        for (int i = 1; i <= wielkoscZbioruDoPokrycia; i++) {
            zbiorDoPokrycia.add(i);
        }
        return zbiorDoPokrycia;
    }

    @Override
    public String toString() {
        return stworzZbiorDoPokrycia().toString();
    }

}
