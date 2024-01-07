package com.example;

import java.awt.image.BufferedImage;

public class blur implements Filter{
    @Override
    public BufferedImage applyFilter(BufferedImage img)
    {
        BufferedImage blurImge = new BufferedImage(
            img.getWidth()-2,img.getHeight()-2,BufferedImage.TYPE_BYTE_GRAY
        );
        int pix = 0;
        for (int y = 0; y < blurImge.getHeight(); y++) {
            for (int x = 0; x < blurImge.getWidth(); x++) {
                pix = (int)(4*(img.getRGB(x+1, y+1) & 0xFF)
                + 2*(img.getRGB(x+1, y) & 0xFF)
                + 2*(img.getRGB(x+1, y+2) & 0xFF)
                + 2*(img.getRGB(x, y+1) & 0xFF)
                + 2*(img.getRGB(x+2, y+1) & 0xFF)

                + (img.getRGB(x, y) & 0xFF)
                + (img.getRGB(x, y+2) & 0xFF)
                + (img.getRGB(x+2, y) & 0xFF)
                + (img.getRGB(x+2, y+2) & 0xFF))/16;
                int p = (255<<24) | (pix << 16) | (pix << 8) | pix;
                blurImge.setRGB(x, y, p);
                
            }
            
        }
        return blurImge;
    }
}
