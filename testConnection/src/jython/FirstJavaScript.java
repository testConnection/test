package jython;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FirstJavaScript {
	public static void main(String args[]) {

//		PythonInterpreter interpreter = new PythonInterpreter();
//		interpreter.execfile("D:\\Check_WHITE\\Check.py");
//		PyFunction func = (PyFunction)interpreter.get("login",PyFunction.class);

		try {
			Process p = Runtime.getRuntime().exec("D:/writeWhite/Check.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		PyObject pyobj = func.__call__();
//		System.out.println("anwser = " + pyobj.toString());
		
//		PythonInterpreter interpreter = new PythonInterpreter();  
//		InputStream filepy;
//		try {
//			filepy = new FileInputStream("D:/workspace/Test/Check.py");
//			interpreter.execfile(filepy);  ///执行python py文件
//			filepy.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
	}// main
}