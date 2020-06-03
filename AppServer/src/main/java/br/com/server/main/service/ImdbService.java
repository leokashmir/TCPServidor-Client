package br.com.server.main.service;

import br.com.server.main.util.Constants;
import com.google.inject.Inject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

import java.util.List;
import java.util.regex.Pattern;


public class ImdbService {

    @Inject
    public ImdbService(){}


    public String listFilms(String sentece) throws IOException {

        final String url = this.urlEncoded(sentece);

        final Document doc = Jsoup.connect(url).get();
        final List<Element> el =  doc.body().getElementsByTag("td");
        final StringBuilder lsTitleFilms = new StringBuilder();

       el.forEach(e -> {
            e.getElementsByTag("a").forEach( a -> lsTitleFilms.append(a.text()).append("¶"));
        });

       return lsTitleFilms.toString();
    }


    private String urlEncoded(String sentece) throws IOException {

        try{

            final String newSentece = removeCharacters(sentece);

            final StringBuilder creatUrl = new StringBuilder(Constants.SITE_ROOT);
            creatUrl.append("find?q=")
                    .append(URLEncoder.encode(newSentece, String.valueOf(StandardCharsets.UTF_8)))
                    .append("&s=tt&ref_=fn_al");

            return  creatUrl.toString();

        }catch( IOException e){
             e.printStackTrace();
        }

        throw  new  IOException("Erro ao montar a url.");
    }


    private String removeCharacters(String sentece){
        sentece = sentece.replaceAll("[:@#$%&]", "");;
        sentece = Normalizer.normalize(sentece, Normalizer.Form.NFD);

        final Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(sentece).replaceAll("");
    }
}
