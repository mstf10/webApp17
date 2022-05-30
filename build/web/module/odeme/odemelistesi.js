import { search } from "../eklenti/search.js";
export function odemelistesi() {

    const content = document.getElementById("content");
    const xhttp = new XMLHttpRequest();
    const loadtext = document.createElement("p");
    content.appendChild(loadtext);
    loadtext.innerHTML = "yükleniyor";
    loadtext.className = "yukleniyor";
    xhttp.onload = function () {
        search();
        const array = JSON.parse(this.responseText);
        const e = 5;
        const table = document.createElement("table");
        content.appendChild(table);
        const thead = document.createElement("thead");
        table.appendChild(thead);
        let tabletr, tabletd = [];
        let tableth = [];
        let tablehead = ['select', 'SIRA NO',
            'FİRMA/PERSONEL ADI',
            'VERGİ NO',
            'HESAP KODU',
            'FİŞ NO',
            'FİŞ TARİHİ',
            'FİŞ TARİHİ BORÇULUK SÜRESİ4',
            'YEVMİYE NO',
            'Muayene Kabul TARİHİ',
            'Muayene Kabul TARİHİ Borçluluk Süresi',
            'ÖDEMEYE ESAS B. NO',
            'ÖDEMEYE ESAS B. TARİHİ',
            'İLİŞKİ NO',
            'TAHAKKUK',
            '103 İLE KAPATILAN',
            '320.11/320.12 İLE KAPATILAN',
            'DİĞER İLE KAPATILAN',
            'KALAN',
            'ALIM TÜRÜ'];

        for (var i = 0; i < tablehead.length; i++) {
            tableth[i] = document.createElement("th");
            tableth[i].innerHTML = tablehead[i];
            thead.appendChild(tableth[i]);
        }

        for (var i = 0; i < e; i++) {
            tabletr = document.createElement("tr");
            table.appendChild(tabletr);
            for (var j = 0; j < tablehead.length; j++) {
                tabletd[j] = document.createElement("td");
                tabletr.appendChild(tabletd[j]);

            }
            let checkbox = document.createElement("input");
            checkbox.type = "checkbox";


            tabletd[0].appendChild(checkbox);
            tabletd[1].innerHTML = array[i].siraNo;
            tabletd[2].innerHTML = array[i].firmaAdı;
            tabletd[3].innerHTML = array[i].vergiNo;
            tabletd[4].innerHTML = array[i].hesapKodu;
            tabletd[5].innerHTML = array[i].fisNo;
            tabletd[6].innerHTML = array[i].fisTarihi;
            tabletd[7].innerHTML = array[i].ftbs;
            tabletd[8].innerHTML = array[i].yevmiyeNo;
            tabletd[9].innerHTML = array[i].muayeneKabulTarihi;
            tabletd[10].innerHTML = array[i].mktbs;
            tabletd[11].innerHTML = array[i].faturaNo;
            tabletd[12].innerHTML = array[i].faturaTarihi;
            tabletd[13].innerHTML = array[i].iliskiNo;
            tabletd[14].innerHTML = array[i].tahakkuk;
            tabletd[15].innerHTML = array[i].kapatilan103;
            tabletd[16].innerHTML = array[i].kapatilan320;
            tabletd[17].innerHTML = array[i].kapatilanDiger;
            tabletd[18].innerHTML = array[i].kalan;
            tabletd[19].innerHTML = array[i].alimTuru;
        }
        loadtext.style.display = "none";

    };
    xhttp.open("get", "../odemelistesi?param=param10");
    xhttp.send();

}