class Demo {
    public static void disp1(){
        System.out.println("Static Method");
    }

    public void disp2(){
        System.out.println("Non static Method");
    }
}




public class demoPractice {



    public static void main(String[] args) {


        Demo.disp1();


        Demo d = new Demo();
        d.disp1();
        d.disp2();

    }
}
