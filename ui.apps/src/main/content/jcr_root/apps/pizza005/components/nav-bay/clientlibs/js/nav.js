
let linkedArray = [];
let linked = document.querySelectorAll('.pzbf-topnav__url');
const locString = window.location.href.toString();

linked.forEach(element => {
    linkedArray.push(element)
});

let noSpace = linkedArray.find(element => locString.includes(element.innerHTML.toLowerCase()))

if (noSpace == undefined){

    if (locString.includes("index.html")){
        
        linkedArray.find(element => element.innerHTML.toLowerCase() == 'order online').classList.toggle('active');
    }

    else {
        linkedArray.forEach(element => {
            if(element.innerHTML.toLowerCase().indexOf(' ') !== -1){
    
                if (locString.includes(element.innerHTML.toLowerCase().slice(0, element.innerHTML.toLowerCase().indexOf(' ')))){
                    element.classList.toggle('active'); 
                }
            }
        });
    }
}

else {
    noSpace.classList.toggle('active')
}

