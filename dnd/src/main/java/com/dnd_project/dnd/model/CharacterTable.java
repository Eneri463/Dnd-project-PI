package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "charactetable")
public class CharacterTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "charname")
    private String charname;

    @Column(name = "charlevel")
    private Integer charlevel;

    @Column(name = "charage")
    private Integer charage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "charclassid", referencedColumnName = "id")
    @JsonBackReference
    private ClassTable charclasstable;

    public Long getId() {
        return id;
    }

    public String getCharname() {
        return charname;
    }

    public Integer getCharlevel() {
        return charlevel;
    }

    public Integer getCharage() {
        return charage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCharname(String charname) {
        this.charname = charname;
    }

    public void setCharlevel(Integer charlevel) {
        this.charlevel = charlevel;
    }

    public void setCharage(Integer charage) {
        this.charage = charage;
    }

    public void setCharclasstable(ClassTable charclasstable) {
        this.charclasstable = charclasstable;
    }

    public ClassTable getClasstable() {
        return charclasstable;
    }
}
