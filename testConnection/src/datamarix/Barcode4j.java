package datamarix;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

/**
 * <p>Title:Barcode4j.java</p>
 * <p>Description: 生成条形码
 * barcode4j是使用datamatrix的二维码生成算法，为支持qr的算法
 * datamatrix是欧美的标准，qr为日本的标准，
 * barcode4j一般生成出来是长方形的 
 * </p>
 * <p>Copyright: Copyright (c) 2013</p>
 * @version 1.0
 */
public class Barcode4j {

    public static void generateCode128Barcode(File file, String code) {   
        Code128Bean bean = new Code128Bean();   
        final int dpi = 150;   
           
        //barcode   
        bean.setModuleWidth(0.21);   
        bean.setHeight(15);   
        bean.doQuietZone(true);   
        bean.setQuietZone(2);//两边空白区   
        //human-readable   
        bean.setFontName("Helvetica");   
        bean.setFontSize(3);   
        bean.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);   
           
        OutputStream out = null;   
      
        try {   
            out = new FileOutputStream(file);   
      
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(out,   
                    "image/jpeg", dpi, BufferedImage.TYPE_BYTE_BINARY, true, 0);   
            bean.generateBarcode(canvas, code);   
            canvas.finish();   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            try {   
                if (out != null)   
                    out.close();   
            } catch (IOException e) {   
                e.printStackTrace();   
            }   
        }   
      
    }   
      
    public static void generateCode39Barcode(int mode, File file, String code) {   
        Code39Bean bean = new Code39Bean();   
        // Dot Per Inch每英寸所打印的点数或线数，用来表示打印机打印分辨率。   
        final int dpi = 150;   
        // bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi));   
        bean.setModuleWidth(0.2);   
        bean.setHeight(15);   
      
        bean.setWideFactor(3);   
        bean.doQuietZone(true);   
      
        OutputStream out = null;   
      
        try {   
            out = new FileOutputStream(file);   
      
            if (mode == 0) {   
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(out,   
                        "image/jpeg", dpi, BufferedImage.TYPE_BYTE_GRAY, false,   
                        0);   
      
                bean.generateBarcode(canvas, code);   
      
                canvas.finish();   
      
            } else {   
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(dpi,   
                        BufferedImage.TYPE_BYTE_GRAY, true, 0);   
                bean.generateBarcode(canvas, code);   
                canvas.finish();   
                BufferedImage barcodeImage = canvas.getBufferedImage();   
      
                ImageIO.write(barcodeImage, "jpg", out);   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            try {   
                if (out != null)   
                    out.close();   
            } catch (IOException e) {   
                e.printStackTrace();   
            }   
        }   
    }
    
    
    public static void main(String[] args) {   
        String code = "DYH0100078615927";   
        generateCode39Barcode(0, new File("d:\\code39_0.jpg"), code);   
        generateCode39Barcode(1, new File("d:\\code39_1.jpg"), code);   
        generateCode128Barcode(new File("d:\\code128.jpg"), code);   
    }  


}