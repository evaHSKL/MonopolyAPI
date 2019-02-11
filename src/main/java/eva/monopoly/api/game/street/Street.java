package eva.monopoly.api.game.street;

public abstract class Street {
	private String name;

	public Street(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
