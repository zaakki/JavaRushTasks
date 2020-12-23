package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace(".","/") +
            "/vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies) {
        try{
            updateFile(getUpdatedFileContent(vacancies));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//Пора заняться отображением вакансий.
//1. В методе update класса HtmlView реализуй следующую логику:
//1.1. сформируй новое тело файла vacancies.html, которое будет содержать вакансии,
//1.2. запиши в файл vacancies.html его обновленное тело,
//1.3. Все исключения должны обрабатываться в этом методе - выведи стек-трейс, если возникнет исключение.
//
//2. Для реализации п.1 создай два пустых private метода:
//String getUpdatedFileContent(List<Vacancy>), void updateFile(String),
//Реализовывать их логику будем в следующих заданиях.
//
//3. Чтобы добраться до файла vacancies.html, сформируй относительный путь к нему.
//В классе HtmlView создай приватное строковое final поле filePath, присвой ему относительный путь к vacancies.html.
//Путь должен быть относительно корня проекта.
//Формируй путь динамически используя this.getClass().getPackage() и разделитель "/".
//
//Подсказка: путь должен начинаться с "./".
//1. В HtmlView создай protected метод Document getDocument() throws IOException, в котором
//распарси файл vacancies.html используя Jsoup. Кодировка файла "UTF-8", используй поле filePath.
//
//2. Получи элемент, у которого есть класс template.
//Сделай копию этого объекта, удали из нее атрибут "style" и класс "template".
//Используй этот элемент в качестве шаблона для добавления новой строки в таблицу вакансий.
//
//3. Удали все добавленные ранее вакансии. У них единственный класс "vacancy".
//В файле backup.html это одна вакансия - Junior Java Developer.
//Нужно удалить все теги tr, у которых class="vacancy".
//Но тег tr, у которого class="vacancy template", не удаляй.
//Используй метод remove.
    //. В цикле для каждой вакансии:
//4.1. склонируй шаблон тега, полученного в п.2. Метод clone.
//4.2. получи элемент, у которого есть класс "city". Запиши в него название города из вакансии.
//4.3. получи элемент, у которого есть класс "companyName". Запиши в него название компании из вакансии.
//4.4. получи элемент, у которого есть класс "salary". Запиши в него зарплату из вакансии.
//4.5. получи элемент-ссылку с тегом a. Запиши в него название вакансии(title). Установи реальную ссылку на вакансию вместо href="url".
//4.6. добавь outerHtml элемента, в который ты записывал данные вакансии,
//непосредственно перед шаблоном <tr class="vacancy template" style="display: none">
//
//5. Верни html код всего документа в качестве результата работы метода.
//
//6. В случае возникновения исключения, выведи его стек-трейс и верни строку "Some exception occurred".
//
//7. Запусти приложение, убедись, что все вакансии пишутся в файл vacancies.html.
    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath),"UTF-8");
    }
    private String getUpdatedFileContent(List<Vacancy> vacancies){
        Document doc = null;
        try {
            doc = getDocument();
            Element temp = doc.getElementsByClass("template").first();
            Element cloneTemp = temp.clone();
            cloneTemp.removeAttr("style");
            cloneTemp.removeClass("template");
            doc.select("tr[class=vacancy]").remove().not("tr[class=vacancy template");
            for (Vacancy vacancy :vacancies ) {
                Element localClone = cloneTemp.clone();
                localClone.getElementsByClass("city").first().text(vacancy.getCity());
                localClone.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                localClone.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element link = localClone.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                temp.before(localClone.outerHtml());
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return doc.html();
    }
    private void updateFile(String string){
        try(FileWriter fw = new FileWriter(new File(filePath))){
            fw.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }
}
