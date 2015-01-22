/**
 * 
 */
package patterns.strategy;

/**
 * @author user
 *
 */

	public class Test {
	 public static void main(String[] args) {
	 String key = "key";
	 String text = "text";
	 int alg = 1;
	 Encryption encryption = new Encryption(new DESAlgorithm());
	// Encryption encryptionRsa = new Encryption(new RSAAlgorythm());
	 String cryptedText1 = encryption.crypt(text, key);
	 encryption.setAlgorithm(new RSAAlgorythm());
	 String cryptedText2 = encryption.crypt(text, key);
	// String cryptedText1 = encryptionRsa.crypt(text, key);
	 }
	}

