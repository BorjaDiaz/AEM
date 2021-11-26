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



window.addEventListener('load',function(){
    document.querySelector('.glider').addEventListener('glider-slide-visible', function(event){
        var glider = Glider(this);
        console.log('Slide Visible %s', event.detail.slide)
    });
    document.querySelector('.glider').addEventListener('glider-slide-hidden', function(event){
        console.log('Slide Hidden %s', event.detail.slide)
    });
    document.querySelector('.glider').addEventListener('glider-refresh', function(event){
        console.log('Refresh')
    });
    document.querySelector('.glider').addEventListener('glider-loaded', function(event){
        console.log('Loaded')
    });

document.querySelectorAll(".glider").forEach((element) => {
   let item = element;
    var d = Math.floor(Math.random() * 999999999);
    item.setAttribute('id', 'glide-'+d)

    window._ = new Glider(document.querySelector('#'+item.id+'.glider'), {
        slidesToShow: 1, //'auto',
        slidesToScroll: 1,
        itemWidth: 150,
        draggable: true,
        scrollLock: false,
        dots: '#dots',
        rewind: true,
        arrows: {
            prev: '.glider-prev',
            next: '.glider-next'
        },
        responsive: [
            {
                breakpoint: 800,
                settings: {
                    slidesToScroll: 'auto',
                    itemWidth: 300,
                    slidesToShow: 'auto',
                    exactWidth: true
                }
            },
            {
                breakpoint: 700,
                settings: {
                    slidesToScroll: 4,
                    slidesToShow: 4,
                    dots: false,
                    arrows: false,
                }
            },
            {
                breakpoint: 600,
                settings: {
                    slidesToScroll: 3,
                    slidesToShow: 3
                }
            },
            {
                breakpoint: 500,
                settings: {
                    slidesToScroll: 2,
                    slidesToShow: 2,
                    dots: false,
                    arrows: false,
                    scrollLock: true
                }
            }
        ]
    });




})/*
$('.slider').each(function(){
    var item = $(this);
    var d = new Date();
    item.attr('id', 'glide-'+d.getTime());

    $('#'+item.attr('id')).glide({
        autoplay: false,
        arrows: '#'+item.attr('id'),
        navigation: '#'+item.attr('id'),
        arrowLeftText: '<div></div>',
        arrowRightText: '<div></div>'
    });
});*/



/*
    window._ = new Glider(document.querySelector('.glider'), {
        slidesToShow: 1, //'auto',
        slidesToScroll: 1,
        itemWidth: 150,
        draggable: true,
        scrollLock: false,
        dots: '#dots',
        rewind: true,
        arrows: {
            prev: '.glider-prev',
            next: '.glider-next'
        },
        responsive: [
            {
                breakpoint: 800,
                settings: {
                    slidesToScroll: 'auto',
                    itemWidth: 300,
                    slidesToShow: 'auto',
                    exactWidth: true
                }
            },
            {
                breakpoint: 700,
                settings: {
                    slidesToScroll: 4,
                    slidesToShow: 4,
                    dots: false,
                    arrows: false,
                }
            },
            {
                breakpoint: 600,
                settings: {
                    slidesToScroll: 3,
                    slidesToShow: 3
                }
            },
            {
                breakpoint: 500,
                settings: {
                    slidesToScroll: 2,
                    slidesToShow: 2,
                    dots: false,
                    arrows: false,
                    scrollLock: true
                }
            }
        ]
    });*/
});