package plugin;

public class PluginOne extends myplugin{
	@Override
    public void whoSaysHello(){
		System.out.println("PluginOne Says Hello");
	}
    public void whoSaysBye(){
		System.out.println("PluginOne Says Bye");
	}
		
	public static void main(String[] args){
		myplugin m = new PluginOne();
		
		m.whoSaysHello();
	}
}