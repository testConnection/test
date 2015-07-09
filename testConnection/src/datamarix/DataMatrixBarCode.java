package datamarix;

import com.barcodelib.barcode.DataMatrix;

public class DataMatrixBarCode {
    private static int uom = 0;        //  0 - Pixel, 1 - CM, 2 - Inch
    private static int resolution = 72;
    private static float leftMargin = 0f;
    private static float rightMargin = 0f;
    private static float topMargin = 0f;
    private static float bottomMargin = 0f;
    private static int rotate = 0;     //  0 - 0, 1 - 90, 2 - 180, 3 - 270

    private static float moduleSize = 0.01f;

    public static void main(String[] args) throws Exception
    {
        DataMatrix barcode = new DataMatrix();
        barcode.setDataMode(DataMatrix.MODE_AUTO);

        barcode.setFormatMode(0);//0 显示1/4块  9 横纵锯齿
        barcode.setProcessTilde(false);//是否显示水印(水印是文件名)
        barcode.setData("DYH0100078615927");

        barcode.setUOM(uom);
        barcode.setModuleSize(moduleSize);
        barcode.setLeftMargin(leftMargin);
        barcode.setRightMargin(rightMargin);
        barcode.setTopMargin(topMargin);
        barcode.setBottomMargin(bottomMargin);
        barcode.setResolution(resolution);
        barcode.setRotate(rotate);

        barcode.renderBarcode("d://trix1.png");

        System.out.println("After creating barcode image.");
    }

}
