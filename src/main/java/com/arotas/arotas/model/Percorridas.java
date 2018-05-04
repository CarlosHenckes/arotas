package com.arotas.arotas.model;

import java.io.Serializable;

public class Percorridas implements Serializable {

    private Veiculo veiculo;
    private float kilometrosPercorridos;

    public Percorridas(){}

    public Percorridas(Veiculo veiculo, float kilometrosPercorridos) {
        this.veiculo = veiculo;
        this.kilometrosPercorridos = kilometrosPercorridos;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public float getKilometrosPercorridos() {
        return kilometrosPercorridos;
    }

    public void setKilometrosPercorridos(float kilometrosPercorridos) {
        this.kilometrosPercorridos = kilometrosPercorridos;
    }
}
