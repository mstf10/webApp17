export function getAllFirma() {
    const xhttp = new XMLHttpRequest();
    const content = document.getElementById("content");
    xhttp.onload = function () {
        const array = JSON.parse(this.response);
        const table = document.createElement("table");
        let tr, td = [], th = [];
        for (let x in array) {
            tr = document.createElement("tr");
            table.appendChild(tr);
            for (var i = 0; i < Object.keys(array[0]).length; i++) {
                td[i] = document.createElement("td");
                tr.appendChild(td[i]);
            }
         
            td[0].innerHTML = array[x].id;
            td[1].innerHTML = array[x].firmaAdı;
            td[2].innerHTML = array[x].vergiNo;
        }

        content.appendChild(table);
    };
    xhttp.open("GET", "/WebApplication17/deneme?param=param");
    xhttp.send();
}