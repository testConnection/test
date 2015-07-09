package datamarix;

import java.io.File;
import java.net.URLEncoder;
 
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
 
/**
 * DataMatrix二维码编码
 * @author 王昂
 */   
public class DataMatrixEncoder{
    public void DataMatrixEncoder(){
        try {
        String content="DYH0100078615927";
        String imagePath = "D:\\code1.png";   
        File file = new File(imagePath);       
        content = new String(content.getBytes("utf-8"),"iso-8859-1");
        DataMatrixWriter writerDM = new DataMatrixWriter();
        BitMatrix matrixDM = writerDM.encode(content, BarcodeFormat.DATA_MATRIX , 5 , 5);
        MatrixToImageWriter.writeToFile(matrixDM, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String [] args){
        try {           
            DataMatrixEncoder DataMatrixencode = new DataMatrixEncoder();
            DataMatrixencode.DataMatrixEncoder();
            System.out.println("生成成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}