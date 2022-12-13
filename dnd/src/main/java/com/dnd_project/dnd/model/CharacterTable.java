package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    private CharClassTable charclasstable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharname() {
        return charname;
    }

    public void setCharname(String charname) {
        this.charname = charname;
    }

    public Integer getCharlevel() {
        return charlevel;
    }

    public void setCharlevel(Integer charlevel) {
        this.charlevel = charlevel;
    }

    public Integer getCharage() {
        return charage;
    }

    public void setCharage(Integer charage) {
        this.charage = charage;
    }

    public CharClassTable getCharclasstable() {
        return charclasstable;
    }

    public void setCharclasstable(CharClassTable charclasstable) {
        this.charclasstable = charclasstable;
    }
}
