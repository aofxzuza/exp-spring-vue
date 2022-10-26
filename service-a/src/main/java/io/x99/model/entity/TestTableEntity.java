package io.x99.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "test_table")
public class TestTableEntity {
    @Id
    @Column(name = "test_id")
    private Integer id;
    private String testColumn;
    private String country;

    public TestTableEntity() {

    }

    public TestTableEntity(Integer id, String testColumn, String country) {
        this.id = id;
        this.testColumn = testColumn;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestColumn() {
        return testColumn;
    }

    public void setTestColumn(String testColumn) {
        this.testColumn = testColumn;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
