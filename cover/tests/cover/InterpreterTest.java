//package cover;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class InterpreterTest {
//
//    @Test
//    void sprawdzPrzykladZZadania() {
//        String przyklad = "-3 1 -3 2 -2 3";
//
//        String output = "0\n" +
//                "1 2 5\n" +
//                "2 5\n" +
//                "2 5\n" +
//                "1 2 5 6 7\n" +
//                "2 5 6 7\n" +
//                "2 5 6 7\n" +
//                "1 2 5 6 7\n" +
//                "2 5 6 7\n" +
//                "5 6 8\n";
//
//        Scanner scaner = new Scanner(przyklad);
//        List<Integer> lista = Main.zapiszWejscieNaListe(scaner);
//        //System.out.println(lista.toString());
//        Interpreter interpreter = new Interpreter(lista);
//        interpreter.zinterpretujWejscie();
//    }
//}