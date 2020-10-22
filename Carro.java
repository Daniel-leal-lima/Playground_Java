public class Carro {
    private String cor;
    private Carro(Carro.CarroBuilder carroBuilder) {
        cor = carroBuilder.corCarro;
    }
    @Override
    public String toString(){
        return String.format("o Carro é %s%n", cor);
    }
    public static class CarroBuilder{
        private String corCarro;

        public CarroBuilder cor(String corCarro){
            this.corCarro = corCarro;
            return this;
        }

        public Carro build(){
            return new Carro(this);
        }

    }//Fim do classe CarroBuilder 

}//Fim da Classe Carro
