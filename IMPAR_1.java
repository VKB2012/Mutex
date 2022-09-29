package PBL;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class IMPAR_1 extends Thread {

    public int[] x;
    public int im;
    private Semaphore mutex;

    public IMPAR_1(int[] x, Semaphore mutex) {
        this.x = x; this.mutex = mutex;; }

    public void run() {

        Inicio Inicio=new Inicio(0);

        ArrayList<Integer> imp=new ArrayList<>();
        imp.add(1);
        imp.add(3);
        imp.add(5);
        imp.add(7);
        imp.add(9);

        while(Inicio.getCount() < 100){

            try {
            Random r = new Random();
            Thread.sleep(r.nextInt(100,300));


            mutex.acquire(); // esperar

            int i=r.nextInt(0,4);
            im=imp.get(i);
            int count=Inicio.getCount();
            Inicio.CHAVE[count]=im;

            count=count+1;
            Inicio.setCount(count);


            mutex.release(); // sinalizar

        } catch (Exception e) {
            e.printStackTrace();
        } }
    }
}
