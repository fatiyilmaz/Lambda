package lambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Lambda04 {
    public static void main(String[] args) {

        List<String>kelimeler = new ArrayList<>(Arrays.asList("bilgisiyar","leptop","telefon","televizyon","ayna","kamera","kart","monitor"));

        System.out.println(ucIle7arasiAileBiten(kelimeler));//[leptop, ayna, kamera, kart]
        uzunlukVeIkinciHarfleriniBenzersizSirala(kelimeler);
        System.out.println();
        System.out.println(uzunlugu4ve8OlanlarHaric(kelimeler));//[bilgisiyar, leptop, televizyon, kamera, monitor]
        System.out.println(sonHarfeGoreSon3ElPrint(kelimeler));//[bilgisiyar, monitor, kart]

    }
    //S7: uzunlugu 3 ile 7 arası olan veya a ile biten elemanlardan yeni bir liste olustur
    public static List<String> ucIle7arasiAileBiten(List<String>kelimeler){
       return kelimeler.stream().filter(t->t.length()>3 && t.length()<7 || t.toLowerCase().endsWith("a")).collect(Collectors.toList());

    }

    //S8:list elemanlarını uzunluklarına ve ikinci harflerine göre benzersiz sıralayıp yazdırın
    public static void uzunlukVeIkinciHarfleriniBenzersizSirala(List<String>kelimeler){
        kelimeler.stream().sorted(Comparator.comparing(String::length)).sorted(Comparator.comparing(t->t.substring(1,2))).distinct().forEach(t-> System.out.print(t+" "));
    }

    //S9: uzunlugu 4 ve 8 olanlar haric bir liste olusturunuz
    public static List<String> uzunlugu4ve8OlanlarHaric(List<String>kelimeler){
        return kelimeler.stream().filter(t->t.length()!=4 && t.length()!=8).collect(Collectors.toList());
    }

    //S10: List elemanlarını son harfe göre sıralayıp, son 3 elemanı yazdırın
    public static List<String> sonHarfeGoreSon3ElPrint(List<String>kelimeler){
       return kelimeler.stream().sorted(Comparator.comparing(t->t.charAt(t.length()-1))).skip(kelimeler.size()-3).collect(Collectors.toList());

    }

}
