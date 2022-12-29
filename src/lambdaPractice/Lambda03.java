package lambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda03 {
    public static void main(String[] args) {
        Apartman daire1=new Apartman("dogu",3,4000);
        Apartman daire2=new Apartman("bati",2,2500);
        Apartman daire3=new Apartman("guney",1,3500);
        Apartman daire4=new Apartman("dogu",5,3000);

        List<Apartman> kiralikDaireler=new ArrayList<>(Arrays.asList(daire1,daire2,daire3,daire4));

        doguKirayaSirala(kiralikDaireler);
        //ApartmanPojo{cephe='dogu', katSayisi=5, kira=3000}
        //ApartmanPojo{cephe='dogu', katSayisi=3, kira=4000}

        System.out.println(ikidenCokDaire(kiralikDaireler));//elimdeki listi gorebilmek icin yazdirmam gerekiyor yani sout yapmam gerekiyor.
        //[4000, 3000]
        kirasi3000denCokDairelerinKatSayisi(kiralikDaireler);//Optional[ApartmanPojo{cephe='guney', katSayisi=1, kira=3500}]
    }

    //Soru 1: dogu cephesindeki kiralık daireleri kiralarına göre sıralayın
    public static void doguKirayaSirala(List<Apartman>list){
        list.stream().filter(t->t.getCephe().equalsIgnoreCase("dogu")).//cephesi dogu olan daireleri filtreledim
        sorted(Comparator.comparing(Apartman::getKira)).forEach(System.out::print);
    }

    //Soru 2: kat sayısı 2den cok olan dairelerin kiralarını listeleyın
    public static List<Integer> ikidenCokDaire(List<Apartman>list){
        return
        list.stream().filter(t->t.getKatSayisi()>2).//kat sayisi 2den cok olan daireler
                map(t->t.getKira()).//objeyi int ifadeyi dondurme kiralari alma
                collect(Collectors.toList());//return keywordu ile list'e dondurdum
    }

    //Soru 3: kirası 3000den cok olan dairelerin kat sayısı en az olanı yazdırın

    public static void kirasi3000denCokDairelerinKatSayisi(List<Apartman>list){
        //findFirst() gorunumdeki ilk elemani alir
        System.out.println(list.stream().filter(t -> t.getKira() > 3000).sorted(Comparator.comparing(Apartman::getKatSayisi)).findFirst());
    }

}
