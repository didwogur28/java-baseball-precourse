package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballGame {

    private int strike;
    private int ball;

    private Computer computer;
    private List<Integer> computerNumArr;
    private List<Integer> usrNumArr;
    ValidateNum validateNum = new ValidateNum();
    Score score = new Score();

    public void init() {
        this.computer = new Computer();
        this.computerNumArr = computer.init();
        playGame();
    }

    public void playGame() {

        System.out.println("*******************");
        System.out.println("** 게임을 시작합니다 **");
        System.out.println("*******************\n");

        do {
            System.out.println(computerNumArr);
            System.out.print("숫자를 입력해주세요 : ");
            String usrInputNum = Console.readLine();
            this.usrNumArr = usrNumToList(usrInputNum);
            validateNum.validateChk(usrNumArr);
            compareNum();
            System.out.println(score.scoreReturn(ball, strike));
        } while (endGameCheck());
    }

    public void compareNum() {
        this.strike = 0;
        this.ball = 0;

        for (int i = 0; i < usrNumArr.size(); i++) {
            getScore(i);
        }
    }

    public void getScore(int i) {

        if (computerNumArr.indexOf(usrNumArr.get(i)) == i) {
            strike++;
            return;
        }

        if (computerNumArr.contains(usrNumArr.get(i))) {
            ball++;
        }
    }

    public List<Integer> usrNumToList(String arg) {

        List<String> usrStringArr = Arrays.asList(arg.split(""));
        List<Integer> usrIntArr = new ArrayList<>();

        for(int i=0; i<usrStringArr.size(); i++) {
            usrIntArr.add(validateNum.numCheck(usrStringArr.get(i)));
        }

        return usrIntArr;
    }

    public boolean endGameCheck() {

        if (strike == 3) {
            System.out.println(StatusCode.GAME_END);
            System.out.println(StatusCode.GAME_RESTART);

            String response = Console.readLine();

            if (response.equals("1")) {
                init();
                return true;
            }

            if (response.equals("2")) {
                return false;
            }
            throw new IllegalArgumentException(StatusCode.GAME_RESTART_ERROR);
        }

        return true;
    }
}
