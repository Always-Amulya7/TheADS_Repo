/*class Grade10
{
    public static void main(String args[])
    {
        System.out.println(Character.isLetter('A'));
        System.out.println(Character.isDigit('1'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.toLowerCase('A'));
        System.out.println(Character.toUpperCase('a'));
    }
}*/
/*class Grade10
{
    public static void main(String args[])
    {
        System.out.println("COMPUTER".charAt(3));
        System.out.println("COMPUTER".length());
        System.out.println("AWAAZ".indexOf('A'));
        System.out.println("EXCLUSIVE".lastIndexOf('E',1));
        System.out.println("EXCLUSIVE".lastIndexOf('E'));
        System.out.println("  ABC  ".trim());
        System.out.println("ABC".concat("XYZ"));
        System.out.println("abc".toUpperCase());
        System.out.println("ABC".toLowerCase());
        System.out.println("OUTDOOR".replace('O','Z'));
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter A Character:");
        char ch=input.readLine().charAt(0);
        if (Character.isLetter(ch))
        {
            System.out.println("Letter");
            if (Character.isUpperCase(ch))
            {
                System.out.println("UpperCase Letter");
            }
            else
            {
                System.out.println("LowerCase Letter");
            }
        }
        else if (Character.isDigit(ch))
        {
            System.out.println("Digit");
        }
        else if (Character.isWhitespace(ch))
        {
            System.out.println("WhiteSpace");
        }
        else
        {
            System.out.println("Some Other Character");
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter A Character:");
        char ch=input.readLine().charAt(0);
        if (ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
        System.out.println("Upper Case Vowel");
        else if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
        System.out.println("Lower Case Vowel");
        else
        System.out.println("Not A Vowel");
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter A Character:");
        char ch=input.readLine().charAt(0);
        if (ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
        System.out.println("Character is a Vowel");
        else if (Character.isLetter(ch))
        System.out.println("A Consonant");
        else
        System.out.println("Not A Letter");
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Two Characters:");
        char ch1=input.readLine().charAt(0);
        char ch2=input.readLine().charAt(0);
        int s=(int)ch1+(int)ch2;
        int d=Math.abs((int)ch1-(int)ch2);
        System.out.println("Sum="+s);
        System.out.println("Difference="+d);
    }
}*/
/*class Grade10
{
    public static void main(String args[])
    {
        System.out.println("UpperCase\tLowerCase");
        char uch,lch='a';
        for (uch='A';uch<='Z';uch++)
        {
            System.out.println(uch+"\t"+lch);
            lch++;
        }
    }
}*/
/*class Grade10
{
    public static void main(String args[])
    {
        String str1="IRan",str2="china";
        String str=str1.substring(1)+str2.substring(0,3);
        System.out.println("String="+str);
    }
}*/
/*class Grade10
{
    public static void main(String args[])
    {
        String str1="BRITAIN",str2="EXIT";
        String str=str1.substring(0,2)+str2;
        System.out.println("String="+str);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String s1,s2,s3,s4;
        System.out.println("Enter The Name:");
        s1=input.readLine();
        s2=input.readLine();
        s3=input.readLine();
        s4=s1.charAt(0)+"."+s2.charAt(0)+"."+s3;
        System.out.println(s4);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String name,sur,rem,nw;
        int f,l;
        System.out.println("Enter The Name:");
        name=input.readLine();
        System.out.println("Enter The Surname:");
        sur=input.readLine();
        f=name.indexOf(" ");
        rem=name.substring(0,f);
        nw=rem+" "+sur;
        System.out.println(nw);
        System.out.println(f);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String name,sur,rem,nw;
        int p;
        System.out.println("Enter The Name:");
        name=input.readLine();
        System.out.println("Enter The Surname:");
        sur=input.readLine();
        p=name.lastIndexOf(" ");
        rem=name.substring(0,p);
        nw=sur+" "+rem;
        System.out.println(nw);
        System.out.println(p);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        char ch;
        int k,l;
        System.out.println("Enter A String:");
        str=input.readLine();
        k=Integer.parseInt(input.readLine());
        l=Integer.parseInt(input.readLine());
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            System.out.println(ch);
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String dob,dd,mm,yy;
        int f,l;
        dob=input.readLine();
        f=dob.indexOf('/');
        l=dob.lastIndexOf('/');
        dd=dob.substring(0,f);
        mm=dob.substring(f+1,l);
        yy=dob.substring(l+1);
        System.out.println("Day-"+dd+"\n"+"Month-"+mm+"\n"+"Year-"+yy);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String path,drv,fidr,file;
        int d,f,l;
        System.out.println("Enter The File Path:");
        path=input.readLine();
        d=path.indexOf("\\");
        f=path.lastIndexOf("\\");
        drv=path.substring(0,d);
        fidr=path.substring(d+1,f);
        file=path.substring(f+1);
        System.out.println("Folder="+fidr);
        System.out.println("File="+file);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String eml,usr,sp;
        int l;
        System.out.println("Enter The E-Mail:");
        eml=input.readLine();
        l=eml.lastIndexOf("@");
        usr=eml.substring(0,l);
        sp=eml.substring(l+1);
        System.out.println("User="+usr);
        System.out.println("Service Provider="+sp);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        char ch;
        int asc,k,l;
        System.out.println("Enter The Word:");
        String str=input.readLine();
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            asc=(int) ch;
            System.out.println("Character="+ch+"\n"+"ASCII Value="+asc);
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        char ch;
        int k,l,ucv=0,lcv=0;
        System.out.println("Enter String:");
        str=input.readLine();
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
            {
                ucv++;
            }
            else if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
            {
                lcv++;
            }
        }
        System.out.println("Lower Case Vowel="+lcv);
        System.out.println("Upper Case Vowel="+ucv);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        char ch;
        int k,l,value=0;
        System.out.println("Enter String:");
        str=input.readLine();
        l=str.length();
        str=str.toUpperCase();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch!='A' && ch!='E' && ch!='I' && ch!='O' && ch!='U')
            {
                value++;
            }
        }
        System.out.println("Number Of Consonants="+value);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        char ch,mch;
        int k,l,c=0;
        System.out.println("Enter String:");
        str=input.readLine();
        l=str.length();
        str=str.toUpperCase();
        for (k=0;k<l-1;k++)
        {
            ch=str.charAt(0);
            if (ch!='A' && ch!='E' && ch!='I' && ch!='O' && ch!='U')
            {
                ch=str.charAt(0);
                mch=str.charAt(k+1);
                if (mch-ch==1)
                {
                    c++;
                }
            }
        }
        if (c>0)
        {
            System.out.println("Number Of Consecutive Consonants="+c);
        }
        else
        {
            System.out.println("It Does Not Contain");
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        char ch;
        int k,l,f=0;
        System.out.println("Enter String:");
        str=input.readLine();
        l=str.length();
        str=str.toUpperCase();
        for (k='A';k<='2';k++)
        {
            ch=str.charAt(k);
            if (ch==k)
            {
                f++;
            }
        }
        System.out.println("Frequency Of The Number="+f);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int l,k,c=0;
        char ch,mch;
        System.out.println("Enter A String:");
        str=input.readLine();
        str=str.toUpperCase();
        l=str.length();
        for (k=0;k<l-1;k++)
        {
            ch=str.charAt(k);
            mch=str.charAt(k+1);
            if (ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
            {
                if (mch=='A'||mch=='E'||mch=='I'||mch=='O'||mch=='U')
                {
                    c++;
                }
            }
        }
        if (c>0)
        {
            System.out.println("Number Of Consecutive Vowels:"+c);
        }
        else
        {
            System.out.println("Does Not Contain Consecutive Vowels");
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        char ch,mch;
        int l,k,i=0,c=0;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (k=0;k<l-1;k++)
        {
            ch=str.charAt(k);
            mch=str.charAt(k+1);
            if (ch==mch)
            c++;
        }
        if (c>0)
        System.out.println("Contains Consecutive Characters:"+c);
        else
        System.out.println("Does Not Contain Consecutive Characters");
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,nw="";
        int l,k,d;
        char ch;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (Character.isUpperCase(ch))
            {
                ch=Character.toLowerCase(ch);
                nw=nw+ch;
            }
            else if (Character.isLowerCase(ch))
            {
                ch=Character.toUpperCase(ch);
                nw=nw+ch;
            }
            else
            {
                System.out.println("Wrong Input");
            }
        }
        System.out.println(nw);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,nw="";
        int l,k;
        char ch;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (k=l-1;k>0;k--)
        {
            ch=str.charAt(k);
            nw=nw+ch;
        }
        System.out.println(nw);
        if (nw.equals(str))
        System.out.println("Palindrome");
        else
        System.out.println("Not A Palindrome");
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,nw="",s;
        char ch;
        int l,k;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch=='A'||ch=='a'||ch=='E'||ch=='e'||ch=='I'||ch=='i'||ch=='O'||ch=='o'||ch=='U'||ch=='u')
            {
                s="*";
                nw=ch+s;
            }
        }
        System.out.println("Answer="+nw);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int i,l,c1=0,c2=0,c3=0,c4=0,c5=0;
        char ch;
        System.out.println("Enter A String:");
        str=input.readLine();
        str=str.toUpperCase();
        l=str.length();
        for (i=0;i<l;i++)
        {
            ch=str.charAt(i);
            if (ch=='A')
            c1++;
            else if(ch=='E')
            c2++;
            else if(ch=='I')
            c3++;
            else if(ch=='O')
            c4++;
            else if(ch=='U')
            c5++;
        }
        System.out.println("Frequency Of 'A'="+c1);
        System.out.println("Frequency Of 'E'="+c2);
        System.out.println("Frequency Of 'I'="+c3);
        System.out.println("Frequency Of 'O'="+c4);
        System.out.println("Frequency Of 'U'="+c5);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int k,l,f=0,mx=0;
        char ch,i,mch=' ';
        System.out.println("Enter A String:");
        str=input.readLine();
        str=str.toUpperCase();
        l=str.length();
        for (i='A';i<='Z';i++)
        {
            f=0;
            for (i=0;i<l;i++)
            {
                ch=str.charAt(i);
                if (ch==i)
                f++;
            }
            if (f>mx)
            {
                mx=f;
                mch=i;
            }
        }
        System.out.println("Maximum="+mx);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,nw="";
        char ch,i;
        int k,l;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        str=str.toUpperCase();
        for (i='A';i<='Z';i++)
        {
            for (k=0;k<l;k++)
            {
                ch=str.charAt(k);
                if (ch==i)
                nw=nw+ch;
            }
        }
        System.out.println("Word="+nw);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,wrd="";
        char ch;
        int k,l;
        System.out.println("Enter A String:");
        str=input.readLine();
        str=str+" ";
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch!=' ')
            {
                wrd=ch+wrd;
            }
            else
            {
                System.out.println(wrd);
                wrd="";
            }
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,wrd="",rev="";
        int l,k;
        char ch;
        System.out.println("Enter Line Of Text:");
        str=input.readLine();
        str=str+" ";
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch!=' ')
            {
                wrd=wrd+ch;
                rev=ch+rev;
            }
            else
            {
                if (rev.equals(wrd))
                System.out.println(wrd);
                wrd="";
                rev="";
            }
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,wrd="";
        char ch;
        int l,k,v=0;
        System.out.println("Enter A String:");
        str=input.readLine();
        str=str+" ";
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch!=' ')
            {
                if(ch=='A'||ch=='a'||ch=='E'||ch=='e'||ch=='I'||ch=='i'||ch=='O'||ch=='o'||ch=='U'||ch=='u')
                {
                    wrd=wrd+ch;
                    v++;
                }
                else
                {
                    System.out.println(wrd+" "+v);
                    wrd="";
                    v=0;
                }
            }
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,wrd=" ",lw=" ";
        int l,k,v=0,mx=0;
        char ch;
        System.out.println("Enter A Line Of Text:");
        str=input.readLine();
        str=str+" ";
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(0);
            if (ch!=' ')
            {
                wrd=wrd+ch;
                int t=wrd.length();
                if (t>mx)
                mx=t;
            }
            else
            {
                wrd=" ";
            }
        }
        System.out.println(wrd);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,sw="Touble",wrd="";
        int l,k,c=0;
        char ch;
        System.out.println("Enter A Line Of Text:");
        str=input.readLine();
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch!=' ')
            wrd=wrd+ch;
            else
            {
                if (wrd.equals(sw)==true)
                c++;
                wrd="";
            }
        }
        System.out.println("Occurence of"+sw+"is="+c);
    }
}*/
/*import java.util.Scanner;
public class CountWordOccurrence 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();
        System.out.println("Enter a word to search for: ");
        String word = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) 
        {
            if (sentence.charAt(i) == word.charAt(0))
            {
                int j = 1;
                while (j < word.length() && sentence.charAt(i + j) == word.charAt(j)) 
                {
                    j++;
                }
                if (j == word.length()) 
                  {
                    count++;
                }
            }
        }
        System.out.println("The word " + word + " appears " + count + " times in the sentence.");
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,nw="";
        char ch,mch;
        int l,k;
        System.out.println("Enter Full Name of A Person:");
        str=input.readLine();
        str=" "+str;
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch==' ')
            {
                mch=str.charAt(k+1);
                nw=nw+mch+".";
            }
        }
        System.out.println(nw);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,wrd="",lw="";
        int k,l,ac=0,mx=0;
        char ch;
        System.out.println("Enter A String:");
        str=input.readLine();
        str=str+" ";
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch!=' ')
            {
                wrd=wrd+ch;
                ac+=(int)ch;
            }
            else
            {
                if (ac>mx)
                {
                    mx=ac;
                    lw=wrd;
                }
                wrd="";
            }
        }
        System.out.println(lw+","+mx);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,nw="";
        int k;
        char ch,mch;
        System.out.println("Enter The String:");
        str=input.readLine();
        str=str.toLowerCase();
        for (k=0;k<str.length();k++)
        {
            ch=str.charAt(k);
            if (ch!=' ')
            {
                mch=str.charAt(k);
                mch=Character.toLowerCase(mch);
                nw=nw+mch;
            }
            else
            {
                nw=nw+" ";
            }
        }
        System.out.println(nw);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        char ch;
        int k,l;
        System.out.println("Enter The Character:");
        ch=input.readLine().charAt(0);
        if (Character.isLetter(ch))
        {
            System.out.println("Yeah A Letter");
            if (Character.isUpperCase(ch))
            System.out.println("YEAH UPPERCASE LETTER");
            else if (Character.isLowerCase(ch))
            System.out.println("YEAH LOWERCASE LETTER");
        }
        else if (Character.isDigit(ch))
        System.out.println("Yeah A Digit");
        else if (Character.isWhitespace(ch))
        System.out.println("Yeah A WhiteSpace");
        else
        System.out.println("Some other Character");
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,nw="",sur,neew="";
        int k;
        char ch,mch;
        System.out.println("Enter The String:");
        str=input.readLine();
        str=" "+str;
        int l=str.lastIndexOf(' ');
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch==' ')
            {
                mch=str.charAt(k+1);
                nw=nw+mch+".";
            }
            else
            {
                sur=str.substring(l);
                neew=sur+","+nw;
            }
        }
        System.out.println(neew);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int l,i,j;
        char ch;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (i=0;i<l;i++)
        {
            for (j=i;j>=0;j--)
            {
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}*/
/*class Grade10
{
    public static void main(String args[])
    {
        int i,j;
        for (i=0;i<=5;i++)
        {
            for (j=i;j>0;j--)
            {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int l,i,j,k;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (i=l-1;i>=0;i--)
        {
            for (j=l-1;j>i;j--)
            {
                for (k=0;k<=i;k++)
                {
                    System.out.print(str.charAt(k));
                }
                System.out.println();
            }
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int l,i,j;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (i=l-1;i>=0;i--)
        {
            for (j=i;j<l;j++)
            {
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int l,i,j;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (i=l-1;i>=0;i--)
        {
            for (j=0;j<=i;j++)
            {
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int l,i,j;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (i=0;i<l;i++)
        {
            for (j=i;j<l;j++)
            {
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int l,i,j,k;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (i=0;i<=l-1;i++)
        {
            for (k=i;k>=0;k--)
            {
                System.out.print(str.charAt(k));
            }
            for (j=l-1;j>=i;j--)
            {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int l,i,j,k;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (i=0;i<=l-1;i++)
        {
            for (k=0;k<=i;k++)
            {
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int l,i,j,k;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (i=0;i<=l-1;i++)
        {
            for (k=l-1;k>i;k--)
            {
                System.out.print(" ");
            }
            for (j=0;j<=i;j++)
            {
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int l,i,j,k;
        System.out.println("Enter A String:");
        str=input.readLine();
        l=str.length();
        for (i=0;i<=l-1;i++)
        {
            for (k=l-1;k>i;k--)
            {
                System.out.print(" ");
            }
            for (j=0;j<=i;j++)
            {
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,nw="";
        int l,k,fi;
        char ch;
        System.out.println("Enter A String:");
        str=input.readLine();
        str=str.toUpperCase();
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            fi=str.indexOf(ch);
            if (k==fi)
            nw=nw+ch;
        }
        System.out.println(nw);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,sw,rw,nw="",wrd="";
        int l,k;
        char ch;
        System.out.println("Enter A Line Of Text:");
        str=input.readLine();
        str=str+" ";
        l=str.length();
        System.out.println("Enter A Word To Be Searched For:");
        sw=input.readLine();
        System.out.println("Enter A Word To Be Replaced For:");
        rw=input.readLine();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch!=' ')
            {
                wrd=wrd+ch;
            }
            else
            {
                if (sw.equals(wrd))
                {
                    wrd=rw;
                }
                nw=nw+wrd+" ";
                wrd="";
            }
        }
        System.out.println(nw);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        char ch;
        System.out.println("Enter A Character:");
        ch=input.readLine().charAt(0);
        if (ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
        System.out.println("UpperCase Vowel");
        else if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
        System.out.println("LowerCase Vowel");
        else
        System.out.println("Not A Vowel");
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        char ch;
        System.out.println("Enter A Character:");
        ch=input.readLine().charAt(0);
        if (ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
        System.out.println("A Vowel");
        else if (Character.isLetter(ch))
        System.out.println("A Consonant");
        else
        System.out.println("Not A Letter");
    }
}*/
/*public class Grade10
{
    public static void main(String args[])
    {
        System.out.println("UpperCase\tLowerCase");
        char uch,lch='a';
        for (uch='A';uch<='Z';uch++)
        {
            System.out.println(uch+"\t\t"+lch);
            lch++;
        }
    }
}*/
/*import java.io.*;
class Grade10
{
    void Me()throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,nw;
        char ch;
        int l,k;
        System.out.println("Enter A Word:");
        str=input.readLine();
        str=str.toUpperCase();
        l=str.length();
        for (k=0;k<l;k++)
        {
            ch=str.charAt(k);
            if (ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
            break;
        }
        if (k==0)
        nw=str+"AX";
        else if (k==l)
        nw=str+"AZ";
        else
        nw=str.substring(k)+str.substring(0,k)+"AY";
        System.out.println(nw);
    }
    public static void main(String args[])throws IOException
    {
        Grade10 ob=new Grade10();
        ob.Me();
    }
}*/
/*import java.io.*;
class Grade10
{
    void Me()throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,nw;
        int f,k;
        System.out.println("Enter A Sentence:");
        str=input.readLine();
        f=str.indexOf(' ');
        k=str.lastIndexOf(' ');
        nw=str.substring(k+1)+str.substring(f,k)+str.substring(0,f);
        System.out.println(nw);
    }
    public static void main(String args[])throws IOException
    {
        Grade10 ob=new Grade10();
        ob.Me();
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,nw="";
        int l,k;
        char ch,al;
        System.out.println("Enter A Word:");
        str=input.readLine();
        l=str.length();
        for (al='A';al<='Z';al++)
        {
            for (k=0;k<l;k++)
            {
                ch=str.charAt(k);
                if (ch==al)
                nw=nw+ch;
            }
        }
        System.out.println(nw);
    }
}*/
/*import java.io.*;
class Grade10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str,wrd="";
        int l,k,cho;
        char ch,mch;
        System.out.println("Enter A Line Of Text:");
        str=input.readLine();
        System.out.println("Enter Your Choices:");
        cho=Integer.parseInt(input.readLine());
        switch (cho)
        {
            case 1:str=" "+str;
            for (k=0;k<str.length();k++)
            {
                ch=str.charAt(k);
                if (ch==' ')
                {
                    mch=str.charAt(k+1);
                    wrd=wrd+mch;
                }
            }
            System.out.println(wrd);
            case 2:str=str+" ";
            for (k=0;k<str.length();k++)
            {
                ch=str.charAt(k);
                if (ch==' ')
                {
                    mch=str.charAt(k+str.length());
                    wrd=wrd+mch;
                }
            }
            System.out.println(wrd);
            default:System.out.print("Invalid Choice");
        }
    }
}*/
/*class Grade10
{
    void swap(int x,int y)
    {
        int t=x;
        x=y;
        y=t;
        System.out.println("In fn:x="+x+"\n"+"In fn:y="+y);
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        int a=5,b=7;
        System.out.println("Before Swap:a="+a+"\n"+"Before Swap:b="+b);
        ob.swap(a,b);
    }
}*/
/*class Grade10
{
    public static void area(float r)
    {
        double ar=3.14*r*r;
        System.out.println("Area Of Circle:"+ar);
    }
    public static void area(float l,float b)
    {
        float ar=l*b;
        System.out.println("Area Of Rectangle:"+ar);
    }
    public static void area(float s1,float s2,float s3)
    {
        float s=(s1+s2+s3)/2;
        double ar=Math.sqrt(s*(s-s1)*(s-s2)*(s-s3));
        System.out.println("Area Of Triangle:"+ar);
    }
}*/
/*class Grade10
{
    void disp()
    {
        System.out.println("Java");
        System.out.println("C++");
        System.out.println("Python");
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        ob.disp();
    }
}*/
/*class Grade10
{
    void disp()
    {
        int i;
        for (i=1;i<=15;i++)
        {
            System.out.print(i+" ");
        }
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        ob.disp();
    }
}*/
/*class Grade10
{
    void disp()
    {
        int i,c,a=0,b=1;
        for (i=1;i<=15;i++)
        {
            c=a+b;
            System.out.print(c);
            a=b;
            b=c;
        }
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        ob.disp();
    }
}*/
/*class Grade10
{
    void disp()
    {
        double y,x;
        for (x=0.5;x<=5.0;x++)
        {
            y=2.4*x*x+5.3*x-1.6;
            System.out.println(x+"="+y);
        }
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        ob.disp();
    }
}*/
/*import java.io.*;
class Grade10
{
    void findroots(int a,int b,int c)
    {
        int d=b*b-4*a*c;
        double r1,r2;
        if (d>0)
        {
            r1=(-b+Math.sqrt(d))/2*a;
            r2=(-b-Math.sqrt(d))/2*a;
            System.out.println("Real and Unequal Roots"+r1+" "+r2);
        }
        else if (d==0)
        {
            r1=-b/2*a;
            r2=-b/2*a;
            System.out.println("Real and Unequal Roots"+r1+" "+r2);
        }
        else
        {
            System.out.println("Imaginary Roots");
        }
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        Grade10 ob=new Grade10();
        System.out.println("Enter The Value:");
        int a=Integer.parseInt(input.readLine());
        int b=Integer.parseInt(input.readLine());
        int c=Integer.parseInt(input.readLine());
        ob.findroots(a,b,c);
    }
}*/
/*import java.util.*;
class Grade10
{
    int findmax(int a,int b,int c)
    {
        int mx=0;
        if (a>b && a>c)
        mx=a;
        else if (b>a && b>c)
        mx=b;
        else if (c>a && c>b)
        mx=c;
        return mx;
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        Scanner sc=new Scanner(System.in);
        int x,y,z,max;
        System.out.println("Enter Three Number:");
        x=sc.nextInt();
        y=sc.nextInt();
        z=sc.nextInt();
        max=ob.findmax(x,y,z);
        System.out.println("Maximum Value is="+max);
    }
}*/
/*import java.util.*;
class Grade10
{
    int toSecond(int hh,int mm,int ss)
    {
        int ts=hh*3600+mm*60+ss;
        return ts;
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Hour,Minute and Second:");
        int h=sc.nextInt();
        int m=sc.nextInt();
        int s=sc.nextInt();
        int tt=ob.toSecond(h,m,s);
        System.out.println(tt);
    }
}*/
/*import java.util.*;
class Grade10
{
    int findfactorial(int N)
    {
        int i,f=1;
        for(i=N;i>=1;i--)
        {
            f=f*i;
        }
        return f;
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        Scanner sc=new Scanner(System.in);
        int x,y;
        System.out.println("Enter A Number:");
        x=sc.nextInt();
        y=ob.findfactorial(x);
        System.out.println("Factorial="+y);
    }
}*/
/*import java.util.*;
class Grade10
{
    int findpower(int a,int b)
    {
        int k,p=1;
        for (k=1;k<=b;k++)
        {
            p=p*a;
        }
        return p;
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Two Number:");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=ob.findpower(a,b);
        System.out.println("Power="+c);
    }
}*/
/*import java.util.*;
class Grade10
{
    int prime(int n)
    {
        int k,c=0;
        for (k=1;k<=n;k++)
        {
            if (n%k==0)
            c++;
        }
        if (c==2)
        return 1;
        else
        return 0;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Grade10 ob=new Grade10();
        System.out.println("Enter A Number:");
        int a=sc.nextInt();
        if (ob.prime(a)==1)
        System.out.println(a+"=Prime");
        else
        System.out.println(a+"=Not Prime");
    }
}*/
/*import java.util.*;
class Grade10
{
    int findfactorial(int x)
    {
        int i,f=1;
        for (i=x;i>=1;i--)
        {
            f=f*i;
        }
        return f;
    }
    double findsumseries(int x,int N)
    {
        int i,j;
        double s=1.0;
        for (i=1;i<N;i+=1)
        {
            s=s+Math.pow(x,1);
        }
        return s;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Grade10 ob=new Grade10();
        int N,x;
        double s;
        System.out.println("Enter Values:");
        x=sc.nextInt();
        N=sc.nextInt();
        s=ob.findsumseries(x,N);
        System.out.println("S="+s);
    }
}*/
/*import java.util.*;
class Grade10
{
    double area(double r)
    {
        double ar,pi=3.14;
        ar=pi*r*r;
        return ar;
    }
    double area(double l,double b)
    {
        double ar,pi=3.14;
        ar=l*b;
        return ar;
    }
    double area(double a,double b,double c)
    {
        double ar,s;
        s=(a+b+c)/2;
        ar=Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return ar;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Grade10 ob=new Grade10();
        double a,b,c,res1,res2,res3;
        int ch;
        System.out.println("Enter The Choice:");
        ch=sc.nextInt();
        switch(ch)
        {
            case 1:System.out.println("Enter Radius:");
            a=sc.nextDouble();
            res1=ob.area(a);
            System.out.println("Area="+res1);
            break;
            case 2:System.out.println("Enter Length and Breadth:");
            a=sc.nextDouble();
            b=sc.nextDouble();
            res2=ob.area(a,b);
            System.out.println("Area="+res2);
            break;
            case 3:System.out.println("Enter The Three Side Of Triangle:");
            a=sc.nextDouble();
            b=sc.nextDouble();
            c=sc.nextDouble();
            res3=ob.area(a,b,c);
            System.out.println("Area="+res3);
            break;
            default:System.out.println("Invalid Choice");
            break;
        }
    }
}*/
/*class Grade10
{
    public static void first()
    {
        System.out.println("HELLO! I AM FIRST");
    }
    public static void second()
    {
        System.out.println("HELLO! I AM SECOND");
    }
    public static void third()
    {
        System.out.println("HELLO! I AM THIRD");
    }
    public static void main(String args[])
    {
        first();
        second();
        third();
    }
}*/
/*class Grade10
{
    int sumeven()
    {
        int s=0,i;
        for (i=2;i<=30;i+=2)
        {
            s+=i;
        }
        return s;
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        int s=ob.sumeven();
        System.out.println(s);
    }
}*/
/*class Grade10
{
    void disp()
    {
        int i,c,a=0,b=1;
        System.out.println(a);
        System.out.println(b);
        for (i=3;i<=15;i++)
        {
            c=a+b;
            System.out.println(c);
            a=b;
            b=c;
        }
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        ob.disp();
    }
}*/
/*class Grade10
{
    int anyfunc(int m)
    {
        m=5*m+3;
        return m;
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        int a=10,b=0;
        System.out.println("Before Function Calling="+a+" && b="+b);
        b=ob.anyfunc(a);
        System.out.println("After Function Calling="+a+" && b="+b);
    }
}*/
/*class Grade10
{
    int sumeven()
    {
        int s=0,i;
        for (i=2;i<=30;i+=2)
        {
            s+=i;
        }
        return s;
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        int s=ob.sumeven();
        System.out.println(s);
    }
}*/
/*class Grade10
{
    int m;
    String nm;
    void Accept()
    {
      m=100;
      nm="Default Constructor";
      System.out.println(nm+" "+m);
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        ob.Accept();
    }
}*/
/*class Grade10
{
    int m;
    String nm;
    Grade10(int m1,String n1)
    {
      m=m1;
      nm=n1;
      System.out.println(nm+" "+m);
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10(99,"ABCD");
    }
}*/
/*class Grade10
{
    int m;
    String nm;
    Grade10(int x,String n)
    {
        this.m=x;
        this.nm=n;
    }
}*/
/*class Grade10
{
    int a;
    Grade10(int a)
    {
        this.a=a;
        a*=2;
        System.out.println(a+" "+this.a);
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10(10);
    }
}*/
/*import java.util.*;
class Grade10
{
    int km,amt;
    String taxino,name;
    void input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Taxi Details:");
        taxino=sc.nextLine();
        name=sc.nextLine();
        km=sc.nextInt();
    }
    void calc()
    {
        if (km<=1)
        amt=25;
        else if(km<=6)
        amt=25+(km-1)*10;
        else if(km<=12)
        amt=25+5*10+(km-6)*15;
        else if(km<=18)
        amt=25+5*10+6*15+(km-12)*20;
        else
        amt=25+5*10+6*15+6*20+(km-18)*25;
    }
    void disp()
    {
        System.out.println("TaxiNumber\tName\t\tDistance\tBill");
        System.out.println(taxino+"\t"+name+"\t"+km+"\t\t"+amt);
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        ob.input();
        ob.calc();
        ob.disp();
    }
}*/
/*import java.util.*;
class Grade10
{
    int n,a,b;
    long phno;
    double amt;
    String name;
    void input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Details:");
        phno=sc.nextLong();
        name=sc.nextLine();
        a=sc.nextInt();
        b=sc.nextInt();
    }
    void calc()
    {
        n=a-b;
        if (n<=100)
        amt=500.0;
        else if(n<=200)
        amt=500+(n-100);
        else if(n<=300)
        amt=500+100*1.0+(n-200)*1.20;
        else
        amt=500+100*1.0+100*1.20+(n-300)*1.50;
    }
    void disp()
    {
        System.out.println("PhoneNumber\tName\t\tCalls\tAmount");
        System.out.println(phno+"\t"+name+"\t"+n+"\t\t"+amt);
    }
    public static void main(String args[])
    {
        Grade10 ob=new Grade10();
        ob.input();
        ob.calc();
        ob.disp();
    }
}*/
/*import java.io.*;
class Grade10
{
    long pan;
    double inc,tax;
    String name;
    void input()throws IOException
    {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Details:");
        pan=Long.parseLong(sc.readLine());
        name=sc.readLine();
        inc=Double.parseDouble(sc.readLine());
    }
    void calc()
    {
        if (inc<=500000)
        tax=0.0;
        else if(inc<=100000)
        tax=(inc-500000)*1.0;
        else if(inc<=1500000)
        tax=50000+(inc-1500000)*1.5;
        else if(inc<=2000000)
        tax=125000+(inc-1500000)*20;
        else
        tax=2250000+(inc-2000000)*30;
    }
    void disp()
    {
        System.out.println("PAN\tName\t\tIncome\tTax");
        System.out.println(pan+"\t"+name+"\t"+inc+"\t\t"+tax);
    }
    public static void main(String args[])throws IOException
    {
        Grade10 ob=new Grade10();
        ob.input();
        ob.calc();
        ob.disp();
    }
}*/
/*import java.io.*;
class Grade10
{
    long mobile;
    double cost,dis,amt;
    String name;
    void input()throws IOException
    {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Details:");
        name=sc.readLine();
        mobile=Long.parseLong(sc.readLine());
        cost=Double.parseDouble(sc.readLine());
    }
    void calc()
    {
        if (cost<=10000)
        dis=0.5/100*cost;
        else if(cost<=20000)
        dis=1.0/100*cost;
        else if(cost<=35000)
        dis=1.5/100*cost;
        else
        dis=2.0/100*cost;
    }
    void disp()
    {
        System.out.println("Name="+name);
        System.out.println("Mobile="+mobile);
        System.out.println("Cost="+cost);
        System.out.println("Discount="+dis);
        System.out.println("Amount="+(cost-dis));
    }
    public static void main(String args[])throws IOException
    {
        Grade10 ob=new Grade10();
        ob.input();
        ob.calc();
        ob.disp();
    }
}*/
/*import java.io.*;
class Grade10
{
    String desti;
    int nop,amt,discount,net;
    void getdata()throws IOException
    {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Enter Number Of Passenger and Destination");
        nop=Integer.parseInt(input.readLine());
        desti=input.readLine();
    }
    void calc()
    {
        if (desti.equalsIgnoreCase("America"))
        amt=nop*500000;
        else if(desti.equalsIgnoreCase("Singapore"))
        amt=nop*200000;
        else if(desti.equalsIgnoreCase("Japan"))
        amt=nop*400000;
        else if(desti.equalsIgnoreCase("Thailand"))
        amt=nop*300000;
        if (amt>=200000)
        discount=amt*25;
        else if(amt>=150001 && amt<=199999)
        discount=amt*20;
        else if(amt>=100001 && amt<=149999)
        discount=amt*15;
        else
        discount=amt*10;
        
    }
    void disp()
    {
        System.out.println("Destination\tPassengers\t\tDiscount\tAmount");
        System.out.println(desti+"\t\t"+nop+"\t\t\t"+discount+"\t"+amt);
    }
    public static void main(String args[])throws IOException
    {
        Grade10 ob=new Grade10();
        ob.getdata();
        ob.calc();
        ob.disp();
    }
}*/
/*import java.util.*;
class Grade10
{
    int hr,min,sec,ts;
    void gettime(int h1,int m1,int s1)
    {
        hr=h1;
        min=m1;
        sec=s1;
    }
    void to_seconds(int hr,int min,int sec)
    {
        ts=hr*3600+min*60+sec;
    }
    void show()
    {
        System.out.println("Total Seconds="+sec);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Grade10 ob=new Grade10();
        System.out.println("Enter The Details:");
        int h=sc.nextInt();
        int m=sc.nextInt();
        int s=sc.nextInt();
        ob.gettime(h,m,s);
        ob.to_seconds(h,m,s);
        ob.show();
    }
}*/

import java.util.Scanner;
class ADS
{
	public static int Count(String Str)
	{
		int count=0;
		int Len=Str.length();
		for (int i=0;i<Str.length();i++)
		{
			if((Str.charAt(i)==' ')&&(Str.charAt(i+1)!=' '))
				count++;
			else if(Str.charAt(Len-1)==' ')
			{
				count++;
			}
		}
		return count;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter A String:");
		String Input=sc.nextLine();
		System.out.println("The Count Of Words:"+Count(Input));
	}
}