package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 랜덤_숫자_3개_셋팅() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        assertThat(randomNumbers.size()).isEqualTo(3);
    }

    @Test
    void 해당값_포함여부_테스트() {

        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        System.out.println(randomNumbers.get(0)+" "+randomNumbers.get(1)+" "+randomNumbers.get(2));

        List<Integer> inputNumbers = Arrays.asList(1,7,4);

        assertTrue(randomNumbers.contains(inputNumbers.get(0)));
    }
}
