package Instructions;


public class Instruccion{
    private final int operacion;
    private final int regDest;
    private final int regOper1;
    private final int regOper2;
    private final int inmediato;

    private static int OpCode=0, Rop1=1, Rop2=2, Rdst=3, Inm=4, Op1=5, Op2=6, Result=7;

    public Instruccion(int operacion, int regDest, int regOper1, int regOper2, int inmediato){
        this.operacion = operacion;
        this.regDest = regDest;
        this.regOper1 = regOper1;
        this.regOper2 = regOper2;
        this.inmediato = inmediato;
    }
    public void etapaIf() {
        Memory.regIfId[OpCode]=operacion;
        Memory.regIfId[Rop1]=regOper1;
        Memory.regIfId[Rop2]=regOper2;
        Memory.regIfId[Rdst]=regDest;
        Memory.regIfId[Inm]=inmediato;
    }

    public void etapaId() {
        Memory.regIdEx[OpCode]=Memory.regIfId[OpCode];
        Memory.regIdEx[Rop1]=Memory.regIfId[Rop1];
        Memory.regIdEx[Rop2]=Memory.regIfId[Rop2];
        Memory.regIdEx[Rdst]=Memory.regIfId[Rdst];
        Memory.regIdEx[Inm]=Memory.regIfId[Inm];
        Memory.regIdEx[Op1]=Memory.registros[Memory.regIfId[Rop1]]; // op1
        Memory.regIdEx[Op2]=Memory.registros[Memory.regIfId[Rop2]]; // op2
    }

    public void etapaEx() {
        Memory.regExMem[0]=Memory.regIdEx[0]; // rop1
        Memory.regExMem[1]=Memory.regIdEx[1]; // rop2
        Memory.regExMem[2]=Memory.regIdEx[2]; // rdst
        Memory.regExMem[3]=Memory.regIdEx[5]; // op2
        Memory.regExMem[4]=Memory.regIdEx[5]+Memory.regIdEx[4]; //result

    }

    public void etapaMem() {

    }

    public void etapaWb() {

    }
}
