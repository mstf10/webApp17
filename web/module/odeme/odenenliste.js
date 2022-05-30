export function odenenliste() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("get", "../deneme?param=param9&siraNo=");
    xhttp.send();
    xhttp.onload = function () {
        const data = JSON.parse(this.responseText);
        const content = document.getElementById("content");
        const table = document.createElement("table");
        content.appendChild(table);

        let tr, td = [];
        for (let i = 0; i < data.length; i++) {
            tr = document.createElement("tr");
            table.appendChild(tr);
            for (let j = 0; j < Object.keys(data[0]).length; j++) {
                td[j] = document.createElement("td");
                tr.appendChild(td[j]);
            }
            let td_sil = document.createElement("td");
            let td_goster = document.createElement("td");
            tr.appendChild(td_goster);
            tr.appendChild(td_sil);


            td[0].innerHTML = data[i].siraNo;
            td[1].innerHTML = data[i].listeNo;
            td[2].innerHTML = data[i].listeTarih;
            td_goster.innerHTML = "Göster";
            td_sil.innerHTML = "sil";

            td_goster.onclick = function () {
                document.location.href = "./odenenlistedetay.html?listNo=" + document.querySelectorAll("tr>td:nth-child(2)")[i].innerHTML;
            };
        }


    };
}
