class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G=6.67E-11;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }
    public Planet(Planet p){
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
        this.imgFileName=p.imgFileName;
    }
    public double calcDistance(Planet p){
        return Math.sqrt((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos)+(this.yyPos-p.yyPos)*(this.yyPos-p.yyPos));
    }
    public double calcForceExertedBy(Planet p){
        return G*p.mass*this.mass/(this.calcDistance(p)*this.calcDistance(p));
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double NetForceX=0;
        for(Planet p:allPlanets){
            if(this.equals(p)){
                continue;
            }
            else{
                double distX=p.xxPos-this.xxPos;
                NetForceX+=distX*this.calcForceExertedBy(p)/this.calcDistance(p);
            }
        }
        return NetForceX;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double NetForceY=0;
        for(Planet p:allPlanets){
            if(this.equals(p)){
                continue;
}
            else{
                double distY=p.yyPos-this.yyPos;
                NetForceY+=distY*this.calcForceExertedBy(p)/this.calcDistance(p);
            }
}

        return NetForceY;
}
    public void update(double t,double ForceX,double ForceY){
        double aX=ForceX/this.mass;
        double aY=ForceY/this.mass;
        this.xxVel+=aX*t;
        this.yyVel+=aY*t;
        this.xxPos+=t*this.xxVel;
        this.yyPos+=t*this.yyVel;
    }
    public void draw(){
        String absRoute="images/"+this.imgFileName;
        StdDraw.picture(this.xxPos,this.yyPos,absRoute);
    }

}