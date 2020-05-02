package cover;

import java.math.BigInteger;
import java.util.*;

public class Dokladny extends Algorytm {

    @Override
    public List<Integer> znajdzNumeryZbiorowPokrywajacych(List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia) {

        int rozmiar = rodzinaZbiorow.size();
        List<Integer> zbior = new ArrayList<>(rozmiar);
        for (int i = 0; i < rozmiar; i++) {
            zbior.add(i + 1);
        }

        BigInteger podniesioneOJeden = BigInteger.ONE.shiftLeft(rozmiar);
        List<Set<Integer>> kandydaci = new LinkedList<>();
        for (BigInteger i = BigInteger.ONE; i.compareTo(podniesioneOJeden) < 0; i = i.add(BigInteger.ONE)) {
            Set<Integer> podzbior = podzbiorZBigInteger(zbior, i);
            if (czyZbioryOPodanychNumerachPokrywajaZbior(podzbior, rodzinaZbiorow, zbiorDoPokrycia)) {
                if (kandydaci.isEmpty()) {
                    kandydaci.add(podzbior);
                } else if (podzbior.size() < wielkoscNajmniejszegoZbioru(kandydaci)) {
                    kandydaci.add(podzbior);

                }
            }
        }


        if (!kandydaci.isEmpty()) {
            List<Integer> najlepszyKandydat = new ArrayList<>(kandydaci.get(kandydaci.size() - 1).size());
            najlepszyKandydat.addAll(kandydaci.get(kandydaci.size() - 1));
            return najlepszyKandydat;
        } else {
            List<Integer> najlepszyKandydat = new ArrayList<>(1);
            najlepszyKandydat.add(0);
            return najlepszyKandydat;
        }

    }


    public Set<Integer> podzbiorZBigInteger(List<Integer> zbior, BigInteger subset) {
        Set<Integer> podzbior = new HashSet<>();
        int i = 0;
        for (Integer element : zbior) {
            if (subset.testBit(i)) {
                podzbior.add(element);
            }
            i++;
        }
        return podzbior;
    }


    boolean czyZbioryOPodanychNumerachPokrywajaZbior(Set<Integer> numery, List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia) {
        Integer[] numeryZbiorow = new Integer[numery.size()];
        numery.toArray(numeryZbiorow);
        Set<Integer> kopiaZbioruDoPokrycia = zbiorDoPokrycia.stworzZbiorDoPokrycia();

        Set<Integer> wspolneElementyZbiorowOPodanychNumerach = new HashSet<>();

        for (Integer i : numeryZbiorow) {
            if (i != 0) {
                Set<Integer> wspolne = rodzinaZbiorow.get(i - 1).wspolneElementyTegoZbioruIZbioruDoPokrycia(zbiorDoPokrycia);
                wspolneElementyZbiorowOPodanychNumerach.addAll(wspolne);

            }
        }
        //System.out.println("wspolneElementyZbiorowOPodanychNumerach: " + wspolneElementyZbiorowOPodanychNumerach);
        //System.out.println(kopiaZbioruDoPokrycia.toString());
        // System.out.println(wspolneElementyZbiorowOPodanychNumerach.containsAll(kopiaZbioruDoPokrycia));
        return wspolneElementyZbiorowOPodanychNumerach.containsAll(kopiaZbioruDoPokrycia);
    }


    Integer wielkoscNajmniejszegoZbioru(List<Set<Integer>> listaZbiorow) {
        int minimalna = 0;
        for (Set<Integer> zbior : listaZbiorow) {
            if (minimalna == 0) {
                minimalna = zbior.size();
            }
            if (zbior.size() < minimalna) {
                minimalna = zbior.size();
            }
        }
        return minimalna;
    }
//    boolean czyPodaneNumeryZbiorowPokrywajaZbior(List<Integer> numeryZbiorow, List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia) {
//        Set<Integer> listaZbiorowDoSprawdzenia = new HashSet<>();
//        for (Integer i : numeryZbiorow) {
//            listaZbiorowDoSprawdzenia.add(rodzinaZbiorow.get(i));
//        }
//        if ()
//    }
}

//    @Override
//    public List<Integer> znajdzNumeryZbiorowPokrywajacych(List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia) {
//        List<Set<Integer>> kandydaci = new LinkedList<Set<Integer>>();
//        List<Set<Integer>> zbiorPotegowy = zbiorPotegowy(stworzZbiorKandydatowDoPokrycia(rodzinaZbiorow));
//        Set<Integer> doPokrycia = zbiorDoPokrycia.stworzZbiorDoPokrycia();
//        List<Integer> znalezionyZbior = new LinkedList<>();
//
//        for (int i = 0; i < zbiorPotegowy.size(); i++) {
//
//            if (zbiorPotegowy.get(i).containsAll(doPokrycia)) {
//                kandydaci.add(zbiorPotegowy.get(i));
//            }
//        }
//
//        znalezionyZbior = znajdzNajmniejszegoKandydata(kandydaci);
//        return znalezionyZbior;
//    }
//    public List<Set<Integer>> zbiorPotegowy(Set<Integer> zbior) {
//        List<Set<Integer>> zbiory = new LinkedList<Set<Integer>>();
//        if (zbior.isEmpty()) {
//            zbiory.add(new HashSet<Integer>());
//            return zbiory;
//        }
//        List<Integer> lista = new ArrayList<Integer>(zbior);
//        Integer poczatekListy = lista.get(0);
//        Set<Integer> pozostalaCzescListy = new HashSet<Integer>(lista.subList(1, lista.size()));
//        for (Set<Integer> ityZbior : zbiorPotegowy(pozostalaCzescListy)) {
//            Set<Integer> nowyZbior = new HashSet<Integer>();
//            nowyZbior.add(poczatekListy);
//            nowyZbior.addAll(ityZbior);
//            zbiory.add(nowyZbior);
//            zbiory.add(ityZbior);
//            System.out.println(ityZbior.toString());
//        }
//        return zbiory;
//    }
//    private Set<Integer> stworzZbiorKandydatowDoPokrycia(List<Zbior> rodzinaZbiorow) {
//        Set<Integer> numeryZbiorow = new HashSet<>();
//
//        for (int i = 0; i < rodzinaZbiorow.size(); i++) {
//            numeryZbiorow.add(i + 1);
//        }
//        return numeryZbiorow;
//
//    }
//
//    private List<Integer> znajdzNajmniejszegoKandydata(List<Set<Integer>> kandydaci) {
//        List<Integer> wielkosciKandydatow = new LinkedList<>();
//        List<Integer> listaIndeksowKandydatow = new LinkedList<>();
//
//        for (int i = 0; i < kandydaci.size(); i++) {
//            wielkosciKandydatow.add(kandydaci.size());
//        }
//        Collections.sort(wielkosciKandydatow);
//        int min = wielkosciKandydatow.get(0);
//
//        for (int i = 0; i < kandydaci.size(); i++) {
//            if (kandydaci.get(i).size() == min) {
//                listaIndeksowKandydatow.add(i);
//            }
//        }

//w tym momencie na liscie indeksow kandydatow mamy indeksy tych elementow z kandydatow ktore są minimalne

//        if (listaIndeksowKandydatow.size() == 1) {
//            List<Integer> znalezionyZbior = new LinkedList<>();
//            Integer[] tablica = new Integer[kandydaci.get(listaIndeksowKandydatow.get(0)).size()];
//            kandydaci.get(listaIndeksowKandydatow.get(0)).toArray(tablica);
//            Collections.addAll(znalezionyZbior, tablica);
//            return znalezionyZbior;
//        }

//        List<Integer[]> listaTablicWielkosciNajmniejszychElementow = new ArrayList<Integer[]>();
//
//        for (int numerTegoKandydata : listaIndeksowKandydatow) {
//            Integer[] tablicaTegoKandydata = new Integer[min];
//            kandydaci.get(numerTegoKandydata).toArray(tablicaTegoKandydata);
//            listaTablicWielkosciNajmniejszychElementow.add(tablicaTegoKandydata);
//        }
//        //stworzylismy liste z tablicami elementow ktore teraz mozemy porownywac
//
//        Collections.sort(listaTablicWielkosciNajmniejszychElementow, new Comparator<Integer[]>() {
//            public int compare(Integer[] a, Integer[] b) {
//                return a[a.length - 1] - b[b.length - 1];
//            }
//        });
//        List<Integer> znalezionyZbior = new LinkedList<>();
//        for (int i = 0; i < listaTablicWielkosciNajmniejszychElementow.get(0).length; i++) {
//            System.out.println(listaTablicWielkosciNajmniejszychElementow.get(0)[i]);
//        }
//        Collections.addAll(znalezionyZbior, listaTablicWielkosciNajmniejszychElementow.get(0));
//
//        return znalezionyZbior;
//    }
//

//}
