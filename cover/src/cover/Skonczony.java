package cover;

import java.util.HashSet;
import java.util.Set;

public class Skonczony extends Skladnik {
    int pierwszyElement;
    int ograniczenieCiagu;
    int postepArytmetyczny;

    public Skonczony(int pierwszyElement, int ograniczenieCiagu, int postepArytmetyczny) {
        this.pierwszyElement = pierwszyElement;
        this.ograniczenieCiagu = ograniczenieCiagu;
        this.postepArytmetyczny = postepArytmetyczny;
    }


    @Override
    public Set<Integer> wspolneElementySkladnikaZeZbiorem(ZbiorDoPokrycia zbior) {
        Set<Integer> wspolneWartosci = new HashSet<>();
        for (int i = this.pierwszyElement; i <= zbior.wielkoscZbioruDoPokrycia() && i <= this.ograniczenieCiagu;
             i += this.postepArytmetyczny) {

            wspolneWartosci.add(i);
        }

        return wspolneWartosci;
    }
}
