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

        String url = this.urlEncoded(sentece);

        Document doc = Jsoup.connect(url).get();
        List<Element> el =  doc.body().getElementsByTag("td");
        StringBuilder lsTitleFilms = new StringBuilder();

       el.forEach(e -> {
            e.getElementsByTag("a").forEach( a -> lsTitleFilms.append(a.text()).append("¶"));
        });

       return lsTitleFilms.toString();
    }


    private String urlEncoded(String sentece) throws IOException {

        try{

            String newSentece = removeCharacters(sentece);

            StringBuilder creatUrl = new StringBuilder(Constants.SITE_ROOT);
            creatUrl.append("find?q=")
                    .append(URLEncoder.encode(newSentece, String.valueOf(StandardCharsets.UTF_8)))
                    .append("&s=tt&ref_=fn_al");

            return  creatUrl.toString();

        }catch( IOException e){
            throw  new  IOException("Erro ao montar a url.");
        }
    }


    private String removeCharacters(String sentece){
        String nfdNormalizedString = sentece.replace(":", "");

        nfdNormalizedString = nfdNormalizedString.replace("&", "");
        nfdNormalizedString = nfdNormalizedString.replace("@", "");
        nfdNormalizedString = nfdNormalizedString.replace("#", "");
        nfdNormalizedString = nfdNormalizedString.replace("$", "");
        nfdNormalizedString = nfdNormalizedString.replace("%", "");
        nfdNormalizedString = Normalizer.normalize(nfdNormalizedString, Normalizer.Form.NFD);

        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}
