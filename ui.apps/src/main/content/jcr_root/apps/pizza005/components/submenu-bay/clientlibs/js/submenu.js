console.log('hola');

let section = document.querySelector('.pzbf-header__section2');
const localString = window.location.href.toString();

if (localString.includes("index.html")){
        
    section.classList.toggle('hidde');
}