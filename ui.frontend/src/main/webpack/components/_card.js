var principalOptions = document.querySelectorAll('input[type=radio][name="principal"]');
var principalButtonActive = undefined;
principalOptions.forEach(sizeOption => sizeOption.addEventListener('change', () => {
    var button = sizeOption.parentNode.parentNode.nextSibling.nextSibling;
    if(principalButtonActive){
        if (button.style.display === "" && principalButtonActive.style.display === "inline-block"){
        principalButtonActive.style.display = "";
        button.style.display = "inline-block";
        principalButtonActive = button;
        } 
    } else if (button.style.display === ""){
        button.style.display = "inline-block";
        principalButtonActive = button;
    }
}));

var complementsOptions = document.querySelectorAll('input[type=radio][name="complements"]');
var complementsButtonActive = undefined;
complementsOptions.forEach(sizeOption => sizeOption.addEventListener('change', () => {
    var button = sizeOption.parentNode.parentNode.nextSibling.nextSibling;
    if(complementsButtonActive){
        if (button.style.display === "" && complementsButtonActive.style.display === "inline-block"){
        complementsButtonActive.style.display = "";
        button.style.display = "inline-block";
        complementsButtonActive = button;
        } 
    } else if (button.style.display === ""){
        button.style.display = "inline-block";
        complementsButtonActive = button;
    }
}));

new Glider(document.querySelector('.pzbf-card-glider'), {
 // Mobile-first defaults
 slidesToShow: 'auto',
 itemWidth: 300,
 slidesToScroll: 1,
 draggable:true,
 duration:1,
  responsive: [
    {
      // screens greater than >= 775px
      breakpoint: 775,
      settings: {
        // Set to `auto` and provide item width to adjust to viewport
        slidesToShow: 'auto',
        slidesToScroll: 'auto',
        itemWidth: 300,
        duration: 0.25
      }
    },{
      // screens greater than >= 1024px
      breakpoint: 1024,
      settings: {
        slidesToShow: 3,
        slidesToScroll: 1,
        itemWidth: 300,
        duration: 0.25
      }
    }
  ]
});

new Glider(document.querySelector('.pzbf-card-glider--complements'), {
 // Mobile-first defaults
 slidesToShow: 2,
 slidesToScroll: 1,
 draggable:true,
 duration:1,
  responsive: [
    {
      // screens greater than >= 775px
      breakpoint: 775,
      settings: {
        // Set to `auto` and provide item width to adjust to viewport
        slidesToShow: 'auto',
        slidesToScroll: 'auto',
        itemWidth: 200
      }
    },{
      // screens greater than >= 1024px
      breakpoint: 1024,
      settings: {
        slidesToShow: 4,
        slidesToScroll: 1
      }
    }
  ]
});
