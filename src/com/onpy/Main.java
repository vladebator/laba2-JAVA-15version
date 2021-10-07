/*
Создать класс треугольник, члены класса – длины 3-х сторон. Предусмотреть в классе методы
вычисления и вывода сведений о фигуре – длины сторон, углы, периметр, площадь. Создать
производный класс – равнобедренный треугольник, предусмотреть в классе проверку, является
ли треугольник равнобедренным. Написать программу, демонстрирующую работу с классом:
дано N треугольников и M равнобедренных треугольников, найти среднюю площадь для N
треугольников и равнобедренный треугольник с наименьшей площадью.
*/

package com.onpy;

import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество треугольников: ");
        int inCountTriangle = 10;//scan.nextInt();

        Triangle[] triangles = new Triangle[inCountTriangle];
        int CountTriangle = 0;

        double x1, x2, x3;
        for (int i = 0; i < triangles.length/2; i++) {
            do {
                /*
                System.out.print("Введите cторону Х1 для треугольника №" + i + ": ");
                x1 = scan.nextInt();
                System.out.print("Введите cторону Х2 для треугольника №" + i + ": ");
                x2 = scan.nextInt();
                System.out.print("Введите cторону Х3 для треугольника №" + i + ": ");
                x3 = scan.nextInt();
                 */
                x1 = 1 + Math.random() * 10;
                x2 = 1 + Math.random() * 10;
                x3 = 1 + Math.random() * 10;
            } while (!Triangle.isTriangle(x1, x2, x3));

            triangles[i] = new Triangle(x1, x2, x3);

            //scan.nextLine();
            triangles[i].numberTriangle = ++CountTriangle;
        }

       // IsocelesTriangle[] isocelesTriangles = new IsocelesTriangle[inCountTriangle];

        for (int i = triangles.length/2; i < triangles.length; i++) {
            do {
                x1 = 1 + Math.round(Math.random() * 10);
                x2 = 1 + Math.round(Math.random() * 10);
                x3 = 1 + Math.round(Math.random() * 10);
            } while (!IsocelesTriangle.isIsoceles(x1, x2, x3));

            triangles[i] = new IsocelesTriangle(x1, x2, x3);

            //scan.nextLine();
            triangles[i].numberTriangle = ++CountTriangle;
        }
        /*

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


         */
        double averageSquare = 0;
        double max = 0;
        double min = 0;
        int countNormalTriangle = 0;
        int countIsoscelesTriangle = 0;


        // Тут подправил. Сначала вычисляем для первой половины треугольников их площадь ( от 0, до triangles.length/2).
        // В нашем решение, треугольник которые ( от 0, до triangles.length/2) - являются "обычными" (не равнобедренными)
        // И в этом цикле я вычисляю среднюю площадь этих треугольников.
        for (int i = 0; i < triangles.length/2; i++) {
            countNormalTriangle = countNormalTriangle + 1;
            averageSquare = +triangles[i].square;
        }

        // Тут подправил. В этом цикле находим минимальную площадь равнобедренного треугольника, которые
        // ( от triangles.length/2 до triangles.length ) - Это вторая половина наших треугольников - равнобедренные.
        for (int i = triangles.length/2; i < triangles.length; i++) {

            countIsoscelesTriangle = countIsoscelesTriangle + 1;

            for (int j = triangles.length/2; j != triangles.length; j++) {
                    if (!(triangles[i].square < max)) {
                        max = triangles[i].square;
                    }
                    if (triangles[i].square < min) {
                        min = triangles[i].square;
                    }
                }
            }
        averageSquare = averageSquare / countNormalTriangle;
        // Выводим теперь эти данные на экран, среднюю площадь треугольников и мин.площ. равнобедренного треугольника.
        System.out.println("Средняя площадь треугольников = " + averageSquare);
        System.out.println("Минимальная площадь равнобедренного треугольника = " + min);

    }
}
