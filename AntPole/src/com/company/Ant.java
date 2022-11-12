package com.company;

public class Ant {

    private Integer position;
    private boolean isPole;
    private Integer speed;
    private boolean direction;
    //direction中true表示向右，false代表向左

    public Ant(){

        this.speed = 5;

        this.isPole = true;


    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public boolean getDirection() {
        return direction;
    }

    public boolean isPole() {
        return isPole;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void nextPositionPerSecond(){
        if(direction){
            position += speed;
        }else{
            position -= speed;
        }
    }

    public void reverseDirection(){
        this.direction = !direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public void setPole(boolean pole) {
        isPole = pole;
    }

}

