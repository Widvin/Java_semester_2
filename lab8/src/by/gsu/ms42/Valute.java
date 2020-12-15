package by.gsu.ms42;

public class Valute {
    String ID;
    int Numcode;
    String Charcode;
    int Nominal;
    String Name;
    double Value;

    public String getID() {
        return ID;
    }

    public void setID(Integer id) {
        this.ID = ID;
    }


    public int getNumcode() {
        return Numcode;
    }

    public void setNumcode(Integer numCode) {
        this.Numcode = Numcode;
    }

    public String getCharcode() {
        return Charcode;
    }

    public void setCharcode(String charCode) {
        this.Charcode = Charcode;
    }

    public int getNominal() {
        return Nominal;
    }

    public void setNominal(Integer integer) {
        this.Nominal = Nominal;
    }

    public String getName() {
        return Name;
    }

    public void setName(String textContent) {
        this.Name = Name;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(Double aDouble) {
        this.Value = Value;
    }

    @Override
    public String toString() {
        return "Valute: Numcode = " + this.Numcode + " CharCode = " + this.Charcode + "Nominal = "
                + this.Nominal + "Name = " + this.Name + "Value = " + this.Value;
    }


}