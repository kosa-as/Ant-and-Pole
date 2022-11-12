package com.company;

import java.util.ArrayList;

public class Control {

    private Integer antNumber;
    private Integer poleLength;

    private ArrayList<Integer> positions;
    private ArrayList<Boolean> directions;

    private AntRun antRun;

    public Control(){

        this.antNumber = 5;

        this.poleLength = 300;

        this.positions = new ArrayList<>();
        this.directions = new ArrayList<>();

        this.directions.add(true);
        this.directions.add(true);
        this.directions.add(true);
        this.directions.add(true);
        this.directions.add(true);

        this.positions.add(30);
        this.positions.add(80);
        this.positions.add(110);
        this.positions.add(160);
        this.positions.add(250);

    }

    public void print(){
        System.out.print("蚂蚁的初始方向为：");
        for(Boolean item: directions)
        {
            if(item){
                System.out.print("  R  ");
            }else {
                System.out.print("  L  ");
            }
        }
        System.out.println("结果如下：");
    }

    public void game(Integer num){

        if(num == antNumber){

            antRun = new AntRun(antNumber, directions, positions, poleLength);

            print();

            antRun.printResult();

            System.out.println();

            return;
        }

        num++; game(num); num--;

        directions.set(num,false);

        num++; game(num); num--;

        directions.set(num,true);

    }

}
