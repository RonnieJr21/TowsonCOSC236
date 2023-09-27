 /**
 * Lab3 Computes the area of Pi for the radius of multiple radius'
 * COSC 236 Section 102
 * Program #4/Lab Assignment #4 Compute PI
 *
 *
 * @author Ronnie Huggins & Gradieu Kisala
 */


class computePI {
    static final double r = 10.0;


/**
 * The main method of which the program is run
 * @param array of strings - command line arguments passed into the function
 * */
    public static void main(String[] args){
        for(int i = 1; i <=10; i++ ){
            double pi = computePI(Math.pow(r, i));
            System.out.println(" At a radius of " + (Math.pow(r, i)) + " the estimate of PI is " + pi + " with a difference of " + (Math.PI - pi));
        }
        
    }

    /**
     * This method will be responsible for computing the value of pi byt using 
     * area/ radius^2 
     * @param the radius as a double
     */
    public static double computePI(double radius){
        double area = computeArea(radius);
        return (area/ (radius * radius));
    }
        
    /**
     * This method is responisble for calculating the area, since pi is half of the circle,
     * we can then split the half into another half, -r | r, we calculate the area for each section from -r | r 
     * and then add all the values into the variable a
     * @param the radius as a double
     */
    public static double computeArea(double radius){
        double a = 0.0;
        for(double i = -radius ; i <= radius; i++){
            a += computeY(i, radius);
        }
        return a*2;
        
    }

    /**
     * This method will give us the Y value for each x value (x value is the corresponding x axis value from -r | r)
     * When this value is calculated it is returned;
     * @param takes the x axis value and the radius
     */
    public static double computeY(double x, double radius){
        return Math.sqrt((radius * radius)- (x * x));
    }
}