package inheritance;

public class Tea extends CaffeineBeverage{

    public void brew() {
        System.out.println("차 티백을 담근다");
    }

    public void addCondiments() {
        System.out.println("레몬을 추가한다");
    }
}
