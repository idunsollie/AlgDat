package org.pg4200.ex03;

/*Consider the class org.pg4200.ex03.GameUser. Write a class called GameUserComparator 
that does implement Comparator<GameUser>. A GameUser is "larger" if it has more points. 
If points are the same, should consider alphabetic sorting based on the user id.

Add a new test in OptimizedBubbleSortTest in which you sort an array of GameUser using GameUserComparator.*/

import java.util.Comparator;

public class GameUserComparator implements Comparator<GameUser> {

    @Override
    public int compare(GameUser g1, GameUser g2) {
        if(g1.getPoints() < g2.getPoints()){
            return -1;
        }else if(g1.getPoints() > g2.getPoints()){
            return 1;
        }else{
            return g1.getUserId().compareTo(g2.getUserId());
        }

        //return g1.getPoints() - g2.getPoints();
    }

}
