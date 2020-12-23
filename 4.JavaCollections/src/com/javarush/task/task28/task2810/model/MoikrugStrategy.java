package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    protected Document getDocument(String searchString, int page) throws IOException {

        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("uMozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)" +
                        " Chrome/84.0.4147.125 Safari/537.36")
                .referrer("no-referrer-when-downgrade").get();
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        Document document;
        List<Vacancy> list = new ArrayList<>();
        Vacancy vacancy;
        int i = 0;
        try {
            while (true) {

                document = getDocument(searchString, i++);

                if (document == null)
                    break;
                Elements elements = document.getElementsByClass("job");

                if (elements.size() == 0)
                    break;
                for (Element element : elements) {
                    vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue("class", "title").text());
                    String city = element.getElementsByAttributeValue("class", "location").text();
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    String salary = element.getElementsByAttributeValue("class", "salary").text();
                    vacancy.setUrl("https://moikrug.ru" + element.select("a[class=job_icon]").attr("href"));
                    vacancy.setSiteName(URL_FORMAT);
                    vacancy.setCity(city.length() == 0 ? "" : city);
                    vacancy.setSalary(salary.length() == 0 ? "" : salary);
                    list.add(vacancy);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
