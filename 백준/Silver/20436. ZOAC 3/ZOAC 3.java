import java.io.*;
import java.util.*;

public class Main {
    public static class Data{
        int x,y;
        Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean check(int[][] keyboard, char target) {
        int targetIdx = (int)target - 'a';
        int targetX = keyboard[targetIdx][0];
        int targetY = keyboard[targetIdx][1];

        // true : ㄱ,ㄴ,ㄷ / false : ㅏ,ㅔ,ㅣ
        if(targetY<=2) {
            if(targetX<=5) return true;
            return false;
        }
        else {
            if(targetX<=4) return true;
            return false;
        }
    }

    public static int calDis(int[][] keyboard, char now, char target) {
        int nowX = keyboard[(int)now - 'a'][0];
        int nowY = keyboard[(int)now - 'a'][1];
        int targetX = keyboard[(int)target - 'a'][0];
        int targetY = keyboard[(int)target - 'a'][1];

        return Math.abs(nowX - targetX) + Math.abs(nowY - targetY) + 1;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int[][] keyboardXY = { {1, 2}, {5, 3}, {3, 3}, {3, 2}, {3, 1}, {4, 2}, {5, 2},
        {6, 2}, {8, 1}, {7, 2}, {8, 2}, {9, 2}, {7, 3}, {6, 3}, {9, 1}, {10, 1},
        {1, 1}, {4, 1}, {2, 2}, {5, 1}, {7, 1}, {4, 3}, {2, 1}, {2, 3}, {6, 1},
        {1, 3} };

        String str = sc.nextLine();
        char sl = str.charAt(0);
        char sr = str.charAt(2);
        int sum  = 0;
        String qwerty = sc.nextLine();

        for(int i=0; i<qwerty.length();i++) {
            char now = qwerty.charAt(i);
            
            // true : ㄱ,ㄴ,ㄷ / false : ㅏ,ㅔ,ㅣ
            if(check(keyboardXY,now)) {
                sum += calDis(keyboardXY,sl,now);
                sl = now;
            }
            else {
                sum += calDis(keyboardXY,sr,now);
                sr = now;
            }
        }
        System.out.println(sum);

    }
}