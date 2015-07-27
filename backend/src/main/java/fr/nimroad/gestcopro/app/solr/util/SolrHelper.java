package fr.nimroad.gestcopro.app.solr.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public enum SolrHelper {

	INSTANCE;
	
	public final Pattern IGNORED_CHARS_PATTERN = Pattern.compile("\\p{Punct}");
	
	public Collection<String> splitSearchTermAndRemoveIgnoredCharacters(String searchTerm) {
		String[] searchTerms = StringUtils.split(searchTerm, " ");
		List<String> result = new ArrayList<String>(searchTerms.length);
		for (String term : searchTerms) {
			if (StringUtils.isNotEmpty(term)) {
				result.add(IGNORED_CHARS_PATTERN.matcher(term).replaceAll(" "));
			}
		}
		System.out.println("result :" + result);
		return result;
	}
}
