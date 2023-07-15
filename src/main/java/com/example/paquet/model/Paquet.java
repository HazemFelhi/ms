package com.example.paquet.model;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "paquet")
@EntityListeners(AuditingEntityListener.class)

public class Paquet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_paquet;

    @Column
    private String Description_paquet;


    public Paquet(){}

    public Paquet(String Description_paquet) {
        this.Description_paquet = Description_paquet;
    }

    public String getDescription_paquet() {
        return Description_paquet;
    }
    public void setDescription_paquet(String Description_paquet) {
        Description_paquet = Description_paquet;
    }
}
