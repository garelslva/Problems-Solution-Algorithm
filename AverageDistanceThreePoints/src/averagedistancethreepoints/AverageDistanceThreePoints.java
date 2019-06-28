/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package averagedistancethreepoints;

/**
 *
 * @author Vinicius
 */
public class AverageDistanceThreePoints {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println( averageDistanceThreePoints( new Point(1,1), new Point(2,2), new Point(3,3) ) );
    }
    
    /**
     * Dm - average distance to Three Points
     * D1_3 - distancy to P1 and P3
     * D2_3 - distancy to P2 and P3
     * D1_3 = √( (x3 - x1)^2 + (y3 - y1)^2 )
     * D2_3 = √( (x3 - x2)^2 + (y3 - y2)^2 )
     * Dm = ( D1_3 + D2_3 ) / 2 
     * @return Dm 
     */
    public static float averageDistanceThreePoints(Point p1, Point p2, Point p3){
                 float distanceP1toP3 = (float) Math.sqrt( Math.pow( (p3.getX() - p1.getX()), 2) +  Math.pow(p3.getY() - p1.getY(), 2) ),
                       distanceP2toP3 = (float) Math.sqrt( Math.pow( (p3.getX() - p2.getX()), 2) +  Math.pow(p3.getY() - p2.getY(), 2) ); 
                 return  ( distanceP1toP3  +  distanceP2toP3 ) / 2;
    }
    
    static class Point{
        private int x;
        private int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public void setX(int x){
            this.x = x;
        }
        
        public int getX(){
            return x;
        }
        
        public void setY(int y){
            this.y = y;
        }
        
        public int getY(){
            return y;
        }
    }
}
