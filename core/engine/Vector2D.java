package core.engine;

public class Vector2D {
	public double x;
	public double y;
	public Vector2D(double x, double y){
		this.x = x;
		this.y = y;
	}
	public Vector2D(int x, int y){
		this.x = (double)x;
		this.y = (double)y;
	}
	public static Vector2D transform(Vector2D point, double trans[][]){
		Vector2D result = new Vector2D(0,0);
		result.x = trans[0][0]*point.x + trans[0][1]*point.y;
		result.y = trans[1][0]*point.x + trans[1][1]*point.y;
		return result;
	}
	public static double[][] rotationMatrix(double angle){
		double [][] result = new double [2][2];
		result [0][0] = Math.cos(angle);
		result [0][1] = -Math.sin(angle);
		result [1][0] = Math.sin(angle);
		result [1][1] = Math.cos(angle);
		return result;
	}
	public static Vector2D proj(Vector2D v, Vector2D onTo){
		return times(onTo, dot(v,onTo)/dot(onTo,onTo));
	}
	public static Vector2D add(Vector2D v1, Vector2D v2){
		return new Vector2D (v1.x+v2.x, v1.y+v2.y);
	}
	public static Vector2D sub(Vector2D v1, Vector2D v2){
		return new Vector2D(v1.x-v2.x, v1.y-v2.y);
	}
	public static double dot(Vector2D v1, Vector2D v2){
		return v1.x*v2.x + v1.y*v2.y;
	}
	public static Vector2D times(Vector2D v, double t){
		return new Vector2D (v.x*t, v.y*t);
	}
	public static Vector2D rotate(Vector2D v, double angle){
		return transform(v,rotationMatrix(angle));
	}
}
