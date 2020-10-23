import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
    public static boolean isRunning = false;
    public Thread thread;
    public JFrame jFrame;
    public static final int WIDTH = 160;
    public static final int HEIGHT = 120;
    public static final int SCALE = 4;

    public Game(){
        this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        jFrame = new JFrame("PRIMEIRO JOGO FEITO EM JAVA");
        jFrame.add(this);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
  
    public synchronized void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private void tick() {
        //System.out.println("tick");
    }

    private void render() {
        //System.out.println("Render");
    }
    @Override
    public void run() {
        long tempo = System.nanoTime();
        double tick = 60.0;
        double ns = 1000000000/tick;
        double delta =0;
        int frames = 0;
        double timer = System.currentTimeMillis();
        while (isRunning){
            long now = System.nanoTime();
            delta+= (now-tempo)/ns;
            tempo=now;
            if (delta>=1){
                tick();
                render();
                frames++;
                delta--;
            }
            if (System.currentTimeMillis() - timer >= 1000){
                System.out.println(frames);
                frames = 0;
                timer +=1000;
            }
            
        }
    }

    public void stop() {
    }
}
