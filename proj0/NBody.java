public class NBody {
    public static String backGroundImage = "/images/starfield.jpg";
    public static double readRadius(String str) {
        In in = new In(str);
        int n = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String url) {
        In in = new In(url);
        int n = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[n];
        int i = 0;
        while (!in.isEmpty() && i < n) {
            Planet planet = new Planet();
            planet.xxPos = in.readDouble();
            planet.yyPos = in.readDouble();
            planet.xxVel = in.readDouble();
            planet.yyVel = in.readDouble();
            planet.mass = in.readDouble();
            planet.imgFileName = in.readString();
            planets[i++] = planet;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);

        StdDraw.setScale(-radius*1.5,radius*1.5);
        StdDraw.clear();
        StdDraw.picture(0,0,backGroundImage);
        for (Planet planet : planets) {
            planet.draw();
        }

        StdDraw.enableDoubleBuffering();

        for (int i = 0; i <= T; i+=dt) {
            for(Planet planet : planets) {
                double xForces = planet.calcNetForceExertedByX(planets);
                double yForces = planet.calcNetForceExertedByY(planets);
                planet.update(dt,xForces,yForces);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            /**
             * Draw all planets
             */
            for (Planet planet : planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

    }

}
