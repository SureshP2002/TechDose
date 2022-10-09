//leetcode-1041
//TC-O(N);

class Solution {
    public boolean isRobotBounded(String s) {
        if(s.length()==0)return false;//returning false when ther is no movement
        int x=0;
        int y=0;//initial position of robots
        String direc="North";//initially robot is at north
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='G')//if g means increment or drcrement
            {
                if(direc.equals("North"))y+=1;
                else if(direc.equals("South"))y-=1;
                else if(direc.equals("East"))x+=1;
                else if(direc.equals("West"))x-=1;
            }
            else if(s.charAt(i)=='L')//l means rotate in four direction
            {
                if(direc.equals("North"))direc="West";
                else if(direc.equals("West"))direc="South";
                else if(direc.equals("South"))direc="East";
                else if(direc.equals("East"))direc="North";
            }
            else if(s.charAt(i)=='R')//r means rotate in four directions;
            {
                if(direc.equals("North"))direc="East";
                else if(direc.equals("East"))direc="South";
                else if(direc.equals("South"))direc="West";
                else if(direc.equals("West"))direc="North";
            }
        }
        if(x==0&&y==0)return true;//if x and y 0 means they come back to starting point;
        if(direc.equals("North"))return false;//if direction north it will go out of the circle
        return true;//if both condition fails then the robot is inside the circle;
        
    }
}
