package art.algo;

import processing.core.PApplet;
import java.util.Random;

public class Plein007 extends PApplet {
    int w, h;
    int leftmargin, rightmargin, topmargin, bottommargin, ah, aw;
    int resolution;
    double penwidth;
    int st;
    float cx;
    float cy;
    float rad;
    Random rand;

    @Override
    public void settings() {
        w = 900;
        h = 900;
        size(w, h);
    }

    @Override
    public void setup() {
        int margin = 45;
        leftmargin = margin;
        rightmargin = w-margin;
        topmargin = margin;
        bottommargin = h-margin;
        aw = rightmargin - leftmargin;
        ah = bottommargin - topmargin;
        colorMode(HSB, 360, 100, 100, 250);
        penwidth = 0.04 * 96; // 0.04 inch is 1 mm, the width of stabilo 68/32
        strokeWeight(3);
        rand=new Random();
        int[] resolutions = new int[] { 3,5,7 };
        int randomIndex = rand.nextInt(resolutions.length);
        resolution = resolutions[randomIndex];
    }

    @Override
    public void draw() {
        background(0, 0, 100);
        noFill();
        stroke(0,100,100);
        vera();
        noLoop();
    }

    public void vera() {
        double step = 270;//Math.floor(actualwidth / resolution);
        resolution=3;
        for (int i = 0; i < resolution; i++) {
            double x = leftmargin + i * step;
            for (int j = 0; j < resolution; j++) {
                double y = topmargin + j * step;
                tiltquad(x, y, step);
            }
        }
    }

    public void tiltquad(double x, double y, double step) {
        double off = 0.2;
        double inc = penwidth + off;
        double horizon = 0.0;
        double desordre = (rand.nextDouble() * (3.6 + 3.6)) - 3.6; // random number in range (-3.6, 3.6)
        pushMatrix();
        translate((float) x, (float) y);
        rotate(radians((float) desordre));
        for (double i = 0; i < step; i += inc) {
            line(0, (float) horizon, (float) step, (float) horizon);
            horizon += inc;
       }
        popMatrix();
    }

    public static void main(String[] args) {
        String[] processingArgs = { "desordre " };
        Plein007 mySketch = new Plein007();
        PApplet.runSketch(processingArgs, mySketch);
    }
}

