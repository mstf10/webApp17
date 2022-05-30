export function getSozlesme() {
    const content = document.getElementById("content");
    const xhttp1 = new XMLHttpRequest();
    xhttp1.open("get", "../deneme?param=param7");
    xhttp1.send();
    const div0 = document.createElement("div");
    div0.id = "div0";
    div0.className = "div0";
    content.appendChild(div0);

    const button1 = function () {
        const a = document.createElement("button");
        a.innerHTML = "tıklm";

        a.onclick = function (e) {
            if (document.getElementById("div1")) {
                document.getElementById("div1").remove();
            }
            const div1 = document.createElement("div");
            div1.id = "div1";
            div1.className = "div1";
            content.appendChild(div1);

            const f = e.composedPath()[2].cells[0].innerHTML;
            if (document.getElementById("table2")) {
                document.getElementById("table2").remove();
            }
            const xhttp = new XMLHttpRequest();
            xhttp.open("get", "../deneme?param=param8&sozlesmeId=" + f);
            xhttp.send();
            xhttp.onload = function () {
                const table = document.createElement("table");
                table.id = "table2";
                table.style.width = "100%";
                let tr;
                const data = JSON.parse(this.responseText);
                for (let x in data) {
                    tr = table.insertRow();
                    tr.insertCell().innerHTML = data[x]["sozlesmeId"];
                    tr.insertCell().innerHTML = data[x]["firmaAdi"];
                    tr.insertCell().innerHTML = data[x]["vergiNo"];
                    tr.insertCell().innerHTML = data[x]["taahhutId"];
                    const button = document.createElement("button");
                    button.innerHTML = "aç";
                    button.onclick = function (e) {
                        const f = e.composedPath()[2].cells[3].innerHTML;
                        location.href = "/WebApplication17/sozlesme/taahhutkarti.html?taahhutid=" + f;
                    };
                    tr.insertCell().appendChild(button);
                }
                table.appendChild(tr);

                div1.appendChild(table);

            };
        };
        return a;
    };

    xhttp1.onload = function () {
        const data = JSON.parse(this.responseText);
        const table = document.createElement("table");
        table.id = "table1";
        table.style.width = "100%";
        div0.appendChild(table);
        for (let x in data) {
            const tr = table.insertRow();
            tr.insertCell().innerHTML = data[x]["id"];
            tr.insertCell().innerHTML = data[x]["ihaleKayitNo"];
            tr.insertCell().innerHTML = data[x]["ihaleAdi"];
            tr.insertCell().append(button1());
            table.appendChild(tr);
        }
    };
}