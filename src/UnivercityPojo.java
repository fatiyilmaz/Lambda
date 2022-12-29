public class UnivercityPojo {
    //pojo class bir pojo class'imin icerisinde field'larim olur. Field'larin hepsinin erisimi private olacak ve getter
    //setter'lari olacak

    private String univercity;
    private String bolum;
    private int ogrSayisi;
    private int notOrt;

    //parametresiz constructor
    public UnivercityPojo() {
    }


    //parametreli constructor
    public UnivercityPojo(String univercity, String bolum, int ogrSayisi, int notOrt) {
        this.univercity = univercity;
        this.bolum = bolum;
        this.ogrSayisi = ogrSayisi;
        this.notOrt = notOrt;
    }


    //getter , setter
    public String getUnivercity() {
        return univercity;
    }

    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Univercity{" +
                "univercity='" + univercity + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayisi=" + ogrSayisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
