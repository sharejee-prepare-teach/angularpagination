package org.baeldung.web.entity;

import javax.persistence.*;

/**
 * Created by DELL on 10/31/2018.
 */
@Entity
@Table(name = "test_person")
public class TestPerson {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;

    public TestPerson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
