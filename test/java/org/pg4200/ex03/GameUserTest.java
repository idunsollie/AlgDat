package org.pg4200.ex03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameUserTest {

    private GameUserComparator comp;

    @BeforeEach
    public void newComparator(){
        comp = new GameUserComparator();
    }

    @Test
    public void addAndSortByPoint(){
        ArrayList<GameUser> array = new ArrayList<GameUser>();

        array.add(0,new GameUser("theGodOfHorses", 101));
        array.add(1, new GameUser("youThinkYouKnow", 430));
        array.add(2, new GameUser("superElefant", 20));
        array.add(3, new GameUser("fastBanana", 456));

        assertEquals(20, array.get(0));
        assertEquals(101, array.get(1));
        assertEquals(430, array.get(2));
        assertEquals(456, array.get(3));
    }
}
