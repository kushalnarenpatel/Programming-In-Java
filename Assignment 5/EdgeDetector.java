package com.bham.pij.assignments.edgedetector;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class EdgeDetector {
	
	public Image filterImage(Image image) {
		
		Color[][] pixelData = getPixelDataExtended(image);
		
		pixelData = applyGreyscale(pixelData);
		
		float[][] filter = createFilter();
		
		pixelData = applyFilter(pixelData, filter);
		
		int dimension = pixelData.length;
		
		WritableImage filteredImage = new WritableImage(dimension, dimension);
		
		PixelWriter pw = filteredImage.getPixelWriter();
		
		for (int i = 0; i < dimension; i++) {
		
			for (int j = 0; j < dimension; j++) {
		
				pw.setColor(i, j, pixelData[i][j]);
		
			}
		
		}
		
		return filteredImage;
		
	}
	
	public float[][] createFilter() {
		
		float[][] filter = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
		
		return filter;
		
	}
	
	public Color[][] getPixelDataExtended(Image image) {
		
		int imageWidth = (int) image.getWidth();
		
		int imageHeight = (int) image.getHeight();
		
		Color[][] pixelArray = new Color[imageWidth + 2][imageHeight + 2];
		
		PixelReader pr = image.getPixelReader();
		
		Color black = new Color(0, 0, 0, 1.0);
		
		for (int j = 0; j < imageWidth + 2; j++) {

			for(int i = 0; i < imageHeight + 2; i++) {
	
				pixelArray[i][j] = black;
			
			}
			
		}
		
		for(int j = 1; j < imageWidth + 1; j++) {
			
			for(int i = 1; i < imageHeight + 1; i++) {
				
				Color c = pr.getColor(i - 1, j - 1);
							
				pixelArray[i][j] = c;
		    
			}
			
		}
		
		return pixelArray;
	}
	
	public Color[][] applyFilter(Color[][]pixels, float[][] filter) {
		
		int picturedimension = pixels.length - 2;
		
		int filterdimension = 3;
		
		Color[][] filterPixels = new Color[filterdimension][filterdimension];
		
		Color[][] filteredPixels = new Color[picturedimension][picturedimension];
		
		for(int j = 1; j < picturedimension + 1; j++) {
			
			for(int i = 1; i < picturedimension + 1; i++) {
				
				for(int fi = 0; fi < filterdimension; fi++) {
					
					for(int fj = 0; fj < filterdimension; fj++) {
						
						filterPixels[fi][fj] = pixels[fi + i - 1][fj + j - 1];
						
					}
					
			}
				
				double red = 0;
				
				double green = 0;
				
				double blue = 0;
				
			for(int pj = 0; pj < filterdimension; pj++) {
				
				for(int pi = 0; pi < filterdimension; pi++) {
					
					red = red + (filter[pi][pj] * filterPixels[pi][pj].getRed());
					
					blue = blue + (filter[pi][pj] * filterPixels[pi][pj].getBlue());
					
					green = green + (filter[pi][pj] * filterPixels[pi][pj].getGreen()); 
					
				}
				
			}
			
			if(red < 0) { red = 0; }
			
			if(red > 1) { red = 1; }
			
			if(green < 0) { green = 0; }
			
			if(green > 1) { green = 1; }
			
			if(blue < 0) { blue = 0; }
		
			if (blue > 1) { blue = 1; }
			
			Color filteredPixel = new Color(red, green, blue, 1.0);
			
			filteredPixels[i - 1][j - 1] = filteredPixel;
				
			}
			
		}
		
		return filteredPixels;
		
	}
	
	public Color[][] getPixelData(Image image) {
		
		int imageWidth = (int) image.getWidth();
		
		int imageHeight = (int) image.getHeight();
		
		Color[][] pixelArray = new Color[imageWidth][imageHeight];
		
		PixelReader pr = image.getPixelReader();
		
		for(int j = 0; j < imageWidth; j ++) {
			
			for(int i = 0; i < imageHeight; i++) {
				
				Color c = pr.getColor(i, j);
							
				pixelArray[i][j] = c;
		    
			}
			
		}
		
		return pixelArray;
		
	}
	
	public Color[][] applyGreyscale(Color[][] pixels) {
		
		int dimension = pixels.length;
		
		Color[][] greyPixels = new Color[dimension][dimension];
		
		for(int i = 0; i < dimension; i++) {
			
			for(int j = 0; j < dimension; j++) {
				
				Color pixel = pixels[i][j];
				
				double red = pixel.getRed();
				
				double green = pixel.getGreen();
				
				double blue = pixel.getBlue();
				
				double greyscaleValue = (red + green + blue) / 3;
				
				Color greyPixel = new Color(greyscaleValue, greyscaleValue, greyscaleValue, 1.0);
				
				greyPixels[i][j] = greyPixel;
				
			}
			
		}
		
		return greyPixels;
		
	}

}
