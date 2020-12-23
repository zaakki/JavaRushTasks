package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    private String url = String.format(URL_FORMAT, "Kiev", 3);
    private String cacheString = "http://javarush.ru/testdata/big28data.html";


    //Это только для этого пункта, в следующих заданиях используй реальные страницы.
    //
    //1. В классе HHStrategy создай protected метод Document getDocument(String searchString, int page) throws IOException.
    //
    //2. Реализуй следующую логику метода getVacancies в классе HHStrategy:
    //2.1. Приконнекться к закешированной страничке ХэдХантера используя метод getDocument, нумерация начинается с 0.
    //2.2. Получи список элементов с атрибутом "vacancy-serp__vacancy". Должно быть до 20 вакансий на странице.
    //2.3. Если данные в списке из п.2.2 есть, то для каждого элемента:
    //2.3.1. создать вакансию и заполнить все ее данные, получив данные из текущего элемента.
    //Если тег с зарплатой присутствует, то заполнить и поле salary, иначе инициализировать поле пустой строкой.
    //2.4. Выполнить п.2.1-2.3 для следующей страницы ХэдХантера.
    //2.5. Если закончились страницы с вакансиями, то выйти из цикла.

    protected Document getDocument(String searchString, int page) throws IOException {

        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36")
                    .referrer("no-referrer-when-downgrade").get();

//        Document doc = null;
//        try {
//             doc = Jsoup.connect(String.format(URL_FORMAT,"Kiev",0))
//                    .userAgent("user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
//                            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36")
//                    .referrer("no-referrer-when-downgrade").get();
//            doc.html();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return doc;
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
                Elements elements = document.select("[data-qa=vacancy-serp__vacancy");
                if (elements.size() == 0)
                    break;
                for (Element element : elements) {
                    vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                    vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                    vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                    vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href").trim());
                    vacancy.setSiteName(URL_FORMAT);
                    list.add(vacancy);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
