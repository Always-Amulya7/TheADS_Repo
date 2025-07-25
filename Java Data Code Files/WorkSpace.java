/*import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Vector;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;
import java.lang.*;

public class WorkSpace {
    public static void main(String args[]) {
        Scanner Sc = new Scanner(System.in);
        HashMap<Integer, String> Obj1 = new HashMap<>();
        Hashtable<Integer, String> Obj2 = new Hashtable<>();
        LinkedHashMap<Integer, String> Obj3 = new LinkedHashMap<>();
        TreeMap<Integer, String> Obj4 = new TreeMap<>();
        HashSet<Integer> Obj5 = new HashSet<>();
        LinkedHashSet<Integer> Obj6 = new LinkedHashSet<>();
        TreeSet<Integer> Obj7 = new TreeSet<>();
        ArrayList<Integer> Obj8 = new ArrayList<>();
        Vector<Integer> Obj9 = new Vector<>();
        LinkedList<Integer> Obj10 = new LinkedList<>();
        PriorityQueue<Integer> Obj11 = new PriorityQueue<>();

        System.out.print("Wish To Run The Code: ");
        String Choice = Sc.nextLine();
        while (!Choice.equals("Yep")) {
            System.out.print("Enter The Data: ");
            int Key = Sc.nextInt();
            String Value = Sc.nextLine();
            Obj1.put(Key, Value);
            Obj2.put(Key, Value);
            Obj3.put(Key, Value);
            Obj4.put(Key, Value);
            Obj5.add(Key);
            Obj6.add(Key);
            Obj7.add(Key);
            Obj8.add(Key);
            Obj9.add(Key);
            Obj10.add(Key);
            Obj11.add(Key);
            System.out.print("Wish To Exit: ");
            Choice = Sc.nextLine();
        }
        System.out.println("Displaying The Result:");

        // Display-1
        System.out.println("\nDisplay-1: HashMap");
        for (Map.Entry<Integer, String> entry : Obj1.entrySet()) {
            System.out.print(entry.getKey() + " -> " + entry.getValue());
        }

        // Display-2
        System.out.println("\nDisplay-2: Hashtable");
        for (Map.Entry<Integer, String> entry : Obj2.entrySet()) {
            System.out.print(entry.getKey() + " -> " + entry.getValue());
        }

        // Display-3
        System.out.println("\nDisplay-3: LinkedHashMap");
        for (Map.Entry<Integer, String> entry : Obj3.entrySet()) {
            System.out.print(entry.getKey() + " -> " + entry.getValue());
        }

        // Display-4
        System.out.println("\nDisplay-4: TreeMap");
        for (Map.Entry<Integer, String> entry : Obj4.entrySet()) {
            System.out.print(entry.getKey() + " -> " + entry.getValue());
        }

        // Display-5 using Iterator
        System.out.println("\nDisplay-5: HashSet Using Iterator");
        Iterator<Integer> iter1 = Obj5.iterator();
        while (iter1.hasNext()) {
            System.out.print(iter1.next()+" , ");
        }

        // Display-6 using Iterator and Enumeration (Vector)
        System.out.println("\nDisplay-6: Vector Using Iterator And Enumeration");
        Iterator<Integer> iter2 = Obj9.iterator();
        while (iter2.hasNext()) {
            System.out.print(iter2.next()+" , ");
        }
        Enumeration<Integer> enum1 = Obj9.elements();
        while (enum1.hasMoreElements()) {
            System.out.print(enum1.nextElement()+" , ");
        }

        // Display-7
        System.out.println("\nDisplay-7: LinkedHashSet");
        for (Integer val : Obj6) {
            System.out.print(val+" , ");
        }

        // Display-8
        System.out.println("\nDisplay-8: TreeSet");
        for (Integer val : Obj7) {
            System.out.print(val+" , ");
        }

        // Display-9
        System.out.println("\nDisplay-9: ArrayList");
        for (Integer val : Obj8) {
            System.out.print(val+" , ");
        }

        // Display-10
        System.out.println("\nDisplay-10: LinkedList");
        for (Integer val : Obj10) {
            System.out.print(val+" , ");
        }

        // Display-11
        System.out.println("\nDisplay-11: PriorityQueue");
        while (!Obj11.isEmpty()) {
            System.out.print(Obj11.poll()+" , ");
        }

        TreeMap<Integer,String> Obj12=new TreeMap<>(Obj1);
        System.err.println("\n"+Obj12);
        System.out.println(Obj6.contains(10));
        System.out.println(Obj1.entrySet());
        Sc.close();
    }
}

/*import java.util.*;
class WorkSpace {
    public static void main(String args[]) {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter The Size: ");
        int Size = Sc.nextInt();
        System.err.print("Enter The Number: ");
        int Number = Sc.nextInt();
        String Store=Integer.valueOf(Number).toString();
        String[] Arr=new String[Size];
        for (int i=0;i<Store.length();i++){
            Arr[i]=Character.valueOf(Store.charAt(i)).toString();
        }
        TreeSet<String> Obj1 = new TreeSet<>();
        ArrayList<String> Obj2 = new ArrayList<>();
        System.err.println(Arrays.toString(Arr));
        for (int i = 0; i < Size; i++) {
            if (i == Size - 1 - i) {
                Obj2.add(Arr[i]);
            } else if (Arr[i].equals(Arr[Size - 1 - i])) {
                Obj1.add(Arr[i]);
            } else {
                Obj2.add(Arr[i]);
            }
        }
        int Storage = Integer.parseInt(Store);
        System.out.println("The Number: " + Storage + " The Size: " + Integer.class.getName());
        System.err.println("The Uniques : "+Obj1+" Count: "+Obj1.size());
        System.err.println("The Mismatched: "+Obj2+" Count: "+Obj2.size());
    }
}
*/
/*import java.io.*;
import java.util.Scanner;

class WorkSpace {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)){
            File file = new File("Store.txt");
            System.err.println("The Directory: "+file.getAbsolutePath());
            System.out.println("Name Of The File: "+file.getName());
            System.out.println("Size Of The File: "+file.length()+" bytes");
            System.out.println("Is The File Readable: "+file.canRead());
            System.out.println("Is The File Writable: "+file.canWrite());
            System.out.println("Is The File Executable: "+file.canExecute());
            System.out.println("Is The File Hidden: "+file.isHidden());
            System.out.println("Is The File Directory: "+file.isDirectory());
            System.out.println("Is The File File: "+file.isFile());
            System.err.println("List Files In The Directory: "+file.listFiles());
            System.out.println("Last Modified: "+file.lastModified());
            System.out.println("File Path: "+file.getPath());
            System.out.println("File Parent: "+file.getParent());
            System.out.println("Rename File: "+file.renameTo(new File("Hero.txt")));
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}*/

/*import java.util.*;
import java.io.*;
class WorkSpace{
    public static void main(String args[])throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the values: ");
        int num1=Integer.parseInt(input.readLine());
        int num2=Integer.parseInt(input.readLine());
        System.out.println("The Sum Is: "+(num1+num2));
    }
}*/

/*import java.util.*;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.LocalDate;
import java.util.concurrent.Flow;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
class WorkSpace{
    public static void main(String args[]){
        try{

            // Date Functions
            System.out.println("Date Functions: \n");
            LocalDate currentDate=LocalDate.now();
            System.out.println("Current Date: "+currentDate);
            System.out.println("Birthday: "+LocalDate.of(2005, 01, 26));
            LocalDate parseDate=LocalDate.parse("2005-01-26");
            System.out.println("Next Day's After Birthday: "+parseDate.plusDays(2));
            System.out.println("Next Day's After Birthday: "+parseDate.plus(2,ChronoUnit.DAYS));
            System.out.println("Next Weeks's After Birthday: "+parseDate.plusWeeks(2));
            System.out.println("Next Month's After Birthday: "+parseDate.plusMonths(2));
            System.out.println("Next Year's After Birthday: "+parseDate.plusYears(2));
            System.out.println("Previous Birthday Day's: "+parseDate.minus(1,ChronoUnit.DAYS));
            System.out.println("Previous Birthday Week's: "+parseDate.minus(1,ChronoUnit.WEEKS));
            System.out.println("Previous Birthday Month's: "+parseDate.minus(1,ChronoUnit.MONTHS));
            System.out.println("Previous Birthday Year's: "+parseDate.minus(1,ChronoUnit.YEARS));
            System.out.println("The day of the week: "+parseDate.getDayOfWeek());
            System.out.println("The day of the month: "+parseDate.getDayOfMonth());
            System.out.println("The day of the year: "+parseDate.getDayOfYear());
            System.out.println("The year "+parseDate.getYear()+" is a leap year: "+parseDate.isLeapYear());
            boolean before=LocalDate.parse("2025-06-01").isBefore(LocalDate.parse("2025-06-02"));
            boolean after=LocalDate.parse("2025-06-02").isAfter(LocalDate.parse("2025-06-01"));
            System.out.println(before+" "+after);

            // Timming Functions
            System.out.println("Timming Functions: \n");
            LocalTime currentTime=LocalTime.now();
            System.out.println("Current time: "+currentTime);
            System.out.println("Birth Time: "+LocalTime.of(11, 05));
            System.out.println("Current Time: "+LocalTime.parse("12:07"));
            System.out.println("Added Time: "+currentTime.plusHours(1));
            System.out.println("Added Time: "+currentTime.plus(1,ChronoUnit.HOURS));
            System.out.println("The hours passed: "+currentTime.getHour());
            System.out.println("The minutes passed: "+currentTime.getMinute());
            System.out.println("The seconds passed: "+currentTime.getSecond());
            boolean beforee=LocalTime.parse("12:05").isBefore(LocalTime.parse("12:07"));
            boolean afterr=LocalTime.parse("12:07").isAfter(LocalTime.parse("12:05"));
            System.out.println(beforee+" "+afterr);

            // Local Time And Date
            LocalDateTime get=LocalDateTime.now();
            System.out.println("Current: "+get);
            System.out.println("Date & Time: "+LocalDateTime.of(2018, Month.MARCH, 10, 03, 30));
            System.out.println("Parse: "+LocalDateTime.parse("2005-01-26T05:26"));
            System.out.println("Add Hours: "+get.plus(2,ChronoUnit.HOURS));
            System.out.println("Add Minutes: "+get.plusMinutes(2));
            System.out.println("Add Seconds: "+get.plusSeconds(2));
            System.out.println("Minus Seconds: "+get.minusSeconds(2));
            System.out.println("Month: "+get.getMonth());

            // Get Zone Id's
            ZoneId zone=ZoneId.of("Asia/Seoul");
            System.out.println("The Zone Id: "+zone);
            Set<String> set=ZoneId.getAvailableZoneIds();
            //System.err.println(set);
            LocalDateTime ltd = LocalDateTime.of(2018, Month.MARCH, 10, 07, 20);
            ZoneOffset os = ZoneOffset.of("+04:00");
            OffsetDateTime osbyfour = OffsetDateTime.of(ltd, os);
            System.out.println(osbyfour);
        }
        catch(Exception e){
            System.out.println("The Error Defined: "+e);
        }
        finally{
            System.out.println("Execution Done");
        }
    }
}*/

/*import java.util.*;
import java.io.*;
class WorkSpace {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long start= new GregorianCalendar().getTimeInMillis();
        long store1=Runtime.getRuntime().freeMemory();
        System.out.print("Enter the file name: ");
        String fileName = sc.nextLine();
        File file = new File(fileName);
        try {
            if (file.exists()) {
                System.out.println("File exists.");
            } else {
                if (file.createNewFile()) {
                    System.out.println("File created.");
                } else {
                    System.out.println("File not created.");
                    return;
                }
            }
            System.out.println("\n--- Metadata ---");
            System.out.println("File Name: " + file.getName());
            System.out.println("File Path: " + file.getAbsolutePath());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("Readable? " + file.canRead());
            System.out.println("Writable? " + file.canWrite());
            System.out.println("Executable? " + file.canExecute());
            System.out.println("Is File? " + file.isFile());
            try (FileWriter writer = new FileWriter(file, true)) {
                boolean choice = false;
                while (!choice) {
                    System.out.print("Enter a sentence (or type 'exit' to stop): ");
                    String sentence = sc.nextLine();
                    if (sentence.equalsIgnoreCase("exit")) {
                        choice = true;
                    } else {
                        writer.write(sentence + "\n");
                    }
                }
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
            System.out.println("\n--- File Contents ---");
            try (FileReader reader = new FileReader(file)) {
                int character;
                while ((character = reader.read()) != -1) {
                    System.out.print((char) character);
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.gc();
            sc.close();
            long end= new GregorianCalendar().getTimeInMillis();
            long store2=Runtime.getRuntime().freeMemory();
            System.out.println("Time take: "+(end-start));
            System.out.println("Memory: "+(store2-store1));
        }
    }
}*/

/*import java.util.*;
class WorkSpace{
    interface Check{
        String getName(String name);
    }
    public static void main(String args[]){
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name=Sc.nextLine();
        Check get=(Name)->{
            System.out.println("My name is "+Name);
            return Name;
        };
        get.getName(name);
        List<Integer> student1=new ArrayList<Integer>();
        student1.add(50);
        student1.add(60);
        student1.add(70);
        student1.add(80);
        student1.add(90);
        System.out.println("The marks of each subject of student1 :");
        student1.forEach((x)->System.out.print(x+" "));
        Runnable run1=new Runnable(){
            public void run(){
                System.out.println("The thread is running");
            }
        };
        Runnable run2=()->{
            System.out.println("The thread is still running");
        };
        try{
            Thread t1=new Thread(run1);
            t1.start();
            Thread t2=new Thread(run2);
            t2.start();
        }
        catch(InterruptedException e){
            System.err.println("Error");
        }
    }
}*/

/*import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class WorkSpace {
    public static void main(String[] args) {
        File file = new File("Demo.txt");
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("huhh\n");
            writer.write("Naah");
        } 
        catch (IOException e) { 
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}*/

/*import java.util.*;
import java.time.*;
class WorkSpace{
    public static void main(String args[]){
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter the details: ");
        String input=Sc.nextLine();
        System.out.println("The detail is: "+input);
        System.err.println("The runtime memory is: "+Runtime.getRuntime().freeMemory());
        System.out.println("The runtime is: "+(long) new GregorianCalendar().getTimeInMillis());
        System.out.println("The max time: "+LocalTime.MAX);
        System.gc();
        Sc.close();
    }
    protected void finalize() throws Throwable{
        System.out.println("Garbage collection is done.");;
    }
}*/

/*import java.util.*;
class WorkSpace extends Thread{
    public void run(){
        System.out.println("The thread is running.");
    }
    public static void main(String args[]){
        WorkSpace work=new WorkSpace();
        work.start();
    }
}*/

/*class WorkSpace implements Runnable{
    public void run(){
        System.out.println("Thread is running");
    }
    public static void main(String args[]){
        WorkSpace run=new WorkSpace();
        Thread t=new Thread(run);
        t.start();
    }
}*/

/*class WorkSpace extends Thread{
    public void run(){
        for (int i=1;i<4;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
    public static void main(String args[]){
        WorkSpace w1=new WorkSpace();
        WorkSpace w2=new WorkSpace();
        w1.start();
        w2.start();
    }
}*/

/*class WorkSpace implements Runnable{
    public void run(){
        for (int i=1;i<4;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.print(i);
        }
    }
    public static void main(String args[]){
        WorkSpace w1=new WorkSpace();
        WorkSpace w2=new WorkSpace();
        Thread t1=new Thread(w1);
        Thread t2=new Thread(w2);
        t1.start();
        t2.start();
    }
}*/

/*import java.util.ArrayList;
import java.util.List;
public class WorkSpace {
    private List<String> wishList = new ArrayList<String>();
    private List<String> shoppingCart = new ArrayList<String>();
    public void addToWishList(String product) {
        synchronized (this) {
            if (!wishList.contains(product)) {
                wishList.add(product);
            }
        }
    }
    public String addToShoppingCart() {
        if (wishList.size() == 0) {
            return null;
        }
        synchronized (this) {
            if (wishList.size() > 0) {
                String s = wishList.get(0);
                wishList.remove(0);
                shoppingCart.add(s);
                return s;
            }
            return null;
        }
    }
    public void returnAns(){
        synchronized(this){
            System.out.println(wishList);
            System.out.println(shoppingCart);
        }
    }
    /*public synchronized void returnAns(){
        System.out.println(wishList);
        System.out.println(shoppingCart);
    }*/
    /*public static void main(String args[]){
        WorkSpace obj=new WorkSpace();
        obj.addToWishList("KinderJoy");
        obj.addToShoppingCart();
        obj.returnAns();
    }
}*/

/*class WorkSpace implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        WorkSpace runnable = new WorkSpace();
        ThreadGroup myThreadGroup = new ThreadGroup("My Thread Group");
        Thread t1 = new Thread(myThreadGroup, runnable, "My First Thread");
        t1.start();
        Thread t2 = new Thread(myThreadGroup, runnable, "My Second Thread");
        t2.start();
        Thread t3 = new Thread(myThreadGroup, runnable, "My Third Thread");
        t3.start();
        System.out.println("My Thread Group Name: " + myThreadGroup.getName());
        myThreadGroup.list();
    }
}*/

/*import java.util.*;
class WorkSpace {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(5); 
        list.add(10); 
        list.add(5 * 3); 
        list.add(20); 
        list.add(25); 
        list.add(30);
        List<Integer> store = Collections.unmodifiableList(list);
        store.forEach(x -> System.out.print(x + " "));
    }
}*/

/*import java.util.concurrent.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
class WorkSpace{
    public static void main(String args[])throws InterruptedException,ExecutionException {
        CompletableFuture<String> complete=new CompletableFuture<>();
        complete.completeAsync(()->{
            try {
                System.out.println("CompletableFuture - Executing the code block");
                return "CompletableFuture completeAsync executed successfully";
            }
            catch (Throwable e) {
                return "In catch block";
            }
        },complete.delayedExecutor(3, TimeUnit.SECONDS)).thenAccept((result)->System.out.println("Accept: "+result));
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Executing For Loop Block : " + i + " s");
        }
    }
}*/

/*class WorkSpace {
    volatile boolean notificationAlert = true;
    public static void main(String args[]) {
        WorkSpace onSpinObj = new WorkSpace();
        onSpinObj.waitForEventAndHandleIt();
    }
    public void waitForEventAndHandleIt() {
        while (notificationAlert) {
            java.lang.Thread.onSpinWait();
            System.out.println("In While Loop");
        }
        processEvent();
    }
    public void processEvent() {
        System.out.println("In Process Event");
    }
}*/

/*import java.util.*;
import java.util.concurrent.*;
import java.lang.*;
import java.math.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.io.*;

class WorkSpace {
    public static void main(String args[]) {
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth(), year = currentDate.getYear();
        LocalTime currentTime = LocalTime.now();
        int hours = currentTime.getHour(), minutes = currentTime.getMinute(), seconds = currentTime.getSecond();
        long start = new GregorianCalender().currentTimeMillis();
        long start_memory = Runtime.getRuntime().freeMemory();
        System.out.println("Starting process: " + day + "/" + currentDate.getMonth() + "/" + year + " " + hours + ":"
                + minutes + ":" + seconds + "\nStart time: " + start + "\nSpace available: " + start_memory);
        Scanner sc = new Scanner(System.in);
        long end = System.currentTimeMillis();
        long end_memory = Runtime.getRuntime().freeMemory();
        System.out.println("The final time: " + (end - start));
        System.out.println("The final memory: " + (start_memory - end_memory));
        Calculator calculate = new Calculator();
        Part1 w1 = new Part1(calculate);
        w1.start();
        Part2 w2 = new Part2(calculate);
        w2.start();
        System.gc();
    }
}

class Calculator {
    public synchronized void calculate(int n) {
        for (int i = 1; i <= 10; i++) {
            //System.out.println(Thread.currentThread().getName() + " : " + (n * i) + " ");
            System.out.print((n * i) + " ");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("It has error.");
            }
        }
    }
}

class Part1 extends Thread {
    Calculator t;

    Part1(Calculator t) {
        this.t = t;
        this.setName("Worker Thread 1");
    }

    public void run() {
        t.calculate(3);
    }
}

class Part2 extends Thread {
    Calculator t;

    Part2(Calculator t) {
        this.t = t;
        this.setName("Worker Thread 2");
    }

    public void run() {
        t.calculate(3);
    }
}*/

/*class WorkSpace implements Comparable{
    public static void main(String args[]){
        WorkSpace obj1=new WorkSpace();
        WorkSpace obj2=new WorkSpace();
        int Store=Integer.compare(get2(), get1());
        if (obj1.compareTo(obj2))
        System.out.println("Yes");
    }
    public static int get1(){
        return 10;
    }
    public static int get2(){
        return 5;
    }
}*/

/*import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
class WorkSpace {
    public static void main(String args[]) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime current = LocalDateTime.now();
        System.out.println("Current time: " + current.format(format));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate str1 = LocalDate.parse("15-02-2025", dateFormatter);
        LocalDate str2 = LocalDate.parse("19-02-2029", dateFormatter);
        long store = ChronoUnit.DAYS.between(str1, str2);
        System.out.println("Days between: " + store);
    }
}*/

/*class Number {
    private int num = 1;
    private final int limit;
    public Number(int limit) {
        this.limit = limit;
    }
    public synchronized void printOdd() {
        while (num < limit) {
            while (num % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Odd: " + num);
            num++;
            notify();
        }
    }
    public synchronized void printEven() {
        while (num <= limit) {
            while (num % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Even: " + num);
            num++;
            notify();
        }
    }
}
public class WorkSpace {
    public static void main(String[] args) {
        int limit = 10;
        Number num = new Number(limit);
        Thread oddThread = new Thread(()->{
            num.printOdd();
        });
        Thread evenThread = new Thread(num::printEven);
        oddThread.start();
        evenThread.start();
    }
}*/

/*import java.util.*;

class Employee {
    private String name, id;
    
    Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    String getName() { return name; }
    String getId() { return id; }
    void setName(String name) { this.name = name; }
    void setId(String id) { this.id = id; }
}

class Department extends Employee {
    private String dept;
    
    Department(String name, String id, String dept) {
        super(name, id);
        this.dept = dept;
    }
    
    String getDept() { return dept; }
    void setDept(String dept) { this.dept = dept; }
}

interface ManageOperations {
    void addEmployee(String name, String id, String dept);
    void removeEmployee(String id);
}

class Manager implements ManageOperations {
    private List<Department> employees = new ArrayList<>();
    
    public void addEmployee(String name, String id, String dept) {
        employees.add(new Department(name, id, dept));
    }
    
    public void removeEmployee(String id) {
        employees.removeIf(emp -> emp.getId().equals(id));
    }
    
    public Department dept_retrieve(String id) {
        for (Department emp : employees) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }
}

class WorkSpace {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addEmployee("John Doe", "E001", "IT");
        manager.addEmployee("Jane Smith", "E002", "HR");
        
        Department emp = manager.dept_retrieve("E001");
        if (emp != null) {
            System.out.println("Found employee: " + emp.getName() + " in " + emp.getDept());
        }
        
        manager.removeEmployee("E002");
    }
}*/

/*import java.util.*;
class WorkSpace{
    private Map<Integer,List<Integer>> adjList=new HashMap<>();
    private Set<Integer> visited=new HashSet<>();
    public void addEdge(int u,int v){
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    public void dfs(int node){
        if (visited.contains(node)) return;
        visited.add(node);
        System.out.print(node+" ");
        for (int neighbour:adjList.getOrDefault(node, new ArrayList<>())){
            if (!visited.contains(neighbour)){
                dfs(neighbour);
            }
        }
    }
    public static void main(String args[]){
        WorkSpace obj=new WorkSpace();
        int[][] edges={
            {0, 1},
            {0, 2},
            {1, 3},
            {1, 4},
            {2, 5},
            {5, 6}
        };
        for(int[] edge:edges){
            obj.addEdge(edge[0], edge[1]);
        }
        obj.dfs(0);
    }
}

import java.util.*;
import java.util.LinkedList;
class WorkSpace{
    private Map<Integer,List<Integer>> adjList=new HashMap<>();
    public void addEdges(int u,int v){
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    public void bfs(int start){
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        visited.add(start);
        queue.offer(start);
        while(!queue.isEmpty()){
            int current=queue.poll();
            System.out.print(current+" ");
            for (int neighbour:adjList.getOrDefault(current, new ArrayList<>())){
                if (!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }
    }
    public static void main(String args[]){
        WorkSpace obj=new WorkSpace();
        int[][] edges={
            {0, 1},
            {0, 2},
            {1, 3},
            {1, 4},
            {2, 5},
            {5, 6}
        };
        for(int[] edge:edges){
            obj.addEdges(edge[0], edge[1]);
        }
        obj.bfs(0);
    }
}*/

/*class NumberPrinter {
    private int number = 1;
    private final int MAX = 10;
    private boolean isOddTurn = true;
    public synchronized void printOdd() {
        while (number <= MAX) {
            if (!isOddTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Odd thread interrupted.");
                }
            } else {
                System.out.println("Odd: " + number);
                number++;
                isOddTurn = false;
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while (number <= MAX) {
            if (isOddTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Even thread interrupted.");
                }
            } else {
                System.out.println("Even: " + number);
                number++;
                isOddTurn = true;
                notify();
            }
        }
    }
}

public class WorkSpace {
    public static void main(String[] args) {
        NumberPrinter np = new NumberPrinter();
        Thread t1 = new Thread(() -> np.printOdd());
        Thread t2 = new Thread(() -> np.printEven());
        t1.start();
        t2.start();
    }
}*/

/*import java.util.*;
interface ShapeImplementations{
    public double area();
    default void display(){
        System.err.println("Area: "+area());
    }
}
abstract class WorkSpace implements ShapeImplementations{
    public static void main(String args[]){
        ShapeImplementations square=()->{
            return 5;
        };
        ShapeImplementations rectangle=()->{
            return 15;
        };
        square.display();
        rectangle.display();
    }
}*/

import java.util.*;
class WorkSpace extends Thread{
    public static void main(String args[]){
        Thread Work=(a,b)->a+b;
        Work.start(5,5);
    }
}