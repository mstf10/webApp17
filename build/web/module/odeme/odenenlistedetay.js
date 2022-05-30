export function odenenlistedetay() {
    const listNo = new URLSearchParams(location.search).get("listNo");
    const xhttp = new XMLHttpRequest();
    xhttp.open("get", "../deneme?param=param6&listNo=" + listNo);
    xhttp.send();
    console.log(listNo);
    xhttp.onload = function () {
        const content = document.getElementById("content");
        const data = JSON.parse(this.response);
        const table = document.createElement("table");
        content.appendChild(table);

        const td = [];
        for (let x in data) {
            const tr = document.createElement("tr");
            table.appendChild(tr);
            for (let i = 0; i < Object.keys(data[0]).length; i++) {
                td[i] = document.createElement("td");
                tr.appendChild(td[i]);
            }

            td[0].innerHTML = data[x].siraNo;
            td[1].innerHTML = data[x].firmaAdı;
            td[2].innerHTML = data[x].vergiNo;
            td[3].innerHTML = data[x].hesapKodu;
            td[4].innerHTML = data[x].fisNo;
            td[5].innerHTML = data[x].fisTarihi;
            td[6].innerHTML = data[x].ftbs;
            td[7].innerHTML = data[x].yevmiyeNo;
            td[8].innerHTML = data[x].muayeneKabulTarihi;
            td[9].innerHTML = data[x].mktbs;
            td[10].innerHTML = data[x].faturaNo;
            td[11].innerHTML = data[x].faturaTarihi;
            td[12].innerHTML = data[x].iliskiNo;
            td[13].innerHTML = data[x].tahakkuk;
            td[14].innerHTML = data[x].kapatilan103;
            td[15].innerHTML = data[x].kapatilan320;
            td[16].innerHTML = data[x].kapatilanDiger;
            td[17].innerHTML = data[x].kalan;
            td[18].innerHTML = data[x].alimTuru;
        }
    };
}

