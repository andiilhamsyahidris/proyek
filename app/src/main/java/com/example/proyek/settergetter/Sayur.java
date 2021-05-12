package com.example.proyek.settergetter;

public class Sayur {
    private String name, harga, url;

    public  Sayur(){

    }

    public Sayur(String name, String harga, String url) {
        this.name = name;
        this.harga = harga;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
