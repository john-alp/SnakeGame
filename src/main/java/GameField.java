import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
    private final int SIZE = 320; // размер игрового поля
    private final int DOT_SIZE = 16; // размер точки (16 пикселей)
    private final int ALL_DOTS = 400; // всего сколько поместится точек на игровом
    private Image dot; //  AWT, Abstract Window Toolkit https://it.wikireading.ru/32693
    private Image apple;
    private int appleX; // значение местонахождения яблока
    private int appleY;
    private int[] x = new int[ALL_DOTS]; // максимальный размер змейки
    private int[] y = new int[ALL_DOTS];
    private int dots;  // размер змейки в текущий момент
    private Timer timer; // стандартный свинговый таймер
    private boolean left = false; // начальное значение false
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true; //

    public GameField() {
        setBackground(Color.black);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    public void initGame() {
        dots = 3; // Размер змейки 3x16
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i * DOT_SIZE; // DOT_SIZE размер точки .. 1/x=48 2/x=32 3/x=16
            y[i] = 48;
        }
        timer = new Timer(250, this); // 250 миллисекунд, на классе GameField
        timer.start();
        createApple();
    }

    public void createApple() {
        appleX = new Random().nextInt(20) * DOT_SIZE; // на игровое поле может поместиться 20, 16 пиксельных квадратиков
        appleY = new Random().nextInt(20) * DOT_SIZE; // от 0 до 19
    }

    public void loadImages() {  // загружаем 16 битные картинки
        ImageIcon imageIconApple = new ImageIcon("apple.png");
        apple = imageIconApple.getImage();
        ImageIcon imageIconDot = new ImageIcon("dot.png");
        dot = imageIconDot.getImage();
    }

    @Override  // перерисовываем змейку
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.drawImage(apple, appleX, appleY, this);
            for (int i = 0; i < dots; i++) {   // тело змейки
                g.drawImage(dot, x[i], y[i], this);
            }
        } else {
            String str = " Game Over ";
            //   Font font = new Font("Arial",14,Font.BOLD);
            g.setColor(Color.ORANGE);
            //   g.setFont(font);
            g.drawString(str, 125, SIZE / 2);
        }
    }

    // проводим логическую перерисовку точки, тоесть делаем сдвиг в массиве
    public void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1]; // сдвигаем тело змейки
            y[i] = y[i - 1];
        }
        if (left) {    // а голову передвигаем в нужном направлении
            x[0] -= DOT_SIZE;
        }
        if (right) {
            x[0] += DOT_SIZE;
        }
        if (up) {
            y[0] -= DOT_SIZE;
        }
        if (down) {
            y[0] += DOT_SIZE;
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            dots++;
            createApple();
        }
    }

    public void checkCollisions() {
        for (int i = dots; i > 0; i--) {  // столкновение со своим телом
            if (i > 4 && x[0] == x[i] && y[0] == y[i])  // если тело > 4, координаты головы совподают с координатами тела змейки
                inGame = false;
        }
        if (x[0] > SIZE) {
            inGame = false;
        }
        if (x[0] < 0) {
            inGame = false;
        }
        if (y[0] > SIZE) {
            inGame = false;
        }
        if (y[0] < 0) {
            inGame = false;
        }
    }

    @Override // вызывается каждый раз, когда "тикает" таймер
    public void actionPerformed(ActionEvent e) {
        if (inGame) {   // inGame - если мы в игре
            checkApple();
            checkCollisions();
            move();
        }
        repaint();
    }

    /*
     KeyListener обрабатыват события с клавиатуры
    KeyListener имеет три метода: keyTyped, keyPressed и keyReleased.
     Метод keyTyped вызывается системой каждый раз, когда пользователь нажимает на клавиатуре клавиши символы Unicode.
     Метод keyPressed вызывается системой в случае нажатия любой клавиши на клавиатуре.
     Метод keyReleased вызывается при отпускании любой клавиши на клавиатуре.
    Чтобы добавить слушателя KeyListener к интересуемому компоненту для прослушивания событий клавиатуры,
    используется метод addKeyListener. В качестве параметра методу передается ссылка на слушателя.
      Для удаления слушателя используется метод removeKeyListener.
     */
    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            System.out.println(key);
            if (key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_RIGHT && !left) {
                right = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_UP && !down) {
                right = false;
                up = true;
                left = false;
            }
            if (key == KeyEvent.VK_DOWN && !up) {
                right = false;
                down = true;
                left = false;
            }
        }
    }
}
