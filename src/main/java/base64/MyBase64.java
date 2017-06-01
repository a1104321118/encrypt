package base64;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class MyBase64 {

	private static String str = "HELLO WORLD";

	public static void main(String[] args) throws IOException {
		jdkBase64();
		CCBase64();
		BCBase64();
	}

	public static void jdkBase64() throws IOException {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		String newStr = base64Encoder.encode(str.getBytes());
		System.out.println(newStr);

		BASE64Decoder base64Decoder = new BASE64Decoder();
		String newStr2 = new String(base64Decoder.decodeBuffer(newStr));
		System.out.println(newStr2);
	}

	public static void CCBase64() {
		byte[] encodeBytes = Base64.encodeBase64(str.getBytes());
		System.out.println(new String(encodeBytes));

		byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
		System.out.println(new String(decodeBytes));
	}

	public static void BCBase64() {
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(str.getBytes());
		System.out.println(new String(encodeBytes));

		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println(new String(decodeBytes));
	}
}
