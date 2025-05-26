interface FoodOrder {
    String getDescription();
    double getCost();
}

class BasicMeal implements FoodOrder {
    public String getDescription() { return "Basic Meal"; }
    public double getCost() { return 10.0; }
}

abstract class FoodDecorator implements FoodOrder {
    protected FoodOrder decoratedOrder;
    public FoodDecorator(FoodOrder order) { this.decoratedOrder = order; }
    public String getDescription() { return decoratedOrder.getDescription(); }
    public double getCost() { return decoratedOrder.getCost(); }
}

class ExtraCheese extends FoodDecorator {
    public ExtraCheese(FoodOrder order) { super(order); }
    public String getDescription() { return decoratedOrder.getDescription() + ", Extra Cheese"; }
    public double getCost() { return decoratedOrder.getCost() + 2.5; }
}

class SpicySauce extends FoodDecorator {
    public SpicySauce(FoodOrder order) { super(order); }
    public String getDescription() { return decoratedOrder.getDescription() + ", Spicy Sauce"; }
    public double getCost() { return decoratedOrder.getCost() + 1.8; }
}

public class DecoratorFoodOrder {
    public static void main(String[] args) {
        FoodOrder order = new ExtraCheese(new SpicySauce(new BasicMeal()));
        System.out.println(order.getDescription() + " $" + order.getCost());
    }
}