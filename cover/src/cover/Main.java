package cover;

import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        return;
    }
}


//        Set<Integer> os = new HashSet<>();
//        os.add(1);
//        os.add(2);
//        os.add(3);
//        Dokladny dokladny = new Dokladny();

//        List<Set<Integer>> a = dokladny.zbiorPotegowy(os, );
//
//        Integer[] al = new Integer[a.get(0).size()];
//        Set<Integer> ala = new HashSet<>();
//        ala = a.get(0);
//        ala.toArray(al);
//        ala.toArray(al);

//System.out.println(a.toString());

//}

//    static void podzbiory(List<Integer> l, int n, int k, int m) //l - stos na którym mamy aktualne elementy podzbioru,
//    // n-ile jeszcze mamy dołożyć, k- maksymalna wartość elementu który możemy dołozyć, m- minimalna wartość
//    {
//        if (n == 0) {
//            listaPodzbiorow.add(l);
//            System.out.println(l.toString());
//        } else
//            for (int i = m; i <= k; i++) {
//                l.add(i);
//                podzbiory(l, n - 1, k, i + 1);
//                l.remove(l.size() - 1);
//            }
//    }

//    static void podzbiory(List<Integer> l, int n, int k, int m) //l - stos na którym mamy aktualne elementy podzbioru,
//    // n-ile jeszcze mamy dołożyć, k- maksymalna wartość elementu który możemy dołozyć, m- minimalna wartość
//    {
//        if (n == 0) {
//            this.listaPodzbiorow.add(l);
//            System.out.println(l.toString()); //wypisanie całej zawartości stosu
//        } else
//            for (int i = m; i <= k; i++) {
//                l.add(i);
//                podzbiory(l, n - 1, k, i + 1);
//                l.remove(l.size() - 1);
//            }
//    }


//    interface Filter<T> {
//        boolean matches(T t);
//    }
//
//    public static void main(String... args) throws IOException {
//        Integer[][] arrayOfSets = {
//                {1, 2, 3, 8, 9, 10},
//                {1, 2, 3, 4, 5},
//                {4, 5, 7},
//                {5, 6, 7},
//                {6, 7, 8, 9, 10},
//        };
//        Integer[] solution = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//
//        List<Set<Integer>> listOfSets = new ArrayList<Set<Integer>>();
//        for (Integer[] array : arrayOfSets)
//            listOfSets.add(new LinkedHashSet<Integer>(Arrays.asList(array)));
//        final Set<Integer> solutionSet = new LinkedHashSet<Integer>(Arrays.asList(solution));
//
//        Filter<Set<Set<Integer>>> filter = new Filter<Set<Set<Integer>>>() {
//            public boolean matches(Set<Set<Integer>> integers) {
//                Set<Integer> union = new LinkedHashSet<Integer>();
//                for (Set<Integer> ints : integers)
//                    union.addAll(ints);
//                return union.equals(solutionSet);
//            }
//        };
//
//        Set<Set<Integer>> firstSolution = shortestCombination(filter, listOfSets);
//        System.out.println("The shortest combination was " + firstSolution);
//    }
//
//
//    private static <T> Set<T> shortestCombination(Filter<Set<T>> filter, List<T> listOfSets) {
//        final int size = listOfSets.size();
//        int combinations = 1 << size;
//        System.out.println("combinations: " + combinations);
//        List<Set<T>> possibleSolutions = new ArrayList<Set<T>>();
//        for (int l = 0; l < combinations; l++) {
//            Set<T> combination = new LinkedHashSet<T>();
//            for (int j = 0; j < size; j++) {
//                if (((l >> j) & 1) != 0) {
//                    combination.add(listOfSets.get(j));
////                    System.out.println(("l: " + l));
////                    System.out.println("j: " + j);
////                    System.out.println("(l >> j): " + (l >> j));
//                }
//            }
//            System.out.println(combination.toString());
//            possibleSolutions.add(combination);
//        }
//        // the possible solutions in order of size.
//        Collections.sort(possibleSolutions, new Comparator<Set<T>>() {
//            public int compare(Set<T> o1, Set<T> o2) {
//                return o1.size() - o2.size();
//            }
//        });
//        for (Set<T> possibleSolution : possibleSolutions) {
//            if (filter.matches(possibleSolution))
//                return possibleSolution;
//        }
//        return null;
//    }

