public class Cat {

    public String name;
    public int appetite;
    public boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat (Plate p) {
        p.lessFood(appetite);
    }

}
