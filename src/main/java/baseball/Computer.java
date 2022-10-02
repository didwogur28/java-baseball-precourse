package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private static Set<Integer> randomNumArr;
    private List<Integer> computerNumArr;
    ValidateNum validateNum = new ValidateNum();

    public Computer() {
        this.randomNumArr = new LinkedHashSet<>();
    }

    public List<Integer> init() {
        while (randomNumArr.size() < 3) {
            int choice = Randoms.pickNumberInRange(1, 9);
            randomNumArr.add(choice);
        }

        return convertToList();
    }

    public List<Integer> convertToList() {
        computerNumArr = new ArrayList<>();

        for (Integer i : randomNumArr)
            computerNumArr.add(i);

        validateNum.sizeCheck(computerNumArr);
        validateNum.containCheck(computerNumArr);

        return computerNumArr;
    }
}
