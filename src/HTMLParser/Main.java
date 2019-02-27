package HTMLParser;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.swing.text.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import MyFootball.Match;
import MyFootball.MatchManager;


public class Main {
	
	public static void main(String[] args) throws IOException 
	{
		/*Document doc = Jsoup.connect("http://www.sport.pl/pilka/2,116928,,,,178633894,P_SPORT_SLOWNIK.html#wyniki").get();
		Elements elements = doc.select("div.node_body > ul > li > a");
		String url = new String();
		for(org.jsoup.nodes.Element e: elements) {

			System.out.println(e.text());
			if(e.text().contains("7"))
			{
				url = e.attr("href");
				break;
			}
		}
		Document doc2 = Jsoup.connect(url).get();
		
		
		
		
		
		Elements elements3 = doc2.select("div.node_body > ul > li > a > span.c1");
		for(org.jsoup.nodes.Element e: elements3)
		{
			String html2 = e.toString();
			if(html2.contains("Milan"))
			{
				Elements el = Jsoup.parse(html2).select("span.score > span.score1");
				for(org.jsoup.nodes.Element e2: el)
				{
					System.out.println(e2.text());
				}
				Elements el2 = Jsoup.parse(html2).select("span.score > span.score2");
				for(org.jsoup.nodes.Element e2: el2)
				{
					System.out.println(e2.text());
				}
			}
		}*/
		
		HtmlScoreReader rd = new HtmlScoreReader("http://www.sport.pl/pilka/2,116928,,,,178633894,P_SPORT_SLOWNIK.html#wyniki");
		System.out.println(rd.getScore(MatchManager.getInstance().getAllMatches().get(0)));
		
	}

}
