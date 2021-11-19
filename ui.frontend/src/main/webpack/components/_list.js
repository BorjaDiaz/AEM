function collapseMenu() {
    var x = document.getElementById("header__topnav");
    if (x.className === "pzbf-header__topnav") {
        x.className += "--mobile";
        console.log("x");
    } else {
        x.className = "pzbf-header__topnav";
    }
}