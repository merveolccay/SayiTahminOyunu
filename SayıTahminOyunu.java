package java101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SayıTahminOyunu {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);
        Scanner input = new Scanner(System.in);

        int right = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin= false;
        boolean isWrong= false; //hatalı giriş değişkeni

        while(right < 5){
            System.out.println("Lütfen tahmin giriniz: ");
            selected = input.nextInt();

            if(selected <0 || selected > 99){
                System.out.println("Aralık dışı değer girişi yaptınız.");
                if (isWrong){
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hakkınız: "+ (5-right));
                }else{
                    isWrong = true;
                    System.out.println("Bir dahaki yanlış değer girişinizde hakkınızdan düşülecektir.");

                }
                continue;
            }
            if (selected == number ){
                System.out.println("Tebrikler doğru sayıyı buldunuz.Sayımız: "+ number);
                isWin = true;
                break;
            }else {
                System.out.println("Hatalı bir sayı girdiniz.");
                if(selected > number){
                    System.out.println("Daha büyük bir değer giriniz!");
                }else{
                    System.out.println("Daha küçük bir sayı giriniz!");
                }
                wrong[right++] = selected;
                System.out.println("Kalan hakkınız: "+ (5-right));
            }


        }
        if(!isWin && !isWrong){
            System.out.println("Kaybettiniz!");
            System.out.println("Girdiğiniz değerler: "+ Arrays.toString(wrong));
        }
    }
}
