package recursos;

import java.time.LocalDate;

/**
 * Crea una clase Bicicleta de la que deseamos mantener los siguientes datos:
 * marca, modelo, precio y descuento. Se pide crear el constructor, getters y
 * setters, método toString (), equals (), un método que devuelva el precio con
 * el descuento aplicado y finalmente un método que fije el descuento a aplicar.
 * Este último método estará sobrecargado de la siguiente forma: • fjarDescuento
 * ()  (se le hace 10% y dura ese descuento 1 mes) • fjarDescuento (double d) 
 * (se le hace d %, 1 mes) • fjarDescuento (double d , int n)  (se le hace d %,
 * n meses)
 */

public class Bicicleta {
    private String marca;
    private String modelo;
    private float precio;
    private float descuento;
    private LocalDate finDescuento;

    public Bicicleta(String type, String model, float price) {
        this.marca = type;
        this.modelo = model;
        this.precio = price;
        this.descuento = 0.0f;
    }

    // Getters
    public float getDescuento() {
        return descuento;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public LocalDate getFinDescuento() {
        return finDescuento;
    }

    // Setters
    private void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setFinDescuento(LocalDate finDescuento) {
        this.finDescuento = finDescuento;
    }

    public void fijarDescuento() {
        setDescuento(0.1f);
        setFinDescuento(LocalDate.now().plusMonths(1));
    }

    public void fijarDescuento(double d) {
        setDescuento((float) d);
        setFinDescuento(LocalDate.now().plusMonths(1));
    }

    public void fijarDescuento(double d, int monthsToAdd) {
        setDescuento((float) d);
        setFinDescuento(LocalDate.now().plusMonths(monthsToAdd));
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f - %.0f%% = %.2f", this.marca, this.modelo, this.precio, this.descuento * 100,
                this.precio - this.precio * this.descuento);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object instanceof Bicicleta) {
            Bicicleta bicicleta = (Bicicleta) object;
            if (this.marca.equals(bicicleta.getMarca()) && this.modelo.equals(bicicleta.getModelo()))
                return true;
        }

        return false;
    }
}
