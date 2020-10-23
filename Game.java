import java.awt.Canvas;

public class Game extends Canvas implements Runnable{
    public static boolean isRunning = false;
    public Thread thread;
    public static final int WIDTH = 160;
    public static final int HEIGHT = 120;
    public static final int SCALE = 4;

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
        System.out.println("tick");
    }

    private void render() {
        System.out.println("Render");
    }
    @Override
    public void run() {
        while (isRunning){
            tick();
            render();
        }
    }

    public void stop() {
    }
}
