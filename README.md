Puzzle-game-in-Java-Swing

In this part of the  Java  games tutorial, we create a Java  Puzzle game clone. The source code and the image can be foud at the author's Github Puzzle-game-in-Java-Swing repository.

Java puzzle game points

Using Swing and Java 2D graphics to build the game.
Randomly shuffling buttons with Collections.shuffle().
Loading image with ImageIO.read().
Resizing image with BufferedImage.
Cropping image with CropImageFilter.
Layout out buttons with GridLayout.
Using two ArrayLists of points to check for solution.

Java puzzle game example

The goal of this little game is to form a picture. Buttons containing images are moved by clicking on them. Only buttons adjacent to the empty button can be moved.


We use an image of a Sid character from the Ice Age movie. We scale the image and cut it into twelve pieces.  These pieces are used by JButton components.  The last piece is not used; we have an empty button instead. You can download some reasonably large picture and use it in this  game. 

     addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
      setBorder(BorderFactory.createLineBorder(Color.yellow));
    }
      @Override
      public void mouseExited(MouseEvent e) {
      setBorder(BorderFactory.createLineBorder(Color.gray));

       }
    });
When we hover a mouse pointer over the button, its border changes to yellow colour.
       
        public boolean isLastButton() {

       return isLastButton;
    }
There is one button that we call the last button. It is a button that does not have an image. Other buttons swap space with this one.

    private final int DESIRED_WIDTH = 300;
The image that we use to form is scaled to have the desired width. With the getNewHeight() method we calculate the new height, keeping the image's ratio.

    solution.add(new Point(0, 0));
    solution.add(new Point(0, 1));
    solution.add(new Point(0, 2));
     solution.add(new Point(1, 0));
    ...
The solution array list stores the correct order of buttons which forms the image. Each button is identified by one Point. 

    panel.setLayout(new GridLayout(4, 3, 0, 0));
