/** 
 * 
 * Lab4 When given the first sunday of the month, use that to determine the first day of the month
 * COSC 236 Section 102
 * Program #5/Lab Assignment #4 Create Calendar
 *
 *
 * @author Ronnie Huggins & Gradieu Kisala
 */

import java.util.*;

class Calendar{

    /** Main method for the CreateCalendar program.
     * @param args an array of command line arguments*/

    public static void main(String[] args){
        System.out.println("Hello world");
        getInfo();
        }

    /**
     * Void method to start the information gathering from the user, will collect the total number of days in the month
     * and will tell the program when the first sunday of the month is
     * once this information is done it passes the information into the fillCalendar function
     */
    public static void getInfo(){
        Scanner console = new Scanner(System.in);

        System.out.print("How many days are in the month?: ");
        int totalDays = console.nextInt();

        System.out.print("what is the first sunday ");
        int day = console.nextInt();

        System.out.println("The month has - " +totalDays+ " - days, and the first sunday of the month is - "+day);
        fillCalendar(day, totalDays);

        

        
    }

    /**
     * @params This function takes in a two-dimensional array and will draw the array based on the data provided to it.
     * In this function we ustilize two more functions which are padding for the numbers, and then padding for the weekdays - strings
     * This allows us to draw the calendar and customize our padding as we see fit.
     */
    public static void drawCalendar(int[][]cal){
        String horizontal = "-";
        String plus = "+";
        
        String[] weekDays =  {"Sun", "Mon","Tue","Wed","Thu","Fri","Sat"};

        for(int i = 0; i < weekDays.length; i++){
            System.out.print(str_padding(weekDays[i], 9) + weekDays[i] + str_padding(weekDays[i], 8));
        }
        System.out.println();

        String top_bot = (plus + horizontal.repeat(7));
        System.out.print(top_bot.repeat(7));
        System.out.print(plus+ "\n");
        
        for(int i = 0; i < 6; i++){
            System.out.print("|");
            for(int j = 0; j < 7; j++){
                
                System.out.print(num_padding(cal[i][j], 7));
                System.out.print("|");
            }
            System.out.println();
            }
        System.out.print(top_bot.repeat(7));
        System.out.print(plus+ "\n");
        
       



    }

    /**
     * This function takes in the first sunday of the month and the total number of days in that month,
     * using this information we fill in the correct days for the month and then pass that array into the draw calendar function. which
     * will draw the calendar in our terminal for us.
     */
    public static void fillCalendar(int day, int totalDays){
      
        int dayCounter = 1;
        int[][] calendar = new int[6][7];


        while(dayCounter <= totalDays){
            for(int i = 0; i < 6; i ++){   
                for(int j = 0; j < 7; j++){
                    if(dayCounter > 31) {break;}
                    else{
                        if(i == 0 && j < (8-day)){
                            System.out.print("");
                        }
                        else{
                            calendar[i][j] = dayCounter;
                            dayCounter++;
                        }
                        
                    }
                }
            }
        }
            drawCalendar(calendar);
    }

        /**
         * Takes the actual integer and width we desire, 
         * converts the integer into a string and then adds padding based on the width
         */

        public static String num_padding(int n, int width){
            String pad = " ";
            String s;

            if(n == 0){
                s = pad.repeat(width);
            }
            else{
            s = "" + n;

            if(s.length() == 1){
                s = pad.repeat((width - s.length()) / 2) + n + pad.repeat((width - s.length()) / 2);
            }
            else{
                s = pad.repeat((width - s.length()) /2) + n + pad.repeat(((width - s.length()) /2)+ 1);
            }
            }
            return s;
        }

     /**
         * Takes the string and width we desire, 
         * then adds padding to the string based on the width
         */
        public static String str_padding(String n, int width){
            String s = "" + n;
            String pad = " ";
            width = (width - n.length()) / 2;
            
            s = pad.repeat(width);
            return s;
        }


    
}
