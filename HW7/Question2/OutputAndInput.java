import java.io.*;

/* 
 * in java documentation, it says:
   The default serialization mechanism for an object writes the class of the object, the class signature, 
   and the values of all non-transient and non-static fields
   https://docs.oracle.com/javase/8/docs/api/
 *
 * in the following code, the output is :
 * s1: normal string
   s2: null
   s3: static string
 * the problem here is s3 is a static string, and once mc1 is initialized, s3 becomes "static string"
   for every MyClass, so s3 of mc2 is also "static string"
 *
 * if we run the program, and then comment the first part of the code, from MyClass mc1 = .... to oos.flush()
   compile and and run it again, the output would be:
   s1: normal string
   s2: null
   s3: null
*/
   
public class OutputAndInput{
	public static void main(String[] args) throws Exception{
		MyClass mc1 = new MyClass("normal string", "transient string", "static string");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("output.txt"));
		oos.writeObject(mc1);
		oos.flush();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("output.txt"));
		MyClass mc2 = (MyClass)ois.readObject();
		
		System.out.printf("s1: %s%ns2: %s%ns3: %s%n", mc2.s1, mc2.s2, mc2.s3);
	}
}

class MyClass implements Serializable{
	public String s1;
	public transient String s2;
	public static String s3;
	
	public MyClass(String s1, String s2, String s3){
		this.s1 = s1;
		this.s2 = s2;
		MyClass.s3 = s3;
	}
}