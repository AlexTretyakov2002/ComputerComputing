package com.company;

public class Main
{

    public static void main(String[] args)
    {
        Dichotomy dichotomy = new Dichotomy();
        System.out.println(dichotomy.min(-2, 2, 0.01));

        //GoldenSection goldSelection = new GoldenSection();
        //System.out.println(goldSelection.findMin(-2, 2, 0.01));

        //Nyton nyton = new Nyton();
        //System.out.println(nyton.minimum(-2, 2, 0.01));
    }
}

class Dichotomy
{
    int i = 0;
    public double fun(double x)
    {
        return Math.pow(64,x)-Math.pow(8,x)-56;
    }

    public double min(double a, double b,double eps)
    {
        if (fun(a)==0) return a;
        if (fun(b)==0) return b;
        double prom;
        double left = a;
        double right = b;
        double delta = eps/5,c,d;
        while (b - a >= eps) {
            ++i;
            c=(a+b)/2-delta/2;
            d=(a+b)/2+delta/2;
            if(fun(c)<=fun(d))
            {
                b=d;
            }
            else
            {
                a=c;
            }
        }
        System.out.println("Итераций: " + i);
        return (b+a)/2;
    }
}

class GoldenSection
{
    int i = 0;
    final double PHI = (1 + Math.sqrt(5)) / 2;

    double f(double x) {
        return  Math.pow(64,x)-Math.pow(8,x)-56;
    }

    double findMin(double a, double b, double e) {
        double x1, x2;
        while (true) {
            ++i;
            x1 = b - (b - a) / PHI;
            x2 = a + (b - a) / PHI;
            if (f(x1) >= f(x2))
                a = x1;
            else
                b = x2;
            if (Math.abs(b - a) < e)
                break;
        }
        System.out.println("Итераций:"+ i);
        return (a + b) / 2;
    }
}

class Nyton
{

    public double f(double x){
        return Math.pow(64,x)-Math.pow(8,x)-56;
    }
    public double df(double x){
        return Math.pow(8,x)*(Math.pow(8,x)*Math.log(64)-Math.log(8));
    }

    public double minimum(double a, double b,double eps) {
        double x0=a;
        double x1=b;
        double fx1;

        while(Math.abs(x1-x0)>eps){
            x0=x1;
            x1=a-df(a)*((b-a)/(df(b)-df(a)));
            fx1=df(x1);
            if(fx1==0){
                break;
            }else if(fx1*df(b)>0){
                b=x1;
            }else{
                a=x1;
            }

        }
        return x1;
    }
}