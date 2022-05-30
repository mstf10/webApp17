import { eklenti } from "../eklenti/eklenti.js";
import { menu } from "./menu.js";
export function sidebar() {
    const sidebar = document.createElement("div");
    sidebar.className = "noShow";
    sidebar.id = "sidebar";
    document.body.appendChild(sidebar);
    menu();
    eklenti();
}

