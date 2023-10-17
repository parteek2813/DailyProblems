
class Books {
    private int pgNo;

    public void setPgNo(int x){
        if(x > 0){
            pgNo=x;
        }else{
            System.out.println("Invalid Input");
        }
    }

    public int getPgNo(){
        return pgNo;
    }

}
public class practice {


    public static void main(String[] args) {
        Books b = new Books();
//        b.setPgNo(100);

        int res = b.getPgNo();
        System.out.println(res);


    }
}
