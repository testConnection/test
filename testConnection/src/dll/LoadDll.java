package dll;

public class LoadDll {
	private native void fanhui(int i);
	public LoadDll() {
		
	}

	public static void main(String[] args) {
		new LoadDll().fanhui(1);
	}
	
	static{
		System.loadLibrary("fanhui");
	}
}
