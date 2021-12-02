
let section = document.querySelector('.pzbf-header__section2');
const localString = window.location.href.toString();

if (localString.includes("index.html") || localString.includes("/products/")){
        
    section.classList.toggle('hidde');
}


//only for develop

if (localString.includes("experience-fragments")){
    section.classList.toggle('hidde');
}