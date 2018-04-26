package com.arotas.arotas.model;

import java.io.Serializable;

public class Localizacao implements Serializable {

    private Float latitude;
    private Float longitude;

    public Localizacao(Float latitude, Float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
