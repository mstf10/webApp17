export function search() {
    const content = document.getElementById("content");
    const search = document.createElement("input");
    search.className = "noShow";
    content.appendChild(search);

    search.onkeyup = function () {
        for (var i = 0; i < document.getElementsByTagName("tr").length; i++) {
            if (document.getElementsByTagName("tr")[i].innerHTML.match(search.value.toLocaleUpperCase())) {
                document.getElementsByTagName("tr")[i].style.display = "";
            } else {
                document.getElementsByTagName("tr")[i].style.display = "none";
            }
        }
    };
}