//setting path in the form for the javamodel 

let path = document.getElementById("path");

path.value = window.location.href;

if (path.value.includes('?')){
    path.value = path.value.substring(0, path.value.lastIndexOf('?'))
}


//showing the email status modal

let emailModal = document.getElementById('email_modal');
let modalText = document.getElementById('modal_text');

const URLSearch = window.location.search;
const URLParams = new URLSearchParams(URLSearch);

const emailReport = URLParams.get('emailSend');

console.log(emailReport)

if (emailReport == 'success'){
    emailModal.classList.toggle('hiddenModal')

    modalText.innerHTML = "Your email has been sent successfully!"

    setTimeout(() => {
        closingModal();
    }, 3500);
}

if (emailReport == 'error'){
    emailModal.classList.toggle('hiddenModal')

    modalText.innerHTML = "Something went wrong, we´re sorry!"

    setTimeout(() => {
        closingModal();
    }, 3500);
} 


//closing the modal

let modalBtn = document.getElementById('modal_button');

modalBtn.addEventListener("click", ()=>{
    closingModal();
})


function closingModal(){
    emailModal.classList.add('hiddenModal');
}