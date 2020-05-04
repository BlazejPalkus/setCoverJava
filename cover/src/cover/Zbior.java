package cover;

import java.util.*;

public class Zbior {
    private Set<Skladnik> skladnikiZbioru;

    public void dodajSkladnikDoZbioru(Skladnik skladnik) {
        if (skladnikiZbioru == null) {
            skladnikiZbioru = new HashSet<>();
        }

        skladnikiZbioru.add(skladnik);
    }

    public boolean czyZbiorJestPusty() {
        if (skladnikiZbioru == null) {
            return true;
        }
        return false;
    }

    public Set<Integer> wspolneElementyTegoZbioruIZbioruDoPokrycia(ZbiorDoPokrycia zbiorDoPokrycia) {
        Set<Integer> wspolneElementy = new HashSet<>();

        for (Skladnik skladnik : skladnikiZbioru) {
            wspolneElementy.addAll(skladnik.wspolneElementySkladnikaZeZbiorem(zbiorDoPokrycia));
        }


        return wspolneElementy;
    }

    public Set<Integer> wspolneElementyTegoZbioruZInnymZbiorem(Set<Integer> zbior) {
        Set<Integer> wspolneElementy = new HashSet<>();

        for (Skladnik skladnik : skladnikiZbioru) {
            wspolneElementy.addAll(skladnik.wspolneElementyTegoSkladnikaZInnymZbiorem(zbior));
        }

        return wspolneElementy;
    }


    public int wielkosc() {
        return skladnikiZbioru.size();
    }


}
