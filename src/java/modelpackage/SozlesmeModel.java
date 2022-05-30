package modelpackage;

public class SozlesmeModel {

    String test = "id İhale Kayıt No İhale Adı Vergi No Firma Adı Sözleşme Bedeli Sözleşme Başlangıç Tarihi "
            + "Sözleşme Bitiş Tarihi";
    private int id;
    private String ihaleKayitNo;
    private String ihaleAdi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIhaleKayitNo() {
        return ihaleKayitNo;
    }

    public void setIhaleKayitNo(String ihaleKayitNo) {
        this.ihaleKayitNo = ihaleKayitNo;
    }

    public String getIhaleAdi() {
        return ihaleAdi;
    }

    public void setIhaleAdi(String ihaleAdi) {
        this.ihaleAdi = ihaleAdi;
    }

}
