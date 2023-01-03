import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class show {
    public static void main(String[] args){
        JFrame screen = new JFrame("Helo");
        screen.setSize(800,800);
        screen.add(new cube());
        screen.setDefaultCloseOperation(3);
        screen.setVisible(true);
    }
}
class cube extends JTextArea implements KeyListener{
    int[][] move = new int[127][2];
    int[] shift = {0,0};
    public void paintComponent(Graphics g){
        g.fillRect(0, 0, 800, 800);
        g.setColor(getBackground());
        g.fillRect(shift[0],shift[1],50,50);
    }
    public void keyPressed(KeyEvent e){
        displace(move[e.getKeyCode()]);
    }
    public void keyReleased(KeyEvent e){
        
    }
    public void keyTyped(KeyEvent e){
        
    }
    void displace(int[] motion){
        if(motion.length == shift.length){
            for(int i = 0;i < motion.length;i++){
                shift[i] = Math.max((shift[i] + motion[i]),0) % 850;
            }
            repaint();

        }
    }
    cube(){
        //ARROW KEYS
        move[37][0] = -1;
        move[37][1] = 0;
        move[38][0] = 0;
        move[38][1] = -1;
        move[39][0] = 1;
        move[39][1] = 0;
        move[40][0] = 0;
        move[40][1] = 1;
        //WASD
        move[65][0] = -1;
        move[65][1] = 0;
        move[87][0] = 0;
        move[87][1] = -1;
        move[68][0] = 1;
        move[68][1] = 0;
        move[83][0] = 0;
        move[83][1] = 1;
        addKeyListener(this);
    }
}