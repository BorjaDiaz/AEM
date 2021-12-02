
let linkedArray = [];
let linked = document.querySelectorAll('.pzbf-topnav__url');
const locString = window.location.href.toString();

linked.forEach(element => {
    linkedArray.push(element)
});

let noSpace = linkedArray.find(element => locString.includes(element.href))

if (noSpace != undefined){

    noSpace.classList.toggle('activeLink')
}

