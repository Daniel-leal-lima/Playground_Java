

public class TestaCarro {
    public static void main(String[] args) {
        Carro a = new Carro.CarroBuilder().cor("azul").build();
        System.out.println(a);
        Carro b = new Carro.CarroBuilder().cor("azul bebe").build();
        System.out.println(b);
        Carro c = new Carro.CarroBuilder().cor("Roxo").build();
        System.out.println(c);
    }
}
