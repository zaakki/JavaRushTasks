package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand  implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".exit_en");
     //1. Реализуй следующую логику в команде ExitCommand:
     //1.1. Спросить, действительно ли пользователь хочет выйти - варианты <y,n>.
     //1.2. Если пользователь подтвердит свои намерения, то попрощаться с ним.
     //1.3. Если пользователь не подтвердит свои намерения, то не прощаться с ним, а просто выйти.
    @Override
    public void execute() throws InterruptOperationException {

            ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
            String answer  = ConsoleHelper.readString();
            if(answer.toLowerCase().equals("y")) {
                ConsoleHelper.writeMessage(res.getString("thank.message"));
            }

    }
}
