package qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.swetake.util.Qrcode;

public class Logo_Two_Code {

	public Logo_Two_Code() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 生成二维码(QRCode)图片
	 * 
	 * @param content
	 *            二维码图片的内容
	 * @param imgPath
	 *            生成二维码图片完整的路径
	 * @param ccbpath
	 *            二维码图片中间的logo路径
	 */
	public static int createQRCode(String content, String imgPath,
			String ccbPath) {
		try {
			Qrcode qrcodeHandler = new Qrcode();
			// 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
			qrcodeHandler.setQrcodeErrorCorrect('M');
			// N代表数字,A代表字符a-Z,B代表其他字符
			qrcodeHandler.setQrcodeEncodeMode('B');
			// 设置设置二维码版本，取值范围1-40，值越大尺寸越大，可存储的信息越大
			qrcodeHandler.setQrcodeVersion(8);
			
			byte[] contentBytes = content.getBytes("gb2312");
			BufferedImage bufImg = new BufferedImage(149, 149,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();

			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, 149, 149);

			// 设定图像颜色 > BLACK
			gs.setColor(Color.BLACK);

			// 设置偏移量 不设置可能导致解析出错
			int pixoff = 2;
			// 输出内容 > 二维码
			if (contentBytes.length > 0 && contentBytes.length < 150) {
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			} else {
				System.err.println("QRCode content bytes length = "
						+ contentBytes.length + " not in [ 0,125]. ");
				return -1;
			}
			//下面为加logo的部分。
//			 Image img = ImageIO.read(new File(ccbPath));// 实例化一个Image对象。
//			 gs.drawImage(img, 50, 50,50,50, null);
//			 gs.dispose();
//			 bufImg.flush();

			// 生成二维码QRCode图片
			File imgFile = new File(imgPath);
			ImageIO.write(bufImg, "png", imgFile);

		} catch (Exception e) {
			e.printStackTrace();
			return -100;
		}

		return 0;
	}

	/**
	  * 解析QRCode二维码,无法解析带logo的
	  */
	 @SuppressWarnings("unchecked")
	 public void decode(File file) {
	     try {
	         BufferedImage image;
	         try {
	             image = ImageIO.read(file);
	             if (image == null) {
	                 System.out.println("Could not decode image");
	         }
	         LuminanceSource source = new BufferedImageLuminanceSource(image);
	         BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
	         Result result;
	         @SuppressWarnings("rawtypes")
	         Hashtable hints = new Hashtable();
	         //解码设置编码方式为：GBK
	         hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
	         result = new MultiFormatReader().decode(bitmap, hints);
	         String resultStr = result.getText();
	         System.out.println("解析后内容：" + resultStr);
	         } catch (IOException ioe) {
	             System.out.println(ioe.toString());
	         } catch (ReaderException re) {
	             System.out.println(re.toString());
	         }
	     } catch (Exception ex) {
	         System.out.println(ex.toString());
	     }
	 }
	
	public static void main(String[] args) {
		String imgPath = "D:/logo_QRCode.png";
		String imgPath1 = "e:/11.jpg";
		String encoderContent = "DYH1201003853597";
		Logo_Two_Code.createQRCode(encoderContent, imgPath, imgPath1);
		
		new Logo_Two_Code().decode(new File(imgPath));
	}
}
