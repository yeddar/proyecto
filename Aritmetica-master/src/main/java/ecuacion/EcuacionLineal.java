package ecuacion;

public class EcuacionLineal {
    public int términoX;
    public int términoIndependiente;

    public EcuacionLineal(){
        int términoIndependiente = términoX = 0;
    }

    public EcuacionLineal(int a, int b) {
        this.términoX = a;
        this.términoIndependiente = b;

    }

    public double devuelveSolución() {
        return (-términoIndependiente)/términoX;
    }

}
