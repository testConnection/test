package datamarix;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.datamatrix.DataMatrixReader;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.qrcode.QRCodeReader;
/**
 * 二维码学习
 * @author LiYongqiang
 */
public class ZxingDataMatrixTest {
	public static void main(String[] args) throws Exception{
		String content = "你好，zixing";
		content = new String(content.getBytes("GBK"),"iso-8859-1");
		String imagePath = "d:\\code.png";
		File file = new File(imagePath);
		
		DataMatrixWriter writer = new DataMatrixWriter();
		try {
			//生成二维码
			BitMatrix matrix = writer.encode(content, BarcodeFormat.DATA_MATRIX, 160, 160);
			MatrixToImageWriter.writeToFile(matrix, "png", file);
			//读取二维码
			DataMatrixReader reader = new DataMatrixReader();
			BufferedImage image = ImageIO.read(file);
			LuminanceSource source = new BufferedImageLuminanceSource(image );
			Binarizer binarizer = new HybridBinarizer(source );
			BinaryBitmap imageBinaryBitmap = new BinaryBitmap(binarizer  );
			Result result = reader.decode(imageBinaryBitmap);
			System.out.println("result = "+ result.toString());
            System.out.println("resultFormat = "+ result.getBarcodeFormat());
            System.out.println("resultText = "+ result.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
