package eva.monopoly.game.card;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import eva.monopoly.game.card.Card.CardType;
import eva.monopoly.game.card.cards.JailCard;
import eva.monopoly.game.card.cards.MoneyCard;
import eva.monopoly.game.card.cards.MoneybuildingsCard;
import eva.monopoly.game.card.cards.MoneyplayerCard;
import eva.monopoly.game.card.cards.MoveCard;
import eva.monopoly.game.card.cards.MoveamountCard;
import eva.monopoly.game.card.cards.MovenextCard;
import eva.monopoly.game.card.cards.MovenextmoneydoubleCard;
import eva.monopoly.game.card.cards.UnjailCard;
import eva.monopoly.utils.ResourceReaderUtil;

public class Cards {

	public static Entry<ArrayList<Card>, ArrayList<Card>> loadCards() {
		ArrayList<Card> eventCards = new ArrayList<>();
		ArrayList<Card> communityCards = new ArrayList<>();
		try {
			Path path = ResourceReaderUtil.getResourcePath("monopoly/resources/Cards.json");
			JsonArray json = ResourceReaderUtil.getObjectAsJsonFromFile(path, JsonArray.class);
			iterrateCards(json, eventCards, communityCards);
		} catch (URISyntaxException | IOException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return new AbstractMap.SimpleEntry<>(eventCards, communityCards);
	}

	private static void iterrateCards(JsonArray json, ArrayList<Card> eventCards, ArrayList<Card> communityCards) {
		for (int i = 0; i < json.size(); i++) {
			JsonElement element = json.get(i);
			JsonObject obj = element.getAsJsonObject();

			Card card = loadCard(obj);
			switch (card.getType()) {
			case EVENT:
				eventCards.add(card);
				break;
			case COMMUNITY:
				communityCards.add(card);
				break;
			}
		}
	}

	private static Card loadCard(JsonObject obj) {
		String text = obj.get("text").getAsString();
		CardType type = CardType.valueOf(obj.get("type").getAsString().toUpperCase());

		JsonObject objAction = obj.get("action").getAsJsonObject();
		String actionType = objAction.get("type").getAsString();

		String target;
		int amount;
		int house;
		int hotel;

		Card card = null;

		switch (actionType) {
		case "jail":
			card = new JailCard(text, type);
			break;
		case "unjail":
			card = new UnjailCard(text, type);
			break;
		case "move":
			target = objAction.get("target").getAsString();
			card = new MoveCard(text, type, target);
			break;
		case "movenext":
			target = objAction.get("target").getAsString();
			card = new MovenextCard(text, type, target);
			break;
		case "moveamount":
			amount = objAction.get("amount").getAsInt();
			card = new MoveamountCard(text, type, amount);
			break;
		case "movenextmoneydouble":
			target = objAction.get("target").getAsString();
			card = new MovenextmoneydoubleCard(text, type, target);
			break;
		case "money":
			amount = objAction.get("amount").getAsInt();
			card = new MoneyCard(text, type, amount);
			break;
		case "moneybuildings":
			house = objAction.get("house").getAsInt();
			hotel = objAction.get("hotel").getAsInt();
			card = new MoneybuildingsCard(text, type, house, hotel);
			break;
		case "moneyplayer":
			amount = objAction.get("amount").getAsInt();
			card = new MoneyplayerCard(text, type, amount);
			break;
		default:
			throw new IllegalArgumentException("type '" + actionType + "' is unknown");
		}
		return card;
	}
}
