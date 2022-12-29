import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {

         /*
     Pojo(Plain Old Java Object) Class nedir
1)Variable ları private olan (Encapsulation yapılmış olan)
2)Bir parametresiz birde parametreli Constructor olan
3)Getter ve Setter methodlar olan
4)toString() methodu olan
 Class'lara kısaltma isim olarak Pojo(Plain Old Java Object) Class denir
     */

        /*
           TASK :
           fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
       */
        UnivercityPojo u01 = new UnivercityPojo("bogazici","matematik",571,93);
        UnivercityPojo u02 = new UnivercityPojo("istanbul tk","matematik",600,81);
        UnivercityPojo u03 = new UnivercityPojo("istanbul","hukuk",1400,71);
        UnivercityPojo u04 = new UnivercityPojo("marmara","bilgi muh",1080,71);
        UnivercityPojo u05 = new UnivercityPojo("odtu","gemi muh",333,74);
        List<UnivercityPojo>unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));
        System.out.println(notOrt74BykUnv(unv));//false
        System.out.println(matVarMi(unv));//true

        System.out.println(ogrSayisiBykSirala(unv));
        System.out.println(matSiralamasi(unv));//2
        System.out.println(ogrSayisi550BykMaxNotOrt(unv));//OptionalInt[93]
        System.out.println(ogrSayisi1050AzMinNotOrt(unv));//OptionalInt[74]

    }

    //task 01--> butun universitelerin notOrt'larinin 74'den buyuk oldugu kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<UnivercityPojo>unv){
        return unv.
                stream().//akis saglandi univ. geldi u01,u02,u03,u04,u05
                allMatch(t->t.getNotOrt()>74);//false
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matVarMi(List<UnivercityPojo>unv){
       return unv.
               stream().//akis saglandi
               anyMatch(t->t.getBolum().//objelerin bolum isimleri alindi
                       toLowerCase().//bolum isimlerindeki karakterler kucuk harfe cevrildi
                       contains("mat"));//true
    }
    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<UnivercityPojo> ogrSayisiBykSirala(List<UnivercityPojo> unv) {
        return unv.
                stream(). // akış sağlandı
                        sorted(Comparator.comparing(UnivercityPojo::getOgrSayisi).reversed()).
                //Comparator.comparing benim istedigim sekilde sirala demek.
                //reversed() buyukten kucuge siralama
                //universiteler öğrenci sayısına göre terden sıralandı
                        collect(Collectors.toList()); // Stream yapısı List yapısına dönüştürüldü
    }
    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.

    public static int matSiralamasi(List<UnivercityPojo> unv) {
        return (int) unv. //longu int'a (int) cast ettik
                stream().//akis sagladim
                filter(t->t.getBolum().contains("mat")).//matematik bolumu olan unv. sectim
                count();//secilen unv. sayisini aldim
    }

    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrSayisi550BykMaxNotOrt(List<UnivercityPojo> unv) {
        //map()akisi update etmeye yarar
        //mapToInt() int return edeceksem seciyorum java int return edecegimi bildigi icin ekstra methodlar veriyor
         return unv.
                stream().
                filter(t->t.getOgrSayisi()>550).
                mapToInt(t->t.getNotOrt()).
                max();
         //butun wrapper classlarin default degeri null'dir.
         //java 8 bunu optionalla cozmustur
    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrSayisi1050AzMinNotOrt(List<UnivercityPojo> unv) {
       return unv.stream().filter(t->t.getOgrSayisi()<1050).mapToInt(t-> t.getNotOrt()).min();
    }
}
