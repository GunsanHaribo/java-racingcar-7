package racingcar;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static final String NAME_OVER_FIVE = "이름이 5자리 이상입니다";
    public static void main(String[] args) {
        String carName = Console.readLine();
        int movingTime = Integer.parseInt(Console.readLine());
        String result = moveCar(carName, movingTime);
        System.out.println(result);
    }
    public static String moveCar(String carName, int moveTime) {
        List<String> carNames = Arrays.stream(carName.split(",")).toList();
        if (carNames.size() > 5) {
            throw new IllegalArgumentException(NAME_OVER_FIVE);
        }

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }

        for (int i = 0; i < moveTime; i++) {
            for (Car car : cars) {
                car.move();
            }
        }


        return carNames.toString();
    }
}
