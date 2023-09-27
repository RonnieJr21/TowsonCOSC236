
/**
 * Lab2 Draws an hourglass with numbers and dots
 * COSC 236 Section 102
 * Program #3/Lab Assignment #3 Hourglass
 * 
 * 
 * @author Ronnie Huggins & Gradieu Kisala
 */
class Hourglass{
    static final int size = 9;
    static final String str = ".";

    /**
     * This is the main method of the program, this is where all of the code will be run at
     * @param args array of command line arguments
     */
public static void main(String args[]){
    for(int i = 0; i < 3; i++){
        generateTop();
        generateBot();
        System.out.println();
    }
}
     /** 
     * This method will print the Top of the hourglass starting with the Number 9 and going down until 1
     */
    static void generateTop(){
       
        for(int i= size; i > 0; i--){
            System.out.print(str.repeat((size - i)));
            for(int j = i; j > 0; j--){
                if(j == i){
                    System.out.print(i);
                }
                else{
                System.out.print(" " + i);
                }
            } 
            System.out.print(str.repeat((size - i)));
            System.out.println();
        }
    }
    /** 
     * This method will print the bottom of the hourglass starting with the Number 2 and going up until 9
     */
    static void generateBot(){
        for(int n = 2; n <= size; n++){
            System.out.print(str.repeat((size - n)));
            for(int k = 1 ; k <= n ; k++){
                if(k == n){
                    System.out.print(n);
                }
                else{
                System.out.print(n + " ");
                }
            } 
            System.out.print(str.repeat((size - n)) + " ");
            System.out.println(); 
        }
    }
}