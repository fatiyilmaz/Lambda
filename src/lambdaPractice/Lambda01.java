package lambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

        boslukluYazdir(list);
        System.out.println();
        negatifYazdir(list);
        System.out.println();
        pozitifYazdir(list);
        System.out.println();
        pozitifCiftYazdir(list);
        System.out.println();
        pozitifveyaCiftYazdir(list);
        System.out.println();
        kareYazdir(list);
        System.out.println();
        ciftKupYazdir(list);
        System.out.println();
        listElTekrarsiz(list);
        System.out.println();
        listElKucuktenBuyuge(list);
        System.out.println();
        listElBuyuktenKucuge(list);
        System.out.println();
        System.out.println("pozitifElKupleri(list) = " + pozitifElKupleri(list));
        System.out.println();
        pozitifElKupleri2(list);
        System.out.println();
        System.out.println("pozitifElKaraleri1Basamak(list) = " + pozitifElKaraleri1Basamak(list));
        System.out.println();
        System.out.println("listElToplam() = " + listElToplam(list));
        System.out.println();
        System.out.println("listElToplamReference() = " + listElToplamReference(list));
        System.out.println();
        System.out.println("listElToplamReferenceInt() = " + listElToplamReferenceInt(list));
        System.out.println();
        pozitifElToplam(list);
    }

    // S1:listi aralarinda bosluk birakarak yazdiriniz
    public static void boslukluYazdir (List<Integer>sayi){
        sayi.stream().forEach(t-> System.out.print(t+" "));//-5 -8 -2 -12 0 1 12 5 5 6 9 15 8

    }

    //S2: sadece negatif olanlari yazdir
    public static void negatifYazdir (List<Integer>sayi){
    sayi.stream().filter(t -> t < 0).forEach(t-> System.out.print(t+" "));//-5 -8 -2 -12

    }
    //S3: cift olanlardan yeni bir liste olustur
    public static void pozitifYazdir (List<Integer>sayi){
        sayi.stream().filter(t -> t%2==0).forEach(t-> System.out.print(t+" "));//-8 -2 -12 0 12 6 8

    }
    //S4:pozitif ve ??ift olanlar?? yazd??r??n
    public static void pozitifCiftYazdir (List<Integer>sayi){
        sayi.stream().filter(t->t%2==0 && t>0).forEach(t-> System.out.print(t+" "));//12 6 8
    }

    //S5:pozitif veya ??ift olanlar?? yazd??r??n
    public static void pozitifveyaCiftYazdir (List<Integer>sayi){
        sayi.stream().filter(t->t%2==0 || t>0).forEach(t-> System.out.print(t+" "));//-8 -2 -12 0 1 12 5 5 6 9 15 8
    }

    // S6: list in elemanlarin karelerini ayn?? sat??rda b??r bosluklu yazd??ral??m
    public static void kareYazdir (List<Integer>sayi){
        //map():stream den gelen elemanlar?? baska tt??plere donusturmek veya uzerler??nde
        //??slem yapmak ??c??n (update) kullan??l??
        sayi.stream().map(t->t*t).forEach(t-> System.out.print(t+" "));//25 64 4 144 0 1 144 25 25 36 81 225 64
    }
    //S7: Listin cift elemanlar??n??n kuplerini  ayn?? sat??rda b??r bosluklu yazd??ral??m
    public static void ciftKupYazdir (List<Integer>sayi){
        sayi.stream().filter(t->t%2==0).map(t->t*t*t).forEach(t-> System.out.print(t+" "));//-512 -8 -1728 0 1728 216 512
    }

    //S8 : list in elemanlarin karelerinden tekrarsiz yazd??ral??m
    public static void listElTekrarsiz (List<Integer>sayi){
        //distinct() => Bu method tekrarl?? elemanlar?? sadece bir kere ak??sa sokar.
        // Bu ak??????n farkl?? elemanlar??ndan (Object.equals (Object) 'e g??re) olu??an bir ak???? d??nd??r??r.
        // S??ral?? ak????lar i??in, farkl?? eleman??n se??imi sabittir
        // (yinelenen ????eler i??in, kar????la??ma s??ras??nda ilk g??r??nen ????e korunur.)
        // S??ras??z ak????lar i??in, herhangi bir kararl??l??k garantisi verilmez. Stream return eder.
        sayi.stream().map(t->t*t).distinct().forEach(t-> System.out.print(t+" "));//25 64 4 144 0 1 36 81 225
    }
    //S9: listin elemanlarini kucukten buyuge siralayalim
    public static void listElKucuktenBuyuge (List<Integer>sayi){
        sayi.stream().sorted().forEach(t-> System.out.print(t+" "));//-12 -8 -5 -2 0 1 5 5 6 8 9 12 15
    }
    //S10: listin elemanlarini buyukten kucuge siralayalim
    public static void listElBuyuktenKucuge (List<Integer>sayi){
        //sorted() methodunun icinde Comparator.reverseOrder() methodunu uygulayinca buyukten kucuge siralariz.
        sayi.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));//15 12 9 8 6 5 5 1 0 -2 -5 -8 -12
    }
    //S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    //1.Yol;
    public static List<Integer> pozitifElKupleri (List<Integer>sayi){
        return sayi.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());//pozitifElKupleri(list) = [125, 125, 3375]
    }
    //S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    //2.Yol;
    public static void pozitifElKupleri2 (List<Integer>sayi){
        List<Integer>list=sayi.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
        System.out.println(list);//[125, 125, 3375]
    }
    //S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> pozitifElKaraleri1Basamak (List<Integer>sayi){
        List<Integer>list=sayi.stream().filter(t->t>0).map(t->t*t).filter(t->t%10!=5).collect(Collectors.toList());//pozitifElKaraleri1Basamak(list) = [1, 144, 36, 81, 64]
        return list;
    }

    /*
      reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
      kullan??m?? yayg??nd??r pratiktir.
      Bir Stream i??erisindeki verilerin teker teker i??lenmesidir. Teker teker i??leme s??recinde, bir ??nceki ad??mda elde edilen sonu??
      bir sonraki ad??ma girdi olarak sunulmaktad??r. Bu sayede y??????lml?? bir hesaplama s??reci elde edilmi?? olmaktad??r.
      reduce metodu ilk parametrede identity de??eri, ikinci parametrede ise BinaryOperator t??r??nden bir obj kullan??l??r.
      reduce i??leminde bir ??nceki hesaplanm???? de??er ile s??radaki de??er bir i??leme tabi tutulmaktad??r.
      ????leme ba??larken bir ??nceki de??er olmad?????? i??in bu de??er identity parametresinde tan??mlanmaktad??r.
*/

    // S13 :list elemanlarini toplamini bulalim
    public static int listElToplam (List<Integer>sayi){
        //1.Yol;
        //Lambda experisson
        //identity (baslangic) degeri 0 cunku toplama icin etkisiz eleman 0 dir.
        int i =sayi.stream().reduce(0,(x,y)->x+y);
        return i;//listElToplam() = 34
    }
    public static int listElToplamReference (List<Integer>sayi){
        //2.Yol;
        int i=sayi.stream().reduce(0,Math::addExact);
        return i;//listElToplamReference() = 34
    }
    public static int listElToplamReferenceInt (List<Integer>sayi){
        //3.Yol;
        int i=sayi.stream().reduce(0,Integer::sum);//carpim isterce carpimin etkisiz elemani 1 oldugundan identity 1 olurdu.
        return i;//listElToplamReferenceInt() = 34
    }
    //S14 : Listin pozitif elemanlar?? toplam??n?? bulal??m
    public static void pozitifElToplam (List<Integer>sayi){
        System.out.println(sayi.stream().filter(t -> t > 0).reduce(0, Integer::sum));//61

    }



}
