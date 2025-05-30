package in.ashok.been4;

public class Callprinter {
    
    private IPrinter Pr;  // Property for the printer

    public Callprinter() {
        System.out.println("0 par constructor for callprinter");
    }

    // The setter method for the 'Pr' property is necessary for autowiring by name
    public void setPr(IPrinter Pr) {
        System.out.println("Setting printer: ");
        this.Pr = Pr;
    }

    public void printer() {
        System.out.println("printing completed");
        Pr.print();  // Here, Pr should be an injected object, like SonyPrinter
    }
}

