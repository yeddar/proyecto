import java.util.Scanner;

public class ConversorGrados {

    public static void main(int args[]) {

        for (int i=0; i<100; i+=5) {
            double inCelsius = i;
            double inFarenheit = (9/5)*inCelsius+32;
            System.out.println(inCelsius);
            System.out.println(inFarenheit);
        }
    }

}
