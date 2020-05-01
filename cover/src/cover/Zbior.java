package cover;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zbior {
    List<Skladnik> skladnikiZbioru;

    void dodajSkladnikDoZbioru(Skladnik skladnik) {
        skladnikiZbioru.add(skladnik);
        return;
    }

    Set<Integer> wspolneElementyTegoZbioruIZbioruDoPokrycia(ZbiorDoPokrycia zbiorDoPokrycia) {
        Set<Integer> wspolneElementy = new HashSet<>();

        for (Skladnik skladnik : skladnikiZbioru) {
            wspolneElementy.addAll(skladnik.wspolneElementySkladnikaZeZbiorem(zbiorDoPokrycia));
        }

        return wspolneElementy;
    }


}
