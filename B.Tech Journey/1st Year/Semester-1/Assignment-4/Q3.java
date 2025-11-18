class Q3
{
    public static void main(String args[])
    {
            int i,rnum=0,avg,sum=0;
            for (i=1;i<=6;i++)
            {
                rnum=((int) ((Math.random()*6)+1));
                sum=sum+rnum;
                System.out.print(rnum+" ");
            }
            avg=sum/6;
            System.out.println("");
            System.out.println("Average:"+avg);
    }
}