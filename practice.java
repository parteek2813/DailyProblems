
class Fan {
    private int cost; // Instance Variable
    private String brand;


    public void setCost(int cost){ // local variable
        this.cost = cost;
    }

    public void setBrand(String brand){
        this.brand=brand;
    }

    public int getCost(){
        return cost;
    }

    public String getBrand(){
        return brand;
    }
}
public class practice {


    public static void main(String[] args) {
        Fan f = new Fan();
        f.setCost(100);
        f.setBrand("Hello");

        System.out.println(f.getCost());
        System.out.println(f.getBrand());


    }
}
