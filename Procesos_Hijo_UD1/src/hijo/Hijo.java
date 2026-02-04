package hijo;

import java.util.Scanner;
import java.util.Random;

public class Hijo { 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        while (in.hasNextLine()) {
            in.nextLine(); 
            
            int numeroAleatorio = random.nextInt(11);
            
            // Enviamos el dato
            System.out.println(numeroAleatorio);
            
            // Forzamos la salida del buffer
            System.out.flush(); 
        }
        in.close();
    }
}