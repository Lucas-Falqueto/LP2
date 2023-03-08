/*
    Imagine que se pretendia suportar em Java um mecanismo de semáforos. Como é que se 
    poderia definir uma classe semáforo que fosse capaz de suportar a funcionalidade dos 
    semáforos?
 */
public class Semaforo {
    private int recursos;

    public Semaforo(int recursos) {
        this.recursos = recursos;
    }

    public synchronized void adquirir() throws InterruptedException {
        while (recursos == 0) {
            wait();
        }
        recursos--;
    }

    public synchronized void liberar() {
        recursos++;
        notifyAll();
    }
}
