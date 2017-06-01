package sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.util.encoders.Hex;

public class MySha {
	
	private static String str = "HELLO WORLD";

	public static void main(String[] args) throws NoSuchAlgorithmException {
		jdkSHA1();
		bcSHA1();
		bcSHA224();
		ccSHA1();
	}
	
	public static void jdkSHA1() throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(str.getBytes());
		byte[] strBytes = md.digest();
		System.out.println(Hex.toHexString(strBytes));
	}
	
	public static void bcSHA1() {
		Digest digest = new SHA1Digest();
		digest.update(str.getBytes(), 0, str.length());
		byte[] sha1Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha1Bytes, 0);
		System.out.println(Hex.toHexString(sha1Bytes));
	}
	
	public static void bcSHA224() {
		Digest digest = new SHA224Digest();
		digest.update(str.getBytes(), 0, str.length());
		byte[] sha1Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha1Bytes, 0);
		System.out.println(Hex.toHexString(sha1Bytes));
	}
	
	public static void ccSHA1() {
		System.out.println(DigestUtils.sha1Hex(str));
	}
}
