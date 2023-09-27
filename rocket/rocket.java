/**
 * Lab0 writes the message "Hello World!" to the standard output
 * 
 * COSC 236 Section 102
 * Program #1/Lab Assignment #2 ASCII Art
 * 
 * 
 * @author Ronnie Huggins
 */

class Rocket{
    /** 
    *  Main method from which the program will run everything inside.
    */
    public static void main(String args[]){
        System.out.println("Hello World");
        nose();
        for(int i = 0; i<5; i++){
            body();
        }
        nozzle();
        

    }
    /**
     * Method that will print the ascii drawing to the console
     */
     public static void nose(){
        String str = " ";
        System.out.println("       ^      ");
        int j = 0;
        for(int i = 5; i >=0; i--){
             System.out.print(str.repeat(i) + " /");
             System.out.println(str.repeat(j * 2) + " \\");
             j++;
            //  System.out.println(j);
        }
    };

    /**
     * Method that will print the a section of the body of the rocket to the console
     */
    public static void body(){
        String body = "|             |\n";
        System.out.print("+-------------+\n");
        System.out.print(body.repeat(3));
    
    };
    
    /**
     * This Method will print the nozzle of the rocket to the console 
     */
    public static void nozzle(){
        String str = "\"";
        System.out.print("+-------------+\n");
        System.out.println("\\             /");
        System.out.println(" \\           /");
        System.out.println("  " + str.repeat(11));
        System.out.println(" /           \\");
        System.out.println("/             \\");
    };
    public static void merica(){};
}


