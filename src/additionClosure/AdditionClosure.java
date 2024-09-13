package additionClosure;

import java.util.List;
import java.util.Objects;

public class AdditionClosure {

    public static boolean isClosed(List<Integer> intList, Integer n)  {



        //iterate through list first
        for (int i = 0; i < intList.size(); i++) {

            //iterate through list again
            for (int j = 0; j < intList.size(); j++) {

                //only proceed if the two positions are unique
                if (!Objects.equals(intList.get(i), intList.get(j)) || intList.size() <= 2) {
                    int case2 = 0;
                    if (intList.size() == 1 && intList.contains(0)) {
                        case2 = 0;
                    } else {
                        case2 = (intList.get(i)+intList.get(j)) % n;
                    }
                    int case1 = case2;
                    List<Integer> tempList = intList.stream()
                            .map(x -> x- case1)
                            .toList();
                    System.out.println(i);
                    System.out.println(j);
                    System.out.println(case1);
                    System.out.println(tempList);
                    if (!tempList.contains(0)) {

                        //take the modulus of each number with n. If an element is a multiple of n,
                        //its modulus will be 0.
                        tempList = tempList.stream()
                                .map(x -> x%n)
                                .toList();
                        System.out.println(tempList);


                        if (!tempList.contains(0)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}