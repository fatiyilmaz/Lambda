package ssgLambdaString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class lambdaString01 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglencelidi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");

        //Structured Programming
        for (String w : list){
            System.out.println(w);
        }

        System.out.println("=========================");

        //functuonal Programming
        //list.forEach(t-> System.out.println(t+ " "));
        list.forEach(Utils::printInSameLine);

        System.out.println("=========================");
        System.out.println(ilkHarfiDveyaC(list));

        System.out.println("=========================");
        basinaVeSonunaYildizYazdir(list);

        // method referance ==> class name::method
        System.out.println("=========================");
        alfabetikGoreYazdir(list);

        System.out.println("=========================");
        lleriSiliniz(list);
    }

    // S1: ilk harfi d ve ya c olanlari listeleyelim
    public static List<String> ilkHarfiDveyaC (List<String> l){
        System.out.println();
        return l.stream().filter(t->t.startsWith("d") || t.startsWith("c")).collect(Collectors.toList());//[cok, da]
    }

    //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim -- *java*
    public static void basinaVeSonunaYildizYazdir (List<String> l){
        System.out.println();
        l.stream().map(t->"*"+t+"*").forEach(Utils::printInSameLine);
    }

    //S3: alfabetik  olarak siralayalim list olarak
    public static void alfabetikGoreYazdir(List<String> l){
        System.out.println();
        l.stream().sorted().forEach(Utils::printInSameLine);
    }

    //S4: tum ‘l’ leri silelim yazdiralim
    public static void lleriSiliniz(List<String> l){
        System.out.println();
        l.stream().map(t->t.replaceAll("l","")).forEach(Utils::printInSameLine);
    }



}
