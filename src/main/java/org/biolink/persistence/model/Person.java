package org.biolink.persistence.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "person")
@Table
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_keeper")
    private String idKeeper;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_internal_number")
    private String cardInternalNumber;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<TemplateImage> templateImages;

    public Person() {
        super();
        this.templateImages = new ArrayList<>();
    }

    public Person(final String name) {
        super();
        this.name = name;
    }

    public Person(String name, String idKeeper, String cardNumber, String cardInternalNumber) {
        super();
        this.name = name;
        this.idKeeper = idKeeper;
        this.cardNumber = cardNumber;
        this.cardInternalNumber = cardInternalNumber;
        this.templateImages = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdKeeper() {
        return idKeeper;
    }

    public void setIdKeeper(String idKeeper) {
        this.idKeeper = idKeeper;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardInternalNumber() {
        return cardInternalNumber;
    }

    public void setCardInternalNumber(String cardInternalNumber) {
        this.cardInternalNumber = cardInternalNumber;
    }

    public List<TemplateImage> getTemplateImages() {
        return templateImages;
    }

    public void setTemplateImages(List<TemplateImage> templateImages) {
        this.templateImages = templateImages;
    }
}