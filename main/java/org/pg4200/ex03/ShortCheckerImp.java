package org.pg4200.ex03;

public class ShortCheckerImp implements SortChecker{

    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {

        //Test null
        if(original == null && sorted == null){
            return true;
        }

        //Test null
        if(original == null || sorted == null){
            return false;
        }

        //Test length mismatch
        if(original.length > sorted.length || original.length < sorted.length){
            return false;
        }

        //Test null in original
        for(int i = 0; i < original.length; i++){
            if(original[i] == null){
                return false;
            }
        }

        //Test null in sorted
        for(int i = 0; i < sorted.length; i++){
            if(sorted[i] == null){
                return false;
            }
        }

        //Test not sorted
        for(int i = 0; i < sorted.length - 1; i++){
            if (sorted[i].compareTo(sorted[i+1]) > 0){
                return false;
            }
        }


        for(int i = 0; i < sorted.length; i++) {
            T valueSorted = sorted[i];
            int countS = 0;
            int countO = 0;

            for(int j = 0; j < sorted.length; j++){

                if(sorted[j].equals(valueSorted)){
                    countS++;
                }
                if (original[j].equals(valueSorted)) {
                    countO++;
                }
            }
            if(countO != countS){
                return false;
            }
        }

        return true;
    }
}
