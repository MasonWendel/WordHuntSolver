import java.util.*;

public class WordHuntSolver {
    public static String[][] InitBoard(String[][] board){
        Scanner in = new Scanner(System.in); 
        for(int i = 0; i<4; i++){
            System.out.println("Enter the row of letters: ");
            String row = in.nextLine().trim(); 
            for(int j = 0; j<4; j++){
                board[i][j] = Character.toString(row.charAt(j)); 
            }
        }
        return board; 
    }
    public static void main(String[] args) {
        Set<String> words = BootUp.loadDict(); // Init dict
        
        String[][] board = new String[4][4]; 
        Boolean[][] visitedBoard = {{false,false,false,false},
                                    {false,false,false,false},
                                    {false,false,false,false},
                                    {false,false,false,false},
                                    };

        
        System.out.println(visitedBoard[0][0]);
    }
}
