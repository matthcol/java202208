package learn;

public enum CouleurFeu {
    // litteral of enum types
    // VERT, ORANGE, ROUGE

    VERT(5){
        @Override
        public double compute(double d) {
            return d*2;
        }
    },
    ORANGE(1){
        @Override
        public double compute(double d) {
            return d/2;
        }
    },
    ROUGE(6){
        @Override
        public double compute(double d) {
            return d+1;
        }
    };

    private CouleurFeu(int delai) {
        this.delai = delai;
    }

    private int delai;

    public int getDelai() {
        return delai;
    }

    // not mandatory
    public void setDelai(int delai) {
        this.delai = delai;
    }

    // NB: not a good idea with Serializer
    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public abstract double compute(double d);

}
