package service;

import domain.game.Game;
import exceptions.CustomGenericException;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TicketService {
	private IGameDao gameDao;
	private MessageSource messageSource;

	public void setGameDao(IGameDao gameDao) {
		this.gameDao = gameDao;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void buyTickets(Game game, Integer toBuy, Locale locale) {
		int ticketsLeft = game.getStadium().getCapacity() - game.getBoughtTickets();
		//Nog voldoende tickets
		if (ticketsLeft >= toBuy) {
			game.setBoughtTickets(game.getBoughtTickets() + toBuy);
			gameDao.update(game);
			return;
		}

		String message = messageSource.getMessage(
				"tickets_sold_out",
				new Object[]{},
				locale
		);

		throw new CustomGenericException("ERR1", message);
	}
	public boolean checkSoldOut(Game game) {
		int ticketsLeft = game.getStadium().getCapacity() - game.getBoughtTickets();
		return ticketsLeft == 0;
	}
}
