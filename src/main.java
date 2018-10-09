public class Calculator {
    
    private final double op1; 
    private final char op;
    private final double op2;
    private final double result;

    public Calculator(double op1, char op, double op2) {
        this.op1 = op1;
        this.op = op;
        this.op2 = op2;
        
         switch(op){
             case '+': result = op1 + op2; break;
             case '-': result = op1 - op2; break;
             case '*': result = op1 * op2; break;
             case '/': result = op1 / op2; break;
             case '^': result = Math.pow(op1, op2); break;
             default:
                 throw new IllegalArgumentException("invailed argument " + op);
         }
    }

    public double getOp1() {
        return op1;
    }

    public char getOp() {
        return op;
    }

    public double getOp2() {
        return op2;
    }

    public double getResult() {
        return result;
    }
    
}
