import java.util.*;

public class WordHuntSolver {

    public static Set<String> words = BootUp.loadDict(); // Init dict

    public static String[][] InitBoard(String[][] board){ // Initializes the board
        Scanner in = new Scanner(System.in); 
        for(int i = 0; i<4; i++){
            System.out.print("Enter the row of letters("+(i+1)+"): ");
            String row = in.nextLine().trim(); 
            for(int j = 0; j<4; j++){
                board[i][j] = Character.toString(row.charAt(j)); 
            }
        }
        return board; 
    }
    public static void solvePuzzle(Set<String> validWords,Boolean[][] visited,String[][] board,int r, int c, String soFar){
         int[][] coords = { // list of coords 
            {0,1},
            {0,-1},
            {1,0}, 
            {1,-1}, 
            {1,1}, 
            {-1,0},
            {-1,-1}, 
            {-1,1}, 
         };

         soFar+=board[r][c]; // Adds current tile to the string so far 

         if(soFar.length()>2&&words.contains(soFar)){ // If so far is a word it is added to the list of valid words
            validWords.add(soFar); 
         }

         visited[r][c] = true; // Marks this spot as visited

         for(int[] coord : coords){ // chooses the next tile to try 
            int newr = r+coord[0]; 
            int newc = c+coord[1]; 
            
            if(!((newr<0)||(newr>3))&&!((newc<0)||(newc>3))){ // checks to see if the coords are out of bounds. (I really need a tool for this, so annoying to write)
                if(visited[newr][newc]!=true){
                    solvePuzzle(validWords, visited, board, newr, newc, soFar);
                }
            }
         }

         visited[r][c] = false; 
    }
    public static void main(String[] args) {
        
        String[][] board = new String[4][4]; // Main playing board
        board = InitBoard(board); 
        Boolean[][] visitedBoard = // Board for the recrusive function to keep track of visited tiles 
        {{false,false,false,false},             
        {false,false,false,false},
        {false,false,false,false},
        {false,false,false,false},
        };

        Set<String> validWords = new TreeSet<String>(); 
        
        for(int r = 0; r<3; r++){
            for(int c = 0; c<3; c++){
                solvePuzzle(validWords, visitedBoard, board, r, c, "");
            }
        }

        ArrayList<String> list = new ArrayList<String>();  // Adding all valid words into an array for sorting
        list.addAll(validWords); 
        list.sort(Comparator.comparing(String::length)); 


        for(String word: list){
            System.out.println(word);
        }


        
    }
}
