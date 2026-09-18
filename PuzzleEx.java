package com.zetcode;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class MyButton extends JButton {

    private boolean isLastButton;

    public MyButton() {

        super();

        initUI();
    }

  public MyButton(Image image) {

        super(new ImageIcon(image));

        initUI();
    }
   private void initUI() {

        isLastButton = false;
        BorderFactory.createLineBorder(Color.gray);

        addMouseListener(new MouseAdapter() {
           private void initUI() {

        isLastButton = false;
        BorderFactory.createLineBorder(Color.gray);

        addMouseListener(new MouseAdapter() {
        @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.gray));
            }
        });
    }
      
    public void setLastButton() {

        isLastButton = true;
    }
       public boolean isLastButton() {

        return isLastButton;
    }
}
   public class PuzzleEx extends JFrame {
     private JPanel panel;
    private BufferedImage source;
    private BufferedImage resized;
    private Image image;
    private MyButton lastButton;
    private int width, height;
    private List<MyButton> buttons;
    private List<Point> solution;
    private final int NUMBER_OF_BUTTONS = 12;
    private final int DESIRED_WIDTH = 300;
            
            public PuzzleEx() {

        initUI();
    }
             private void initUI() {

        solution = new ArrayList<>();
    
        solution.add(new Point(0, 0));
        solution.add(new Point(0, 1));
        solution.add(new Point(0, 2));
        solution.add(new Point(1, 0));
        solution.add(new Point(1, 1));
        solution.add(new Point(1, 2));
         solution.add(new Point(2, 0));
        solution.add(new Point(2, 1));
        solution.add(new Point(2, 2));
        solution.add(new Point(3, 0));
        solution.add(new Point(3, 1));
        solution.add(new Point(3, 2));
            buttons = new ArrayList<>();
            panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        panel.setLayout(new GridLayout(4, 3, 0, 0));
         try {
             source = loadImage();
            int h = getNewHeight(source.getWidth(), source.getHeight());
            resized = resizeImage(source, DESIRED_WIDTH, h,
                    BufferedImage.TYPE_INT_ARGB);
                } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not load image", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

                 width = resized.getWidth(null);
        height = resized.getHeight(null);
                 
        add(panel, BorderLayout.CENTER);
        for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 3; j++) {
                  image = createImage(new FilteredImageSource(resized.getSource(),
                         new CropImageFilter(j * width / 3, i * height / 4,
                                      (width / 3), height / 4)));

                          var button = new MyButton(image);
                           button.putClientProperty("position", new Point(i, j));
                           if (i == 3 && j == 2) {
                         lastButton = new MyButton();
                         lastButton.setBorderPainted(false);
                          lastButton.setContentAreaFilled(false);
                             lastButton.setLastButton();
                            lastButton.putClientProperty("position", new Point(i, j));
                               } else {

                    buttons.add(button);
                }
            }
        }
                 Collections.shuffle(buttons);
                 buttons.add(lastButton);
                 for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {
                     var btn = buttons.get(i);
                      panel.add(btn);
            btn.setBorder(BorderFactory.createLineBorder(Color.gray));
            btn.addActionListener(new ClickAction());
        }
            pack();
            setTitle("Puzzle");
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
    }
    private int getNewHeight(int w, int h) {
                 double ratio = DESIRED_WIDTH / (double) w;
                 int newHeight = (int) (h * ratio);
        return newHeight;
    }
     private BufferedImage loadImage() throws IOException {
         var bimg = ImageIO.read(new File("src/resources/icesid.jpg"));
          return bimg;
    }
          private BufferedImage resizeImage(BufferedImage originalImage, int width,
                                      int height, int type) {
             var resizedImage = new BufferedImage(width, height, type);

    




       
