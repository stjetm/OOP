public class Operations {

    private int a;
    private int b;
    private int r;

    // Getters
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getR() {
        return r;
    }

    // Setters
    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    // Métodos de operaciones
    public int sumar() {
        r = a + b;
        return r;
    }

    public int restar() {
        r = a - b;
        return r;
    }

    public int multiplicar() {
        r = a * b;
        return r;
    }

    public int potencia() {
        r = potenciaRecursiva(a, b);
        return r;
    }

    private int potenciaRecursiva(int base, int exponente) {
        return (exponente == 0) ? 1 : base * potenciaRecursiva(base, exponente - 1);
    }
}
