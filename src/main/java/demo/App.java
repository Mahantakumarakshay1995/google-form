package demo;
import java.net.MalformedURLException;



public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        System.out.println("Hello Autmation Wizards!");
        //TestCases tc= new TestCases();
        System.out.println("Starting of Framework");
        
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
       
    }
}
