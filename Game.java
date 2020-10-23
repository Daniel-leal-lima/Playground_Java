import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Game extends Canvas implements Runnable{
    private static boolean isRunning = false;
    private Thread thread;
    private JFrame jFrame;
    private static final int WIDTH = 160;
    private static final int HEIGHT = 120;
    private static final int SCALE = 4;
    private BufferedImage image;

    public Game(){
        this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        jFrame = new JFrame("PRIMEIRO JOGO FEITO EM JAVA");
        jFrame.add(this);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
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
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = image.getGraphics();
        g.setColor(new Color(20,20,20));
        g.fillRect(0,0,WIDTH, HEIGHT);
        g= bs.getDrawGraphics();
        g.drawImage(image,0,0, WIDTH*SCALE,HEIGHT*SCALE,null);
        bs.show();
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
