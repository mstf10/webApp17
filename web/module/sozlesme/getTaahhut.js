"use strict";
export function getTaahhut() {
    const content = document.getElementById("content");

    const taahhutBasDiv = document.createElement("div");
    taahhutBasDiv.id = "taahhutBasDiv";
    content.appendChild(taahhutBasDiv);

    const taahhutDetayDiv = document.createElement("div");
    taahhutDetayDiv.id = "taahhutDetayDiv";
    content.appendChild(taahhutDetayDiv);

    const taahhutSonDiv = document.createElement("div");
    taahhutSonDiv.id = "taahhutSonDiv";
    content.appendChild(taahhutSonDiv);

    const xhttp = new XMLHttpRequest();
    const urlParam = new URLSearchParams(location.search).get("taahhutid");
    xhttp.open("get", "../deneme?param=param11&taahhutid=" + urlParam);
    xhttp.send();
    xhttp.onload = function () {
        const data = JSON.parse(this.responseText);

        const taahhutBasTable = document.createElement("table");
        taahhutBasDiv.appendChild(taahhutBasTable);

        const taahhutBasContent = {
            "tbs0": ["İhale Kayıt No/İhale Adı", data[0].ikn + " / " + data[0].ihaleAdi],
            "tbs1": ["Yüklenici Firma Adı/Vergi No", data[0].firmaAdi + " / " + data[0].vergiNo],
            "tbs2": ["Sözleşme Başlangıç/Bitiş Tarihi", data[0].sozlesmeBasTar + " / " + data[0].sozlesmeBitTar],
            "tbs3": ["Sağlık Tesisi", "BAŞH"]
        };

        for (var i = 0; i < Object.keys(taahhutBasContent).length; i++) {
            const tr = document.createElement("tr");
            taahhutBasTable.appendChild(tr);
            const td = document.createElement("td");
            tr.appendChild(td);
            td.innerHTML = Object.values(taahhutBasContent)[i][0];
            const td1 = document.createElement("td");
            tr.appendChild(td1);
            td1.innerHTML = Object.values(taahhutBasContent)[i][1];
        }

        const taahhutDetayTable = document.createElement("table");
        taahhutDetayDiv.appendChild(taahhutDetayTable);
        taahhutDetayTable.id = "taahhutTable";

        const thead = taahhutDetayTable.createTHead();
        taahhutDetayTable.appendChild(thead);
        const trforthead = document.createElement("tr");
        thead.appendChild(trforthead);
        const thName = ["TAAHHÜT İD", "Fatura Tarihi", "Fatura No", "Hakediş Tutarı (KDV Hariç)", "Damga Vergisi",
            "Gelir Vergisi", "Fon Payı", "Para Cezası", "Mahsup Edilen Avans", "İcra Kesintisi",
            "Teminat Kesintisi", "SGK Kesintisi", "Vergi Borcu", "KDV Tevkifatı", "Temlik",
            "Kesinti Toplamı", "Yapılan Ödeme"];
        let thforthead = [];
        for (let i = 1; i < thName.length; i++) {
            thforthead[i] = document.createElement("th");
            thforthead[i].innerHTML = thName[i];
            trforthead.appendChild(thforthead[i]);
        }
        const tbody = taahhutDetayTable.createTBody();
        taahhutDetayTable.appendChild(tbody);
        let tdfortr = [];
        for (let x in data) {
            const tr = document.createElement("tr");
            tbody.appendChild(tr);
            for (let i = 0; i < 16; i++) {
                tdfortr[i] = document.createElement("td");
                tr.appendChild(tdfortr[i]);
            }
            tdfortr[0].innerHTML = data[x].faturaTarihi;
            tdfortr[1].innerHTML = data[x].faturaNo;
            tdfortr[2].innerHTML = data[x].hakedisTutari;
            tdfortr[3].innerHTML = data[x].damgaVergisi;
            tdfortr[4].innerHTML = data[x].gelirVergisi;
            tdfortr[5].innerHTML = data[x].fonPayi;
            tdfortr[6].innerHTML = data[x].paraCezasi;
            tdfortr[7].innerHTML = data[x].mahsupEdilenAvans;
            tdfortr[8].innerHTML = data[x].icraKesintisi;
            tdfortr[9].innerHTML = data[x].teminatKesintisi;
            tdfortr[10].innerHTML = data[x].sgkKesintisi;
            tdfortr[11].innerHTML = data[x].vergiBorcu;
            tdfortr[12].innerHTML = data[x].kdvTevkifati;
            tdfortr[13].innerHTML = data[x].temlik;
            tdfortr[14].innerHTML = data[x].kesintiToplami;
            tdfortr[15].innerHTML = data[x].yapilanOdeme;

        }

        const hakedisTutariToplami = function () {
            let toplam = 0.00;
            for (var i = 1; i < taahhutDetayTable.rows.length; i++) {
                toplam += parseInt(taahhutDetayTable.rows[i].cells[2].innerHTML);
            }
            return toplam;
        };

        const taahhutSonTable = document.createElement("table");
        taahhutSonDiv.appendChild(taahhutSonTable);
        const taahhutSonContent = {
            "tsc0": ["Sözleşme Bedeli", data[0].sozlesmeBedeli],
            "tsc1": ["Kullanılan", hakedisTutariToplami()],
            "tsc2": ["Kalan", data[0].sozlesmeBedeli - hakedisTutariToplami()]
        };
        for (var i = 0; i < Object.keys(taahhutSonContent).length; i++) {
            const tr = document.createElement("tr");
            taahhutSonTable.appendChild(tr);
            const td = document.createElement("td");
            tr.appendChild(td);
            td.innerHTML = Object.values(taahhutSonContent)[i][0];
            const td1 = document.createElement("td");
            tr.appendChild(td1);
            td1.innerHTML = Object.values(taahhutSonContent)[i][1];
        }
    };
}
