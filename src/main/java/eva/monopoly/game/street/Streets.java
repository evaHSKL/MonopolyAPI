package eva.monopoly.game.street;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import eva.monopoly.game.street.streets.FactoryStreet;
import eva.monopoly.game.street.streets.NormalStreet;
import eva.monopoly.game.street.streets.TrainstationStreet;
import eva.monopoly.utils.ResourceReaderUtil;

public class Streets {
	public static ArrayList<Street> loadStreets() {
		ArrayList<Street> streets = new ArrayList<>();
		try {
			Path path = ResourceReaderUtil.getResourcePath("monopoly/resources/Streets.json");
			JsonArray json = ResourceReaderUtil.getObjectAsJsonFromFile(path, JsonArray.class);
			iterrateCards(json, streets);
		} catch (URISyntaxException | IOException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return streets;
	}

	private static void iterrateCards(JsonArray json, ArrayList<Street> streets) {
		for (int i = 0; i < json.size(); i++) {
			JsonElement element = json.get(i);
			JsonObject obj = element.getAsJsonObject();
			streets.add(loadStreet(obj));
		}
	}

	private static Street loadStreet(JsonObject obj) {
		String name = obj.get("name").getAsString();
		String group = obj.get("group").getAsString();
		int mortgageValue = obj.get("mortgagevalue").getAsInt();
		int cost = obj.get("cost").getAsInt();

		JsonObject objRent = obj.get("rent").getAsJsonObject();

		int nohouse;
		int onehouse;
		int twohouses;
		int threehouses;
		int fourhouses;
		int hotel;
		int housecost;
		int factorsingle;
		int factorgroup;
		int onestation;
		int twostations;
		int threestations;
		int fourstations;

		Street street = null;

		switch (group) {
		case "factory":
			factorsingle = objRent.get("factorsingle").getAsInt();
			factorgroup = objRent.get("factorgroup").getAsInt();
			street = new FactoryStreet(name, mortgageValue, group, cost, factorsingle, factorgroup);
			break;
		case "trainstation":
			onestation = objRent.get("onestation").getAsInt();
			twostations = objRent.get("twostations").getAsInt();
			threestations = objRent.get("threestations").getAsInt();
			fourstations = objRent.get("fourstations").getAsInt();
			street = new TrainstationStreet(name, mortgageValue, group, cost, onestation, twostations, threestations,
					fourstations);
			break;
		default:
			nohouse = objRent.get("nohouse").getAsInt();
			onehouse = objRent.get("onehouse").getAsInt();
			twohouses = objRent.get("twohouses").getAsInt();
			threehouses = objRent.get("threehouses").getAsInt();
			fourhouses = objRent.get("fourhouses").getAsInt();
			hotel = objRent.get("hotel").getAsInt();
			housecost = objRent.get("housecost").getAsInt();
			street = new NormalStreet(name, mortgageValue, group, cost, nohouse, onehouse, twohouses, threehouses,
					fourhouses, hotel, housecost);
			break;
		}
		return street;
	}
}
