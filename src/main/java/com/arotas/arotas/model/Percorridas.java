package com.arotas.arotas.model;

import java.io.Serializable;

public class Percorridas implements Serializable {

    private String placa;
    private float kilometrosPercorridos;

    public Percorridas(){}

    public Percorridas(String placa, float kilometrosPercorridos) {
        this.placa = placa;
        this.kilometrosPercorridos = kilometrosPercorridos;
    }

    public float getKilometrosPercorridos() {
        return kilometrosPercorridos;
    }

    public void setKilometrosPercorridos(float kilometrosPercorridos) {
        this.kilometrosPercorridos = kilometrosPercorridos;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
