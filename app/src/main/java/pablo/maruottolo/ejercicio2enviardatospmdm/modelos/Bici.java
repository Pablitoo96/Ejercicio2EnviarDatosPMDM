package pablo.maruottolo.ejercicio2enviardatospmdm.modelos;

public class Bici {
    private String marca;
    private int pulgada;

    public Bici() {
    }

    public Bici(String marca, int pulgada) {
        this.marca = marca;
        this.pulgada = pulgada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPulgada() {
        return pulgada;
    }

    public void setPulgada(int pulgada) {
        this.pulgada = pulgada;
    }

    @Override
    public String toString() {
        return "Bici{" +
                "marca='" + marca + '\'' +
                ", pulgada=" + pulgada +
                '}';
    }
}
