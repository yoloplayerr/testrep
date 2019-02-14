package economic_project;

import Jama.Matrix;


public class Matrice1 {
	double[] z=new double[3];
	
	public static void main(String[] args) {
		double[][] x=new double[][]{{2,4,5,6,8},{4,7,3,2,1},{2,40,8,90,1},{4,5,60,7,80}};
		double[] y=new double[] { 20 , 40, 570,760,800};
	double[][]f=new double[3][5];
		for (int i = 0; i < 5; i++) {
			f[0][i]=1;
		}
		for (int i = 0; i < 4; i++) {
			for (int j = i+1; j < 4; j++) {
				System.out.println("i="+i);
				System.out.println("j="+j);
				for (int k = 0; k < 5; k++) {
				f[1][k]=x[i][k];	
				f[2][k]=x[j][k];
				System.out.println("f[1]["+k+"]="+f[1][k]);
				System.out.println("f[2]["+k+"]="+f[2][k]);
				}
			Matrice1 H= new Matrice1();
			H.test(f, y);
			H.R(f, y);
			}
		}	
	}
	
			public void test(double[][]ff, double[]yy){
				Matrix A1=new Matrix(ff);
		        A1.print(10, 2);
				Matrix B1=A1.transpose();
				Matrix F1=A1.times(B1);
				Matrix F4=F1.inverse();
				Matrix F2=F4.times(A1);
				 Matrix C=new Matrix(yy,5);
				Matrix F3=F2.times(C);
				z=F3.getColumnPackedCopy();
				for (int i = 0; i < 3; i++) 
					 System.out.println("z["+i+"]="+z[i]);

			}
public double R(double[][]ff, double[]yy){
	double r=0, S1=0, S2=0, S3=0;
	double[] u1=new double[5];
	double[] u2=new double[5];
	for (int i = 0; i < 5; i++) 
	{S3+=yy[i];
	u1[i]=0;}
	S3=S3/5;
	for (int m = 0; m < 5; m++){
		u1[m]=(z[0]+z[1]*ff[1][m]+z[2]*ff[2][m]-yy[m])*(z[0]+z[1]*ff[1][m]+z[2]*ff[2][m]-yy[m]);
	S1+=u1[m];
	u2[m]=(S3-yy[m])*(S3-yy[m]);
	S2+=u2[m];
	}
	r=1-S1/S2;
	System.out.println("r="+r);
	return r;
} 		
}