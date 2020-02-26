package Instructions;


public class Memory {
    private static final int NUM_INSTRUCCIONES = 20;

    public static int[] regIfId = new int[8];
    public static int[] regIdEx = new int[8];
    public static int[] regExMem = new int[8];
    public static int[] regMemWb = new int[8];

    public static int[] registros;

    private static int instrPosicion=0;
    private static Instruction[] instrucciones;
    private static int[] datos;

    public static void iniciaInstrucciones(){
        instrucciones = new Instruction[NUM_INSTRUCCIONES];
    }

    public static void iniciaDatos(int tamanno){
        datos = new int[tamanno];
    }

    public static void iniciaRegistros(int tamanno){
        registros = new int[tamanno];
    }

    public static Instruction getInstruction(){
        return instrPosicion >= instrucciones.length ? null : instrucciones[instrPosicion++];
    }

    public static void guarda(int direccion, int valor){
        if(direccion<datos.length && direccion >=0) datos[direccion]= valor;
        else throw new RuntimeException();
    }

    public static int lee(int direccion){
        if(direccion<datos.length && direccion >=0) return datos[direccion];
        else throw new RuntimeException();
    }
}
