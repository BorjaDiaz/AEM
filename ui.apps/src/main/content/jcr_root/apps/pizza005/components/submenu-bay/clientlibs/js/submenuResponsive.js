

/* responsive show */

let foodMenu = document.getElementById("food_menu_btn");
let sectionRes = document.querySelector('.pzbf-header__section_res');

foodMenu.addEventListener('click', ()=>{
    sectionRes.classList.toggle('hiddeRes')

    foodMenu.classList.toggle('color_active')
})