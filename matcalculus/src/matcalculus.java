import javax.swing.*;

public class matcalculus {
    public static final float PI = 3.1415927f;
    public static final float E = 2.7182818f;

    float topla(float a, float b) {                                      //İki değişkeni toplar
        return a + b;
    }

    float topla(float[] a) {                                            //Dizide bulunan tüm elamanları toplar
        float b = 0;
        for (int i = 0; i < a.length; i++) {
            b = b + a[i];
        }
        return b;
    }

    float carp(float a, float b) {                                      //iki değişkeni çarpar
        return a * b;
    }

    float cikar(float a, float b) {                                     //İki değişkende a'dan b'yi çıkartır
        return a - b;
    }

    boolean ciftmi(int a) {                                             //Sayı çift ise true döndürür
        if (a % 2 == 0) return true;
        return false;
    }

    float bol(float a, float b) {                                       //İki değişkeni böler
        return a / b;
    }

    int mutlak(int a) {                                                 //Sayının mutlak değerini alır
        if (a < 0) return -a;
        else if (a > 0) return a;
        else if (a == 0) return 0;
        return 0;
    }

    int fibonnaci(int a) {
        int m = 1;
        int n = 1;
        int cur;
        for (int i = 2; i < a; i++) {
            cur=m;
            m=m+n;
            n=cur;
        }
        return m;
    }

    int kare(int a) {                                                   //Sayının karesini alır
        return a * a;
    }

    int maks(int a, int b) {                                            //İki değişkenden büyük olanı döndürür
        if (a > b) return a;
        else if (b > a) return b;
        else return a;
    }

    int[] max(int[] a) {                                                //Dizideki en büyük elemanı döndürür
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) max = a[i];
        }
        return new int[]{max};
    }

    float us(float a, int b) {                                          //Üs alır a=taban b=üs olmak üzere
        if (b == 0) return 1;
        else if (b < 0) return 1 / us(a, -b);//Üst negatif olma drumu
        return a * us(a, b - 1);
    }

    int obeb(int a, int b) {                                           //İki değişkenin Obebini alır değişkenlerde a>b koşulu vardır
        if ((a % b) == 0) return b;
        return obeb(b, a % b);
    }

    int okek(int a, int b) {                                            //İki değişkenin Okekini alır değişkenlerde a>b koşulu vardır
        return (a * b) / obeb(a, b);
    }

    float basitkok(int a) {                                             //Sayının kökünü lise düzeyinde hesaplar
        if (a < 0) {
            System.out.println("Bu method negatif sayıları hesaplayamıyor");
            return 0;
        }
        boolean n = true;
        int m = 0;
        while (n) {
            if (a > kare(m) && a < kare(m + 1)) {
                float b = (float) (a - kare(m)) / (kare(m + 1) - kare(m));
                return m + b;
            } else if (a == kare(m)) return m;
            m++;
        }
        return 0;
    }

    int faktoriyel(int a) {                                             //Sayının faktöriyelini alır
        if (a == 0) return 1;
        else if (a < 0) {
            System.out.println("Bu method negatif sayıları hesaplayamıyor");

        }
        return a * faktoriyel(a - 1);
    }

    float cos(int a) {                                                  //Sayı derece olmak üzere,karşılık gelen cosinüs değerini hesaplar
        int x = a % 360;
        if (x == 90 || x == 270) return 0;//Bu koşullar yeterli hasaslık ile çalışmadığı için eklenmiştir
        else if (x == 0) return 1;
        else if (x == 180) return -1;
        else {
            int m = 1;
            float r = (x * PI) / 180;
            float n = 0;
            for (int i = 2; i < 18; i += 2) {
                if (!ciftmi(m)) {
                    n = n - (us(r, i) / faktoriyel(i));
                } else n = n + (us(r, i) / faktoriyel(i));
                m++;
            }
            return n + 1;
        }
    }

    float sin(int a) {                                                  //Sayı derece olmak üzere,karşılık gelen sinüs değerini hesaplar
        int x = a % 360;
        if (x == 0 || x == 180) return 0;//Bu koşullar yeterli hasaslık ile çalışmadığı için eklenmiştir
        else if (x == 90) return 1;
        else if (x == 270) return -1;
        else {
            int m = 1;
            float r = (x * PI) / 180;
            float n = 0;
            for (int i = 3; i < 19; i += 2) {
                if (!ciftmi(m)) {
                    n = n - (us(r, i) / faktoriyel(i));
                } else n = n + (us(r, i) / faktoriyel(i));
                m++;
            }
            return n + r;
        }
    }

    float tan(int a) {                                                  //Sayı derece olmak üzere,karşılık gelen tanjant değerini hesaplar
        return sin(a) / cos(a);
    }

    float cot(int a) {                                                  //Sayı derece olmak üzere,karşılık gelen cotanjant değerini hesaplar
        return cos(a) / sin(a);
    }

    float sec(int a) {                                                  //Sayı derece olmak üzere,karşılık gelen secant değerini hesaplar
        return 1 / cos(a);
    }

    float cosec(int a) {                                                //Sayı derece olmak üzere,karşılık gelen cosecant değerini hesaplar
        return 1 / sin(a);
    }

    float alankare(int a) {
        return kare(a);
    }

    float alandortgen(int a, int b) {
        return a * b;
    }

    float alandikucgen(int a, int b) {
        return (a * b) / 2;
    }

    float alanyuvarlak(int a) {
        return PI * kare(a);
    }
}
