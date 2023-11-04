

class Plane {
    public void fly(){
        System.out.println("Plane is flying");

    }
    public void takeOff(){
        System.out.println("Plane is taking off");
    }
}

class CargoPlane extends Plane{
    public void fly(){
        System.out.println("Cargo Plane flies at lower height");

    }
    public void takeOff(){
        System.out.println("Cargo plane carries goods");
    }
}

class FighterPlane extends Plane{
    public void fly(){
        System.out.println("Fighter Plane flies at high height");

    }
    public void takeOff(){
        System.out.println("Fighter plane requires short runway to takeOff");
    }
}
public class practice {


    public static void main(String[] args) {
            CargoPlane cp = new CargoPlane();
            FighterPlane fp = new FighterPlane();

            Plane p ;
            p = cp;
            cp.takeOff();
            cp.fly();

            p=fp;
            fp.takeOff();
            fp.fly();

    }
}
