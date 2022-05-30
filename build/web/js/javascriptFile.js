/*

     
     const toplam = document.createElement("button");
     toplam.innerHTML = "toplam";
     toplam.style.bottom = "25px";
     toplam.style.position = "absolute";
     toplam.style.left = "0px";
     
     const select = document.createElement("select");
     select.style.width = "200px";
     select.style.position = "absolute";
     const toplam_input = document.createElement("input");
     
     select.onchange = function asd() {
     document.querySelectorAll("th")[select.selectedIndex].appendChild(toplam_input);
     };
     
     
     button.onclick = function () {
     eklentiDiv.appendChild(toplam);
     toplam.onclick = function () {
     const test2 = document.createElement("div");
     eklentiDiv.appendChild(test2);
     test2.style.backgroundColor = "red";
     test2.style.width = "150px";
     test2.style.height = "100px";
     test2.style.zIndex = "1";
     test2.style.position = "absolute";
     test2.style.bottom = "50px";
     
     test2.appendChild(select);
     const option = odemeListesiModel;
     option.forEach(function (element, key) {
     select[key] = new Option(element, key);
     });
     
     };
     }
       
 function loginController() {
    sessionStorage.setItem("usertoken", "asd");
    if (sessionStorage.getItem("usertoken") === null) {
        location.href = "./login.html";
    } else {
        location.href = "./index.html";
    }
}



function deneme() {
    const content = document.getElementById("content");
    const datalistInput = document.createElement("input");
    datalistInput.setAttribute("list", "firmalist");
    const datalist = document.createElement("datalist");
    datalist.id = "firmalist";
    for (var i = 0; i < 10; i++) {
        const datalist_option = document.createElement("option");
        datalist_option.value += i;
        datalist.appendChild(datalist_option);
    }
    datalistInput.appendChild(datalist);
    content.appendChild(datalistInput);
}

function deneme2() {
    const content = document.getElementById("content");
    const denemeInput = document.createElement("input");
    denemeInput.onkeyup = function () {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            const array = JSON.parse(this.responseText);
            for (var i = 0; i < 5; i++) {
                if (array[i].firmaAdı.match(denemeInput.value.toLocaleUpperCase())) {
                    console.log(array[i].firmaAdı);
                }

            }
        };
        xhttp.open("GET", "./deneme?param=param");
        xhttp.send();

    };
    content.appendChild(denemeInput);
}

function fileupload() {
    const fileupload = document.getElementById("fileupload");
    const formdata = new FormData();
    formdata.append("file", fileupload.files[0]);

    const xhttp = new XMLHttpRequest();
    xhttp.open("post", "./fileupload");
    xhttp.send(formdata);
}




function pagination() {
    const content = document.getElementById("content");
    let satır = document.getElementsByTagName("tr");
    let satırsayısı = satır.length;
    let sayfasayısı = satırsayısı / 30;
    let buttonPagination;
    for (var i = 0; i < sayfasayısı; i++) {
        buttonPagination = document.createElement("button");
        buttonPagination.innerHTML = i;
        buttonPagination.id = "buttonPagination";
        content.appendChild(buttonPagination);
        buttonPagination.onclick = function () {
            let satırbas = this.innerHTML * 30;
            let satırson = satırbas + 30;
            for (var i = 1; i < satırsayısı; i++) {
                if (i > satırbas && i <= satırson) {
                    document.getElementsByTagName("tr")[i].style.display = "";

                } else {
                    document.getElementsByTagName("tr")[i].style.display = "none";
                }

            }
        };
    }
}



function pagesum() {
    const content = document.getElementById("content");
    const firmaadıth = document.getElementsByTagName("th")[18];
    const kalaninput = document.createElement("input");
    firmaadıth.appendChild(kalaninput);
    const tabletr = document.getElementsByTagName("tr").length;
    kalaninput.addEventListener("keydown", function (e) {
        if (e.code == "Enter" || e.code == "NumpadEnter") {
            let deger = parseFloat(kalaninput.value);
            let deger0 = 0.0;
            let tabledeger = [];
            for (var i = 0; i < tabletr; i++) {
                tabledeger[i] = parseFloat(document.getElementsByTagName("tr")[i].children[18].innerHTML.trim());
                deger0 += tabledeger[i];
                if (deger0 <= deger && tabledeger[i] > 0) {
                    document.getElementsByTagName("tr")[i].style.display = "";
                    kalaninput.value = deger0;

                } else if (isNaN(deger)) {
                    document.getElementsByTagName("tr")[i].style.display = "";
                } else {
                    document.getElementsByTagName("tr")[i].style.display = "none";
                }
            }
            if (confirm("Ödeme listesi oluşturulsunmu?") == true) {
                let dizi_siraNo = [];
                let siraNo = document.querySelectorAll("tr:not([style*='display'])>td:nth-child(2)");
                let kalan = document.querySelectorAll("tr:not([style*='display'])>td:nth-child(19)");

                for (let i = 0; i < siraNo.length; i++) {

                    if (kalan[i].innerHTML > 0) {
                        dizi_siraNo[i] = siraNo[i].innerHTML;
                    }
                }



                const xhttp3 = new XMLHttpRequest();
                xhttp3.open("get", "./deneme?param=param9&siraNo=" + dizi_siraNo.filter(function (ddd) {
                    return ddd;
                }));
                xhttp3.send();
                //  window.location.href = "odemelisteleri.html";


            }
        }
        ;

    });
}

function tumunusec() {
    const checkbox = document.querySelectorAll("input[type=checkbox]");
    let dizi = [];

    for (var i = 0; i < checkbox.length; i++) {
        checkbox[i].onclick = function (e) {
            if (this.checked === true) {
                dizi.push(e.path[2].cells[1].innerHTML);
                console.log(dizi.sort());
            } else {
                dizi.splice(dizi.indexOf(e.path[2].cells[1].innerHTML), 1);
                console.log(dizi.sort());
                prompt(dizi.sort());
            }

        };

    }

}


*/