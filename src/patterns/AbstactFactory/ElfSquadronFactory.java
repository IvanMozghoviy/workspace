/**
 * 
 */
package patterns.AbstactFactory;

/**
 * @author user
 *
 */
public class ElfSquadronFactory extends SquadronFactory {

	/* (non-Javadoc)
	 * @see patterns.AbstactFactory.SquadronFactory#createMage()
	 */
	@Override
	public Mage createMage() {
		// TODO Auto-generated method stub
		return new ElfMage();

	}

	/* (non-Javadoc)
	 * @see patterns.AbstactFactory.SquadronFactory#createArcher()
	 */
	@Override
	public Archer createArcher() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see patterns.AbstactFactory.SquadronFactory#createWarrior()
	 */
	@Override
	public Warrior createWarrior() {
		// TODO Auto-generated method stub
		return null;
	}

}
