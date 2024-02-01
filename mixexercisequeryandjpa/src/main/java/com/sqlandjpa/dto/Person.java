package com.sqlandjpa.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblPerson")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "Name", length = 50, nullable = false)
    private String name;
    @Column(name = "Email", length = 50, nullable = false)
    private String email;    
    @ManyToOne    
    @JoinColumn(name = "GenderID", nullable = true, unique = false, columnDefinition = "int default 3",
        foreignKey = @ForeignKey(name = "tblPerson_GenderID_FK", foreignKeyDefinition = "FOREIGN KEY (GenderID) REFERENCES tblGender (ID) ON DELETE" +
        /* please pick one for jpa hbm2ddl.auto creation. remove double slash */
        //" SET DEFAULT"
        //" SET NULL"
        " CASCADE"
        )
    )
    private Gender genderId;
        
    public Gender getGenderId() {
        return genderId;
    }    
    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
