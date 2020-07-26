import javax.swing.*;

public class MainWindow extends JFrame {
    // создаем конструктор и описывем свойства
    public MainWindow(){
        setTitle("Super Snake");
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // при нажатии крестика на окне, заершаем работу приложения
        setSize(330,355); // размер окна
        setLocation(500,200); // позиция окна?
        add(new GameField());
        setVisible(true);

    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }
}
