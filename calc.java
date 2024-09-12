import java.util.*;

class calc {
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);

        double firstnum, secondnum, answer;
        System.out.println("Input the first number: ");
        firstnum = input.nextDouble();

        System.out.println("Input the second number: ");
        secondnum = input.nextDouble();

        System.out.println("What do you want to do with the numbers?");
        System.out.println("1. Add \n2. Subtract \n3. Multiply \n4. Divide");

        int decide = input.nextInt();

        //determine opertor to be used
        for (int tries = 0; tries < 1; tries++) {
            if (decide != 1 && decide != 2 && decide != 3 && decide != 4) {
                System.out.println("Only input 1 - 4");
                tries--;
                decide = input.nextInt();
            } else if (decide == 1) {
                answer = firstnum + secondnum;
                System.out.println(firstnum + " + " + secondnum + " = " + answer);
            } else if (decide == 2) {
                answer = firstnum - secondnum;
                System.out.println(firstnum + " - " + secondnum + " = " + answer);
            } else if (decide == 3) {
                answer = firstnum * secondnum;
                System.out.println(firstnum + " x " + secondnum + " = " + answer);
            } else if (decide == 4) {
                answer = firstnum / secondnum;
                System.out.println(firstnum + " / " + secondnum + " = " + answer);
            }
//                switch (decide) {
//                case 1:
//                    answer = firstnum + secondnum;
//                    System.out.println(answer);
//                    break;
//
//                case 2:
//                    answer = firstnum - secondnum;
//                    System.out.println(answer);
//                    break;
//
//                case 3:
//                    answer = firstnum * secondnum;
//                    System.out.println(answer);
//                    break;
//
//                case 4:
//                    answer = firstnum / secondnum;
//                    System.out.println(answer);
//                    break;
//
//                default:
//                    System.out.println("Only input 1 - 4");
//                    tries--;
//                    decide = input.nextInt();
//            }
        }
    }
}


/* 2 methods of choosing the operator. Either by if loops, or by switch. Prefer using if method.
Maybe there's a better way of doing this?*/
