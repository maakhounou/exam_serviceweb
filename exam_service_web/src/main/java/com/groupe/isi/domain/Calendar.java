package com.groupe.isi.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Date_History")
public class Calendar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Override
    public String toString() {
        return "Calendar{" +
            "id=" + id +
            '}';
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
