package PBL;

import java.util.concurrent.Semaphore;

public class Inicio {


  static  int[] CHAVE = new int[100];

    public int[] getCHAVE() {
        return CHAVE;
    }

    public void setCHAVE(int[] CHAVE) {
        this.CHAVE = CHAVE;
    }

    public   int count=0;

    public Inicio(int count){this.count=count;}
    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    public static void main(String[] args) {

        int contagem_impar=0;
        int contagem_par=0;
        int[] x = {10};


        Semaphore mutex = new Semaphore(1);

        IMPAR_1 t1 = new IMPAR_1(x, mutex);
        PAR_1 t2 = new PAR_1(x, mutex);
        IMPAR_1 t3 = new IMPAR_1(x, mutex);
        PAR_1 t4 = new PAR_1(x, mutex);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

            try {

                t1.join(); // espera a thread t1 terminar
                t2.join(); // espera a thread t2 terminar
                t3.join(); // espera a thread t1 terminar
                t4.join();
                System.out.println();
                for(int i=0;i<100;i++){
                    System.out.print(CHAVE[i]+"\n");

                    if(CHAVE[i]%2!=0){contagem_impar++;}
                    else{contagem_par++;}
                }


               System.out.print("Numeros impares:"+contagem_impar+"\nNumeros pares:"+contagem_par);

            }  catch (Exception e) {
                e.printStackTrace();

            }
    }
}
