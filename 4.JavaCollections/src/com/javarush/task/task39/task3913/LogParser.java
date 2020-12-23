package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

    private Path logDir;


    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    //Метод getAllUsers() должен возвращать всех пользователей.
    @Override
    public Set<String> getAllUsers() {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, null, null);
            if (data != null)
                set.add(data.name);
        }
        return set;
    }

    // Метод getNumberOfUsers() должен возвращать количество уникальных пользователей.
    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null) {
                set.add(data.name);
            }
        }
        return set.size();
    }

    //2.3. Метод getNumberOfUserEvents() должен возвращать количество событий от определенного пользователя.
    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.name.equals(user))
                set.add(data.event);
        }
        return set.size();
    }


    //2.4. Метод getUsersForIP() должен возвращать пользователей с определенным IP.
    //Несколько пользователей могут использовать один и тот же IP.
    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.ip.equals(ip))
                set.add(data.name);
        }
        return set;
    }

    //2.5. Метод getLoggedUsers() должен возвращать пользователей, которые делали логин.
    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && Event.LOGIN == data.event)
                set.add(data.name);
        }
        return set;
    }

    //2.6. Метод getDownloadedPluginUsers() должен возвращать пользователей, которые скачали плагин.
    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && Event.DOWNLOAD_PLUGIN == data.event)
                set.add(data.name);
        }
        return set;
    }

    //2.7. Метод getWroteMessageUsers() должен возвращать пользователей, которые отправили сообщение.
    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && Event.WRITE_MESSAGE == data.event)
                set.add(data.name);
        }
        return set;
    }

    //2.8. Метод getSolvedTaskUsers(Date after, Date before) должен возвращать пользователей, которые решали любую задачу.
    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && Event.SOLVE_TASK == data.event)
                set.add(data.name);
        }
        return set;
    }

    //2.9. Метод getSolvedTaskUsers(Date after, Date before, int task) должен возвращать пользователей, которые решали задачу с номером task.
    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && Event.SOLVE_TASK == data.event && task == data.taskNumber)
                set.add(data.name);
        }
        return set;
    }

    //2.10. Метод getDoneTaskUsers(Date after, Date before) должен возвращать пользователей, которые решили любую задачу.
    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && Event.DONE_TASK == data.event)
                set.add(data.name);
        }
        return set;
    }

    //2.11. Метод getDoneTaskUsers(Date after, Date before, int task) должен возвращать пользователей, которые решили задачу с номером task.
    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && Event.DONE_TASK == data.event && task == data.taskNumber)
                set.add(data.name);
        }
        return set;
    }


    //3.1. Метод getDatesForUserAndEvent() должен возвращать даты, когда определенный пользователь произвел определенное событие.
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && event == data.event && data.name.equals(user))
                set.add(data.date);
        }
        return set;
    }

    //3.2. Метод getDatesWhenSomethingFailed() должен возвращать даты, когда любое событие не выполнилось (статус FAILED).
    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && Status.FAILED == data.status)
                set.add(data.date);
        }
        return set;
    }

    //3.3. Метод getDatesWhenErrorHappened() должен возвращать даты, когда любое событие закончилось ошибкой (статус ERROR).
    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && Status.ERROR == data.status)
                set.add(data.date);
        }
        return set;
    }

    //3.4. Метод getDateWhenUserLoggedFirstTime() должен возвращать дату, когда пользователь залогинился впервые за указанный период.
    // Если такой даты в логах нет - null.
    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        TreeSet<Date> set = new TreeSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.name.equals(user) && Event.LOGIN == data.event && Status.OK == data.status)
                set.add(data.date);
        }
        return set.size() > 0 ? set.first() : null;
    }

    //3.5. Метод getDateWhenUserSolvedTask() должен возвращать дату, когда пользователь впервые попытался решить определенную задачу.
// Если такой даты в логах нет - null.
    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        TreeSet<Date> set = new TreeSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.name.equals(user) && Event.SOLVE_TASK == data.event
                    && task == data.taskNumber)
                set.add(data.date);
        }
        return set.size() > 0 ? set.first() : null;
    }

    //3.6. Метод getDateWhenUserDoneTask() должен возвращать дату, когда пользователь впервые решил определенную задачу.
    // Если такой даты в логах нет - null.
    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        TreeSet<Date> set = new TreeSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.name.equals(user) && Event.DONE_TASK == data.event
                    && task == data.taskNumber)
                set.add(data.date);
        }
        return set.size() > 0 ? set.first() : null;
    }

//3.7. Метод getDatesWhenUserWroteMessage() должен возвращать даты, когда пользователь написал сообщение.

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.name.equals(user) && Event.WRITE_MESSAGE == data.event)
                set.add(data.date);
        }
        return set;
    }

//3.8. Метод getDatesWhenUserDownloadedPlugin() должен возвращать даты, когда пользователь скачал плагин.

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.name.equals(user) && Event.DOWNLOAD_PLUGIN == data.event)
                set.add(data.date);
        }
        return set;
    }


    //4.1. Метод getNumberOfAllEvents() должен возвращать количество событий за указанный период.
    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null)
                set.add(data.event);
        }
        return set.size();
    }


    //4.2. Метод getAllEvents() должен возвращать все события за указанный период.
    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null)
                set.add(data.event);
        }
        return set;
    }

    //4.3. Метод getEventsForIP() должен возвращать события, которые происходили с указанного IP.
    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.ip.equals(ip))
                set.add(data.event);
        }
        return set;
    }

    //4.4. Метод getEventsForUser() должен возвращать события, которые инициировал
    //определенный пользователь.
    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.name.equals(user))
                set.add(data.event);
        }
        return set;
    }

    //4.5. Метод getFailedEvents() должен возвращать события, которые не выполнились.
    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && Status.FAILED == data.status)
                set.add(data.event);
        }
        return set;
    }

    //4.6. Метод getErrorEvents() должен возвращать события, которые завершились ошибкой.
    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && Status.ERROR == data.status)
                set.add(data.event);
        }
        return set;
    }

    //4.7. Метод getNumberOfAttemptToSolveTask() должен возвращать количество попыток
    //решить определенную задачу.
    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int res = 0;
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && task == data.taskNumber && Event.SOLVE_TASK == data.event)
                res++;
        }
        return res;
    }

    //4.8. Метод getNumberOfSuccessfulAttemptToSolveTask() должен возвращать количество
    //успешных решений определенной задачи.
    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int res = 0;
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && task == data.taskNumber && Event.DONE_TASK == data.event)
                res++;
        }
        return res;
    }

    //4.9. Метод getAllSolvedTasksAndTheirNumber() должен возвращать мапу (номер_задачи :
    //количество_попыток_решить_ее).
    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.taskNumber != 0 && Event.SOLVE_TASK == data.event) {
                if (map.containsKey(data.taskNumber)) {
                    map.put(data.taskNumber, map.get(data.taskNumber) + 1);
                } else
                    map.put(data.taskNumber, 1);
            }
        }
        return map;
    }

    //4.10. Метод getAllDoneTasksAndTheirNumber() должен возвращать мапу (номер_задачи :
    //сколько_раз_ее_решили).
    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.taskNumber != 0 && Event.DONE_TASK == data.event) {
                if (map.containsKey(data.taskNumber)) {
                    map.put(data.taskNumber, map.get(data.taskNumber) + 1);
                } else
                    map.put(data.taskNumber, 1);
            }
        }
        return map;
    }

    //Вызов метода execute("get ip") должен вернуть Set<String>, содержащий все уникальные IP из лога
    // (это будет: 127.0.0.1, 12.12.12.12, 146.34.15.5, 192.168.100.2 для тестового файла).
    // Аналогично должны работать и другие запросы.
    @Override
    public Set<Object> execute(String query) {   Set<Object> objects = new HashSet<>();
        String field1 = null, field2 = null, value = null;
        Date after = null, before = null, date = null;
        Status status = null;
        Event event = null;
        try {
            Pattern pattern = Pattern.compile("get (?<field1>\\w+) for (?<field2>\\w+) = \"(?<value>[\\w.: ]+)\" and date " +
                    "between \"(?<after>\\d+\\.\\d+\\.\\d+ \\d+:\\d+:\\d+)\" and \"(?<before>\\d+\\.\\d+\\.\\d+ \\d+:\\d+:\\d+)\"");
            Matcher matcher = pattern.matcher(query);
            if (matcher.find()) {
                field1 = matcher.group("field1");
                field2 = matcher.group("field2");
                value = matcher.group("value");
                after = new SimpleDateFormat("d.M.y H:m:s").parse(matcher.group("after"));
                before = new SimpleDateFormat("d.M.y H:m:s").parse(matcher.group("before"));
            } else {
                Pattern pat = Pattern.compile("get (?<field1>\\w+)" +
                        " for (?<field2>\\w+) = \"(?<value>[\\w.: ]+)\"");
                Matcher mat = pat.matcher(query);
                if (mat.find()) {
                    field1 = mat.group("field1");
                    field2 = mat.group("field2");
                    value = mat.group("value");
                }
            }
            if (field1 != null) {
                if (field2 != null) {
                    if (field2.equals("date"))
                        date = new SimpleDateFormat("d.M.y H:m:s").parse(value);
                    if (field2.equals("event")) event = Event.valueOf(value);
                    if (field2.equals("status")) status = Status.valueOf(value);
                    if (field1.equals("ip")) {
                        if (field2.equals("user")) {
                            if (after != null && before != null) objects.addAll(getIPsForUser(value, after, before));
                            else objects.addAll(getIPsForUser(value, null, null));
                        }
                        if (field2.equals("date")) {
                            if (after != null && before != null) {
                                if (date.getTime() >= after.getTime() && date.getTime() <= before.getTime())
                                    objects.addAll(getUniqueIPs(date, date));
                            } else objects.addAll(getUniqueIPs(date, date));
                        }
                        if (field2.equals("event")) {
                            if (after != null && before != null) {
                                Date aft = new Date(after.getTime() + 1);
                                Date bef = new Date(before.getTime() - 1);
                                objects.addAll(getIPsForEvent(event, aft, bef));
                            } else objects.addAll(getIPsForEvent(event, null, null));
                        }
                        if (field2.equals("status")) {
                            if (after != null && before != null) {
                                Date aft = new Date(after.getTime() + 1);
                                Date bef = new Date(before.getTime() - 1);
                                objects.addAll(getIPsForStatus(status, aft, bef));
                            } else objects.addAll(getIPsForStatus(status, null, null));
                        }
                    }
                    if (field1.equals("user")) {
                        if (field2.equals("ip")) {
                            if (after != null && before != null) objects.addAll(getUsersForIP(value, after, before));
                            else objects.addAll(getUsersForIP(value, null, null));
                        }
                        if (field2.equals("date")) {
                            if (after != null && before != null) {
                                if (date.getTime() >= after.getTime() && date.getTime() <= before.getTime())
                                    objects.addAll(getUsersForEventStatusDate(null, null, date, date));
                            } else objects.addAll(getUsersForEventStatusDate(null, null, date, date));
                        }
                        if (field2.equals("event")) {
                            if (after != null && before != null)
                                objects.addAll(getUsersForEventStatusDate(event, null, after, before));
                            else objects.addAll(getUsersForEventStatusDate(event, null, null, null));
                        }
                        if (field2.equals("status")) {
                            if (after != null && before != null)
                                objects.addAll(getUsersForEventStatusDate(null, status, after, before));
                            else objects.addAll(getUsersForEventStatusDate(null, status, null, null));
                        }
                    }
                    if (field1.equals("date")) {
                        if (field2.equals("ip")) {
                            if (after != null && before != null)
                                objects.addAll(getDatesForIpOrUserOrEventOrStatus(value, null, null, null, after, before));
                            else
                                objects.addAll(getDatesForIpOrUserOrEventOrStatus(value, null, null, null, null, null));
                        }
                        if (field2.equals("user")) {
                            if (after != null && before != null)
                                objects.addAll(getDatesForIpOrUserOrEventOrStatus(null, value, null, null, after, before));
                            else
                                objects.addAll(getDatesForIpOrUserOrEventOrStatus(null, value, null, null, null, null));
                        }
                        if (field2.equals("event")) {
                            if (after != null && before != null) {
                                Date aft = new Date(after.getTime() + 1);
                                Date bef = new Date(before.getTime() - 1);
                                objects.addAll(getDatesForIpOrUserOrEventOrStatus(null, null, event, null, aft, bef));
                            } else
                                objects.addAll(getDatesForIpOrUserOrEventOrStatus(null, null, event, null, null, null));
                        }
                        if (field2.equals("status")) {
                            if (after != null && before != null)
                                objects.addAll(getDatesForIpOrUserOrEventOrStatus(null, null, null, status, after, before));
                            else
                                objects.addAll(getDatesForIpOrUserOrEventOrStatus(null, null, null, status, null, null));
                        }
                    }
                    if (field1.equals("event")) {
                        if (field2.equals("ip")) {
                            if (after != null && before != null) objects.addAll(getEventsForIP(value, after, before));
                            else objects.addAll(getEventsForIP(value, null, null));
                        }
                        if (field2.equals("user")) {
                            if (after != null && before != null) objects.addAll(getEventsForUser(value, after, before));
                            else objects.addAll(getEventsForUser(value, null, null));
                        }
                        if (field2.equals("date")) {
                            if (after != null && before != null) {
                                if (date.getTime() >= after.getTime() && date.getTime() <= before.getTime())
                                    objects.addAll(getAllEvents(date, date));
                            } else objects.addAll(getAllEvents(date, date));
                        }
                        if (field2.equals("status")) {
                            if (after != null && before != null)
                                objects.addAll(getEventsForStatus(status, after, before));
                            else objects.addAll(getEventsForStatus(status, null, null));
                        }
                    }
                    if (field1.equals("status")) {
                        if (field2.equals("ip")) {
                            if (after != null && before != null)
                                objects.addAll(getStatusesForIpOrUserOrEvent(value, null, null, after, before));
                            else objects.addAll(getStatusesForIpOrUserOrEvent(value, null, null, null, null));
                        }
                        if (field2.equals("user")) {
                            if (after != null && before != null)
                                objects.addAll(getStatusesForIpOrUserOrEvent(null, value, null, after, before));
                            else objects.addAll(getStatusesForIpOrUserOrEvent(null, value, null, null, null));
                        }
                        if (field2.equals("date")) {
                            if (after != null && before != null) {
                                if (date.getTime() >= after.getTime() && date.getTime() <= before.getTime())
                                    objects.addAll(getStatusesForIpOrUserOrEvent(null, null, null, date, date));
                            } else objects.addAll(getStatusesForIpOrUserOrEvent(null, null, null, date, date));
                        }
                        if (field2.equals("event")) {
                            if (after != null && before != null)
                                objects.addAll(getStatusesForIpOrUserOrEvent(null, null, event, after, before));
                            else objects.addAll(getStatusesForIpOrUserOrEvent(null, null, event, null, null));
                        }
                    }
                }
            } else {
                switch (query) {
                    case "get ip":
                        objects.addAll(getUniqueIPs(null, null));
                        break;
                    case "get user":
                        objects.addAll(getAllUsers());
                        break;
                    case "get date":
                        objects.addAll(getDatesForIpOrUserOrEventOrStatus(null, null, null, null, null, null));
                        break;
                    case "get event":
                        objects.addAll(getAllEvents(null, null));
                        break;
                    case "get status":
                        objects.addAll(getStatusesForIpOrUserOrEvent(null, null, null, null, null));
                        break;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return objects;
    }


    private Set<Event> getEventsForStatus(Status status, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (String line : getStringFromLogFiles()){
            LogParserData data = getDataFromLine(line,after,before);
            if(data != null && data.status == status)
                set.add(data.event);
        }
        return set;
    }

    private Set<Status> getStatusesForIpOrUserOrEvent(String ip, String user, Event event, Date after, Date before){
        Set<Status> set = new HashSet<>();
        for (String line : getStringFromLogFiles()){
            LogParserData data = getDataFromLine(line,after,before);
            if(data != null){
                if(ip == null && user == null && event == null)
                    set.add(data.status);
                else {
                    if(data.ip.equals(ip)) set.add(data.status);
                    if(data.name.equals(user)) set.add(data.status);
                    if (data.event.equals(event)) set.add(data.status);
                }
            }
        }
        return set;
    }

    private Set<Date> getDatesForIpOrUserOrEventOrStatus(String ip, String user, Event event, Status status, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (String line : getStringFromLogFiles()){
            LogParserData data = getDataFromLine(line,after,before);
            if(data!= null){
                if(ip == null && user == null && event == null && status == null){
                    set.add(data.date);
                }else {
                    if(data.ip.equals(ip)) set.add(data.date);
                    if(data.name.equals(user)) set.add(data.date);
                    if(data.event == event) set.add(data.date);
                    if(data.status == status) set.add(data.date);
                }
            }
        }
        return set;

    }

    private Set<String> getUsersForEventStatusDate(Event event, Status status, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for(String line : getStringFromLogFiles()){
            LogParserData data = getDataFromLine(line,after,before);
            if(data != null){
                if(event == null && status == null){
                    set.add(data.name);
                } else {
                    if(event == data.event && status == data.status)
                        set.add(data.name);
                    else {
                        if(event == data.event)
                            set.add(data.name);
                        if(status == data.status)
                            set.add(data.name);
                    }
                }
            }
        }
        return set;
    }


    /////////////////////////////////
    private static class LogParserData {
        private String ip;
        private String name;
        private Date date;
        private Event event;
        private int taskNumber;
        private Status status;

        public LogParserData(String ip, String name, Date date, Event event, int taskNumber, Status status) {
            this.ip = ip;
            this.name = name;
            this.date = date;
            this.event = event;
            this.taskNumber = taskNumber;
            this.status = status;
        }
    }

    //////////////////////////////////////
    private List<String> getStringFromLogFiles() {
        List<String> list = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(logDir, "*.log")) {
            for (Path entry : stream) {
                try (BufferedReader reader = new BufferedReader(new FileReader(entry.toFile()))) {
                    while (reader.ready()) {
                        list.add(reader.readLine());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private LogParserData getDataFromLine(String line, Date after, Date before) {
        try {
            Pattern pattern = Pattern.compile("(?<ip>\\d+\\.\\d+\\.\\d+\\.\\d+)\\s+(?<name>[a-zA-Zа-яА-Я ]+)\\s+" +
                    "(?<date>\\d+\\.\\d+\\.\\d+ \\d+:\\d+:\\d+)\\s+(?<event>[A-Z_]+)(\\s(?<taskNumber>\\d+))?\\s+(?<status>[A-Z]+)");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                Date date = new SimpleDateFormat("d.M.y H:m:s").parse(matcher.group("date"));
                Event event = Event.valueOf(matcher.group("event"));
                Status status = Status.valueOf(matcher.group("status"));
                int taskNumber = 0;
                if (matcher.group("taskNumber") != null)
                    taskNumber = Integer.parseInt(matcher.group("taskNumber"));
                LogParserData logParserHelper = new LogParserData(matcher.group("ip"),
                        matcher.group("name"), date, event, taskNumber, status);
                long ms = date.getTime();
                if (after == null && before == null) {
                    return logParserHelper;
                } else {
                    if (after == null) {
                        if (ms <= before.getTime()) {
                            return logParserHelper;
                        }
                    } else {
                        if (before == null) {
                            if (ms >= after.getTime()) {
                                return logParserHelper;
                            }
                        } else {
                            if (ms >= after.getTime() && ms <= before.getTime()) {
                                return logParserHelper;
                            }
                        }
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null) {
                set.add(data.ip);
            }
        }
        return set.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null)
                set.add(data.ip);
        }
        return set;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && data.name.equals(user)) {
                set.add(data.ip);
            }
        }
        return set;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && event == data.event)
                set.add(data.ip);
        }
        return set;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (String line : getStringFromLogFiles()) {
            LogParserData data = getDataFromLine(line, after, before);
            if (data != null && status == data.status)
                set.add(data.ip);
        }
        return set;
    }
}