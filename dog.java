public class dog {
    String name;
    String breed;
    int age;

    dog(){
        System.out.println("Constructor is called");
        age = 1;


    }
    dog(String n, String a, int b){
        System.out.println("Constructor is called with parameters");
        name = n;
        breed= a;
        age = b;


    }
    void introduce(){
        System.out.println("Hi I am " + name );

        if(age>0){
            System.out.println("I am " + age + " " + "years old");
        }else{
            System.out.println("I am 1 Years old");
        }
    }

}
