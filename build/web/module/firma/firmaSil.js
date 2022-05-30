export function firmaSil() {
    const content = document.getElementById("content");
    const vergiNo = document.createElement("input");
    const firmaBul = document.createElement("button");
    firmaBul.innerHTML = "Firma Bul";
    content.appendChild(vergiNo);
    content.appendChild(firmaBul);
    firmaBul.onclick = function () {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            const p = document.createElement("p");
            const p1 = document.createElement("p");
            content.appendChild(p1);
            content.appendChild(p);
            const array = JSON.parse(this.response);
            p1.innerHTML = array[0].id;
            p.innerHTML = array[0].firmaAdı;
            const firmaSil = document.createElement("button");
            firmaSil.innerHTML = "Firma Sil";
            content.appendChild(firmaSil);
            firmaSil.onclick = function () {
                const xhttp2 = new XMLHttpRequest();
                xhttp2.onload = function () {
                    content.removeChild("p", "p1");
                };
                xhttp2.open("get", "../deneme?param=param4&id=" + array[0].id);
                xhttp2.send();
            };


        };
        xhttp.open("get", "../deneme?param=param3&vergiNo=" + vergiNo.value);
        xhttp.send();

    };

}