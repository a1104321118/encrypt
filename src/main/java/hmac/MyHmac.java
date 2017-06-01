package hmac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class MyHmac {
	
	private static String str = "HELLO WORLD";
	
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {
		jdkHmacMD5();
	}

	public static void jdkHmacMD5() throws NoSuchAlgorithmException, InvalidKeyException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		//产生密钥
		SecretKey secretKey = keyGenerator.generateKey();
		//获得密钥
		byte[] key = secretKey.getEncoded();
		//还原密钥
		SecretKey restoreSecretKey = new SecretKeySpec(key, "HmacMD5");
		//实例化Mac
		Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
		//初始化Mac
		mac.init(restoreSecretKey);
		byte[] hmacMD5Bytes = mac.doFinal(str.getBytes());
		System.out.println(Hex.encodeHexString(hmacMD5Bytes));
		
	}
}
