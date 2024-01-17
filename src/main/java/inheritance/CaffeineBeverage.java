package inheritance;

public abstract class CaffeineBeverage {

    public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public void boilWater() {
        System.out.println("물을 끓인다");
    }

    public void pourInCup() {
        System.out.println("컵에 붓는다");
    }

    // abstract로 선언한 메소드를 자식 클래스에서 반드시 구현해야 한다
    abstract void brew();

    abstract void addCondiments();
}
