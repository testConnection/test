package datamarix;

import com.keepautomation.barcode.BarCode;
import com.keepautomation.barcode.IBarCode;

public class KAMatrix {
	public static void main(String[] args) {

		BarCode datamatrix = new BarCode();

		
		datamatrix.setCodeToEncode("DYH0100078615927");
		datamatrix.setSymbology(IBarCode.DATAMATRIX);
		datamatrix.setDataMatrixDataMode(IBarCode.DM_FORMAT_10X10);
		datamatrix.setDataMatrixFormatMode(0);
		datamatrix.setFnc1(IBarCode.FNC1_NONE);

		try {

			datamatrix.draw("D://trix.gif");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
