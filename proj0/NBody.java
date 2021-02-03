public class NBody {
    private static String backGroundImage = "/images/starfield.jpg";
    private static String backGroundAudio = "/audio/2001.mid";
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
            Planet planet = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
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

        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        StdDraw.picture(0,0,backGroundImage);
        for (Planet planet : planets) {
            planet.draw();
        }

        StdDraw.enableDoubleBuffering();

        for (int i = 0; i <= T; i+=dt) {
            //StdAudio.loop(backGroundAudio);

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
        //StdAudio.close();

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }

}
