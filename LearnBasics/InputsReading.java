package LearnBasics;

import java.io.*;
import java.util.*;
public class InputsReading {
    public static void main(String[] args) throws IOException
    {
        System.out.println("Jai Shree Ram");
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int t1 = sc.nextInt();

        System.out.println(t);
        System.out.println(t1);

        String s = sc.nextLine();
        System.out.println(s);
        
        String s1 = sc.nextLine();
        System.out.println(s1);

        Long lint = sc.nextLong();
        System.out.println(lint);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcases = Integer.parseInt(br.readLine());
        while(tcases-- > 0)
        {
            
            //if input has only one number in the line to be parsed and given as parameter to helper function.
            int t4 = Integer.parseInt(br.readLine());
            //int t5 = br.read();
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            //System.out.println(t5);
            
            // if input has lot of numbers in the same line
            String[] arr = br.readLine().trim().split(" ");
            int A1 = Integer.parseInt(arr[0]);
            int A2 = Integer.parseInt(arr[1]);
            int N = Integer.parseInt(arr[2]);

            //below  not printing to the console as thought
            bw.write("hello world!!");
            //  the BufferedWriter is not writing to the console because the output stream is not being flushed or closed.
            bw.flush();
            
        }
        sc.close();
    }
}
