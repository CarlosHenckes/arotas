package com.arotas.arotas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Timestamp;

@Document
public class Viagem implements Serializable {

    @Id
    private String id;
    private Timestamp horaInicio;
    private String placa;
    /*@DBRef
    private Veiculo veiculo;*/
    private float percorrida;

    public Viagem(){}

    /*public Viagem(String id, Timestamp horaInicio, Veiculo veiculo, float percorrida) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.veiculo = veiculo;
        this.percorrida = percorrida;
    }*/

    public Viagem(String id, Timestamp horaInicio, String placa, float percorrida) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.placa = placa;
        this.percorrida = percorrida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    /*public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }*/

    public float getPercorrida() {
        return percorrida;
    }

    public void setPercorrida(float percorrida) {
        this.percorrida = percorrida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
