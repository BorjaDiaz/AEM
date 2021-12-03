
let section = document.querySelector('.pzbf-header__section2');
const localString = window.location.href.toString();

if (localString.includes("index.html") || localString.includes("/products/")){
        
    section.classList.toggle('hidde');
}


//only for develop

if (localString.includes("experience-fragments")){
    section.classList.toggle('hidde');
}


// decoration active link

let linkesArray = [];

let linkes = document.querySelectorAll(".pzbf-list__item--URL");

linkes.forEach(element => {
    linkesArray.push(element)
});

let decor = linkesArray.find(element => localString.includes(element.href))

if (decor != undefined){

    decor.classList.toggle('submenu_active')
}