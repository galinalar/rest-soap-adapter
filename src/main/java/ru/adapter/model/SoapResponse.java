package ru.adapter.model;

public class SoapResponse {

    private Integer resultNumber;

    public SoapResponse(Integer resultNumber) {
        this.resultNumber = resultNumber;
    }

    public Integer getResultNumber() {
        return resultNumber;
    }

    public void setResultNumber(Integer resultNumber) {
        this.resultNumber = resultNumber;
    }
}
