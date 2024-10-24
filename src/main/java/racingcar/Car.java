package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int currentPosition = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
    }

    private int createMovement() {
        int random = Randoms.pickNumberInRange(0, 9);
        return validateMovement(random);
    }

    public int validateMovement(int random) {
        if (random < 4) {
            return 0;
        }
        return random;
    }
}
