package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener {
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public View(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init(){
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }
    public void exit(){
        controller.exit();
    }

    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        MenuHelper.initFileMenu(this,menuBar);
        MenuHelper.initEditMenu(this,menuBar);
        MenuHelper.initStyleMenu(this,menuBar);
        MenuHelper.initAlignMenu(this,menuBar);
        MenuHelper.initColorMenu(this,menuBar);
        MenuHelper.initFontMenu(this,menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar,BorderLayout.NORTH);
    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane htmlPane = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", htmlPane);
        JScrollPane textPane = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст",textPane);
        tabbedPane.setPreferredSize(new Dimension(250,250));
        TabbedPaneChangeListener tabbedListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedListener);
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged(){
        int selectedTab = tabbedPane.getSelectedIndex();
        if(selectedTab == 0){
            controller.setPlainText(plainTextPane.getText());
        } else if(selectedTab == 1){
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
      String command = e.getActionCommand();
      switch (command){
          case "Новый":
              controller.createNewDocument();
              break;
          case "Открыть":
              controller.openDocument();
              break;
          case "Сохранить":
              controller.saveDocument();
              break;
          case "Сохранить как...":
              controller.saveDocumentAs();
              break;
          case "Выход":
              controller.exit();
              break;
          case "О программе":
              showAbout();
              break;
      }
    }
      public void resetUndo(){
        undoManager.discardAllEdits();
    }
    public UndoListener getUndoListener(){
        return undoListener;
    }
    public void undo(){
        try {
            undoManager.undo();
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
    public void redo(){
        try {
            undoManager.redo();
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
    public boolean canUndo(){
        if(undoManager.canUndo()){
            return true;
        } else
        return false;
    }
    public boolean canRedo(){
        if(undoManager.canRedo()){
            return true;
        } else
        return false;
    }

    public boolean isHtmlTabSelected(){
        if(tabbedPane.getSelectedIndex() == 0 ){
            return true;
        } else
            return false;
    }
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }
    public void showAbout(){
        String info = "This is my HTML editor";
        JOptionPane.showMessageDialog(null,info,"Info about program",JOptionPane.INFORMATION_MESSAGE);
    }
}
