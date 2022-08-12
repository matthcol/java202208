package geometry;

public abstract class Form {

    private String name;

    protected Form() {
        this("");
        // this.name = "";
    }

    protected Form(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
        // i.e.:
        // return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract void translate(double deltaX, double deltaY);

}
