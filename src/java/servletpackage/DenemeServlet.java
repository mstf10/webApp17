package servletpackage;

import classpackage.DbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelpackage.FirmaModel;
import modelpackage.OdemeListesiModel;
import modelpackage.OdemeListesiModel2;
import modelpackage.SozlesmeFirmaModel;
import modelpackage.SozlesmeModel;
import modelpackage.TbankModel;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "denemeservlet", urlPatterns = {"/deneme"})
public class DenemeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        PrintWriter out = resp.getWriter();
        String param = req.getParameter("param");

        if (param.equals("param")) {
            try {
                DbConnect dbConnect = new DbConnect();
                Statement statement = dbConnect.connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from firma");
                ArrayList arrayList = new ArrayList();
                while (resultSet.next()) {
                    FirmaModel firmaModel = new FirmaModel();
                    firmaModel.setFirmaAdı(resultSet.getString(1));
                    firmaModel.setId(resultSet.getString(3));
                    firmaModel.setVergiNo(resultSet.getString(2));
                    arrayList.add(firmaModel);
                }
                JSONArray jSONArray = new JSONArray(arrayList);
                out.println(jSONArray);
                resultSet.close();
                statement.close();
                dbConnect.connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (param.equals("param2")) {
            try {
                String firmaAdı = req.getParameter("firmaAdı");
                String vergiNo = req.getParameter("vergiNo");
                DbConnect dbConnect = new DbConnect();
                Statement statement = dbConnect.connection.createStatement();
                statement.executeQuery("INSERT INTO firma(firma.`Firma Adı`,firma.`Vergi No`) VALUES('" + firmaAdı + "','" + vergiNo + "')");
                out.println("Firma Adı: " + firmaAdı + "\nVergi No: " + vergiNo + "\nFirma Kaydedildi");

                statement.close();
                dbConnect.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (param.equals("param3")) {
            try {
                DbConnect dbConnect = new DbConnect();
                String vergiNo = req.getParameter("vergiNo");
                Statement statement = dbConnect.connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from firma where `Vergi No`='" + vergiNo + "'");
                ArrayList arrayList = new ArrayList();
                while (resultSet.next()) {
                    FirmaModel firmaModel = new FirmaModel();
                    firmaModel.setFirmaAdı(resultSet.getString(1));
                    firmaModel.setId(resultSet.getString(3));
                    firmaModel.setVergiNo(resultSet.getString(2));
                    arrayList.add(firmaModel);
                }
                JSONArray jSONArray = new JSONArray(arrayList);
                out.println(jSONArray);
                resultSet.close();
                statement.close();
                dbConnect.connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (param.equals("param4")) {
            try {
                String id = req.getParameter("id");
                DbConnect dbConnect = new DbConnect();
                Statement statement = dbConnect.connection.createStatement();
                statement.executeQuery("delete from firma where id='" + id + "'");

                statement.close();
                dbConnect.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (param.equals("param6")) {
            try {
                String listNo = req.getParameter("listNo");
                DbConnect dbConnect = new DbConnect();
                ArrayList<OdemeListesiModel> arrayList = new ArrayList<OdemeListesiModel>();
                Statement statement = dbConnect.connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT 2021bl1.*  FROM 2021bl1 inner JOIN odemelisteleri ON odemelisteleri.`SIRA NO`=2021bl1.`SIRA NO` WHERE odemelisteleri.`LİSTE NO`='" + listNo + "'");
                while (resultSet.next()) {
                    OdemeListesiModel odemeListesiModel = new OdemeListesiModel();
                    odemeListesiModel.setSiraNo(resultSet.getInt("SIRA NO"));
                    odemeListesiModel.setFirmaAdı(resultSet.getString("FİRMA/PERSONEL ADI"));
                    odemeListesiModel.setVergiNo(resultSet.getString("VERGİ NO"));
                    odemeListesiModel.setHesapKodu(resultSet.getString("HESAP KODU"));
                    odemeListesiModel.setFisNo(resultSet.getInt("FİŞ NO"));
                    odemeListesiModel.setFisTarihi(resultSet.getString("FİŞ TARİHİ"));
                    odemeListesiModel.setFtbs(resultSet.getString("FİŞ TARİHİ BORÇULUK SÜRESİ4"));
                    odemeListesiModel.setYevmiyeNo(resultSet.getString("YEVMİYE NO"));
                    odemeListesiModel.setMuayeneKabulTarihi(resultSet.getString("Muayene Kabul TARİHİ"));
                    odemeListesiModel.setMktbs(resultSet.getString("Muayene Kabul TARİHİ Borçluluk Süresi"));
                    odemeListesiModel.setFaturaNo(resultSet.getString("ÖDEMEYE ESAS B. NO"));
                    odemeListesiModel.setFaturaTarihi(resultSet.getString("ÖDEMEYE ESAS B. TARİHİ"));
                    odemeListesiModel.setIliskiNo(resultSet.getString("İLİŞKİ NO"));
                    odemeListesiModel.setTahakkuk(resultSet.getString("TAHAKKUK"));
                    odemeListesiModel.setKapatilan103(resultSet.getDouble("103 İLE KAPATILAN"));
                    odemeListesiModel.setKapatilanDiger(resultSet.getDouble("DİĞER İLE KAPATILAN"));
                    odemeListesiModel.setKalan(resultSet.getDouble("KALAN"));
                    odemeListesiModel.setAlimTuru(resultSet.getString("ALIM TÜRÜ"));
                    arrayList.add(odemeListesiModel);
                }

                JSONArray jSONArray = new JSONArray(arrayList);
                out.println(jSONArray);

                statement.close();
                dbConnect.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (param.equals("param7")) {
            try {
                DbConnect dbConnect = new DbConnect();
                Statement statement = dbConnect.connection.createStatement();
                ArrayList arrayList = new ArrayList();
                ResultSet resultSet = statement.executeQuery("select * from sozlesme");
                while (resultSet.next()) {
                    SozlesmeModel sozlesmeModel = new SozlesmeModel();
                    sozlesmeModel.setId(resultSet.getInt("id"));
                    sozlesmeModel.setIhaleKayitNo(resultSet.getString("İhale Kayıt No"));
                    sozlesmeModel.setIhaleAdi(resultSet.getString("İhale Adı"));
                    arrayList.add(sozlesmeModel);
                }
                JSONArray jSONArray = new JSONArray(arrayList);
                out.println(jSONArray);
                resultSet.close();
                statement.close();
                dbConnect.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (param.equals("param8")) {
            try {
                DbConnect dbConnect = new DbConnect();
                Statement statement = dbConnect.connection.createStatement();
                String sozlesmeId = req.getParameter("sozlesmeId");
                ArrayList arrayList = new ArrayList();
                ResultSet resultSet = statement.executeQuery("select * from sozlesmefirma where `SÖZLEŞME İD`='" + sozlesmeId + "'");

                while (resultSet.next()) {
                    SozlesmeFirmaModel sozlesmeFirmaModel = new SozlesmeFirmaModel();
                    sozlesmeFirmaModel.setSozlesmeId(resultSet.getInt("SÖZLEŞME İD"));
                    sozlesmeFirmaModel.setFirmaAdi(resultSet.getString("FİRMA ADI"));
                    sozlesmeFirmaModel.setVergiNo(resultSet.getString("VERGİ NO"));
                    sozlesmeFirmaModel.setTaahhutId(resultSet.getInt("TAAHHÜT İD"));
                    arrayList.add(sozlesmeFirmaModel);

                }
                JSONArray jSONArray = new JSONArray(arrayList);
                out.println(jSONArray);

                resultSet.close();
                statement.close();
                dbConnect.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (param.equals("param9")) {
            try {
                String[] siraNo = req.getParameter("siraNo").split(",");
                DbConnect dbConnect = new DbConnect();
                int listeNo = 0;
                Statement statement = dbConnect.connection.createStatement();
                if (siraNo[0].equals("")) {
                    ResultSet resultSet = statement.executeQuery("select * from odemelisteleri");
                    ArrayList arrayList = new ArrayList();
                    while (resultSet.next()) {
                        OdemeListesiModel2 odemeListesiModel2 = new OdemeListesiModel2();
                        odemeListesiModel2.setListeNo(resultSet.getInt("LİSTE NO"));
                        odemeListesiModel2.setSiraNo(resultSet.getInt("SIRA NO"));
                        odemeListesiModel2.setListeTarih(resultSet.getString("LİSTE TARİHİ"));
                        arrayList.add(odemeListesiModel2);
                    }
                    resultSet.close();
                    JSONArray jSONArray = new JSONArray(arrayList);
                    out.println(jSONArray);

                } else {
                    ResultSet resultSet2 = statement.executeQuery("select `LİSTE NO` from odemelisteleri");
                    while (resultSet2.next()) {
                        listeNo = resultSet2.getInt("LİSTE NO");
                    }
                    for (int i = 0; i < siraNo.length; i++) {
                        statement.executeQuery("insert into odemelisteleri(`SIRA NO`,`LİSTE TARİHİ`,`LİSTE NO`) values('" + siraNo[i] + "',"
                                + "'" + new Date() + "','" + (listeNo + 1) + "')");
                        statement.executeQuery("update 2021bl1 set `kalan` =0 where `SIRA NO`=" + siraNo[i]);
                    }
                }
                statement.close();
                dbConnect.connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (param.equals("param11")) {
            try {
                DbConnect dbConnect = new DbConnect();
                try ( Statement statement = dbConnect.connection.createStatement()) {
                    ArrayList arrayList = new ArrayList();
                    String taahhutid = req.getParameter("taahhutid");
                    String sorgu = "select * from tbank \n"
                            + "INNER JOIN sozlesmefirma\n"
                            + "ON sozlesmefirma.`TAAHHÜT İD`=tbank.`TAAHHÜT İD`\n"
                            + "INNER JOIN sozlesme\n"
                            + " ON sozlesme.id = sozlesmefirma.`SÖZLEŞME İD`\n"
                            + "WHERE sozlesmefirma.`TAAHHÜT İD`='" + taahhutid + "'";

                    try ( ResultSet resultSet = statement.executeQuery(sorgu)) {
                        while (resultSet.next()) {
                            TbankModel tbankModel = new TbankModel();
                            tbankModel.setTaahhutId(resultSet.getString("TAAHHÜT İD"));
                            tbankModel.setFaturaTarihi(resultSet.getString("Fatura Tarihi"));
                            tbankModel.setFaturaNo(resultSet.getString("Fatura No"));
                            tbankModel.setHakedisTutari(resultSet.getDouble("Hakediş Tutarı (KDV Hariç)"));
                            tbankModel.setDamgaVergisi(resultSet.getDouble("Damga Vergisi"));
                            tbankModel.setGelirVergisi(resultSet.getDouble("Gelir Vergisi"));
                            tbankModel.setFonPayi(resultSet.getDouble("Fon Payı"));
                            tbankModel.setParaCezasi(resultSet.getDouble("Para Cezası"));
                            tbankModel.setMahsupEdilenAvans(resultSet.getDouble("Mahsup Edilen Avans"));
                            tbankModel.setIcraKesintisi(resultSet.getDouble("İcra Kesintisi"));
                            tbankModel.setTeminatKesintisi(resultSet.getDouble("Teminat Kesintisi"));
                            tbankModel.setSgkKesintisi(resultSet.getDouble("SGK Kesintisi"));
                            tbankModel.setVergiBorcu(resultSet.getDouble("Vergi Borcu"));
                            tbankModel.setKdvTevkifati(resultSet.getDouble("KDV Tevkifatı"));
                            tbankModel.setTemlik(resultSet.getDouble("Temlik"));
                            tbankModel.setKesintiToplami(resultSet.getDouble("Kesinti Toplamı"));
                            tbankModel.setYapilanOdeme(resultSet.getDouble("Yapılan Ödeme"));

                            tbankModel.setIkn(resultSet.getString("İhale Kayıt No"));
                            tbankModel.setIhaleAdi(resultSet.getString("İhale Adı"));

                            tbankModel.setFirmaAdi(resultSet.getString("FİRMA ADI"));
                            tbankModel.setVergiNo(resultSet.getString("VERGİ NO"));
                            tbankModel.setSozlesmeBasTar(resultSet.getString("SÖZLEŞME BAŞLANGIÇ TARİHİ"));
                            tbankModel.setSozlesmeBitTar(resultSet.getString("SÖZLEŞME BİTİŞ TARİHİ"));
                            tbankModel.setSozlesmeBedeli(resultSet.getString("SÖZLEŞME BEDELİ"));
                            arrayList.add(tbankModel);
                        }

                        JSONArray jSONArray = new JSONArray(arrayList);

                        out.println(jSONArray);
                    }
                }
                dbConnect.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (param.equals("param12")) {
            try {
                DbConnect dbConnect = new DbConnect();
                Statement statement = dbConnect.connection.createStatement();
                String ihaleAdi = req.getParameter("ihaleAdi");
                String ikn = req.getParameter("ikn");
                String sorgu = "insert into sozlesme(`İhale Kayıt No`,`İhale Adı`) values('" + ikn + "','" + ihaleAdi + "')";
                statement.executeUpdate(sorgu);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("durum", "ok");
                out.println(jSONObject);

                statement.close();
                dbConnect.connection.close();
            } catch (SQLException ex) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("durum", "hata");
                jSONObject.put("hataKodu", ex.getErrorCode());
                out.println(jSONObject);
                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (param.equals("param13")) {
            try {
                String id = req.getParameter("id");
                DbConnect dbConnect = new DbConnect();
                Statement statement = dbConnect.connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * from sozlesme\n"
                        + "INNER JOIN sozlesmefirma\n"
                        + "ON sozlesme.id = sozlesmefirma.`SÖZLEŞME İD`\n"
                        + "WHERE sozlesme.id=\'" + id + "\'");

                if (resultSet.next()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("durum", "hata");
                    jSONObject.put("hata", "veri eklendiği için silinemez");
                    out.println(jSONObject);
                } else {
                    int s = statement.executeUpdate("delete from sozlesme where id='" + id + "'");
                    if (s > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("durum", "ok");
                        out.println(jSONObject);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("durum", "hata");
                        jSONObject.put("hata", "silinecek veri bulunmadı");
                        out.println(jSONObject);
                    }
                }
                resultSet.close();
                statement.close();
                dbConnect.connection.close();
            } catch (SQLException ex) {

                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (param.equals("param14")) {
            try {
                String firmaAdi = req.getParameter("firmaAdi");
                String vergiNo = req.getParameter("vergiNo");
                String sozlesmeId = req.getParameter("sozlesmeId");
                String sozBasTar = req.getParameter("sozBasTar");
                String sozBitTar = req.getParameter("sozBitTar");
                String sozlesmeBedeli = req.getParameter("sozlesmeBedeli");
                DbConnect dbConnect = new DbConnect();
                Statement statement = dbConnect.connection.createStatement();
                String sorgu = "insert into sozlesmefirma(`SÖZLEŞME İD`,`FİRMA ADI`,`VERGİ NO`,"
                        + "`SÖZLEŞME BAŞLANGIÇ TARİHİ`,`SÖZLEŞME BİTİŞ TARİHİ`,`SÖZLEŞME BEDELİ`) values("
                        + "'" + sozlesmeId + "',"
                        + "'" + firmaAdi + "',"
                        + "'" + vergiNo + "',"
                        + "'" + sozBasTar + "',"
                        + "'" + sozBitTar + "',"
                        + "'" + sozlesmeBedeli + "'"
                        + ")";
                int s = statement.executeUpdate(sorgu);
                out.println(s);

                statement.close();
                dbConnect.connection.close();
            } catch (SQLException ex) {

                Logger.getLogger(DenemeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
