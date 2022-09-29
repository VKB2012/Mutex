package PBL;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class PAR_1 extends Thread {


    public int pa;
    public int[] z;
    private Semaphore mutex;

    public PAR_1(int[] z, Semaphore mutex) {
        this.z = z;
        this.mutex = mutex;
    }

    public void run() {
        int count;
       Inicio Inicio=new Inicio(0);

        ArrayList<Integer> par = new ArrayList<>();

        par.add(0);
        par.add(2);
        par.add(4);
        par.add(6);
        par.add(8);

        while (Inicio.getCount() < 100) {

            try {
                Random r = new Random();
                Thread.sleep(r.nextInt(100, 300));


                mutex.acquire(); // esperar


              int  i = r.nextInt(0, 5);
              pa = par.get(i);
              count=Inicio.getCount();
              Inicio.CHAVE[count]=pa;
              count=count+1;
              Inicio.setCount(count);

                mutex.release(); // sinalizar

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


