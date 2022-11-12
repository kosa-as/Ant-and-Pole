package com.company;

public class Pole {

    private Integer startPosition;
    private Integer endPosition;

    public Pole(Integer length){
        this.startPosition = 0;
        this.endPosition = length;
    }

    public Boolean checkPole(Integer pos){

        if(pos > startPosition && pos <endPosition) return true;

        return false;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setEndPosition(Integer endPosition) {
        this.endPosition = endPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }
}
