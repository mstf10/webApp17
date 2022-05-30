export function menu() {
    const sidebar = document.getElementById("sidebar");
    sidebar.className = "noShow";
    const anasayfa = document.createElement("a");
    anasayfa.innerHTML = "Anasayfa";
    anasayfa.href = "/WebApplication17/index.html";
    sidebar.appendChild(anasayfa);

    const firma = document.createElement("a");
    firma.innerHTML = "Firma";
    firma.href = "#";
    firma.className = "menu-firma";
    sidebar.appendChild(firma);

    const ul = document.createElement("ul");
    ul.style.display = "none";
    firma.appendChild(ul);

    const li_firmagoster = document.createElement("li");
    ul.appendChild(li_firmagoster);
    const firmagoster = document.createElement("a");
    firmagoster.innerHTML = "Firmaları Getir";
    firmagoster.href = "/WebApplication17/firma/firma.html";
    li_firmagoster.appendChild(firmagoster);

    const li_firmasil = document.createElement("li");
    ul.appendChild(li_firmasil);
    const firmasil = document.createElement("a");
    firmasil.innerHTML = "Firma Sil";
    firmasil.href = "/WebApplication17/firma/firmasil.html";
    li_firmasil.appendChild(firmasil);

    const li_firmakaydet = document.createElement("li");
    ul.appendChild(li_firmakaydet);
    const firmakaydet = document.createElement("a");
    firmakaydet.innerHTML = "Firma Kaydet";
    firmakaydet.href = "/WebApplication17/firma/firmaekle.html";
    li_firmakaydet.appendChild(firmakaydet);

    const li_firmaguncelle = document.createElement("li");
    ul.appendChild(li_firmaguncelle);
    const firmaguncelle = document.createElement("a");
    firmaguncelle.innerHTML = "Firma Güncelle";
    firmaguncelle.href = "/WebApplication17/firma/firmaguncelle.html";
    li_firmaguncelle.appendChild(firmaguncelle);

    firma.onclick = function () {
        if (ul.style.display === "grid") {
            ul.style.display = "none";
        } else {
            ul.style.display = "grid";
        }
    };

    const odeme = document.createElement("a");
    odeme.innerHTML = "Ödemeler";
    odeme.href = "#";
    odeme.style.display = "block";
    odeme.style.marginTop = "5px";
    sidebar.appendChild(odeme);

    const ulOdeme = document.createElement("ul");
    ulOdeme.style.display = "none";
    odeme.appendChild(ulOdeme);

    const li_odemeListesi = document.createElement("li");
    ulOdeme.appendChild(li_odemeListesi);
    const odemeListesi = document.createElement("a");
    odemeListesi.innerHTML = "Ödeme Listesi";
    odemeListesi.href = "/WebApplication17/odeme/odemelistesi.html";
    li_odemeListesi.appendChild(odemeListesi);

    const li_odenenListe = document.createElement("li");
    ulOdeme.appendChild(li_odenenListe);
    const odenenListe = document.createElement("a");
    odenenListe.innerHTML = "Ödenen Liste";
    odenenListe.href = "/WebApplication17/odeme/odenenliste.html";
    li_odenenListe.appendChild(odenenListe);

    const li_odenenListedetay = document.createElement("li");
    ulOdeme.appendChild(li_odenenListedetay);
    const odenenListedetay = document.createElement("a");
    odenenListedetay.innerHTML = "Ödenen Liste Detay";
    odenenListedetay.href = "/WebApplication17/odeme/odenenlistedetay.html";
    li_odenenListedetay.appendChild(odenenListedetay);

    odeme.onclick = function () {
        if (ulOdeme.style.display === "grid") {
            ulOdeme.style.display = "none";
        } else {
            ulOdeme.style.display = "grid";
        }
    };

    const sozlesme = document.createElement("a");
    sozlesme.innerHTML = "Sözleşme";
    sozlesme.href = "#";
    sozlesme.className = "menu-firma";
    sidebar.appendChild(sozlesme);

    const ulSozlesme = document.createElement("ul");
    ulSozlesme.style.display = "none";
    sozlesme.appendChild(ulSozlesme);

    const li_SozlesmeBilgisi = document.createElement("li");
    ulSozlesme.appendChild(li_SozlesmeBilgisi);

    const sozlesmeBilgisi = document.createElement("a");
    sozlesmeBilgisi.innerHTML = "Sözleşmeler";
    sozlesmeBilgisi.href = "/WebApplication17/sozlesme/sozlesme.html";
    li_SozlesmeBilgisi.appendChild(sozlesmeBilgisi);

    const li_TaahhutKarti = document.createElement("li");
    ulSozlesme.appendChild(li_TaahhutKarti);

    const taahhutKarti = document.createElement("a");
    taahhutKarti.innerHTML = "Taahhüt Karti";
    taahhutKarti.href = "/WebApplication17/sozlesme/taahhutkarti.html";
    li_TaahhutKarti.appendChild(taahhutKarti);

    sozlesme.onclick = function () {
        if (ulSozlesme.style.display === "grid") {
            ulSozlesme.style.display = "none";
        } else {
            ulSozlesme.style.display = "grid";
        }
    };


}
