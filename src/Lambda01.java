import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {

        /*
      1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.

*/

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34,22,16,11,35,20,63,21,65,44,66,64,81,38,15));

        printElStructered(sayi);
        System.out.println("\n***************");
        printElFunctional(sayi);
        System.out.println("\n***************");
        printElFunctional1(sayi);
        System.out.println("\n***************");
        printElFunctional2(sayi);
        System.out.println("\n***************");
        printCiftElFunctional(sayi);
        System.out.println("\n***************");
        printCiftElStructured(sayi);
        System.out.println("\n***************");
        printCiftOtzBykFunctional(sayi);
        System.out.println("\n***************");
        printCiftOtzKckFunctional(sayi);
        System.out.println("\n***************");
        printCiftOtzKckFunctional1(sayi);




    }

    //TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElStructered (List<Integer> sayi){
        for (int w: sayi) {
            System.out.print(w+ " ");
        }
    }

    //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElFunctional (List<Integer> sayi){
        sayi.
                stream(). //ben burda lambda expressionlari kullancam stream key le diyorum java'ya.
                forEach((k)-> System.out.print(k+ " ")); //lambda expression == nasil calisacagini soyluyorum
    }

    public static void printElFunctional1 (List<Integer> sayi){
        sayi.
                stream(). //system classina git out'a gir ordan da printi getir bana
                forEach(System.out::print); //method referance == ne yapicagini soyluyorum
    }

    //----> kendimiz bir method olusturalim == rakamlar yanyana bosluklu gozuksun istiyorum
    public static void yazdir(int a){
        System.out.print(a + " ");
    }

    public static void yazdir(String a){
        System.out.print(a + " ");
    }

    public static void printElFunctional2 (List<Integer> sayi){
        sayi.
                stream(). //forEach bir terminal operatorudur
                forEach(Lambda01::yazdir); //method referance // Lambda01.yazdir() diye de cagirabilirim ama
                                                              // Lambda01.yazdir(). dedikten sonra baska method cagiramam.
    }

    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    // -> = arrow functional
    public static void printCiftElFunctional (List<Integer> sayi){
        sayi.
                stream().
                filter(t -> t % 2 == 0). // lambda expression
                forEach(Lambda01::yazdir);
    }

    //yukaridaki Task'i filter() kismini method referance ile yapalim

    public static boolean ciftBul(int a){
        return a%2 ==0;
    }

    public static void printCiftElFunctional1 (List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul). // method referance //imkan varsa method referance kullanilir
                forEach(Lambda01::yazdir);
    }

    //TASK  : Structural Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElStructured (List<Integer> sayi){
        for (Integer w:sayi) {
            if (w%2==0){
                System.out.print(w+ " ");
            }
        }
    }

    //Yukaridaki functional yapidaki filter methodunun icini method referance ile yapalim.
    //en uygulanabilir method, method referance'dir yeni bir method olusturmak. Daha dinamik ve okunabilir olmasi icin.

    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOtzKckFunctional (List<Integer> sayi){

        sayi.
                stream().
                filter(t -> t %2==0).
                filter(t -> t <34).
                //filter(t -> t %2 == 0 && t <34).  Boyle de olur.
                forEach(Lambda01::yazdir);
    }

    //TASK :Structural Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    //Odev

    public static void printCiftOtzKckFunctional1 (List<Integer> sayi){
        for (Integer w : sayi){
            if (w%2==0 && w<34){
                System.out.print(w+ " ");
            }
        }
    }

    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOtzBykFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t -> t %2 ==0 || t > 34 ). // odev method create yaparak cagirarak yap.
                forEach(Lambda01::yazdir); //forEach((t) -> System.out.print(t+ " "));
    }



}
