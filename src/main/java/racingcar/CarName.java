package racingcar;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        isNameLongerThanFive(carName);
        this.carName = carName;
    }

    public CarName(CarName carName) {
        isNameLongerThanFive(carName.carName);
        this.carName = carName.carName;
    }

    public Car createCar() {
        return new Car(this.carName);
    }

    public boolean isName(String givenName) {
        return this.carName.equals(givenName);
    }

    @Override
    public String toString() {
        return carName;
    }

    private static void isNameLongerThanFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(name + "이름이 5자리가 넘습니다");
        }
    }
}
