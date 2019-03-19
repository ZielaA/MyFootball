package HTMLParser;

import java.io.IOException;

import javax.swing.text.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import MyFootball.Match;
import MyFootball.Score;

public class HtmlScoreReader { 

	
	private String url;
	private Document doc;
	
	public HtmlScoreReader(String url)
	{
		this.url = url;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void connectToRoundWeb(int roundNumber) throws IOException
	{
		if(roundNumber != 1)
		{
			String newUrl = new String();
			
			Elements elements = doc.select("div.mod_chooser > div.node_body > ul > li > a");
			for(org.jsoup.nodes.Element e: elements)
			{
				if(e.text().equals(Integer.toString(roundNumber) + ". kolejka"))
				{
					newUrl = e.attr("href");
					doc = Jsoup.connect(newUrl).get();
					break;
				}
			}
		}
	}

	public String getTextScore(Match match)
	{
		
		try {
			connectToRoundWeb(match.getRoundNumber());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String score1 = new String();
		String score2 = new String();
		
		Elements elements = doc.select("div.node_body > ul > li > a > span.c1");
		for(org.jsoup.nodes.Element e: elements)
		{
			String html = e.toString();
			if(html.contains(match.getHomeName()) || html.contains(match.getAwayName()))
			{
				score1 = Jsoup.parse(html).select("span.score > span.score1").first().text();
				score2 = Jsoup.parse(html).select("span.score > span.score2").first().text();
				//System.out.println(e.toString() + "           " + match.info());
			}
		}
		return score1 + ":" + score2;
	}
	
	public Score getScore(Match match)
	{
		String [] t = getTextScore(match).split(":");
		//System.out.println(t[0] + ": " + t[1]);
		int score1 = Integer.parseInt(t[0]);
		int score2 = Integer.parseInt(t[1]);
		
		Score score = new Score(score1, score2);
		return score;
	}
	
	public String getUrl()
	{
		return url;
	}

}
