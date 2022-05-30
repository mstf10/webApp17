export function firmaGuncelle() {
    const content = document.getElementById("content");
    const vergiNo = document.createElement("input");
    const firmaBul = document.createElement("button");
    firmaBul.innerHTML = "Firma Bul";
    content.appendChild(vergiNo);
    content.appendChild(firmaBul);
    const inputID = document.createElement("input");
    const inputFirmaAdı = document.createElement("input");
    const inputVergiNo = document.createElement("input");
    const firmaGuncelle = document.createElement("button");
    firmaBul.addEventListener("click", function () {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            const array = JSON.parse(this.response);
            content.appendChild(inputID);
            content.appendChild(inputFirmaAdı);
            content.appendChild(inputVergiNo);
            content.appendChild(firmaGuncelle);
            console.log(array[0].id);
            inputID.value = array[0].id;
            inputID.disabled = true;
            inputFirmaAdı.value = array[0].firmaAdı;
            inputVergiNo.value = array[0].vergiNo;
            firmaGuncelle.innerHTML = "Güncelle";
            firmaGuncelle.onclick = function () {
                const xhttp2 = new XMLHttpRequest();
                xhttp2.open("get", "../deneme?param=param5&id=" + array[0].id + "&firmaAdı=" + inputFirmaAdı.value + "&vergiNo=" + inputVergiNo.value);
                xhttp2.send();
            };
        };
        xhttp.open("get", "../deneme?param=param3&vergiNo=" + vergiNo.value);
        xhttp.send();

    });


}