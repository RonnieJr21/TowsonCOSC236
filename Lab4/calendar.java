/** 
 * When given the first sunday of the month, use that to determine the first day of the month
 */

import java.util.*;

class Calendar{
    public static void main(String[] args){
        System.out.println("Hello world");
        getInfo();

        }

    public static void getInfo(){
        Scanner console = new Scanner(System.in);

        System.out.print("How many days are in the month?: ");
        int totalDays = console.nextInt();

        System.out.print("what is the first sunday ");
        int day = console.nextInt();

        drawCalendar(day, totalDays);

        
    }

    public static void drawCalendar(int day, int totalDays){
        int[][] calendar = new int[7][7];
        int dayCounter = 1;
        while(dayCounter <= totalDays){
            for(int i = 1; i < 7; i ++){   
                for(int j = 0; j < 7; j++){
                    if(dayCounter > 31){
                        break;
                    }
                    else{
                    calendar[i][j] = dayCounter;
                    dayCounter++;
                    }
                }
            }
        }

            for(int i = 0; i < 7; i++){
                System.out.println();
                for(int j = 0; j < 7; j++){
                    System.out.print(" " + calendar[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
