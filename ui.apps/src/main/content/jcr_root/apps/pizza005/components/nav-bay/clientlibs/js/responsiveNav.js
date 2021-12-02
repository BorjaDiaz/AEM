//showing nav

let menuRes = document.getElementById('burger_menu_res');
let navRes = document.querySelector('.responsive_menu_header');

menuRes.addEventListener("click", ()=>{
    navRes.classList.toggle('hiddenMenu')

    if (!navRes.classList.contains('hiddenMenu')){
        menuRes.classList.remove('fa-bars')
        menuRes.classList.add('fa-times')
    }
    
    if (navRes.classList.contains('hiddenMenu')){
        menuRes.classList.remove('fa-times')
        menuRes.classList.add('fa-bars')
        food_menu_btn.classList.toggle('color_active')
    }

    if (navRes.classList.contains('hiddenMenu') && !sectionRes.classList.contains('hiddeRes')){
        sectionRes.classList.add('hiddeRes')
    }
})


//current page decoration logic

let linkedArrayRes = [];
let linkedRes = document.querySelectorAll('.pzbf-topnav__url_res');

linkedRes.forEach(element => {
    linkedArrayRes.push(element)
});

let noSPaceRes = linkedArrayRes.find(element => locString.includes(element.href))

if (noSPaceRes != undefined){
    noSPaceRes.classList.toggle('activeLinkRes')
}


/* showing menu button */

let btn = document.getElementById("food_menu_btn");

if (locString.includes("index.html")){
        
    btn.classList.toggle('hidde');
}