


package convert_to_grayscale;
import java.io.File; // class bulid in
import java.io.IOException;
import java.awt.image.BufferedImage; // class bulid in
import javax.imageio.ImageIO;

public class Convert_to_Grayscale {
    
    public static void main(String[] args) throws IOException {
        BufferedImage img = null; //create object from BufferedImage
        File f = null;

    //read image
    try{
      f = new File("/home/orangeprog1/Desktop/oldImage.jpg");
      img = ImageIO.read(f);
    }catch(IOException e){
      System.out.println("The Error: "+e);
    }

    //get image width and height
    int width = img.getWidth();   // getWidth is a function bulid in class "BufferedImage"
    int height = img.getHeight(); // getHigh is a function bulid in class "BufferedImage"

    //convert to grayscale
    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        int p = img.getRGB(x,y); //getRGB is a function bulid in class "BufferedImage"...get the value of each pixel

        
        int r = (p>>16) & 0xff; //Get Value of Red in each Pixel
        int g = (p>>8) & 0xff;  //Get Value of Green in each Pixel
        int b = p & 0xff;       //Get Value of Blue in each Pixel
       
        
        
        

        //calculate average of RGB in each Pixel
        int avg = (r+g+b)/3;

        //replace RGB value with avg
        p =  (avg << 16) | (avg << 8) | avg; 

        img.setRGB(x, y, p);
      }
    }
    

    //write image
    try{
      f = new File("/home/orangeprog1/Desktop/newImage.jpg");
      ImageIO.write(img, "jpg", f);
    }catch(IOException e){
      System.out.println("The Error: "+e);
    }
        
    }
    
}
