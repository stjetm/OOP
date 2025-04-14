public class Main {
    public static void main(String[] args) {
        Operations op = new Operations();

        op.setA(3);
        op.setB(2);
        op.sumar();
        System.out.println("Suma: " + op.getR());

        op.setA(4);
        op.setB(6);
        op.restar();
        System.out.println("Resta: " + op.getR());

        op.setA(6);
        op.setB(7);
        op.multiplicar();
        System.out.println("Multiplicación: " + op.getR());

        op.setA(2);
        op.setB(3);
        op.potencia();
        System.out.println("Potencia: " + op.getR());
    }
}

