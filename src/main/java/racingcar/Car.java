package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;

    private int currentPosition = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public Car move() {
        return new Car(this.name, this.currentPosition + updateCurrentPosition());
    }

    public int updateCurrentPosition() {
        int forwardDistance = Randoms.pickNumberInRange(0, 9) - 3;

        if (forwardDistance <= 0) {
            return 0;
        }

        return forwardDistance;
    }

    public boolean isName(String givenName) {
        return name.equals(givenName);
    }

    public boolean isPosition(int givenPosition) {
        return this.currentPosition == givenPosition;
    }
}
