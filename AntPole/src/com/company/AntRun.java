package com.company;

import java.util.ArrayList;

public class AntRun {

    private ArrayList<Ant> ants;
    private Pole pole;

    private Integer minTime;
    private Integer maxTime;

    //根据速度为5和蚂蚁的距离都是10的倍数可知蚂蚁离开杆子或者相遇的时间一定是整数//

    public AntRun(Integer num, ArrayList<Boolean> directions, ArrayList<Integer> positions, Integer length) {

        this.ants = new ArrayList<>();

        this.maxTime = 0;
        this.minTime = 0;

        for(int i =0 ; i < num; ++i)
        {
            Ant ant = new Ant();

            ant.setDirection(directions.get(i));

            ant.setPosition(positions.get(i));

            ants.add(ant);

        }

        this.pole = new Pole(length);

    }

    public Boolean checkAllAnts(){

        boolean ans = false;

        for(Ant ant : ants){

            ans |= ant.isPole();

        }
        return ans;
    }

    public Boolean isEncounter(Ant antOne, Ant antTwo){

        if(!antOne.isPole())return false;

        if(!antTwo.isPole())return false;

        if(antOne.getPosition()==antTwo.getPosition())return true;

        return false;
    }

    public void encounterProcess(){
        for(int i = 1; i<ants.size(); ++i)
        {
            if(isEncounter(ants.get(i-1) , ants.get(i))){

                ants.get(i).reverseDirection();
                ants.get(i-1).reverseDirection();

            }
        }
    }

    public Boolean checkExit(Ant ant, Boolean isFirst)
    {
        if(!pole.checkPole(ant.getPosition())){
            ant.setPole(false);
            if(isFirst){
                minTime = maxTime;
                isFirst = false;
            }
        }
        return isFirst;
    }

    public void run(){

        boolean isFirst =true;

        while(checkAllAnts()){//每轮循环代表过了一秒

            maxTime++;

            for(Ant ant : ants)
            {
                ant.nextPositionPerSecond();

                isFirst = checkExit (ant , isFirst);
            }

            encounterProcess();

        }

    }

    public void printResult() {

        run();

        System.out.println("maxtime:"+maxTime+"   mintime:"+minTime );

    }
}
