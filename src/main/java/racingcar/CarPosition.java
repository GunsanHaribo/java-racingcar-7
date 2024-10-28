package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class CarPosition {
    private static final int ZERO = 0;
    private static final int RANDOM_END = 9;
    private static final int FORWARD_CRITERIA = 3;
    private int currentPosition;

    public CarPosition() {
        this.currentPosition = ZERO;
    }

    public CarPosition(CarPosition carPosition) {
        this.currentPosition = carPosition.currentPosition;
    }

    public void updateCurrentPosition() {
        int forwardDistance = Randoms.pickNumberInRange(ZERO, RANDOM_END) - FORWARD_CRITERIA;

        this.currentPosition += Math.max(ZERO, forwardDistance);
    }

    public boolean isAheadOrEqual(CarPosition carPosition) {
        return this.currentPosition >= carPosition.currentPosition;
    }

    public boolean isPosition(int givenPosition) {
        return this.currentPosition == givenPosition;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }
}
