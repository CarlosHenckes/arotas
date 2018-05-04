package com.arotas.arotas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document
public class Veiculo implements Serializable {

    @Id
    private String id;
    private String placa;
    private String nomeMotorista;
    @GeoSpatialIndexed
    private Localizacao localizacao;
    private Status status;

    public Veiculo(){}

    public Veiculo(String id, String placa, String nomeMotorista, Localizacao localizacao, Status status) {
        this.id = id;
        this.placa = placa;
        this.nomeMotorista = nomeMotorista;
        this.localizacao = localizacao;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
