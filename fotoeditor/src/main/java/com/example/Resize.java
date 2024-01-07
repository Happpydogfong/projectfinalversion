package com.example;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * ConverToGrayScale
 */
public class Resize implements Filter {
    int newHeight;

    Resize(int newHeight) {
        this.newHeight = newHeight;
    }

    @Override
    public BufferedImage applyFilter(BufferedImage img) {
        System.out.println("Scaling image.");
        double scaleFactor = (double) newHeight / img.getHeight();
        int newWidth = (int) (scaleFactor * img.getWidth());

        BufferedImage scaledImg = new BufferedImage(
                newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = scaledImg.createGraphics();
        g2d.drawImage(img, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        System.out.println("Scaling completed.");
        return scaledImg;
    }

    
}