package practice;
interface A{
    void add(int a,int b);
    void add(float a,float b);
}
public class New implements A{
    public void add(int a,int b)
    {
        System.out.println(a+b);
    }
    public void add(float a,float b)
    {
        System.out.println(a+b);
    }
    public static void main(String[] args)
    {
       A obj=new New();
       obj.add(3,5);
       obj.add(7,25);
       obj.add(3.2f,4.5f);
    }
}
