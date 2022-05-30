"use strict";
import {getSozlesme} from '../sozlesme/getSozlesme.js'
export function sozlesmeEkleButtonFunction(x, y) {
    const sozlesmeEkleButton = document.createElement("button");
    const buttonx = document.createElement("button");
    const ikn = document.createElement("input");
    const ihaleAdi = document.createElement("input");
    const sozlesmeDiv = sozlesmeDivCreate();
    x.onclick = function () {
        sozlesmeEkleButton.innerHTML = "Sözleşme Ekle";
        y.appendChild(sozlesmeEkleButton);
    };
    sozlesmeEkleButton.onclick = function () {
        if (document.getElementById("sozlesmeDiv")) {
            document.getElementById("sozlesmeDiv").remove();
        }

        const content = document.getElementById("content");
        content.appendChild(sozlesmeDiv);
        ikn.placeholder = "İhale Kayıt No/Dosya No";
        sozlesmeDiv.appendChild(ikn);
        ihaleAdi.placeholder = "İşin Adı";
        sozlesmeDiv.appendChild(ihaleAdi);
        buttonx.innerHTML = "Kaydet";
        sozlesmeDiv.appendChild(buttonx);
        buttonx.onclick = function () {
            const xhttp = new XMLHttpRequest();
            xhttp.open("get", "../deneme?param=param12&ikn=" + ikn.value + "&ihaleAdi=" + ihaleAdi.value);
            xhttp.send();
            xhttp.onload = function () {
                const data = JSON.parse(this.responseText);
                const durumDiv = document.createElement("div");
                if (data.durum == "ok") {
                    durumDiv.style.backgroundColor = "green";
                    durumDiv.innerHTML = "ok";
                    sozlesmeDiv.appendChild(durumDiv);
                    if (document.getElementById("div0")) {
                        document.getElementById("div0").remove();
                    }
                    getSozlesme();
                } else if (data.durum == "hata" && data.hataKodu == "1062") {
                    durumDiv.style.backgroundColor = "red";
                    durumDiv.innerHTML = "hata";
                    sozlesmeDiv.appendChild(durumDiv);
                }

            };
        };
    };
}
export function sozlesmeSilButtonFunction(x, y) {
    const sozlesmeSilButton = document.createElement("button");
    sozlesmeSilButton.innerHTML = "Sözleşme Sil";
    const idInput = document.createElement("input");
    const silButton = document.createElement("button");
    const sozlesmeDiv = sozlesmeDivCreate();
    x.addEventListener("click", function () {
        y.appendChild(sozlesmeSilButton);
    });
    sozlesmeSilButton.addEventListener("click", function () {
        if (document.getElementById("sozlesmeDiv")) {
            document.getElementById("sozlesmeDiv").remove();
        }
        const content = document.getElementById("content");
        content.appendChild(sozlesmeDiv);
        idInput.placeholder = "Sözleşme Id";
        sozlesmeDiv.appendChild(idInput);
        silButton.innerHTML = "sil";
        sozlesmeDiv.appendChild(silButton);
    });
    silButton.onclick = function () {
        const xhttp = new XMLHttpRequest();
        xhttp.open("get", "../deneme?param=param13&id=" + idInput.value);
        xhttp.send();
        xhttp.onload = function () {
            const data = JSON.parse(this.responseText);
            const durumDiv = document.createElement("div");
            if (data.durum === "ok") {
                durumDiv.style.backgroundColor = "green";
                durumDiv.innerHTML = data.durum;
                sozlesmeDiv.appendChild(durumDiv);
                if (document.getElementById("div0")) {
                    document.getElementById("div0").remove();
                }
                getSozlesme();
            } else if (data.durum === "hata") {
                durumDiv.style.backgroundColor = "red";
                durumDiv.innerHTML = data.durum + ": " + data.hata;
                sozlesmeDiv.appendChild(durumDiv);
            }

        };
    };
}


export function taahhutKartiEkleButtonFunction(x, y) {
    const taahhutKartiEkleButton = document.createElement("button");
    taahhutKartiEkleButton.innerHTML = "Taahhüt Kartı Ekle";
    const sozlesmeDiv = sozlesmeDivCreate();
    x.addEventListener("click", function () {
        y.appendChild(taahhutKartiEkleButton);
    });
    const firmaAdi = document.createElement("input");
    firmaAdi.placeholder = "Firma Adı";
    const vergiNo = document.createElement("input");
    vergiNo.placeholder = "Vergi No";
    const sozlesmeId = document.createElement("input");
    sozlesmeId.placeholder = "Sözleşme ID";
    const sozBasTar = document.createElement("input");
    sozBasTar.placeholder = "Sözleşme Başlangıç Tarihi";
    const sozBitTar = document.createElement("input");
    sozBitTar.placeholder = "Sözleşme Bitiş Tarihi";
    const sozlesmeBedeli = document.createElement("input");
    sozlesmeBedeli.placeholder = "Sözleşme Bedeli";
    const button = document.createElement("button");
    button.innerHTML = "Kaydet";

    taahhutKartiEkleButton.addEventListener("click", function () {
        sozlesmeDiv.append(firmaAdi, vergiNo, sozlesmeId, sozBasTar, sozBitTar, sozlesmeBedeli, button);
        const content = document.getElementById("content");
        content.appendChild(sozlesmeDiv);
    });

    button.addEventListener("click", function () {
        const xhttp = new XMLHttpRequest();
        xhttp.open("get", "../deneme?param=param14&firmaAdi=" + firmaAdi.value +
                "&vergiNo=" + vergiNo.value +
                "&sozlesmeId=" + sozlesmeId.value +
                "&sozBasTar=" + sozBasTar.value +
                "&sozBitTar=" + sozBitTar.value +
                "&sozlesmeBedeli=" + sozlesmeBedeli.value);
        xhttp.send();
    });
    /*
     taahhutKartiEkleButton.onclick = function () {
     
     
     
     
     xhttp.onload = function () {
     const data = JSON.parse(this.responseText);
     const durumDiv = document.createElement("div");
     if (data.durum === "ok") {
     durumDiv.style.backgroundColor = "green";
     durumDiv.innerHTML = data.durum;
     sozlesmeDiv.appendChild(durumDiv);
     if (document.getElementById("div0")) {
     document.getElementById("div0").remove();
     }
     
     } else if (data.durum === "hata") {
     durumDiv.style.backgroundColor = "red";
     durumDiv.innerHTML = data.durum + ": " + data.hata;
     sozlesmeDiv.appendChild(durumDiv);
     }
     
     };
     
     };
     
     
     */}

export function sozlesmeDivCreate() {
    const sozlesmeDiv = document.createElement("div");
    sozlesmeDiv.className = "sozlesmeDiv";
    sozlesmeDiv.id = "sozlesmeDiv";
    return sozlesmeDiv;
}



