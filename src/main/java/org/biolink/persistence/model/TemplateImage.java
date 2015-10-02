package org.biolink.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "template_image")
@Table
public class TemplateImage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "id_person")
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public TemplateImage(){
        super();
    }

    public TemplateImage(Person p, byte[] image){
        super();
        this.person = p;
        this.image = image;
    }



}
