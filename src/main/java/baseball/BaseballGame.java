package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballGame {

    private List<Integer> randomNumArr;
    private List<Integer> usrNumArr;

    private StatusCode statusCode;

    public BaseballGame() {
        init();
    }

    public void init() {
        randomNumArr = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        System.out.println("*******************");
        System.out.println("** 게임을 시작합니다 **");
        System.out.println("*******************\n");
    }

    public void playGame() {

        System.out.println("숫자를 입력해주세요 : ");
        String usrInputNum = Console.readLine();
        this.usrNumArr = usrNumToList(usrInputNum);
        validateChk();
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
            throw new IllegalArgumentException(statusCode.NOT_INTEGER_TYPE);
        }

        return chgNum;
    }

    public void validateChk() {
        Set<Integer> chkDup = new HashSet<>(usrNumArr);

        sizeCheck();
        containCheck();
        dupCheck(chkDup);
    }

    public void sizeCheck() {
        if(usrNumArr.size() != 3) {
            throw new IllegalArgumentException(statusCode.ARRAY_SIZE_ERROR);
        }
    }

    public void containCheck() {
        if(usrNumArr.contains(0)) {
            throw new IllegalArgumentException(statusCode.ARRAY_CONTAIN_ERROR);
        }
    }

    public void dupCheck(Set<Integer> chkDup) {

        if(usrNumArr.size() != chkDup.size()) {
            throw new IllegalArgumentException(statusCode.ARRAY_DUP_ERROR);
        }
    }
}
