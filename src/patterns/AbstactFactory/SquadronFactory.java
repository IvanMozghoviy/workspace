/**
 * 
 */
package patterns.AbstactFactory;

/**
 * @author user
 *
 */
public abstract class SquadronFactory {
	 public abstract Mage createMage() {}

	 public abstract Archer createArcher() {}

	 public abstract Warrior createWarrior() {}
	}
