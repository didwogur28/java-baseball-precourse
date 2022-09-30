package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {

    private List<Integer> randomNum;
    private List<Integer> usrNum;

    public BaseballGame() {
        init();
    }

    public void init() {
        randomNum = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        System.out.println("*******************");
        System.out.println("** 게임을 시작합니다 **");
        System.out.println("*******************\n");
    }

    public void playGame() {

        System.out.println("숫자를 입력해주세요 : ");
        String usrInputNum = Console.readLine();

    }


}
