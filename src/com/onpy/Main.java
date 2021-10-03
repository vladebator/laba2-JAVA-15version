package com.onpy;

import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество треугольников: ");
        int inCountTriangle = scan.nextInt();

        triangle[] triangle = new triangle[inCountTriangle];
        int CountTriangle = 0;

        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new triangle();
            scan.nextLine();

            triangle[i].numberTriangle = CountTriangle + 1;

            System.out.print("Введите cторону Х1 для треугольника №" + triangle[i].numberTriangle + ": ");
            triangle[i].setX1(scan.nextInt());

            System.out.print("Введите cторону Х2 для треугольника №" + triangle[i].numberTriangle + ": ");
            triangle[i].setX2(scan.nextInt());

            System.out.print("Введите cторону Х3 для треугольника №" + triangle[i].numberTriangle + ": ");
            triangle[i].setX3(scan.nextInt());

            CountTriangle = CountTriangle + 1;
        }

        for (int i = 0; i < triangle.length; i++) {
            triangle[i].perimeter = triangle[i].x1 + triangle[i].x2 + triangle[i].x3;
            System.out.println("Периметр треугольника №" + triangle[i].numberTriangle + ": " + triangle[i].perimeter);

            triangle[i].alpha = Math.abs(Math.cos(((pow(triangle[i].x1, 2) + pow(triangle[i].x3, 2) - pow(triangle[i].x2, 2)) / 2 * triangle[i].x1 * triangle[i].x3)));
            triangle[i].betta = Math.abs(Math.cos(((pow(triangle[i].x1, 2) + pow(triangle[i].x2, 2) - pow(triangle[i].x3, 2)) / 2 * triangle[i].x1 * triangle[i].x2)));
            triangle[i].gamma = Math.abs(Math.cos(((pow(triangle[i].x2, 2) + pow(triangle[i].x3, 2) - pow(triangle[i].x1, 2)) / 2 * triangle[i].x3 * triangle[i].x2)));

            double radian = 57.295780;

            System.out.println("Косинус угла Alpha = " + triangle[i].alpha);
            System.out.println("Косинус угла Betta = " + triangle[i].betta);
            System.out.println("Косинус угла Gamma = " + triangle[i].gamma);

            // S = 0,5 * a * b⋅sin(α) , где a, b — стороны, α — угол между ними.
            triangle[i].square = 0.5 * triangle[i].x1 * triangle[i].x2 * Math.sin(triangle[i].alpha);
            System.out.println("Площадь треугольника №" + triangle[i].numberTriangle + " = " + triangle[i].square);

            if (triangle[i].x1 == triangle[i].x2 || triangle[i].x1 == triangle[i].x3 || triangle[i].x2 == triangle[i].x3) {
                System.out.println("Треугольник №" + triangle[i].numberTriangle + " является равнобедренным.");
                triangle[i].isosceles = 1;
            }
            else {
                System.out.println("Треугольник №" + triangle[i].numberTriangle + " не является равнобедренным.");
            }
        }

        double averageSquare = 0;
        double max = 0;
        double min = 0;
        int countNormalTriangle = 0;
        int countIsoscelesTriangle = 0;

        for (int i = 0; i < triangle.length; i++) {
            if (triangle[i].isosceles == 0) {
                countNormalTriangle = countNormalTriangle + 1;
                averageSquare = +triangle[i].square;
            }
            else {
                countIsoscelesTriangle = countIsoscelesTriangle + 1;

                for (int j = 0; j != triangle.length; j++) {
                    if (!(triangle[i].square < max)) {
                        max = triangle[i].square;
                    }
                    if (triangle[i].square < min) {
                        min = triangle[i].square;
                    }
                }
            }
        }

        averageSquare = averageSquare / countNormalTriangle;

        System.out.println("Средняя площадь треугольников = " + averageSquare);
        System.out.println("Минимальная площадь равнобедренного треугольника = " + min);
    }
}