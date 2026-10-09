**Puzzle-game-in-Java-Swing
**


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

We use a GridLayout to store our components. The layout consists of 4 rows and 3 columns.

         image = createImage(new FilteredImageSource(resized.getSource(),
         new CropImageFilter(j * width / 3, i * height / 4,
          (width / 3), height / 4)));
CropImageFilter is used to cut a rectangular shape from the already resized image source. It is meant to be used in conjunction with a FilteredImageSource object to produce cropped versions of existing images.

          button.putClientProperty("position", new Point(i, j));
Buttons are identified by their position client property. It is a point containing the button's correct row and colum position in the picture. These properties are used to find out if we have the correct order of buttons in the window.

        if (i == 3 && j == 2) {
           lastButton = new MyButton();
           lastButton.setBorderPainted(false);
           lastButton.setContentAreaFilled(false);
           lastButton.setLastButton();
           lastButton.putClientProperty("position", new Point(i, j));
           } else {
    buttons.add(button);
     }
The button with no image is called the last button; it is placed at the end of the grid in the bottom-right corner. It is the button that swaps its position with the adjacent button that is being clicked. We set its isLastButton flag with the setLastButton() method.


         Collections.shuffle(buttons);
         buttons.add(lastButton);
 We randomly reorder the elements of the buttons list. The last button, i.e. the button with no image, is inserted at the end of the list. It is not supposed to be shuffled, it always goes at the end when we start the  Puzzle game.


        for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {
             MyButton btn = buttons.get(i);
             panel.add(btn);
             btn.setBorder(BorderFactory.createLineBorder(Color.gray));
             btn.addActionListener(new ClickAction());
    }
All the components from the buttons list are placed on the panel.  We create some gray border around the buttons and add a click action listener.

            private int getNewHeight(int w, int h) {
