package task;

import java.util.*;

public class Main {

    static Envelope envelope;
    static Envelope[] envelopeList;

    public static void main(String[] args) {
        int n = 2;// кол-во конвертов
        for(;;) {
            Scanner s = new Scanner(System.in);
            envelopeList = new Envelope[n];
            for (int i = 0; i < n; i++) envelopeList[i] = CreateEnvelope(i);

            rectangleS(0,1);
            System.out.println("Продолжаем?! Введите: YES");
            if(!s.nextLine().toUpperCase().equals("YES")){
                break;
            }
        }
    }

    static void rectangleS(int i,int j){
        float s0,s1;
        System.out.println("Расчет площади... \nОпределение меньшего конверта");
        s0 = envelopeList[i].getHeight() * envelopeList[i].getWidth();
        s1 = envelopeList[j].getHeight() * envelopeList[j].getWidth();
        if(s0 < s1){
            OutPutResult(i,j);
        }
        else OutPutResult(j,i);
    }

    static private void OutPutResult(int i, int j){
        System.out.println("Конверт "+ (i+1) + " меньше конверта " + (j+1));

        if(envelopeList[i].getDiagonal() < envelopeList[j].getHeight()
        && envelopeList[j].getWidth() > envelopeList[j].getHeight()) {
            System.out.println((i + 1) + "-й конверт можно вложить в другой по диагонали!");
        } else System.out.println((i + 1) + "-й конверт нельзя вложить в другой по диагонали!");

        if (envelopeList[i].getWidth() < envelopeList[j].getWidth()
                && envelopeList[i].getHeight() < envelopeList[j].getHeight()) {
            System.out.println((i + 1) + "-й конверт можно вложить в другой по горизонтали!");
        } else System.out.println((i + 1) + "-й конверт нельзя вложить в другой по горизонтали!");

        if (envelopeList[i].getWidth() < envelopeList[j].getHeight()
                && envelopeList[i].getHeight() < envelopeList[j].getWidth()) {
            System.out.println((i + 1) + "-й конверт можно вложить в другой перевернув!");
        } else System.out.println((i + 1) + "-й конверт нельзя вложить в другой перевернув!");
    }

    private static Envelope CreateEnvelope(int i){
        float w,h;
        for(;;) {
            System.out.println("Введите параметры "+ (i + 1) +"-го конверта: ");
            try {
                Scanner s = new Scanner(System.in);
                System.out.print("Width: ");
                w = s.nextFloat();
                System.out.print("Height: ");
                h = s.nextFloat();
                break;
            } catch (Exception ex) {
                System.out.println(ex + "\n\tTry again");
            }
        }
        return envelope = new Envelope(w, h);
    }
}
