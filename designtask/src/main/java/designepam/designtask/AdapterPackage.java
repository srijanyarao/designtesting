package designepam.designtask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterPackage {

	static class CountriesInterface {
		public List<String> getList() {
			List<String> countries = Arrays.asList("IND",
					"PAK", "SL");
			return countries;
		}
	}

	static class CountriesAdapter {
		private static Map<String, String> countryCodeNameMapping = new HashMap<String, String>();
		static {
			countryCodeNameMapping.put("IND", "India");
			countryCodeNameMapping.put("PAK", "Pakistan");
			countryCodeNameMapping.put("SL", "Sri Lanka");
			//...A lot of others as well
		}

		public List<String> getTranslatedList() {
			List<String> countryCodes = new CountriesInterface()
					.getList();
			List<String> countryNames = new ArrayList<String>();
			for (String country : countryCodes) {
				countryNames.add(countryCodeNameMapping
						.get(country));
			}
			return countryNames;
		}
	}

	public static void main(String[] args) {
		System.out.println(new CountriesAdapter()
				.getTranslatedList());
	}

}
