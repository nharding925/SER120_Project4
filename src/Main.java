import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {
    private JFrame frame;
    private JPanel dp, bp;
    private JButton shiny, draggable, moving, splitting, outline, shrinking, combo1, combo2;
    private Scene scene;
    private Timer timer;

    public Main() {
        scene = new Scene(800, 800);

        dp = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                scene.draw(g);
            }
        };
        dp.setPreferredSize(new Dimension(scene.getWidth(), scene.getHeight()));
        dp.setBackground(Color.BLACK);
        scene.registerMouseListener(dp);

        shiny = new JButton("Shiny");
        shiny.addActionListener(_ -> scene.getActions().addToScene(new Ball(scene.getActions(), new Shiny())));
        
        draggable = new JButton("Draggable");
        draggable.addActionListener(_ -> scene.getActions().addToScene(new Ball(scene.getActions(), new Draggable())));
        
        moving = new JButton("Moving");
        moving.addActionListener(_ -> scene.getActions().addToScene(new Ball(scene.getActions(), new Moving())));
        
        splitting = new JButton("Splitting");
        splitting.addActionListener(_ -> scene.getActions().addToScene(new Ball(scene.getActions(), new Splitting(), new Moving())));
        
        outline = new JButton("Outline");
        outline.addActionListener(_ -> scene.getActions().addToScene(new Ball(scene.getActions(), new Outline())));
        
        // New components
        shrinking = new JButton("Shrinking");
        shrinking.addActionListener(_ -> scene.getActions().addToScene(new Ball(scene.getActions(), new Shrink())));
        
        
        // Combination buttons
        combo1 = new JButton("Draggable + Shrinking");
        combo1.addActionListener(_ -> scene.getActions().addToScene(new Ball(scene.getActions(), new Draggable(), new Shrink())));
        
        combo2 = new JButton("Shrinking + Shiny");
        combo2.addActionListener(_ -> scene.getActions().addToScene(new Ball(scene.getActions(), new Shrink(), new Shiny())));

        bp = new JPanel();
        bp.setBackground(Color.GRAY);
        bp.add(shiny);
        bp.add(draggable);
        bp.add(moving);
        bp.add(splitting);
        bp.add(outline);
        bp.add(shrinking);
        bp.add(combo1);
        bp.add(combo2);

        frame = new JFrame();
        frame.add(dp, BorderLayout.CENTER);
        frame.add(bp, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer = new Timer(16, _ -> {
            scene.update();
            dp.repaint();
        });
        timer.start();
    }

    public static void main(String[] args) {
        new Main();
    }
}