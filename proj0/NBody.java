public class NBody{
    public static String starfilepicture = "images/starfield.jpg";
    public static double readRadius(String path){
        In in=new In(path);
        int planetCount=in.readInt();
        double radius=in.readDouble();
        return radius;
    }
    public static Planet[] readPlanets(String path){
        In in=new In(path);
        int planetCount=in.readInt();
        double radius=in.readDouble();
        Planet[] planets=new Planet[planetCount];
        for(int i=0;i<planetCount;i++){
            double xx=in.readDouble();
            double yy=in.readDouble();
            double xxV=in.readDouble();
            double yyV=in.readDouble();
            double mass=in.readDouble();
            String fp=in.readString();
            Planet p=new Planet(xx,yy,xxV,yyV,mass,fp);
            planets[i]=p;
        }
        return planets;
    }


    public static void main(String[] args) {
        if(args.length==0){
            return;
        }
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        Planet[] planets=readPlanets(filename);
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.enableDoubleBuffering();
        double t=0;
        int num=planets.length;
        while(t<T) {
            double xForces[]=new double[planets.length];
            double yForces[]=new double[planets.length];
            for(int i=0;i<planets.length;i++)    {
                xForces[i]=planets[i].calcNetForceExertedByX(planets);
                yForces[i]=planets[i].calcNetForceExertedByY(planets);
            }
            for(int i=0;i<planets.length;i++){
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0, 0, starfilepicture);
            for(Planet planet:planets){
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t+=dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

}