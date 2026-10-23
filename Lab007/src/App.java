import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        BufferedReader br = null;
    try {    
        // creating object of FileReader
    FileReader reader = new FileReader("file.txt");
    
    // passing FileReader to
    // buffered reader
     br = new BufferedReader(reader);
    
    // declaring empty string 
    String data =null;
    
    // while loop to read data 
    // and printing them
    while ((data = br.readLine()) != null) 
    {
        System.out.println(data);
    }
}
catch (Exception e) {
    System.out.println("Archivo no existe");  
    // closing the object
} 
   
   
}
}
