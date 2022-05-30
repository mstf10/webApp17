import { odemeListesiModel } from "../model/odemeListesiModel.js";
import { sozlesmeEkleButtonFunction } from "./sozlesme.js";
import { sozlesmeSilButtonFunction } from "./sozlesme.js";
import { taahhutKartiEkleButtonFunction } from "./sozlesme.js";
import { taahhutEkleButton } from "./taahhut.js";

export function eklenti() {
    const sidebar = document.getElementById("sidebar");
    const eklentiDiv = document.createElement("div");
    eklentiDiv.className = "eklentiDiv";
    sidebar.appendChild(eklentiDiv);
    const eklentiButton = document.createElement("button");
    eklentiButton.innerHTML = "Eklentiler";
    eklentiDiv.appendChild(eklentiButton);
    if (window.location.pathname === "/WebApplication17/sozlesme/sozlesme.html") {
        sozlesmeEkleButtonFunction(eklentiButton, eklentiDiv);
        sozlesmeSilButtonFunction(eklentiButton, eklentiDiv);
        taahhutKartiEkleButtonFunction(eklentiButton, eklentiDiv);
    }
    if (document.location.pathname === "/WebApplication17/sozlesme/taahhutkarti.html") {
        taahhutEkleButton(eklentiButton, eklentiDiv);
    }




}