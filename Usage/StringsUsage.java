package Usage;

public class StringsUsage {
    public static void main(String[] args) {
        String s = "Ashok".toUpperCase();
        String str = "Raju".toLowerCase();
        System.out.println(s);
        System.out.println(str);

        String s1 = "123456789";
        System.out.println(s1.charAt(3));
        System.out.println(s1.substring(2));
        System.out.println(s1.substring(6, 8)); // second is not the length, but the end index;

        String jsr = "Jai Shree Ram";
        String[] splits = jsr.split(" ");
        System.out.println(splits[0].toCharArray());
        System.out.println("  **ashok**  ".trim());
        System.out.println("abc".compareTo("xyz"));
        System.out.println("xyz".compareTo("abc"));

        System.out.println(jsr.indexOf("Ram"));
        System.out.println(String.join(", ", splits));
        System.out.println(String.join(", ", splits).replace(",", ":"));

        StringBuilder sb = new StringBuilder(s1);
        sb.replace(1, 3, "abc");
        System.out.println(sb);
    }
}
