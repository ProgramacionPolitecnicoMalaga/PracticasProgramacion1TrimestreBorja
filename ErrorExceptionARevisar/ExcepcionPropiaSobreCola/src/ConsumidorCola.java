import java.util.Scanner;

public class ConsumidorCola {

    private static Cola cola;
    private static final int TAM_COLA = 5;

    public static void main(String[] args)  {
        cola = new Cola(TAM_COLA);

        try {
            System.out.println("[P1]");
            cola.meter(10);
            cola.meter(30);
            cola.meter(60);
            cola.meter(12);
            System.out.println(cola);
            //cola.sacar();
            //cola.sacar();
            cola.meter(66);
            cola.meter(98);
            cola.meter(74);
            cola.meter(37);
            cola.meter(9);
            System.out.println(cola);
            System.out.println(cola);
        } catch (ControlExcepciones controlExcepciones) {
            controlExcepciones.printStackTrace();
        }
        System.out.println(cola);
    }
}