abstract class Marks 
{
    protected int markICP;
    protected int markDSA;
    protected double percentage;
    abstract void getPercentage();
}

class CSE extends Marks
{
    private int algoDesign;
    CSE(int markICP, int markDSA, int algoDesign)
     {
        this.markICP = markICP;
        this.markDSA = markDSA;
        this.algoDesign = algoDesign;
    }
    void getPercentage()
    {
        percentage = (markICP + markDSA + algoDesign) / 3.0;
        System.out.println("Percentage of CSE student: " + percentage);
    }
}

class NonCSE extends Marks
{
    private int enggMechanics;
    NonCSE(int markICP, int markDSA, int enggMechanics)
    {
        this.markICP = markICP;
        this.markDSA = markDSA;
        this.enggMechanics = enggMechanics;
    }
    void getPercentage()
    {
        percentage = (markICP + markDSA + enggMechanics) / 3.0;
        System.out.println("Percentage of NonCSE student: " + percentage);
    }
}

public class Q6
{
    public static void main(String[] args)
    {
        CSE cseStudent = new CSE(80, 85, 90);
        NonCSE nonCseStudent = new NonCSE(75, 78, 82);
        cseStudent.getPercentage();
        nonCseStudent.getPercentage();
    }
}
