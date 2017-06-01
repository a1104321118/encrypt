package md;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;

public class MyMD {
	
	private static String str = "HELLO WORLD";

	public static void main(String[] args) throws NoSuchAlgorithmException {
		jdkMD5();
		bcMD5();
		ccMD5();
		bcMD4();
	}
	
	public static void jdkMD5() throws NoSuchAlgorithmException {
		
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		byte[] md5Byte = messageDigest.digest(str.getBytes());
		System.out.println(Hex.encodeHex(md5Byte));
	}
	
	public static void bcMD5() {
		Digest digest = new MD5Digest();
		digest.update(str.getBytes(), 0, str.length());
		byte[] md5Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md5Bytes, 0);
		System.out.println(org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
	}
	
	public static void bcMD4() {
		Digest digest = new MD4Digest();
		digest.update(str.getBytes(), 0, str.length());
		byte[] md4Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md4Bytes, 0);
		System.out.println(org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
	}
	
	public static void ccMD5() {
		String newStr = DigestUtils.md5Hex(str);
		System.out.println(newStr);
	}
}
