

class A {
    public  A(){
        super();
        System.out.println("In A");
    }

    public A(int a){
        super();
        System.out.println("In A int");
    }
}

class B extends A{
    public B(){
        super(1);
        System.out.println("In B");
    }

    public B(int a ){
        super();
        System.out.println("In B int");
    }
}

public class practice {


    public static void main(String[] args) {
        B obj = new B();

    }
}
