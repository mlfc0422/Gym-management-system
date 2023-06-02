package Common;

import java.util.Scanner;

public class IntPut {
    public int getInput(Scanner sc, String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("输入超出范围，请重新输入。");
                }
            } else {
                System.out.println("输入无效，请输入一个有效的整数。");
                sc.next(); // 清除非整数输入
            }
        }
        return input;
    }
}
