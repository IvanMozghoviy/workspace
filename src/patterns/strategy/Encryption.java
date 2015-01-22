/**
 * 
 */
package patterns.strategy;

/**
 * @author user
 *
 */
public class Encryption {
	private Algorithm algorithm;

	//констуктор
	public Encryption(Algorithm algorithm) {
		this.algorithm = algorithm;
	}
//
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	public String crypt(String text, String key) {
		return algorithm.crypt(text, key);
	}
}
