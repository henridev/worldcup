package domain.game;

public class GameTicket {
	private final Game game;

	private int tickets; // available

	public GameTicket(Game game, int tickets) {
		this.game = game;
		this.tickets = tickets;
	}

	public int getTickets() {
		return tickets;
	}

	public Game getGame() {
		return game;
	}

	public int buyTickets(int count) {
		if (count <= 0) {
			return -1;
		}

		if (tickets >= count) {
			tickets -= count;
			return count;
		}

		int bought = tickets;
		tickets = 0;
		return bought;
	}

	public boolean soldOut() {
		return tickets == 0;
	}
}
