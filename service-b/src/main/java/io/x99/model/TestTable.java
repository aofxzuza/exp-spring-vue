package io.x99.model;

public class TestTable {
    private Integer id;
    private String testColumn;
    private String country;

    public TestTable() {

    }

    public TestTable(Integer id, String testColumn, String country) {
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
