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

        this.usrNum = usrNumToList(usrInputNum);
    }

    public List<Integer> usrNumToList(String arg) {

        List<String> usrStringArr = Arrays.asList(arg.split(""));
        List<Integer> usrIntArr = new ArrayList<>();

        for(int i=0; i<usrStringArr.size(); i++) {
            usrIntArr.add(numCheck(usrStringArr.get(i)));
        }

        return usrIntArr;
    }

    public int numCheck(String arg) {

        int chgNum = 0;

        try {
            chgNum = Integer.parseInt(arg);
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 세자리 숫자를 입력해주세요.");
        }

        return chgNum;
    }
}
