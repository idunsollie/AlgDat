package org.pg4200.ex03;

import org.pg4200.ex04.MixedSort;
import org.pg4200.les03.sort.MySort;


public class MiexedSortTest extends SortTestIdun {
    @Override
    protected MySort getInstance() {
        return new MixedSort();
    }
}
