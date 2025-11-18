class Box<T>
{
    T Store;
    Box(T Store)
    {
        this.Store=Store;
    }
    void SetVar(T Store)
    {
        this.Store=Store;
    }
    T GetVar()
    {
        return Store;
    }
}
public class Q4
{
    public static void main(String args[])
    {
        Box<String> Var1=new Box<>(null);
		Box<String> Var2=new Box<>(null);
        Var1.SetVar("Pahla Value");
        Var2.SetVar("Dusra Value");
        System.out.println("First Set Of Data: ");
        System.out.println(Var1.GetVar());
        System.out.println(Var2.GetVar());
        Box<Integer> Var3=new Box<>(null);
        Box<Integer> Var4=new Box<>(null);
        Var3.SetVar(10);
        Var4.SetVar(7);
        System.out.println("Second Set Of Data: ");
        System.out.println(Var3.GetVar());
        System.out.println(Var4.GetVar());
        Box<Object> Var5=new Box<>(null);
        Box<Object> Var6=new Box<>(null);
        Var5.SetVar("Saab Thik Hai Naa?");
        Var6.SetVar((double) 15);
        System.out.println("Third Set Of Data: ");
        System.out.println(Var5.GetVar());
        System.out.println(Var6.GetVar());
    }
}