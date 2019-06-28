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
        System.out.println( averageDistanceThreePoints(1,2,3,1,2,3) );
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
    public static float averageDistanceThreePoints(int x1, int x2, int x3, int y1, int y2, int y3){
                 float distanceP1toP3 = (float) Math.sqrt( Math.pow( (x3 - x1), 2) +  Math.pow(y3-y1, 2) ),
                       distanceP2toP3 = (float) Math.sqrt( Math.pow( (x3 - x2), 2) +  Math.pow(y3-y2, 2) ); 
                 return  ( distanceP1toP3  +  distanceP2toP3 ) / 2;
    }
}
