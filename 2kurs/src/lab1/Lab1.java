package lab1;

import java.util.ArrayList;

import lab1.Function;

public class Lab1 {

	public static void main(String[] args) {
		/*
		 * Лист функций
		 */
		ArrayList<Function> funcList = new ArrayList<>();
		/*
		 * Функция синуса
		 */
		Function lambdaSin = (x) -> 2 * Math.sin(x) + 1;
		funcList.add(lambdaSin);
//		System.out.println(getFunc(lambdaSin));
		System.out.println();
		/*
		 * Квадратичная функция
		 */
		Function lambdaQuad1 = (x) -> Math.pow(x / Math.PI - 1, 2);
		funcList.add(lambdaQuad1);
//		System.out.println(getFunc(lambdaQuad1));
		/*
		 * Квадратичная функция #2
		 */
		Function lambdaQuad2 = (x) -> (-Math.pow(x / Math.PI, 2) - 2 * x + 5 * Math.PI);
		funcList.add(lambdaQuad2);
//		System.out.println(getFunc(lambdaQuad2));
		/*
		 * Функция косинуса
		 */
		Function lambdaCos = (x) -> ((0.5) * (Math.pow((Math.cos(x)), 2)) + 1);
		funcList.add(lambdaCos);
//		System.out.println(getFunc(lambdaCos));
		int count=0;	
		for (int i = 0; i < funcList.size(); i++) {
			count=0;
				for(int j=0;j<(getFunc(funcList.get(i))).size();j++) {
					if((getFunc(funcList.get(i))).get(j)<0) {
						count++;
					}
				}
				System.out.println(getFunc(funcList.get(i)));
				System.out.println("Количество отрицательных значений:"+count);
				
				
		}
		

	}
	public static double getMinMaxValue() {
		double[] x=new double[20];
			for(int i=0;i<x.length;i++) {
				x[i]=-10+i;				
			}
			return 1.0;
	}

	public static ArrayList<Double> getFunc(Function lambda) {
		ArrayList<Double> y = new ArrayList<>();
		for (double i = -2 * Math.PI; i <= 2 * Math.PI; i += Math.PI / 6) {
			y.add(lambda.funcValue(i));
		}
		return y;
	}
}
