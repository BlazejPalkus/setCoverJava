package cover;

import java.util.*;

public class Zbior {
    private Set<Skladnik> skladnikiZbioru = new HashSet<>();

    public void dodajSkladnikDoZbioru(Skladnik skladnik) {
        skladnikiZbioru.add(skladnik);
    }

    Set<Integer> wspolneElementyTegoZbioruIZbioruDoPokrycia(ZbiorDoPokrycia zbiorDoPokrycia) {
        Set<Integer> wspolneElementy = new HashSet<>();

        for (Skladnik skladnik : skladnikiZbioru) {
            wspolneElementy.addAll(skladnik.wspolneElementySkladnikaZeZbiorem(zbiorDoPokrycia));
        }

        return wspolneElementy;
    }


}
