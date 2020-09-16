package org.pg4200.ex04;

import org.pg4200.ex03.SortChecker;
import org.pg4200.ex03.SortCheckerTestTemplate;
import org.pg4200.les04.sort.MergeSort;

public class MergeSortTest extends SortCheckerTestTemplate {
    @Override
    protected SortChecker getNewInstance() {
        return (SortChecker) new MergeSort();
    }
}
