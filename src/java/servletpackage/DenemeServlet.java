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
                    firmaModel.setFirmaAdÄ±(resultSet.getString(1));
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
                String firmaAdÄ± = req.getParameter("firmaAdÄ±");
                String vergiNo = req.getParameter("vergiNo");
                DbConnect dbConnect = new DbConnect();
                Statement statement = dbConnect.connection.createStatement();
                statement.executeQuery("INSERT INTO firma(firma.`Firma AdÄ±`,firma.`Vergi No`) VALUES('" + firmaAdÄ± + "','" + vergiNo + "')");
                out.println("Firma AdÄ±: " + firmaAdÄ± + "\nVergi No: " + vergiNo + "\nFirma Kaydedildi");

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
                    firmaModel.setFirmaAdÄ±(resultSet.getString(1));
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
                ResultSet resultSet = statement.executeQuery("SELECT 2021bl1.*  FROM 2021bl1 inner JOIN odemelisteleri ON odemelisteleri.`SIRA NO`=2021bl1.`SIRA NO` WHERE odemelisteleri.`LÄ°STE NO`='" + listNo + "'");
                while (resultSet.next()) {
                    OdemeListesiModel odemeListesiModel = new OdemeListesiModel();
                    odemeListesiModel.setSiraNo(resultSet.getInt("SIRA NO"));
                    odemeListesiModel.setFirmaAdÄ±(resultSet.getString("FÄ°RMA/PERSONEL ADI"));
                    odemeListesiModel.setVergiNo(resultSet.getString("VERGÄ° NO"));
                    odemeListesiModel.setHesapKodu(resultSet.getString("HESAP KODU"));
                    odemeListesiModel.setFisNo(resultSet.getInt("FÄ°Å NO"));
                    odemeListesiModel.setFisTarihi(resultSet.getString("FÄ°Å TARÄ°HÄ°"));
                    odemeListesiModel.setFtbs(resultSet.getString("FÄ°Å TARÄ°HÄ° BORÃULUK SÃRESÄ°4"));
                    odemeListesiModel.setYevmiyeNo(resultSet.getString("YEVMÄ°YE NO"));
                    odemeListesiModel.setMuayeneKabulTarihi(resultSet.getString("Muayene Kabul TARÄ°HÄ°"));
                    odemeListesiModel.setMktbs(resultSet.getString("Muayene Kabul TARÄ°HÄ° BorÃ§luluk SÃ¼resi"));
                    odemeListesiModel.setFaturaNo(resultSet.getString("ÃDEMEYE ESAS B. NO"));
                    odemeListesiModel.setFaturaTarihi(resultSet.getString("ÃDEMEYE ESAS B. TARÄ°HÄ°"));
                    odemeListesiModel.setIliskiNo(resultSet.getString("Ä°LÄ°ÅKÄ° NO"));
                    odemeListesiModel.setTahakkuk(resultSet.getString("TAHAKKUK"));
                    odemeListesiModel.setKapatilan103(resultSet.getDouble("103 Ä°LE KAPATILAN"));
                    odemeListesiModel.setKapatilanDiger(resultSet.getDouble("DÄ°ÄER Ä°LE KAPATILAN"));
                    odemeListesiModel.setKalan(resultSet.getDouble("KALAN"));
                    odemeListesiModel.setAlimTuru(resultSet.getString("ALIM TÃRÃ"));
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
                    sozlesmeModel.setIhaleKayitNo(resultSet.getString("Ä°hale KayÄ±t No"));
                    sozlesmeModel.setIhaleAdi(resultSet.getString("Ä°hale AdÄ±"));
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
                ResultSet resultSet = statement.executeQuery("select * from sozlesmefirma where `SÃZLEÅME Ä°D`='" + sozlesmeId + "'");

                while (resultSet.next()) {
                    SozlesmeFirmaModel sozlesmeFirmaModel = new SozlesmeFirmaModel();
                    sozlesmeFirmaModel.setSozlesmeId(resultSet.getInt("SÃZLEÅME Ä°D"));
                    sozlesmeFirmaModel.setFirmaAdi(resultSet.getString("FÄ°RMA ADI"));
                    sozlesmeFirmaModel.setVergiNo(resultSet.getString("VERGÄ° NO"));
                    sozlesmeFirmaModel.setTaahhutId(resultSet.getInt("TAAHHÃT Ä°D"));
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
                        odemeListesiModel2.setListeNo(resultSet.getInt("LÄ°STE NO"));
                        odemeListesiModel2.setSiraNo(resultSet.getInt("SIRA NO"));
                        odemeListesiModel2.setListeTarih(resultSet.getString("LÄ°STE TARÄ°HÄ°"));
                        arrayList.add(odemeListesiModel2);
                    }
                    resultSet.close();
                    JSONArray jSONArray = new JSONArray(arrayList);
                    out.println(jSONArray);

                } else {
                    ResultSet resultSet2 = statement.executeQuery("select `LÄ°STE NO` from odemelisteleri");
                    while (resultSet2.next()) {
                        listeNo = resultSet2.getInt("LÄ°STE NO");
                    }
                    for (int i = 0; i < siraNo.length; i++) {
                        statement.executeQuery("insert into odemelisteleri(`SIRA NO`,`LÄ°STE TARÄ°HÄ°`,`LÄ°STE NO`) values('" + siraNo[i] + "',"
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
                            + "ON sozlesmefirma.`TAAHHÃT Ä°D`=tbank.`TAAHHÃT Ä°D`\n"
                            + "INNER JOIN sozlesme\n"
                            + " ON sozlesme.id = sozlesmefirma.`SÃZLEÅME Ä°D`\n"
                            + "WHERE sozlesmefirma.`TAAHHÃT Ä°D`='" + taahhutid + "'";

                    try ( ResultSet resultSet = statement.executeQuery(sorgu)) {
                        while (resultSet.next()) {
                            TbankModel tbankModel = new TbankModel();
                            tbankModel.setTaahhutId(resultSet.getString("TAAHHÃT Ä°D"));
                            tbankModel.setFaturaTarihi(resultSet.getString("Fatura Tarihi"));
                            tbankModel.setFaturaNo(resultSet.getString("Fatura No"));
                            tbankModel.setHakedisTutari(resultSet.getDouble("HakediÅ TutarÄ± (KDV HariÃ§)"));
                            tbankModel.setDamgaVergisi(resultSet.getDouble("Damga Vergisi"));
                            tbankModel.setGelirVergisi(resultSet.getDouble("Gelir Vergisi"));
                            tbankModel.setFonPayi(resultSet.getDouble("Fon PayÄ±"));
                            tbankModel.setParaCezasi(resultSet.getDouble("Para CezasÄ±"));
                            tbankModel.setMahsupEdilenAvans(resultSet.getDouble("Mahsup Edilen Avans"));
                            tbankModel.setIcraKesintisi(resultSet.getDouble("Ä°cra Kesintisi"));
                            tbankModel.setTeminatKesintisi(resultSet.getDouble("Teminat Kesintisi"));
                            tbankModel.setSgkKesintisi(resultSet.getDouble("SGK Kesintisi"));
                            tbankModel.setVergiBorcu(resultSet.getDouble("Vergi Borcu"));
                            tbankModel.setKdvTevkifati(resultSet.getDouble("KDV TevkifatÄ±"));
                            tbankModel.setTemlik(resultSet.getDouble("Temlik"));
                            tbankModel.setKesintiToplami(resultSet.getDouble("Kesinti ToplamÄ±"));
                            tbankModel.setYapilanOdeme(resultSet.getDouble("YapÄ±lan Ãdeme"));

                            tbankModel.setIkn(resultSet.getString("Ä°hale KayÄ±t No"));
                            tbankModel.setIhaleAdi(resultSet.getString("Ä°hale AdÄ±"));

                            tbankModel.setFirmaAdi(resultSet.getString("FÄ°RMA ADI"));
                            tbankModel.setVergiNo(resultSet.getString("VERGÄ° NO"));
                            tbankModel.setSozlesmeBasTar(resultSet.getString("SÃZLEÅME BAÅLANGIÃ TARÄ°HÄ°"));
                            tbankModel.setSozlesmeBitTar(resultSet.getString("SÃZLEÅME BÄ°TÄ°Å TARÄ°HÄ°"));
                            tbankModel.setSozlesmeBedeli(resultSet.getString("SÃZLEÅME BEDELÄ°"));
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
                String sorgu = "insert into sozlesme(`Ä°hale KayÄ±t No`,`Ä°hale AdÄ±`) values('" + ikn + "','" + ihaleAdi + "')";
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
                        + "ON sozlesme.id = sozlesmefirma.`SÃZLEÅME Ä°D`\n"
                        + "WHERE sozlesme.id=\'" + id + "\'");

                if (resultSet.next()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("durum", "hata");
                    jSONObject.put("hata", "veri eklendiÄi iÃ§in silinemez");
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
                        jSONObject.put("hata", "silinecek veri bulunmadÄ±");
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
                String sorgu = "insert into sozlesmefirma(`SÃZLEÅME Ä°D`,`FÄ°RMA ADI`,`VERGÄ° NO`,"
                        + "`SÃZLEÅME BAÅLANGIÃ TARÄ°HÄ°`,`SÃZLEÅME BÄ°TÄ°Å TARÄ°HÄ°`,`SÃZLEÅME BEDELÄ°`) values("
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
