package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	
	protected Probleme(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public boolean equals(Object obj) {
		if(obj instanceof Probleme probleme) {
			if(obj.getClass()==this.getClass())
				return probleme.getType() == this.getType();
		}
		return false;
	}
}
