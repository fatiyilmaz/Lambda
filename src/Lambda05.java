import jdk.jshell.spi.ExecutionControl;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {

        System.out.println(topla(5));//15
        System.out.println(toplaCincix(5));//15
        System.out.println(ciftTamsayiTopla(6));
        System.out.println(xPozitifCiftTamsayiTopla(4));//20
        System.out.println(toplaIlkXCift(4));//20
        System.out.println(pztfTekTamSayi(3));//9
        ikininXKuvveti(3);//2 4 8
        System.out.println();
        istenilenKuvvet(3,2);//3 9
        //kullanicidan almak istersek
        //int istenenSayi = Scanner.nextInt();
        //int kuvvet = Scanner.nextInt();
        //istenilenKuvvet(istenilenKuvvet,kuvvet);
        System.out.println();
        System.out.println(istenenSayiFactorial(5));//120
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.

    //Structured
    public static int topla(int x){
        int toplam = 0;
        for (int i=0; i<=x; i++){
            toplam=toplam+i;
        }
        return toplam;
    }

    //Functional
    public static int toplaCincix(int x){// IntStream ==> List<Integer> x
        return IntStream.//int degerler de bir akis saglar. Akisi int data turunde sagliyoruz. List<Integer> x varmis gibi, --> x.stream().
                range(1,x+1).//range(a+b) --> a dan b ye kadar (b dahil degil) int degerler akisa alindi
                sum();//akistan gelen degerler toplandi
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftTamsayiTopla(int x){
        return IntStream.
                rangeClosed(1,x).//range(). 1 dahil 2 dahil degil , rangeClosed() 1 dahil 2 dahil , 1 den x' e kadar ilerler
                filter(Lambda01::ciftBul).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int xPozitifCiftTamsayiTopla(int x){
        return IntStream.
                rangeClosed(1,x * 2).
                filter(Lambda01::ciftBul).
                sum();
    }
    //range bazen sorun yaratabilir ama iterate hicbir zaman sorun yaratmaz
    public static int toplaIlkXCift(int x){
        return IntStream.
                iterate(2,t->t+2).//2 den sonsuza kadar elemanlari 2 arttirarak akisa alir --> 2 4 6 8... sonsuza kadar.
                limit(x).//x ile sinirliyorum , memoryi bosuna harcamasin istedim
                sum();//akistan gelen butun degerleri topluyorum
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int pztfTekTamSayi(int x){
        return IntStream.
                iterate(1,t->t+2).//1,3,5,7,9......
                limit(x).//ilk x tek tamsayi ile sinirlandirildi
                sum();//akistan gelen int degerler toplandi
    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininXKuvveti(int x){
      IntStream.
              iterate(2,t->t*2).//iterasyon icin sartimizi yazdik
              limit(x).//x degeri ile sinirladik
              forEach(Lambda01::yazdir);//Lambda01 classindaki yazdir() methodunu cagirarak ekrana yazdik
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenilenKuvvet(int istenenSayi, int x){
        IntStream.iterate(istenenSayi,t->t*istenenSayi).limit(x).forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    //5-->5*4*3*2 3-->3*2
    public static int istenenSayiFactorial(int x) {  // 5
        return IntStream. // int akış başladı
                rangeClosed(1,x). // rangeClosed(1,5) --> 1,2,3,4,5
                reduce(1,(t,u)->t*u);
    }

}
