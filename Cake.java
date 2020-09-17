package MyPackage;

public class Cake {
    public String name;

    public static CakeSize[] sizes = {
            new CakeSize("20cm round", 1.0, 15.00),
            new CakeSize("25cm round", 1.5, 22.50),
            new CakeSize("30cm round", 2.0, 30.00),
            new CakeSize("35cm round", 3.0, 45.00),
            new CakeSize("15*15cm quadrangular", 1.0, 15.00),
            new CakeSize("20*20cm quadrangular", 1.5, 22.50),
            new CakeSize("30*30cm quadrangular", 2.0, 30.00),
            new CakeSize("35*35cm quadrangular", 3.00, 45.00)

    };

    public Cake(String _name) {
        this.name = _name;
    }
}
