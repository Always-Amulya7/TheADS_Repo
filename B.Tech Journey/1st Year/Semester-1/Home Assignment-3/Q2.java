import java.util.Scanner;
class Q2 
{
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.print("Enter today's day:");
            int today = sc.nextInt();
            System.out.print("Enter the number of days elapsed since today:");
            int daysAfter = sc.nextInt();
            int futureDay = (today + daysAfter) % 7;
            String futureDayName="",Dname="";
            if (today==1)
            	Dname="Monday";
            else if (today==2)
            	Dname="Tuesday";
            else if (today==3)
            	Dname="Wednesday";
            else if (today==4)
            	Dname="Thursday";
            else if (today==5)
            	Dname="Friday";
            else if (today==6)
            	Dname="Saturday";
            else if (today==0)
            	Dname="Sunday";
            switch (futureDay) 
            {
                case 0:
                    futureDayName = "Sunday";
                    break;
                case 1:
                    futureDayName = "Monday";
                    break;
                case 2:
                    futureDayName = "Tuesday";
                    break;
                case 3:
                    futureDayName = "Wednesday";
                    break;
                case 4:
                    futureDayName = "Thursday";
                    break;
                case 5:
                    futureDayName = "Friday";
                    break;
                case 6:
                    futureDayName = "Saturday";
                    break;
            }
            System.out.println("Today is "+Dname+" and the future day is "+futureDayName);
        }
    }
}