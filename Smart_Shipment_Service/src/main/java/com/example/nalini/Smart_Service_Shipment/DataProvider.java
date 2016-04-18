package com.example.nalini.Smart_Service_Shipment;


public class DataProvider {

    private String name;
    private String mob;
    private String email;
    private String paddress;
    private String taddress;



    public DataProvider(String name,String mob,String email,String paddress,String taddress)
    {
        this.name=name;
        this.mob=mob;
        this.email=email;
        this.paddress=paddress;
        this.taddress=taddress;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {this.mob = mob;  }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public void setTaddress(String taddress) {
        this.taddress = taddress;
    }

    public String getTaddress() {
        return taddress;
    }
}
