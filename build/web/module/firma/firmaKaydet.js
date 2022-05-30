export function firmaKaydet() {
    const content = document.getElementById("content");
    const firmaAdı = document.createElement("input");
    content.appendChild(firmaAdı);
    const vergiNo = document.createElement("input");
    content.appendChild(vergiNo);
    const kaydet = document.createElement("button");
    kaydet.innerHTML = "Kaydet";
    kaydet.onclick = () => {
        const xhttp = new XMLHttpRequest();
        xhttp.open("get", "/WebApplication17/deneme?param=param2&firmaAdı=" + firmaAdı.value + "&vergiNo=" + vergiNo.value);
        xhttp.send();
        xhttp.onload = function () {
            alert(this.responseText);
            vergiNo.value = "";
            firmaAdı.value = "";
        }
    };
    content.appendChild(kaydet);

}