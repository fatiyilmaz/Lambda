import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {
        /*
            eger biz ilave birseyler yazmadan  hazir java methodlarindan cagiriyor isek "Method  reference" ;
            biz ilave biseyler yaziyor isek "lambda expression"  oluyor.
         */

        List<Integer>sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));

        ciftKarePrint(sayi);
        System.out.println("\n *********");
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n *********");
        ciftKareKokPrint(sayi);
        System.out.println("\n *********");
        maxElBul(sayi);
        System.out.println("\n *********");
        structuredMaxElBul(sayi);
        System.out.println("\n *********");
        ciftKareMaxPrint(sayi);
        System.out.println("\n *********");
        elTopla(sayi);
        System.out.println("\n *********");
        elCarp(sayi);
        System.out.println("\n *********");
        minBul(sayi);
        System.out.println("\n *********");
        bestenBykTekKck(sayi);
        System.out.println("\n *********");
        ciftKarekbSortPrint(sayi);

    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKarePrint(List<Integer>sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).// akistaki cift sayilari filtreledim
                map(t->t*t).// 16,4,36 -- Stream icerisindeki elemanlarin baska degerlere donusturur
                forEach(Lambda01::yazdir);//16 4 36

    }

    // Task-2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz
    public static void tekKupBirFazlaPrint(List<Integer>sayi){
        sayi.
                stream().// (4,2,6,11,-5,7,3,15)
                filter(t->t%2!=0).// 11 -5 7 3 15
                map(t->(t*t*t)+1).// kuplerinin +1 fazlasi. -Akisin icindeki elemanlarda degisiklik oldugunda map kullaniriz.
                forEach(Lambda01::yazdir);//1332 -124 344 28 3376
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKareKokPrint(List<Integer>sayi){
        sayi.stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).// double
                forEach(t-> System.out.println(t+ " "));//2.0 //1.4142135623730951 //2.449489742783178


    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz
    public static void maxElBul(List<Integer>sayi){
        Optional<Integer>maxSayi = //optional kullanmak istemiyorsak lambda expression kullanicaz kullanirsak compile time exeption dan kacmis oluruz
                sayi.
                stream().
                reduce(Math::max);// eger benim result'im tek bir deger ise o zaman reduce terminal opr. kullanilir.
        System.out.println(maxSayi);//Optional[15]
    }

    //Structured yapi ile cozelim
    public static void structuredMaxElBul(List<Integer>sayi){
        int max = Integer.MIN_VALUE;
        System.out.println("max= " +max);
        for (int i=0; i<sayi.size(); i++){
            if (sayi.get(i)>max)max = sayi.get(i);
        }
        System.out.println("en buyuk sayi : "+max);//max= -2147483648  //en buyuk sayi : 15
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxPrint(List<Integer>sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));// Math::max'a gore, Integer::max method'u daha hizli calisir //Optional[36]
    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elTopla(List<Integer>sayi){
        /*
       * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
         bu örnekte 0 oluyor
       * b degerini her zamana  stream()'dan akısdan alır
       * a ilk degerinden sonraki her değeri action(işlem)'dan alır
    */

        int toplam = sayi.
                stream().
                reduce(0,(a,b)->a+b);// .reduce(Integer::sum); de olur. // null pointer gelme ihtimali yok
        System.out.println("toplam = "+toplam);// toplam = 43
    }

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void elCarp(List<Integer>sayi){
        System.out.println(sayi.stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));// Optional[48] //method referance //optinal (farli seylerle ugrasmak) gelme ihtimali var.

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b)));// 48 //nul pointer gelme ihtimali yok
    }
    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void minBul(List<Integer>sayi){
        //1.Yol: method referance
        System.out.println(sayi.
                stream().
                reduce(Integer::min));// Optional[-5]  //Math::min

        //2.Yol: method referance
        System.out.println(sayi.
                stream().//bu akistan degerler verilir
                reduce(Lambda02::byFatihMin));// Optional[-5]
    }
    public static int byFatihMin(int a, int b){
        return a<b ? a : b;// orn; byMiracMin(4,9) ilk taraf dogru a yi aliriz a 4'tur.
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykTekKck(List<Integer>sayi){
        System.out.println(sayi.
                stream().
                filter(a -> a > 5 && a % 2 == 1).
                reduce(Lambda02::byFatihMin));// Optional[7]
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKarekbSortPrint(List<Integer>sayi){
        sayi.
                stream().// akisi baslattik
                filter(Lambda01::ciftBul).// akis icindeki cift sayilari aldim
                map(t->t*t).// sayilarin karesi ile yeni bir akis olusturdum
                sorted().// akis icindeki sayilari natural-order(kucukten-buyuge) siraladim
                forEach(Lambda01::yazdir);// akisdaki, sayilari ekrana yazdim //4 16 36
    }




}