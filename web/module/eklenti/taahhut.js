"use strict";
import { taahhutDetayElement } from '../model/taahhutDetayElement.js'

export function taahhutEkleButton(a, b) {
    const taahhutEkle = document.createElement("button");
    taahhutEkle.innerHTML = "Taahhüt Ekle";
    a.addEventListener("click", function () {
        b.appendChild(taahhutEkle);
    });

    taahhutEkle.addEventListener("click", function () {
        const taahhutTable = document.querySelector("#taahhutTable>tbody");
        const tr = document.createElement("tr");
        taahhutTable.appendChild(tr);
        const td = [];
        const input = [];
        for (let i = 1; i < taahhutDetayElement.length; i++) {
            td[i] = document.createElement("td");
            tr.appendChild(td[i]);
            input[i] = document.createElement("input");
            input[i].placeholder = taahhutDetayElement[i];
            td[i].appendChild(input[i]);
        }
    });



}

