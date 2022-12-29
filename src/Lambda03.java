import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        //forEach(t-> System.out.print(t+" ")); ve forEach(Lambda01::yazdir); farki;
        //biri lambda expression , diğeri method referance ikiside aynı işi yapıyor.

        List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havucDilim","guvec","kokorec",
                "küşleme","arabAşı","waffle","künefe","guvec"));
        alfabetikBuyukHarfVeTekrarsiz(menu);
        System.out.println();
        chrTersSiraliTekrarsiz(menu);
        System.out.println();
        chrSayisiniKcktenBuyugeTekrarsiz(menu);
        System.out.println();
        elKrktrSayisi(menu);
        System.out.println();
        elKontrolEtme(menu);
        System.out.println();
        xIleBitiyormu(menu);
        System.out.println();
        krktrSayisiEnbuyukEl(menu);
        System.out.println();
        ilkElHaricSonHarfSiraliPrint(menu);
    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve tekrarsiz print ediniz.
    public static void alfabetikBuyukHarfVeTekrarsiz (List<String>yemek){
        yemek.
                stream().//akis basladi
                map(String::toUpperCase).//buyuk harf
                sorted().//dogal siralandi (alfabetik)
                distinct().//elemanlarin tekrarsiz olmasini sagladi
                forEach(t-> System.out.print(t+" "));//print //ARABAŞI GUVEC HAVUCDILIM KOKOREC KÜNEFE KÜŞLEME TRILEÇE WAFFLE
    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz.
    public static void chrTersSiraliTekrarsiz(List<String>yemek){//parametre ismi (yemek) degisince bir sey farketmiyor.
        yemek.
                stream().//akis alindi
                map(String::length).//akisi guncelledim,kelimelerin uzunlugu olarak
                sorted(Comparator.reverseOrder()).//ters sirali
                distinct().//tekrarsiz
                forEach(Lambda01::yazdir);//print //10 7 6 5
    }

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz.
    public static void chrSayisiniKcktenBuyugeTekrarsiz(List<String>yemek){
        yemek.
                stream().//akis saglandi
                sorted(Comparator.comparing(String::length)).//string ifadeleri karakter
                //sayisina gore k->b ye gore siraladim
                forEach(Lambda01::yazdir);//print //guvec guvec waffle künefe trileçe kokorec küşleme arabAşı havucDilim
    }

    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elemanlarinin hepsinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void elKrktrSayisi(List<String>yemek){
        System.out.println(yemek.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanlari 7 ve daha az harften olusuyor" : ("list elemanlarinin tamami 7 harften buyuk")); //ist elemanlarinin tamami 7 harften buyuk
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void elKontrolEtme(List<String>yemek){
        System.out.println(yemek.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile yemek ismi mi olur" : "w ile yemek icat ettik");
    }
    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı var mi kontrol ediniz.
    public static void xIleBitiyormu(List<String>yemek){
        System.out.println(yemek.stream().anyMatch(t -> t.endsWith("x")) ? "x ile bitiyor" : "x ile bitmiyor");
    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void krktrSayisiEnbuyukEl(List<String>yemek){
        Stream<String> sonIsim=yemek.
                stream().
                sorted(Comparator
                        .comparing(t->t.toString().length()).
                        reversed()).//karakter sayisina gore tersten siralanci
                limit(1);//limit methodu kullanilarak sadece ilk eleman cagrildi 2 desek ilk 2 olur.
                //limit() methodunun donen degeri Stream<String> yapidadir

        System.out.println(Arrays.toString(sonIsim.toArray()));//[havucDilim]
        //sonIsim.toArray() --> Stream olan akis Array'e cevrildi
        //Arrays.toString(sonIsim.toArray() --> Arrayi String yapiya ceviriyor
    }
    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHaricSonHarfSiraliPrint(List<String>yemek){
        yemek.
                stream().//akis saglandi
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).//son harfine gore alfabetik siralandi
                skip(1).//akisdaki ilk eleman haric tutuldu
                forEach(Lambda01::yazdir);//print //kokorec guvec trileçe küşleme waffle künefe havucDilim arabAşı
    }

}
