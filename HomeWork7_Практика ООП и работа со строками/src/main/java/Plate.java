public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }


    public void moreFood (int x) {
        food += x;
    }

    public void lessFood (int n) {
        food -= n ;
    }

    public void checkFood() {
        System.out.println("Всего еды в тарелке: " + food);
    }

}
