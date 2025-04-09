package com.lobufo.metier;

public class Telephone extends Appareil{
    private String imei;


    public Telephone(String marque, String couleur, String description, String imagePath, String imei) {
        super(marque, couleur, description, imagePath);
        this.imei = imei;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

}
