import java.util.*;
import java.lang.reflect.*;

public class TestDriver{
	
	public static void main(String[] args) throws Exception{
		System.out.println("Selecg which plugin you want to use: PluginOne or PluginTwo");
		Scanner stdin = new Scanner(System.in);
		String className = stdin.next();
		
		while(!className.equals("PluginOne") && !className.equals("PluginTwo")){
			System.out.println("Please select PluginOne or PluginTwo");
			className = stdin.next();
		}
		stdin.close();
		
		Class<?> c = Class.forName("plugin." + className);
		Object o = c.newInstance();
		
		System.out.println("\n\nYou select " + c);
		Method m1 = c.getMethod("whoSaysHello");
		Method m2 = c.getMethod("whoSaysBye");
		m1.invoke(o);
		m2.invoke(o);
	}

}