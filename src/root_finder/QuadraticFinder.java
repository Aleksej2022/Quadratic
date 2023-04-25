package root_finder;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class QuadraticFinder extends Canvas {
    static double x_root1;
    static double x_root2;
    static int Val;// ac value as a negative or positive
    static int Val_b;// b value
    static int number; // this value will be used to store  the ac value to find the factors

    static JFrame test = new JFrame();
    static String option_choice = "";
    static double determinant;
    static double a;
    static double b;
    static double c;
    static DecimalFormat df;

    public void paint(Graphics g){
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Comic Sans MS",Font.BOLD,40));
        g.drawOval(20,5,800,300);
        df = new DecimalFormat("#.#");
        String ans_1 = df.format(x_root1);
        String ans_2 = df.format(x_root2);
        if (option_choice.equals("A")){
            g.drawString("The x values are: -> " + ans_1 + "," + ans_2, 150,150);
        }
        else if (option_choice.equals("B")){
            if (determinant > 0.0){
                double root_1 = (-b + Math.pow(determinant, 0.5)) / (2.0 * a);
                double root_2 = (-b - Math.pow(determinant, 0.5)) / (2.0 * a);
                g.drawString("The roots are: -> " + df.format(root_1) + " , " + df.format(root_2),150, 150);
            }
            else if (determinant == 0.0){
                double root_1 = -b / (2.0 * a);
                g.drawString("The root is: -> " + root_1, 150, 150);
            }
            else {
                g.drawString("There are no real roots", 150, 150);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        QuadraticFinder draw = new QuadraticFinder();
        test.getContentPane().setBackground(Color.BLACK);
        test.setSize(900,400);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.add(draw);

        Scanner numbers = new Scanner(System.in);
        Scanner text = new Scanner(System.in);

        System.out.println(Colors.BLUE_BOLD_BRIGHT + "Are you ready to begin(Yes - Y, No - N)?");
        String user_input = text.nextLine();
        while (user_input.equals("Yes")){
            System.out.println(Colors.RED_BOLD_BRIGHT + "*****************************************************************************");
            System.out.println("Welcome to the quadratic root finder programmed system");
            System.out.println("*****************************************************************************");
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "Choose one of the options\nA.Find the roots of the quadratic equation by factorization\nB.Find the roots of the quadratic equation by formula\n");

            String user_response = text.nextLine();
            System.out.println("*****************************************************************************");

            if (user_response.equals("A")){
                option_choice = "A";
                System.out.println(Colors.BLACK_BOLD_BRIGHT + "Enter the ac value(enter as a positive value)");
                number = numbers.nextInt();

                //the codes below is to check if the ac value is positive or negative
                System.out.println("Is the ac value positive or negative(type any one of the options)");
                String response = text.nextLine();
                if (response.equals("negative")){
                    System.out.println(Colors.PURPLE_BOLD + "Enter the ac value again without putting a negative sign");
                    int number_n = numbers.nextInt();
                    Val = (~(number_n - 1));
                }

                else if (response.equals("positive")){
                    System.out.println(Colors.PURPLE_BOLD + "Enter the ac value again");
                    int number_n = numbers.nextInt();
                    Val = number_n;
                }

                //the code below is to check if the b value of the quadratic equation is positive or negative
                System.out.println("Is the b value positive or negative(type any one of the options)");
                String response_y = text.nextLine();
                if (response_y.equals("negative")){
                    System.out.println(Colors.PURPLE_BOLD + "Enter the b value again without putting a negative sign");
                    int number_b = numbers.nextInt();
                    Val_b = (~(number_b - 1));
                }

                else if (response_y.equals("positive")){
                    System.out.println(Colors.PURPLE_BOLD + "Enter the b value again");
                    int number_b = numbers.nextInt();
                    Val_b = number_b;
                }
                for (int i = 1; i <=number; i++) {
                    //ac = 4
                    if (number % i == 0){
                        if((-(number / i) + i == Val_b) && (-(number / i) * i == Val)){
                            //print the factors on the console with decorations
                            System.out.println(Colors.CYAN_BOLD_BRIGHT + "*****************************************************************************");
                            System.out.println("The factors are: -> " + "- " +(number / i) + " " + i);
                            System.out.println("*****************************************************************************");
                            System.out.println("Enter the a value");
                            double a = numbers.nextInt();
                            x_root1 = -1 * (-(number / i) / a);
                            x_root2 = -1 * (i / a);
                            //Display roots of the equation on Canvas
                            break;
                        }

                       else if((i - (number / i)  == Val_b) && ((i) * -(number / i) == Val)){
                            //print the factors on the console with decorations
                            System.out.println(Colors.CYAN_BOLD_BRIGHT + "*****************************************************************************");
                            System.out.println("The factors are: -> " + i + "- " + (number / i));
                            System.out.println("*****************************************************************************");
                            System.out.println("Enter the a value");
                            double a = numbers.nextInt();
                            x_root1 = -1 * (-(number / i) / a);
                            x_root2 = -1 * (i / a);
                            //Display roots of the equation on Canvas using the Graphics g object
                            break;
                        }

                        else if((i + (number / i)  == Val_b) && ((i) * (number / i) == Val)){
                            //print the factors on the console with decorations
                            System.out.println(Colors.CYAN_BOLD_BRIGHT + "*****************************************************************************");
                            System.out.println("The factors are: -> " + i + " " + (number / i));
                            System.out.println("*****************************************************************************");
                            System.out.println("Enter the a value");
                            double a = numbers.nextInt();
                            x_root1 = -1 * ((number / i) / a);
                            x_root2 = -1 * (i / a);
                            //Display roots of the equation on Canvas using the Graphics g object
                            break;
                        }

                        else if((-i - (number / i)  == Val_b) && ((-i) * -(number / i) == Val)){
                            //print the factors on the console with decorations
                            System.out.println(Colors.CYAN_BOLD_BRIGHT + "*****************************************************************************");
                            System.out.println("The factors are: -> " + "-" + i +" " + "-" + (number / i));
                            System.out.println("*****************************************************************************");
                            System.out.println("Enter the a value");
                            double a = numbers.nextInt();
                            x_root1 = -1 * (-(number / i) / a);
                            x_root2 = -1 * (-i / a);
                            //Display roots of the equation on Canvas using the Graphics g object
                            break;
                        }
                    }
                }

                test.setVisible(true);
                Thread.sleep(10000);
                test.dispose();
            }

            else if (user_response.equals("B")){
                option_choice = "B";
                //Finding the roots of quadratic equation
                System.out.println("Enter the a value of the equation");
                a = numbers.nextDouble();
                System.out.println("Enter the b value of the equation");
                b = numbers.nextDouble();
                System.out.println("Enter the c value of the equation");
                c = numbers.nextDouble();
                determinant = b * b - 4.0 * a * c;
                // the if else conditions to determine if the quadratic equation has two, one or none roots will be written in the public void paint method
                test.setVisible(true);
                Thread.sleep(10000);
                test.dispose();
            }

            System.out.println(Colors.BLUE_BOLD_BRIGHT + "Are you ready to begin(Yes - Y, No - N)?");
            user_input = text.nextLine();
        }

        if (user_input.equals("No")){
            System.out.println("Okay,thank you!");
        }
    }
}
