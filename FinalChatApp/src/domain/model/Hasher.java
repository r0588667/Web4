package domain.model;

import java.math.BigInteger;
import java.security.MessageDigest;

import sun.security.provider.SecureRandom;

public class Hasher {

	public static  String hashString(String password,byte[] seed) {
		try{
		MessageDigest crypt = MessageDigest.getInstance("SHA-1");
		crypt.reset();
		crypt.update(seed);
		crypt.update(password.getBytes("UTF-8"));
		byte[] digest = crypt.digest();
		return new BigInteger(1,digest).toString(16);
		}
		catch(Exception e){
			throw new DomainException("Something went wrong in the Hasher Class");
		}
	}
	public static byte[] createSalt(){
		SecureRandom random = new SecureRandom();
		byte seed[] = random.engineGenerateSeed(20);
		return seed;
	}
}

