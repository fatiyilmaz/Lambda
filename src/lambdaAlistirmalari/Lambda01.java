package lambdaAlistirmalari;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    //How to read text from the file
//How to convert all characters in the file to upper case
//How to check if a specific word(Lambda) exists in the text
//Print distinct words on the console in the file
//Get the words which end with "e" and print them on the console
    /*

//Dosyadan metin nasıl okunur
//Dosyadaki tüm karakterler nasıl büyük harfe çevrilir
//Metinde belirli bir kelimenin (Lambda) olup olmadığı nasıl kontrol edilir
//Dosyadaki konsolda farklı sözcükleri yazdır
//"e" ile biten kelimeleri al ve konsola yazdır
     */


    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havucDilim","guvec","kokorec",
                "küşleme","arabAşı","waffle","künefe","guvec"));

        metinOkuma(menu);
        System.out.println();
        tumKrktrByk(menu);




    }
    public static void metinOkuma(List<String> menu){
        menu.stream().forEach(t-> System.out.print(t+" "));

    }

    public static void tumKrktrByk (List<String> menu){
        menu.stream().map(t->t.toUpperCase()).forEach(t-> System.out.print(t+" "));

    }
}