package DiaVDKlasjes.KlassenDiagram;

public interface IColorClickerWebsocketRESTLogic {

	/**
	 * 
	 * @param email
	 * @param password
	 */
	public int SignUp(char email, char password);

	public String[][] getHighscores();

}