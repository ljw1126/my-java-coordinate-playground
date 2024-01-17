import coordinate.controller.CoordinateController;

public class MainApplication {
    /**
     * 테스트 데이터
     * Line : (10,10)-(14,15) / 6.403124
     * Rectangular : (10,10)-(22,10)-(22,18)-(10,18) / 96
     * Triangle : (10,10)-(14,15)-(20,8) / 29.0
     */
    public static void main(String[] args) {
        new CoordinateController().run();
    }
}
