package com.onpy;

public class IsocelesTriangle extends Triangle {
    public IsocelesTriangle(double x1, double x2, double x3) {
       super(x1, x2, x3);
    }
    
    public static boolean isIsoceles(double x1, double x2, double x3)
    {
        if (Triangle.isTriangle(x1, x2, x3)) {
            if (x1 == x2 || x1 == x3 || x2 == x3) {
                //System.out.println("Треугольник №" + numberTriangle + " является равнобедренным.");
                return true;
            }
        }
        return false;
    }
}
