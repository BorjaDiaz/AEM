$('#products-paginate').easyPaginate({
    elementsPerPage: 4,
    effect: 'fade'
    //paginateElement: 'div'
});
var complementsOptions = document.querySelectorAll('input[type=radio][name="products"]');
var complementsButtonActive = undefined;

let inputsReset=()=>{
    complementsOptions = document.querySelectorAll('input[type=radio][name="products"]');

    complementsOptions.forEach(element => element.addEventListener('change', chargeButtonsEvents));

}


let chargeButtonsEvents=(element)=>{
    inputsReset()
    var button =  element.currentTarget.parentNode.parentNode.parentNode.lastElementChild
    if(complementsButtonActive){
        if (button.style.display === "" && complementsButtonActive.style.visibility === "visible"){
            complementsButtonActive.style.visibility = "hidden";
            button.style.visibility="visible";
            complementsButtonActive = button;
        }
    } else if (button.style.display === ""){
        button.style.visibility = "visible";
        complementsButtonActive = button;
    }

}

complementsOptions.forEach(element => element.addEventListener('change', chargeButtonsEvents));





document.querySelectorAll('.easyPaginateNav a').forEach(element=> element.addEventListener("click", ()=>{ inputsReset();chargeButtonsEvents}))
