public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static double G = 6.67e-11;


    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet planet) {
        double r = Math.sqrt(Math.pow(planet.xxPos - xxPos, 2) + Math.pow(planet.yyPos - yyPos, 2));
        return r;
    }

    public double calcForceExertedBy(Planet planet) {
        return G * mass * planet.mass / Math.pow(calcDistance(planet), 2);
    }

    public double calcForceExertedByX(Planet planet) {
        return (planet.xxPos - xxPos) / calcDistance(planet) * calcForceExertedBy(planet);
    }

    public double calcForceExertedByY(Planet planet) {
        return (planet.yyPos - yyPos) / calcDistance(planet) * calcForceExertedBy(planet);
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double xForce = 0;
        for (Planet planet : planets) {
            if (planet.equals(this)) {
                continue;
            }
            xForce += calcForceExertedByX(planet);
        }
        return xForce;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double yForce = 0;
        for (Planet planet : planets) {
            if (planet.equals(this)) {
                continue;
            }
            yForce += calcForceExertedByY(planet);
        }
        return yForce;
    }

    public void update(double dt, double fx, double fy) {
        double acclerationX = fx / mass;
        double acclerationY = fy / mass;
        xxVel = xxVel + dt * acclerationX;
        yyVel = yyVel + dt * acclerationY;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos,yyPos,"/images/" + imgFileName);
    }
}
