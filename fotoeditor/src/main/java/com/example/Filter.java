 package com.example;

import java.awt.image.BufferedImage;

public interface Filter {
    public BufferedImage applyFilter(BufferedImage input);
    
} 