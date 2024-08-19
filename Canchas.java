package unal.todosalau.ahorravoltios.modelos;

public class Canchas {
    private float Kilovatios;
    private float precio;
    private String mes;

    public Canchas(float Kilovatios, float precio, String mes) {
        this.Kilovatios = Kilovatios;
        this.precio = precio;
        this.mes = mes;
    }

    public float getKilovatios() {
        return Kilovatios;
    }

    public void setKilovatios(float kilovatios) {
        this.Kilovatios = Kilovatios;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
