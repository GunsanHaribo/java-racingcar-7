package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Application.NAME_OVER_FIVE;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 이름이_5개이상일떄_예외테스트() {
        String carName = "pobi,woni,jun,jihwan,jiso,jiU";
        int movingTime = 5;

        assertThatThrownBy(() -> Application.moveCar(carName, movingTime)).isInstanceOf(IllegalArgumentException.class).hasMessage(NAME_OVER_FIVE);
    }

    @Test
    void 차가_움직이는_거리가_4미만시_0을_반환_테스트() {
        Car car = new Car("pobi");
        int result = car.validateMovement(1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 차가_움직이는_거리가_4이상시_정상반환_테스트() {
        Car car = new Car("pobi");
        int result = car.validateMovement(4);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
