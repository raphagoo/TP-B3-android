package com.example.tp.models;

import androidx.annotation.NonNull;

@androidx.room.Entity(tableName = "contact_table")
public class Contact {


    @androidx.room.PrimaryKey(autoGenerate = true)
    @NonNull
    @androidx.room.ColumnInfo(name = "_ID")
    public Integer mId;

    @androidx.room.ColumnInfo(name = "name")
    public String name;

    @androidx.room.ColumnInfo(name = "firstname")
    public String firstname;

    @androidx.room.ColumnInfo(name = "sexe")
    public String sexe;

    @androidx.room.ColumnInfo(name = "contact_type")
    public String contact_type;

    @androidx.room.ColumnInfo(name = "numero")
    public String numero;

    @androidx.room.ColumnInfo(name = "date_naissance")
    public String date_naissance;

    @androidx.room.ColumnInfo(name = "image")
    public String image;


    @NonNull
    public Integer getmId() {
        return mId;
    }

    public void setmId(@NonNull Integer mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getContact_type() {
        return contact_type;
    }

    public void setContact_type(String contact_type) {
        this.contact_type = contact_type;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Contact(String name, String firstname, String sexe, String contact_type, String numero, String date_naissance, String image) {
        this.name = name;
        this.firstname = firstname;
        this.sexe = sexe;
        this.contact_type = contact_type;
        this.numero = numero;
        this.date_naissance = date_naissance;
        this.image = image;
    }

}
