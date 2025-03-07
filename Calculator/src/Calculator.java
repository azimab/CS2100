// Azim Abdulmajeeth
// zwf8qy@virginia.edu
// HW 2 - Calculator
// None
public class Calculator {
    private int mem1;
    private int mem2;
    private String op;
    public Calculator() { //A constructor used to create a calculator object with zeros for each operand and an empty operator
        mem1 = 0;
        mem2 = 0;
        op = " ";
    }
    public Calculator(int op1, int op2, String newOp) { //Creates a calculator object with set values for the operands and operator
        mem1 = op1;
        mem2 = op2;
        if (newOp.equals("+") || newOp.equals("-") || newOp.equals("*") || newOp.equals("/") || newOp.equals("^")) {
            op = newOp;
        }
        else {
            op = " ";
        }
    }
    public int getMem1 (){ //accessor method to access the first operand
        return mem1;
    }
    public int getMem2(){ //accessor method to access the second operand
        return mem2;
    }
    public String getOp(){ //accessor method to access the operator
        return op;
    }
    public void setMem1(int op1) { //mutator method to change the value of the first operand
         mem1 = op1;
    }
    public void setMem2(int op2) { //mutator method to change the value of the second operand
        mem2 = op2;
    }
    public void setOp(String newOp) { //mutator method to change the operator to a valid operation
        if (newOp.equals("+") || newOp.equals("-") || newOp.equals("*") || newOp.equals("/") || newOp.equals("^")) {
                op = newOp;
        }
    }
    public String toString() { //returns a string containing mem1, op, and mem2 with a space in between each
        return (mem1 + " " + op + " " + mem2);
    }
    public int perform() { //performs the operation in which mem1 is the first operand and mem2 is the second operand
        if(op.equals("+")) {
            mem2 = mem1 + mem2;
            return mem2;
        }
        else if(op.equals("-")) {
            mem2 = mem1 - mem2;
            return mem2;
        }
        else if(op.equals("*")) {
            mem2 = mem1 * mem2;
            return mem2;
        }
        else if(op.equals("/") && mem2 != 0) {
            mem2 = mem1 / mem2;
            return mem2;
        }
        else if(op.equals("^")) {
            mem2 = (int)Math.pow(mem1, mem2);
            return mem2;
        }
        else return 0;
    }
    public double performDiv() { //if the operator is /, the method will perform division with doubles allowing for decimal values
        if (op.equals("/") && mem2 != 0) {
            return (double)mem1 / mem2;
        }
        else return 0.0;
    }
    public void swap () { //swaps the values of the first and second operands
        int temp = mem1;
        mem1 = mem2;
        mem2 = temp;
    }

}
