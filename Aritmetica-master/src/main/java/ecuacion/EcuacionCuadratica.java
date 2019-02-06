package ecuacion;

public class EcuacionCuadratica {
    private double a;
    private double b;
    private double c;
    public double x1;
    public double x2;

    public EcuacionCuadratica(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void calcularSolucion() throws ArithmeticException {

        double raíz = b * b - (4.0 * a * c);
        if(a == 0) {
            this.x1 = -b + Math.sqrt(raíz);
            this.x2 = -b - Math.sqrt(raíz);
        }

        else if(raíz>=0) {
            this.x1 = (-b + Math.sqrt(raíz)) / (2.0 * a);
            this.x2 = (-b - Math.sqrt(raíz)) / (2.0 * a);
        } else {
             throw new ArithmeticException();
        }
    }
}


