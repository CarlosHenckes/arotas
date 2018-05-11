package com.arotas.arotas.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Timestamp;

@Document
public class Viagem implements Serializable {

    @Id @ApiModelProperty(notes = "Identidade gerada pelo próprio banco de dados")
    private String id;
    @ApiModelProperty(notes = "Timestamp do início da corrida")
    private Timestamp horaInicio;
    @ApiModelProperty(notes = "Placa do veículo")
    private String placa;
    @ApiModelProperty(notes = "Quilômetros percorridos pela corrida")
    private float percorrida;

    public Viagem(){}

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
