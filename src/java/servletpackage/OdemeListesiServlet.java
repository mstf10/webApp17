package servletpackage;

import classpackage.DbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelpackage.OdemeListesiModel;
import org.json.JSONArray;

@WebServlet(name = "Ödeme Listesi", urlPatterns = {"/odemelistesi"})
public class OdemeListesiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        try {

            Class.forName("org.mariadb.jdbc.Driver");
            PrintWriter out = resp.getWriter();
            String param = req.getParameter("param10");
            DbConnect dbConnect = new DbConnect();
            ArrayList<OdemeListesiModel> arrayList_OdemeListesi = new ArrayList<>();

            Statement statement = dbConnect.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from 2021bl1 where `KALAN`>0");
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

                arrayList_OdemeListesi.add(odemeListesiModel);
            }
            JSONArray jSONArray_OdemeListesi = new JSONArray(arrayList_OdemeListesi);
            out.println(jSONArray_OdemeListesi);
            resultSet.close();
            statement.close();
            dbConnect.connection.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OdemeListesiServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
