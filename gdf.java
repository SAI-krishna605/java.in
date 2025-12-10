public class gdf {
    public static void main(String[] args) {
        
     {
        System.out.println("name : T.sai krishna");

        int english = 90;
        int social = 70;
        int maths = 85;
        int java = 70;
        int science = 65;
        int total = english + social + maths + java+ science;
        float marks = total/5;
        System.out.println("total marks:" + total);
        System.out.println("average marks:" + marks);
        if (marks >=100) {
            System.out.println("grade : outstanding");
    }
    else if (marks>=90) {
        System.out.println("grade:A");

}
else if (marks>=80){
    System.out.println("grade:B");
}
else if (marks>=70){
    System.out.println("grade:C");
}
else if (marks>=60){
    System.out.println("grade:D");
}
else{
    System.out.println("grade:F");
}
}
    }
}